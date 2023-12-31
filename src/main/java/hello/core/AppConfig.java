package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 실제 동작에 필요한 구현 객체를 생성
 * 객체의 생성과 연결은 AppConfig가 해결.
 *
 * 팩토리 메소드를 통해서 제공해주는 방식
 * 외부에서 메소드를 호출해서 제공하는 것을 뜻함.
 * 펙토리 메소드 패턴 참조
 */
@Configuration
public class AppConfig {

    /**
     * 코드 리펙토링 과정
     * 실제 Repository의 구현체가 바뀌면 이 부분들만 변경되면 된다.
     *
     * @Bean 으로 DI 컨테이너에 객체를 등록
     */
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy () {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    /***
     * 코드 리펙토링 과정
     * 구현체가 변경되어도 아래 코드는 변경될 이유가 없다.
     */
    @Bean
    public MemberService memberService () {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService () {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

}
