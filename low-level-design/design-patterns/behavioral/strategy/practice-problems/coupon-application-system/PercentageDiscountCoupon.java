class PercentageDiscountCoupon implements CouponStrategy {
    double discountPercent;

    PercentageDiscountCoupon(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public double applyDiscount(double price) {
        return price - (price * discountPercent / 100);
    }
}
