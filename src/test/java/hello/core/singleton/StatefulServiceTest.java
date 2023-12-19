package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("빈이 상태정보를 가지고 있는 경우 발생하는 문제")
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //A : 10000주문
        int userAprice = statefulService1.order("userA", 10000);
        //B : 20000주문
        int userBprice = statefulService2.order("userB", 20000);

        //userA 주문금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("userAprice = " + userAprice);
        System.out.println("userBprice = " + userBprice);

        //A의 주문금액은 10000원 이지만, 20000원 출력.
        //statefulService 필드 정보가 바뀜 (10000 -> 20000)
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService () {
            return new StatefulService();
        }
    }

}