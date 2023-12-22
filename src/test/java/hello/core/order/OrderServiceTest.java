package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    /**
     * Test 이전에 바로 실행되는 정보 입력 가능
     */
    @BeforeEach
    public void beforEach() {
    AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();
    orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        /**
         * null 이슈를 피하기 위해 래퍼클래스 사용
         */
        Long memberId = 1L;

        //given
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

//    @Test
//    @DisplayName("직접 DI 주입을 활용하면, 변경이 불가하다. 그렇게되면 setter 메소드 생성등 추가작업 필요. 테스트에 큰 어려움이 있다. 따라서 사용하지 않는게 좋음.")
//    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L, "itemA", 10000);
//    }
}
