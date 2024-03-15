package hello.hellospringbasic;

import hello.hellospringbasic.discount.DiscountPolicy;
import hello.hellospringbasic.discount.FixDiscountPolicy;
import hello.hellospringbasic.member.MemberRepository;
import hello.hellospringbasic.member.MemberService;
import hello.hellospringbasic.member.MemberServiceImpl;
import hello.hellospringbasic.member.MemoryMemberRepository;
import hello.hellospringbasic.order.OrderService;
import hello.hellospringbasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
