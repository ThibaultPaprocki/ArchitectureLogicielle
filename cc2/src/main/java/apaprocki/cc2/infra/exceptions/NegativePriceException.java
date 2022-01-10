package apaprocki.cc2.infra.exceptions;

public class NegativePriceException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private NegativePriceException(String message) {
            super(message);
        }

        public static NegativePriceException withPrice(double price) {
            return new NegativePriceException(String.format("contract price cannot be less than 0 . found : %.2f €.", price));
        }
}
