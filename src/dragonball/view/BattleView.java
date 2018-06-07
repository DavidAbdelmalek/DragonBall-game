package dragonball.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
//import javafx.scene.layout.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleView extends JFrame {
	Game g;

	public BattleView(Game g) {
		this.g = g;
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		setLayout(new BorderLayout());
		Box x = Box.createVerticalBox();
		Box x1 = Box.createVerticalBox();

		JPanel p = new JPanel();
		p.setBorder(new BevelBorder(BevelBorder.RAISED));
		add(p, BorderLayout.NORTH);
		p.setPreferredSize(new Dimension(100, 0));
		p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));

		JProgressBar o = new JProgressBar();
		o.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		o.setBounds(0, 0, 800, 500);
		o.setSize(100, 5000);
		// p1.add(o);

		JProgressBar o1 = new JProgressBar();
		o1.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		o.setBounds(0, 0, 500, 500);

		JProgressBar o2 = new JProgressBar();
		o2.setAlignmentX(JLabel.LEFT_ALIGNMENT);
		o.setBounds(0, 0, 1500, 500);
		
		JProgressBar o3 = new JProgressBar();
		o.setBounds(0, 0, 500, 500);
		JProgressBar o4 = new JProgressBar();
		o.setBounds(0, 0, 500, 500);
		JProgressBar o5 = new JProgressBar();
		o.setBounds(0, 0, 500, 500);
		// o3.setValue(50);
		// o3.setStringPainted(true);
		viewBar(o1);
		JLabel l = new JLabel("Woooohoooooo");
		l.setHorizontalAlignment(SwingConstants.LEFT);
		p.add(l);
		x.setBounds(0, 0, 1000, 1000);
		x.add(o);
		x.add(o1);
		x.add(o2);

		x1.add(o3);
		x1.add(o4);
		x1.add(o5);
		getContentPane().setLayout(new BorderLayout());
		add(x, BorderLayout.WEST);
		add(x1, BorderLayout.EAST);

		// setLayout(new FlowLayout());
		// p.add(new JButton(""));
		addWindowListener(new WindowDestroyer());

		// Box x = new Box(49);

	}

	public void viewBar(JProgressBar b) {
		b.setStringPainted(true);
		b.setValue(0);

		int timeDelay = 10;
		// Timer t = new Timer(10, new StartMenu());
		new Timer(timeDelay, new ActionListener() {

			private int index = 0;
			private int maxIndex = 100;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (index < maxIndex) {
					b.setValue(index);
					index++;
				} else {
					b.setValue(maxIndex);
					((Timer) e.getSource()).stop();
				}

			}

		}).start();
		b.setValue(b.getMinimum());
	}

	public static void main(String[] args) throws MissingFieldException, UnknownAttackTypeException {
		BattleView b = new BattleView(new Game());
		b.setSize(b.getMaximumSize());
		b.setVisible(true);
	}
}
