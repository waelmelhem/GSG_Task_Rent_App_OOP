class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardType; // Visa or MasterCard

    public CreditCardStrategy(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using " + cardType + " (card number: " + cardNumber + ")");
    }
}