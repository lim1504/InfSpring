package hello.core.member;

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
}
