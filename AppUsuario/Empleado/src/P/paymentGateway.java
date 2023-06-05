package P;

public interface paymentGateway {
	boolean processPayment(CreditCard card, double amount, String accountNumber, String transactionNumber);
    String getName();

}
