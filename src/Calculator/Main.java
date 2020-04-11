package Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator {

    public static void createAndShowGUI() {

        JFrame jf = new JFrame("Kalkulator");

        Font font = new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT, 40);

        TextField textField = new TextField();
        textField.setFont(font);

        textField.setEditable(false);

        MyActionListener myActionListener = new MyActionListener(textField);
        textField.setText("0");

        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.decode(String.valueOf(Integer.parseInt("d7e1fe", 16))));

        jPanel.setLayout(new GridLayout(4, 4));
        jPanel.setPreferredSize(new Dimension(400, 200));

        JButton[] buttons = new JButton[16];
        int j = 0;

        for (int i = 1; i < 10; i++) {
            buttons[j] = new JButton("" + i);

            j++;
            if (i == 3) {
                buttons[j] = new JButton("+");
                j++;
            }
            if (i == 6) {
                buttons[j] = new JButton("-");
                j++;
            }
            if (i == 9) {
                buttons[j] = new JButton("*");
                j++;
            }
        }
        buttons[j] = new JButton("0");
        j++;
        buttons[j] = new JButton("=");
        j++;
        buttons[j] = new JButton("C");
        j++;
        buttons[j] = new JButton("/");
        font = new Font("Verdana", Font.BOLD, 20);
        for (int i = 0; i < 16; i++) {

            buttons[i].addActionListener(myActionListener);
            buttons[i].setBackground(Color.gray);
            buttons[i].setFont(font);
            buttons[i].setPreferredSize(new Dimension(20, 20));
            jPanel.add(buttons[i]);
        }

        jf.getContentPane().add(textField, BorderLayout.NORTH);
        jf.getContentPane().add(jPanel);
        jf.setPreferredSize(new Dimension(500, 300));
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


}
