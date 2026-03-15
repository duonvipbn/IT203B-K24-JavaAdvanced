package Ss07.Bai01;

class OrderCalculator {

    public double calculateTotal(Order order) {
        double total = 0;

        for (OrderItem item : order.items) {
            total += item.product.price * item.quantity;
        }

        return total;
    }
}