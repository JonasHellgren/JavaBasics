package medium.enum_based_patterns;

public enum CustomerType {
    REGULAR {
        @Override
        public double calculateDiscountedPrice(double basePrice) {
            return basePrice;
        }
    },
    MEMBER {
        @Override
        public double calculateDiscountedPrice(double basePrice) {
            return basePrice * 0.9;
        }
    },
    VIP {
        @Override
        public double calculateDiscountedPrice(double basePrice) {
            return basePrice * 0.8;
        }
    };
public abstract double calculateDiscountedPrice(double basePrice);
}