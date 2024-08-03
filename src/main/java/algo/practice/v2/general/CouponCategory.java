package algo.practice.v2.general;

import lombok.Getter;

import java.util.*;

/**
 * The type CouponCategory
 *
 * @author nadeem Date : 28/07/24
 */
@Getter
public class CouponCategory {

    private final Map<String, PriorityQueue<Coupon>> categoryCouponMap;
    private final Map<String, String> categoryParentMap;

    public CouponCategory() {
        categoryCouponMap = new HashMap<>();
        categoryParentMap = new HashMap<>();
    }

    public void addCategoryCoupon(String category, Coupon coupon) {
        categoryCouponMap.putIfAbsent(category, new PriorityQueue<>());
        categoryCouponMap.get(category).offer(coupon);
    }

    public void addCategoryParent(String category, String parentCategory) {
        categoryParentMap.put(category, parentCategory);
    }

    public CouponCategory(
            Map<String, PriorityQueue<Coupon>> categoryCouponMap,
            Map<String, String> categoryParentMap) {
        this.categoryCouponMap = categoryCouponMap;
        this.categoryParentMap = categoryParentMap;
    }

    private String findBestCouponFromParents(String category) {
        if (categoryCouponMap.containsKey(category)) {
            PriorityQueue<Coupon> coupons = categoryCouponMap.get(category);
            while (!coupons.isEmpty()) {
                Coupon currentCoupon = coupons.remove();
                if (currentCoupon.isValid()) {
                    addCategoryCoupon(category, currentCoupon);
                    return currentCoupon.getName();
                }
            }
            if (!categoryParentMap.containsKey(category)) {
                return null;
            }

            String parentCategory = categoryParentMap.get(category);
            String coupon = findBestCouponFromParents(parentCategory);

            if (coupon != null) {
                addCategoryCoupon(category, new Coupon(coupon));
            }

            return coupon;
        }

        if (!categoryParentMap.containsKey(category)) {
            return null;
        }

        String parentCategory = categoryParentMap.get(category);
        String coupon = findBestCouponFromParents(parentCategory);

        if (coupon != null) {
            addCategoryCoupon(category, new Coupon(coupon));
        }

        return coupon;
    }

    private String findCouponFromParents(String category) {
        if (categoryCouponMap.containsKey(category)) {
            return categoryCouponMap.get(category).remove().getName();
        }

        if (!categoryParentMap.containsKey(category)) {
            return null;
        }

        String parentCategory = categoryParentMap.get(category);
        String coupon = findCouponFromParents(parentCategory);

        if (coupon != null) {
            addCategoryCoupon(category, new Coupon(coupon));
        }

        return coupon;
    }

    public String findCoupon(String categoryName) {
        if (categoryCouponMap.containsKey(categoryName))
            return categoryCouponMap.get(categoryName).remove().getName();
        return findCouponFromParents(categoryName);
    }

    public String findBestCoupon(String categoryName) {
        if (categoryCouponMap.containsKey(categoryName)) {
            PriorityQueue<Coupon> coupons = categoryCouponMap.get(categoryName);
            while (!coupons.isEmpty()) {
                Coupon currentCoupon = coupons.peek();
                if (currentCoupon.isValid()) return currentCoupon.getName();
                else coupons.remove();
            }
            return findBestCouponFromParents(categoryName);
        }
        return findBestCouponFromParents(categoryName);
    }
}
