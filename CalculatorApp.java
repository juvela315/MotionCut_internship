import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp{
    private JFrame frame;
    private JPanel panel;
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private double num1, num2, result;
    private String operator;

    public CalculatorApp() {
        frame = new JFrame("Calculator");
        panel = new JPanel();
        inputField = new JTextField(10);

        numberButtons = new JButton[10];
        operationButtons = new JButton[4];

        operator = "";

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        inputField.setPreferredSize(new Dimension(400, 50));
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(JTextField.RIGHT);
        inputField.setEditable(false);

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            final int digit = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inputField.setText(inputField.getText() + digit);
                }
            });
        }

        for (int i = 0; i < 4; i++) {
            final String[] operators = {"+", "-", "*", "/"};
            operationButtons[i] = new JButton(operators[i]);
            operationButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
            final String op = operators[i];
            operationButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    num1 = Double.parseDouble(inputField.getText());
                    operator = op;
                    inputField.setText("");
                }
            });
        }

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 24));
        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(inputField.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            inputField.setText("Error");
                            return;
                        }
                        break;
                }
                inputField.setText(String.valueOf(result));
            }
        });

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                num1 = 0;
                num2 = 0;
                operator = "";
            }
        });

        panel.setLayout(new GridLayout(4, 4));
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(operationButtons[0]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(operationButtons[1]);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(operationButtons[2]);
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(operationButtons[3]);

        frame.add(inputField, BorderLayout.NORTH);
        frame.add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorApp();
            }
        });
    }
}
