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

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
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
