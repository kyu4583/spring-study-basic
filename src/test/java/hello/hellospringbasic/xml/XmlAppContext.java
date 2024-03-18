package hello.hellospringbasic.xml;

import hello.hellospringbasic.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContext {
    @Test
    void xmlAppContext() {
        String path = "classpath:appConfig.xml";
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
        MemberService memberService = ctx.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
