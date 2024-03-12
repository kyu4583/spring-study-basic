package hello.hellospringbasic.order;

import hello.hellospringbasic.discount.DiscountPolicy;
import hello.hellospringbasic.discount.FixDiscountPolicy;
import hello.hellospringbasic.member.Member;
import hello.hellospringbasic.member.MemberRepository;
import hello.hellospringbasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
