package me.jwjung.couponsystem.service;

import me.jwjung.couponsystem.producer.CouponCreateProducer;
import me.jwjung.couponsystem.repository.CouponCountRepository;
import me.jwjung.couponsystem.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;

    public ApplyService(final CouponRepository couponRepository,
        final CouponCountRepository couponCountRepository,
        final CouponCreateProducer couponCreateProducer) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
    }

    public void apply(Long userId) {
//        long count = couponRepository.count();
        Long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }

//        couponRepository.save(new Coupon(userId));
        couponCreateProducer.create(userId);
    }


}
