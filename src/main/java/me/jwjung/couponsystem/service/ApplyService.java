package me.jwjung.couponsystem.service;

import me.jwjung.couponsystem.domain.Coupon;
import me.jwjung.couponsystem.repository.CouponCountRepository;
import me.jwjung.couponsystem.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public ApplyService(final CouponRepository couponRepository,
        final CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    public void apply(Long userId) {
//        long count = couponRepository.count();
        Long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
