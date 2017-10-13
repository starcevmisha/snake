package delme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stocks implements ActionListener {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Stocks().createGui();
            }
        });

    }

    public void createGui() {
        JFrame frame = new JFrame("Java Stocks");
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        frame.add(panel);
        frame.getContentPane().add(panel, BorderLayout.WEST);
        GridBagConstraints c = new GridBagConstraints();

        JButton button1 = new JButton("Profile");
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(40, 40, 40, 40);
        panel.add(button1, c);
        button1.addActionListener(this);

        JButton button2 = new JButton("Market");
        c.gridx = 0;
        c.gridy = 1;
        panel.add(button2, c);
        button2.addActionListener(this);

        JButton button3 = new JButton("Users");
        c.gridx = 0;
        c.gridy = 2;
        panel.add(button3, c);
        button3.addActionListener(this);

        JButton button4 = new JButton("Notes");
        c.gridx = 0;
        c.gridy = 3;
        panel.add(button4, c);
        button4.addActionListener(this);

        JButton button5 = new JButton("Information");
        c.gridx = 0;
        c.gridy = 4;
        panel.add(button5, c);
        button5.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JFrame frame2 = new JFrame("Your Stocks");
        frame2.setVisible(true);
        frame2.setSize(600, 600);
        JLabel label = new JLabel("Your Personal Stocks");
        JPanel panel = new JPanel();
        frame2.add(panel);
        panel.add(label);
    }
}