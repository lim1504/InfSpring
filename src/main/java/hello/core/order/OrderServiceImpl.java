package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/**
 * 할인에 대한 정보는 OrderServiceImpl은 필요없다. 결과만 도출하면됨
 * 할인 정보는 -> DiscountPolicy가 책임
 * 단일책임 원칙을 잘 지켰다고 볼 수 있다.
 */
public class OrderServiceImpl implements OrderService{


//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    /**
     * Repository에 관한 정보는 AppConfig에서 받아온다. => 생성자 주입
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /**
     *
     * @param memberRepository
     * @param discountPolicy -> 어떤 객체가 들어올지 종속되어 있지않다. DIP를 잘 지킴.
     */
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //1. 회원정보 조회
        Member member = memberRepository.findById(memberId);
        //2. 회원 - 할인률 조회
        //등급만 넘길지, 회원전체를 넘길지 판단.
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //3. 주문정보 리턴
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
