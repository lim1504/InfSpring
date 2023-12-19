package hello.core.scan.filter;

import java.lang.annotation.*;

/**
 * 컴포넌트 스켄에 추가
 * 추가할 빈 객체 명시
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncloudeComponent {

}
