package Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {

    private char operatorSign;
    private int firstArgument;
    private int secondArgument;
    private boolean ifNumber;
    private TextField textField;
    private String out;
    private boolean ifEqu;
    private boolean ifSecSign;

    public MyActionListener(TextField text) {
        operatorSign = '0';
        firstArgument = 0;
        secondArgument = 0;
        ifNumber = true;
        textField = text;
        out = "0";
        ifEqu = false;
        ifSecSign = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        char sign;
        sign = e.getActionCommand().charAt(0);
        if (out == "0" || out == "ERROR") out = "";
        out = out + sign;
        textField.setForeground(Color.black);

        switch (sign) {
            case '+':
            case '-':
            case '*':
            case '/':
                if (!ifNumber) ifSecSign = true;
                if (operatorSign != '0' && ifNumber) {
                    if (!Calculate()) break;
                }
                operatorSign = sign;
                ifNumber = false;
                break;

            case '=':
                if (Calculate()) out = "" + firstArgument;
                ifEqu = true;
                operatorSign = '0';
                secondArgument = 0;
                ifNumber = true;
                break;

            case 'C':
                out = "0";
                operatorSign = '0';
                firstArgument = 0;
                secondArgument = 0;
                ifNumber = true;
                ifSecSign = false;
                textField.setText(out);
                break;

            default:
                if (ifNumber) firstArgument = firstArgument * 10 + sign - '0';
                else {
                    ifNumber = true;
                    ifSecSign = false;
                    secondArgument = firstArgument;
                    firstArgument = sign - '0';
                }
                break;
        }

        if (ifSecSign) {
            out = out.substring(0, out.length() - 2) + sign;
        }
        textField.setText(out);
    }

    public boolean Calculate() {
        switch (operatorSign) {
            case '+':
                firstArgument = firstArgument + secondArgument;
                return true;
            case '-':
                firstArgument = secondArgument - firstArgument;
                return true;
            case '*':
                firstArgument = firstArgument * secondArgument;
                return true;
            case '/':
                try {
                    firstArgument = secondArgument / firstArgument;
                    return true;
                } catch (ArithmeticException e) {
                    out = "ERROR";
                    textField.setForeground(Color.red);
                    operatorSign = '0';
                    firstArgument = 0;
                    secondArgument = 0;
                    ifNumber = true;
                    ifSecSign = false;
                    return false;
                }
        }
        return false;
    }
}
