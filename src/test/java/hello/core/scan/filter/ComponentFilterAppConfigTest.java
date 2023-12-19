package hello.core.scan.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ComponentFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();
//
//        ac.getBean("beanB", BeanB.class);
        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class));
    }

    /**
     * type = FilterType.ANNOTATION => 기본 타입이다.
     * 어떠한 빈을 포함 혹은 제외하고 싶을 경우, CustomAnnotation 을 생성해 필터로 설정해준다.
     * 특정 클래스 정보에 만든 어노테이션 정보를 입력해준다.
     */
    @Configuration
    @ComponentScan(
            includeFilters = @Filter(classes = MyIncloudeComponent.class), // 해당 애노테이션이 붙은 정보 포함
            excludeFilters = {
                    @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class) // 해당 애노테이션이 붙은 정보 제외
//                    @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = BeanA.class) // 명시한 타입 제외
            }
    )
    static class ComponentFilterAppConfig {

    }
}
