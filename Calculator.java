import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private double num1, num2, result;
    private char operator;

    public Calculator() {

        // Frame settings
        setTitle("Modern Java Calculator");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(new Color(240, 240, 240));
        display.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        panel.setBackground(new Color(220, 220, 220));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setFocusPainted(false);
            btn.setBackground(Color.WHITE);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        // If number or dot
        if ((command.charAt(0) >= '0' && command.charAt(0) <= '9') || command.equals(".")) {
            display.setText(display.getText() + command);
        }

        // If operator
        else if (command.equals("+") || command.equals("-") ||
                 command.equals("*") || command.equals("/")) {

            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        }

        // If equals
        else if (command.equals("=")) {

            try {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            display.setText("Error");
                            return;
                        }
                        result = num1 / num2;
                        break;
                }

                display.setText(String.valueOf(result));

            } catch (Exception ex) {
                display.setText("Error");
            }
        }

        // Clear button
        else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
