package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /**
     * 커맨드 + 시프트 + 엔터 => 세미콜론까지 완성
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }
}
