package dragonball.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.*;

public class Window extends JFrame implements ActionListener {
	public Window(String x) {
		JLabel l = new JLabel(x);
		l.setFont(new Font("Serif", Font.PLAIN, 50));
		setSize(1000, 200);
		setLayout(new FlowLayout());
		getContentPane().add(l, BorderLayout.NORTH);
		setVisible(true);
		JPanel p = new JPanel();
		JButton b = new JButton("OK");
		b.setFont(new Font("Serif", Font.PLAIN, 50));
		b.addActionListener(this);
		p.add(b);
		getContentPane().add(p, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		//addWindowListener(new WindowDestroyer());
	}
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		dispose();
	}
}
