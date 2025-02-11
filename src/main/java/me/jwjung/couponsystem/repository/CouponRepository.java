package me.jwjung.couponsystem.repository;

import me.jwjung.couponsystem.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
