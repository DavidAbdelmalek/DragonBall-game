package dragonball.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class CreateFighter extends JFrame implements ActionListener {
	Game gam;
	JTextField a;
	JButton bab;
	JButton m11;
	JButton m22;
	JButton m33;
	JButton m44;
	JButton m55;

	public CreateFighter(Game g) {
		gam = g;
		Container c = getContentPane();
		setSize(getMaximumSize());
		// Container c = getContentPane();

		JPanel p = new JPanel();
		// p.setBackground(Color.CYAN);
		// p.setLayout(new FlowLayout());

		a = new JTextField(10);
		a.setFont(new Font("Serif", Font.PLAIN, 50));

		JPanel p2 = new JPanel();
		// p2.setBackground(Color.CYAN);
		// p2.setLayout(new FlowLayout());

		JPanel p3 = new JPanel();
		JLabel haha = new JLabel("Please choose a race");
		haha.setFont(new Font("Serif", Font.PLAIN, 50));
		// p3.setBackground(Color.CYAN);
		// p3.setFLayout(new FlowLayout());
		p3.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel s = new JLabel("Create a fighter");
		s.setFont(new Font("Serif", Font.PLAIN, 50));
		p.add(s);

		JLabel m = new JLabel("Please enter the fighter's name");
		m.setFont(new Font("Serif", Font.PLAIN, 50));
		JButton r = new JButton("Create");
		r.addActionListener(this);
		r.setFont(new Font("Serif", Font.PLAIN, 50));
		JButton m1 = new JButton("");
		// m1.setFont(new Font("Serif", Font.PLAIN, 40));

		m1.addActionListener(this);
		m1.setActionCommand(1 + "");
		JButton m2 = new JButton("");
		m2.addActionListener(this);
		m2.setActionCommand(2 + "");
		JButton m3 = new JButton("");
		m3.addActionListener(this);
		m3.setActionCommand(3 + "");
		JButton m4 = new JButton("");
		m4.addActionListener(this);

		m4.setActionCommand(4 + "");
		JButton m5 = new JButton("");
		m5.addActionListener(this);
		m5.setActionCommand(5 + "");
		m11 = m1;
		m22 = m2;
		m33 = m3;
		m44 = m4;
		m55 = m5;
		try {
			Image img = ImageIO.read(new FileInputStream("Frieza.png"));
			BufferedImage im = scaleImage(300, 700, "Frieza.png");
			m1.setIcon(new ImageIcon(im));

			// Image img1 = ImageIO.read(new FileInputStream("Krilling.png"));
			// BufferedImage im1 = scaleImage(300, 700, "Krillin.png");
			// m2.setIcon(new ImageIcon(im1));

			Image img2 = ImageIO.read(new FileInputStream("Majin.png"));
			BufferedImage im2 = scaleImage(300, 700, "Majin.png");

			m3.setIcon(new ImageIcon(im2));

			Image img3 = ImageIO.read(new FileInputStream("Piccolo.png"));
			BufferedImage im3 = scaleImage(300, 700, "Piccolo.png");

			m4.setIcon(new ImageIcon(im3));

			Image img4 = ImageIO.read(new FileInputStream("Vegeta.png"));
			BufferedImage im4 = scaleImage(300, 700, "Vegeta.png");
			m5.setIcon(new ImageIcon(im4));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * m1.setSize(5, 6); m2.setSize(5, 6); m3.setSize(5, 6); m4.setSize(5,
		 * 6); m5.setSize(5, 6);
		 */

		p2.add(m);
		p2.add(a);
		p2.add(r);

		p3.add(m1);
		p3.add(m2);
		p3.add(m3);
		p3.add(m4);
		p3.add(m5);
		p3.add(haha, BorderLayout.SOUTH);
		getContentPane().setLayout(new BorderLayout());

		// p.add(j1, BorderLayout.NORTH);
		// p.add(j2, BorderLayout.SOUTH);

		// c.add(p2, BorderLayout.SOUTH);
		c.add(p, BorderLayout.NORTH);
		c.add(p3, BorderLayout.CENTER);
		c.add(p2, BorderLayout.SOUTH);

		/*
		 * getContentPane().add(j1, BorderLayout.NORTH);
		 * getContentPane().add(j2, BorderLayout.SOUTH);
		 * getContentPane().add(j3, BorderLayout.WEST); getContentPane().add(j4,
		 * BorderLayout.EAST); getContentPane().add(j5, BorderLayout.CENTER);
		 */
		addWindowListener(new WindowDestroyer());
		m11.setBackground(null);
		m22.setBackground(null);
		m33.setBackground(null);
		m44.setBackground(null);
		m55.setBackground(null);
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

	public void actionPerformed(ActionEvent e) {
		if (!(e.getActionCommand().equals("Create"))) {
			m11.setBackground(null);
			m22.setBackground(null);
			m33.setBackground(null);
			m44.setBackground(null);
			m55.setBackground(null);
			((JButton) e.getSource()).setBackground(Color.RED);
			bab = ((JButton) e.getSource());
		}
		if (e.getActionCommand().equals("Create")) {
			if (bab != null && !(a.getText().equals(""))) {
				switch (bab.getActionCommand()) {
				case "1":
					gam.getPlayer().createFighter('F', a.getText());
					// System.out.println("Helllo");
					break;
				case "2":
					gam.getPlayer().createFighter('E', a.getText());
					break;
				case "3":
					gam.getPlayer().createFighter('M', a.getText());
					break;
				case "4":
					gam.getPlayer().createFighter('N', a.getText());
					break;
				case "5":
					gam.getPlayer().createFighter('S', a.getText());
					break;
				}
				Grid jjj = new Grid(gam);
				jjj.setVisible(true);
				this.setVisible(false);
				dispose();
				try {
					gam.save("Saved");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (bab == null && !(a.getText().equals("")))
				new Window("Please choose a race");
			else if (a.getText().equals("") && bab != null)
				new Window("Please enter the fighter's name");
			else
				new Window("Please choose a race and enter the fighter's name")
						.setSize(1000, 200);
			setVisible(true);
		}

	}

	public static void main(String[] args) throws MissingFieldException,
			UnknownAttackTypeException {
		CreateFighter f = new CreateFighter(new Game());
		// f.setVisible(true);
	}
}
