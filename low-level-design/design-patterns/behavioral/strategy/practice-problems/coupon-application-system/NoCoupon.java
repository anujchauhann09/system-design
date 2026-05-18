class NoCoupon implements CouponStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
