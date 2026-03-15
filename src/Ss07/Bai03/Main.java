package Ss07.Bai03;

public class Main {

    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        // COD
        PaymentMethod cod = new CODPayment();
        processor.processPayment(cod, 500000);

        // Credit Card
        PaymentMethod card = new CreditCardPayment();
        processor.processPayment(card, 1000000);

        // MoMo
        PaymentMethod momo = new MomoPayment();
        processor.processPayment(momo, 750000);

        // Kiểm tra LSP
        PaymentMethod test = new MomoPayment();
        processor.processPayment(test, 800000);
    }
}
