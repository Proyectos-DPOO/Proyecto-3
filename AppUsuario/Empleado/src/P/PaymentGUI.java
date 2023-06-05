package P;

import P.paymentGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI {
    private paymentGateway PaymentGateway;

    public PaymentGUI(paymentGateway paymentGateway) {
        this.PaymentGateway = paymentGateway;
    }

    public void setupGUI() {
        JFrame frame = new JFrame("Payment Gateway");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 2));

        // Label y campo de texto para el número de tarjeta
        JLabel cardNumberLabel = new JLabel("Card Number:");
        JTextField cardNumberField = new JTextField();
        mainPanel.add(cardNumberLabel);
        mainPanel.add(cardNumberField);

        // Label y campo de texto para el nombre del titular de la tarjeta
        JLabel cardHolderLabel = new JLabel("Card Holder:");
        JTextField cardHolderField = new JTextField();
        mainPanel.add(cardHolderLabel);
        mainPanel.add(cardHolderField);

        // Botón de pago
        JButton paymentButton = new JButton("Make Payment");
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberField.getText();
                String cardHolder = cardHolderField.getText();

                CreditCard creditCard = new CreditCard(cardNumber, cardHolder);

                // Realizar el pago utilizando la pasarela de pago
                boolean paymentResult = PaymentGateway.processPayment(cardNumber, cardHolder, amount, description, currency);

                // Mostrar el resultado del pago en un mensaje emergente
                String message = paymentResult ? "Payment successful" : "Payment failed";
                JOptionPane.showMessageDialog(frame, message);
            }
        });
        mainPanel.add(paymentButton);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    public void showGUI() {
        SwingUtilities.invokeLater(() -> setupGUI());
    }
}

