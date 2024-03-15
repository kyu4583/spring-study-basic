package hello.hellospringbasic;

import hello.hellospringbasic.member.Grade;
import hello.hellospringbasic.member.Member;
import hello.hellospringbasic.member.MemberService;
import hello.hellospringbasic.member.MemberServiceImpl;
import hello.hellospringbasic.order.Order;
import hello.hellospringbasic.order.OrderService;
import hello.hellospringbasic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String [] args) {
        AppConfig appConfig = new AppConfig();
        OrderService orderService = appConfig.orderService();
        MemberService memberService = appConfig.memberService();
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
