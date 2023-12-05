package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class XmlAppContext {

    @Test
    void xmlAppContext() {
        //XML을 스프링 빈 컨테이너로 생성하는 방법
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        Object memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
