package dragonball.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import dragonball.model.character.fighter.Frieza;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class Info extends JFrame implements ActionListener, KeyListener {
	JTextField a;
	JTextField a2;
	Game gam;

	public Info() {
		super();
		setSize(getMaximumSize());
		Container c = getContentPane();
		JPanel p = new JPanel();
		p.setBackground(Color.CYAN);
		p.setLayout(new FlowLayout());
		JLabel m = new JLabel();
		try {
			Image img = ImageIO.read(new FileInputStream(
					"dragonball_resurrection_cover.jpg"));
			m.setIcon(new ImageIcon(img));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JPanel p2 = new JPanel();
		p2.setBackground(Color.CYAN);
		p2.setLayout(new FlowLayout());
		try {
			gam = new Game();
		} catch (MissingFieldException | UnknownAttackTypeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel p3 = new JPanel();
		p3.setBackground(Color.CYAN);
		p3.setLayout(new FlowLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		// JLabel m = new JLabel("Please choose a race");
		// m.setFont(new Font("Serif", Font.PLAIN, 50));
		p3.add(m);

		/*
		 * m1.setSize(5, 6); m2.setSize(5, 6); m3.setSize(5, 6); m4.setSize(5,
		 * 6); m5.setSize(5, 6);
		 */

		JTextField h = new JTextField(10);
		h.setFont(new Font("Serif", Font.PLAIN, 50));

		getContentPane().setLayout(new BorderLayout());
		JLabel label = new JLabel("A label");

		label.setFont(new Font("Serif", Font.PLAIN, 50));
		JLabel j1 = new JLabel("Please enter your name: ");
		j1.setFont(new Font("Serif", Font.PLAIN, 50));

		JTextField j2 = new JTextField(10);
		j2.setFont(new Font("Serif", Font.PLAIN, 50));
		JButton j3 = new JButton("Create Player");
		j3.addActionListener(this);
		a = j2;
		j2.addActionListener(this);
		j3.setFont(new Font("Serif", Font.PLAIN, 50));
		// j3.addActionListener(this);
		JButton j4 = new JButton("LOAD GAME");
		j4.setFont(new Font("Serif", Font.PLAIN, 50));
		JLabel j5 = new JLabel(
				"Welcome to DragonBall Adventures (THE VIDEO GAME)");
		j5.setFont(new Font("Serif", Font.PLAIN, 50));

		// p.add(j1, BorderLayout.NORTH);
		// p.add(j2, BorderLayout.SOUTH);
		p.add(j1);
		p.add(j2);
		p.add(j3);
		c.add(p, BorderLayout.NORTH);
		c.add(p2, BorderLayout.SOUTH);
		c.add(p3, BorderLayout.CENTER);

		/*
		 * getContentPane().add(j1, BorderLayout.NORTH);
		 * getContentPane().add(j2, BorderLayout.SOUTH);
		 * getContentPane().add(j3, BorderLayout.WEST); getContentPane().add(j4,
		 * BorderLayout.EAST); getContentPane().add(j5, BorderLayout.CENTER);
		 */
		addWindowListener(new WindowDestroyer());
		// addMouseListener(this);

	}

	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("Welcome.png").getImage();
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
		g.drawImage(img, 0, 0, null);
	}

	public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
		BufferedImage bi = null;
		try {
			ImageIcon ii = new ImageIcon(filename);// path to image
			bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = (Graphics2D) bi.createGraphics();
			g2d.addRenderingHints(new RenderingHints(
					RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY));
			g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bi;
	}

	public static void main(String[] args) {
		Info f = new Info();
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Create Player")) {
			if (a.getText().contains(" "))
				new Window("Please don't leave spaces");
			else if (a.getText().equals(""))
				new Window("Please enter the player name");
			else {
				gam.getPlayer().setName(a.getText());
				CreateNewFighter o = new CreateNewFighter(gam);
				this.setVisible(false);
				dispose();
				o.setVisible(true);
			}
		}
		// System.out.println(e.getActionCommand());
	}

	public void keyPressed(KeyEvent e) {

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent e) {

	}
}
