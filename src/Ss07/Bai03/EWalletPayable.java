package Ss07.Bai03;

interface EWalletPayable extends PaymentMethod {
    void processEWallet(double amount);
}