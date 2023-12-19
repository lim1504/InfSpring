package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    /**
     * 커맨드 + 시프트 + 엔터 => 세미콜론까지 완성
     */
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * AppConfig에서 memberRepository를 가져와 사용함. => 생성자주입
     * 의존관계를 외부에서 주입해준다. (AppConfig) => DI (외존관계 주입)
     */
    private final MemberRepository memberRepository;

    /**
     * 스프링이 빈의 의존관계를 자동으로 설정해준다.
     * ac.getBean(MemberRepository.class) 처럼 작동.
     * @param memberRepository
     */
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }

    //Test
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
