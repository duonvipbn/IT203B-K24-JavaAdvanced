package Ss07.Bai03;

interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}