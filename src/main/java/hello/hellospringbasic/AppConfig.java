package hello.hellospringbasic;

import hello.hellospringbasic.discount.DiscountPolicy;
import hello.hellospringbasic.discount.FixDiscountPolicy;
import hello.hellospringbasic.discount.RateDiscountPolicy;
import hello.hellospringbasic.member.MemberRepository;
import hello.hellospringbasic.member.MemberService;
import hello.hellospringbasic.member.MemberServiceImpl;
import hello.hellospringbasic.member.MemoryMemberRepository;
import hello.hellospringbasic.order.OrderService;
import hello.hellospringbasic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
