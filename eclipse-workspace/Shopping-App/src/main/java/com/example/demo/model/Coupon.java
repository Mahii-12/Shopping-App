package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Coupon")
public class Coupon {

    public static final String OFF5_CODE = "OFF5";
    public static final String OFF10_CODE = "OFF10";

    public static final int OFF5_DISCOUNT_PERCENTAGE = 5;
    public static final int OFF10_DISCOUNT_PERCENTAGE = 10;

    public static List<String> getAllCoupons() {
        List<String> coupons = new ArrayList<>();
        coupons.add(OFF5_CODE);
        coupons.add(OFF10_CODE);
        return coupons;
    }
}
