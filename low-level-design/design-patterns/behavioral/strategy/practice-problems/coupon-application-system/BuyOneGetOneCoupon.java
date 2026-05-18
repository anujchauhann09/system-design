class BuyOneGetOneCoupon implements CouponStrategy {
    @Override
    public double applyDiscount(double price) {
        return price / 2;
    }
}
