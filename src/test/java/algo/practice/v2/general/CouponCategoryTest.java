package algo.practice.v2.general;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CouponCategoryTest {

    private CouponCategory couponCategory;

    @BeforeEach
    void setUp() {
        couponCategory = new CouponCategory();
    }

    @Test
    void findCoupon() {
        // set data
        couponCategory.addCategoryCoupon("Comforter Sets", new Coupon("Comforters Sale"));
        couponCategory.addCategoryCoupon("Bedding", new Coupon("Savings on Bedding"));
        couponCategory.addCategoryCoupon("Bed & Bath", new Coupon("Low price for Bed & Bath"));

        couponCategory.addCategoryParent("Comforter Sets", "Bedding");
        couponCategory.addCategoryParent("Bedding", "Bed & Bath");
        couponCategory.addCategoryParent("Bed & Bath", null);
        couponCategory.addCategoryParent("Soap Dispensers", "Bathroom Accessories");
        couponCategory.addCategoryParent("Bathroom Accessories", "Bed & Bath");
        couponCategory.addCategoryParent("Toy Organizers", "Baby and Kids");
        couponCategory.addCategoryParent("Baby and Kids", null);

        String comforterSetsCoupon = couponCategory.findCoupon("Comforter Sets");
        assertEquals("Comforters Sale", comforterSetsCoupon);

        String beddingCoupon = couponCategory.findCoupon("Bedding");
        assertEquals("Savings on Bedding", beddingCoupon);

        String bathroomAccessoriesCoupon = couponCategory.findCoupon("Bathroom Accessories");
        assertEquals("Low price for Bed & Bath", bathroomAccessoriesCoupon);

        String soapDispensersCoupon = couponCategory.findCoupon("Soap Dispensers");
        assertEquals("Low price for Bed & Bath", soapDispensersCoupon);

        String toyOrganizersCoupon = couponCategory.findCoupon("Toy Organizers");
        assertNull(toyOrganizersCoupon);
    }

    @Test
    void findBestCoupon() {
        // set data
        couponCategory.addCategoryCoupon(
                "Comforter Sets", new Coupon("Comforters Sale", "2020-01-01"));
        couponCategory.addCategoryCoupon(
                "Comforter Sets", new Coupon("Cozy Comforter Coupon", "2020-01-01"));
        couponCategory.addCategoryCoupon(
                "Bedding", new Coupon("Best Bedding Bargains", "2019-01-01"));
        couponCategory.addCategoryCoupon("Bedding", new Coupon("Savings on Bedding", "2019-01-01"));
        couponCategory.addCategoryCoupon(
                "Bed & Bath", new Coupon("Low price for Bed & Bath", "2018-01-01"));
        couponCategory.addCategoryCoupon(
                "Bed & Bath", new Coupon("Bed & Bath Extravaganza", "2019-01-01"));
        couponCategory.addCategoryCoupon(
                "Bed & Bath", new Coupon("Big Savings on Bed & Bath", "2030-01-01"));

        couponCategory.addCategoryParent("Comforter Sets", "Bedding");
        couponCategory.addCategoryParent("Bedding", "Bed & Bath");
        couponCategory.addCategoryParent("Bed & Bath", null);
        couponCategory.addCategoryParent("Soap Dispensers", "Bathroom Accessories");
        couponCategory.addCategoryParent("Bathroom Accessories", "Bed & Bath");
        couponCategory.addCategoryParent("Toy Organizers", "Baby and Kids");
        couponCategory.addCategoryParent("Baby and Kids", null);

        String bedAndBathCoupon = couponCategory.findBestCoupon("Bed & Bath");
        assertEquals("Bed & Bath Extravaganza", bedAndBathCoupon);

        String beddingCoupon = couponCategory.findBestCoupon("Bedding");
        assertTrue(
                "Savings on Bedding".equals(beddingCoupon)
                        || "Best Bedding Bargains".equals(beddingCoupon));

        String bathroomAccessoriesCoupon = couponCategory.findBestCoupon("Bathroom Accessories");
        assertEquals("Bed & Bath Extravaganza", bathroomAccessoriesCoupon);

        String comforterSetsCoupon = couponCategory.findBestCoupon("Comforter Sets");
        assertTrue(
                "Comforters Sale".equals(comforterSetsCoupon)
                        || "Cozy Comforter Coupon".equals(comforterSetsCoupon));
    }
}
