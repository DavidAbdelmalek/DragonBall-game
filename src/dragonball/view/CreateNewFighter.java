package dragonball.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class CreateNewFighter extends JFrame {
	Game g;
	JTextField a;

	// boolean selected = false;
	char ff;

	public CreateNewFighter(Game l) {
		this.g = l;
		ff = ' ';
		a = new JTextField(10);
		System.out.println("[" + a.getText() + "]");
		a.setFont(new Font("Serif", Font.ROMAN_BASELINE, 50));

		// System.out.print(a.getText()+55);
		JButton Create = new JButton();
		Create.setText("Create!");
		Create.setFont(new Font("Serif", Font.BOLD, 50));
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (a.getText().equals("")) {
					new Window("Please set a Name for your Fighter");
				} else if (ff == ' ')
					new Window("Please set a Fighter");
				else
				g.getPlayer().createFighter(ff, a.getText());
				Grid w = new Grid(g);
				setVisible(false);
				// g.getPlayer().createFighter('F',);
			}
		});

		JPanel e = new JPanel();
		e.setLayout(null);

		BufferedImage F1 = scaleImage(270, 700, "Frieza.png");
		BufferedImage F2 = scaleImage(270, 700, "Majin.png");
		BufferedImage F3 = scaleImage(270, 700, "Namekian.png");
		BufferedImage F4 = scaleImage(270, 700, "Earthling.png");
		BufferedImage F5 = scaleImage(270, 700, "Saiyn.jpg");
		// JButton Health = new JButton(new ImageIcon(H));

		JButton F6 = new JButton(new ImageIcon(F1));
		F6.setToolTipText("Frieza");
		F6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ff = 'F';
				F6.setBorder(BorderFactory.createLineBorder(Color.BLUE));

			}
		});
		JButton F7 = new JButton(new ImageIcon(F2));
		F7.setToolTipText("Majin");
		F7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ff = 'M';
			//	F7.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
		});
		JButton F8 = new JButton(new ImageIcon(F3));
		F8.setToolTipText("Namekian");
		F8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ff = 'N';
				//F8.setBorder(BorderFactory.createLineBorder(Color.RED));
			}
		});
		JButton F9 = new JButton(new ImageIcon(F4));
		F9.setToolTipText("Earthling");
		F9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ff = 'E';
				F9.setBorder(BorderFactory
						.createBevelBorder(BevelBorder.LOWERED));
			}
		});
		JButton F10 = new JButton(new ImageIcon(F5));
		F10.setToolTipText("Saiyan");
		F10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ff = 'S';
				//F10.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// e.add(ww);
		F6.setBounds(0, 0, 270, 700);
		F7.setBounds(272, 0, 270, 700);
		F8.setBounds(544, 0, 270, 700);
		F9.setBounds(820, 0, 270, 700);
		F10.setBounds(1096, 0, 270, 700);

		JLabel hh = new JLabel("Player's Name is ");
		hh.setFont(new Font("Serif", Font.BOLD, 50));

		hh.setBounds(0, 700, 450, 768 - 700);

		a.setBounds(380, 700, 700, 768 - 700);

		Create.setBounds(1080, 700, 300, 768 - 700);

		BufferedImage tt = scaleImage(1366, 768, "BackForCreating.png");
		JLabel y = new JLabel(new ImageIcon(tt));
		y.setBounds(0, 0, 1366, 768);

		e.add(F6);
		e.add(F7);
		e.add(F8);
		e.add(F9);
		e.add(F10);
		e.add(a);
		e.add(hh);
		e.add(Create);
		e.add(y);

		add(e);

		setUndecorated(true);
		setSize(1366, 768);
		setVisible(true);
	}

	public static void main(String[] args) throws MissingFieldException,
			UnknownAttackTypeException {
		Game q = new Game();
		CreateNewFighter e = new CreateNewFighter(q);
	}

	public static BufferedImage scaleImage(int WIDTH, int HEIGHT,
			String filename) {
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
}
