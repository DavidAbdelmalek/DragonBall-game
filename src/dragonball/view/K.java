package dragonball.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class K extends JPanel implements ActionListener {
	Timer m = new Timer(5, this);
	int x = 0, vel = 2;
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(x, 2, 15, 13);
		m.start();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		x+=vel;
		repaint();
		if(x>=585 || x<=0)
			vel = -vel;
		
	}
	public static void main(String[] args) {
		K m = new K();
		JFrame j = new JFrame();
		j.setSize(600, 400);
		j.setVisible(true);
		j.add(m);
	}
}
