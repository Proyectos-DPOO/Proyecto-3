package P;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<paymentGateway> paymentGateways = loadPaymentGateways();

        System.out.println("Bienvenido al sistema de pago");
        System.out.println("Seleccione una pasarela de pago:");
        displayPaymentGatewayOptions(paymentGateways);

        int selectedOption = getUserInput();
        if (selectedOption >= 0 && selectedOption < paymentGateways.size()) {
            paymentGateway selectedPaymentGateway = paymentGateways.get(selectedOption);
            processPayment(selectedPaymentGateway);
        } else {
            System.out.println("Opción inválida");
        }
    }

    private static List<paymentGateway> loadPaymentGateways() {
        List<paymentGateway> paymentGateways = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("paymentgateways.txt"));
            String gatewayClassName;
            while ((gatewayClassName = reader.readLine()) != null) {
                try {
                    Class<?> gatewayClass = Class.forName(gatewayClassName);
                    paymentGateway gatewayInstance = (paymentGateway) gatewayClass.getDeclaredConstructor().newInstance();
                    paymentGateways.add(gatewayInstance);
                } catch (Exception e) {
                    System.out.println("Error al cargar la pasarela de pago: " + gatewayClassName);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración de pasarelas de pago");
        }
        return paymentGateways;
    }

    private static void displayPaymentGatewayOptions(List<paymentGateway> paymentGateways) {
        for (int i = 0; i < paymentGateways.size(); i++) {
            paymentGateway paymentGateway = paymentGateways.get(i);
            System.out.println(i + ". " + paymentGateway.getName());
        }
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void processPayment(paymentGateway paymentGateway) {
        System.out.println("Ha seleccionado la pasarela de pago: " + paymentGateway.getName());

        // Lógica para capturar la información de la tarjeta y el pago
        CreditCard card = captureCreditCardInfo();
        double amount = capturePaymentAmount();
        String accountNumber = captureAccountNumber();
        String transactionNumber = captureTransactionNumber();

        // Procesar el pago
        boolean paymentSuccess = paymentGateway.processPayment(card, amount, accountNumber, transactionNumber);

        // Mostrar el resultado del pago
        if (paymentSuccess) {
            System.out.println("El pago se ha realizado con éxito");
        } else {
            System.out.println("El pago ha sido rechazado");
        }
    }

    private static CreditCard captureCreditCardInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de tarjeta:");
        String cardNumber = scanner.nextLine();

        System.out.println("Ingrese el nombre del titular:");
        String cardHolderName = scanner.nextLine();

        System.out.println("Ingrese la fecha de vencimiento (MM/YY):");
        String expirationDate = scanner.nextLine();

        System.out.println("Ingrese el código de seguridad:");
        String securityCode = scanner.nextLine();

        return new CreditCard(cardNumber, cardHolderName, expirationDate, securityCode);
    }

    private static double capturePaymentAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el monto del pago:");
        return scanner.nextDouble();
    }

    private static String captureAccountNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta:");
        return scanner.nextLine();
    }

    private static String captureTransactionNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de transacción:");
        return scanner.nextLine();
    }
}

