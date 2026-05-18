class CartService {
    CouponStrategy couponStrategy;

    CartService(CouponStrategy couponStrategy) {
        this.couponStrategy = couponStrategy;
    }

    double getFinalPrice(double price) {
        return couponStrategy.applyDiscount(price);
    }
}
