package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. 순수자바를 활용한, 비지니스로직 생성
 */
public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); //AppConfig에서 가져와 사용. 의존관계 주입
//        MemberService memberService = new MemberServiceImpl(); -> 직접생성

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // DI 컨테이너에 등록된 Bean은 기본적으로 메소드 명으로 지정된다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find Member = " + findMember.getName());
        System.out.println("new member = " + member.getName());
    }
}
