package hello.hellospringbasic;

import hello.hellospringbasic.discount.FixDiscountPolicy;
import hello.hellospringbasic.member.MemberRepository;
import hello.hellospringbasic.member.MemberService;
import hello.hellospringbasic.member.MemberServiceImpl;
import hello.hellospringbasic.member.MemoryMemberRepository;
import hello.hellospringbasic.order.OrderService;
import hello.hellospringbasic.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
