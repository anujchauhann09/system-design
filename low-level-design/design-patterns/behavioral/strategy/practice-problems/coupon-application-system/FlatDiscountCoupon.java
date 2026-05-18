class FlatDiscountCoupon implements CouponStrategy {
    double discountAmount;

    FlatDiscountCoupon(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double price) {
        return Math.max(0, price - discountAmount);
    }
}
