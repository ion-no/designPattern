package designPatterns;

import java.util.Scanner;

interface PaymentMethod {
    void pay(double amount);
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment done with a credit card");
    }
}

class DebitCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Payment done with a debit card");
    }
}

class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void pay(double amount) {
        paymentMethod.pay(amount);
    }
}

public class Main2 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter payment method (credit/debit):");
            String choice = scanner.nextLine().toLowerCase();

            PaymentMethod paymentMethod;
            if (choice.equals("debit")) {
            paymentMethod = new DebitCardPayment();
            } else {
            paymentMethod = new CreditCardPayment();
            }
            
            PaymentProcessor paymentProcessor = new PaymentProcessor(paymentMethod);
            paymentProcessor.pay(23);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
