package dragonball.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.character.fighter.Fighter;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.player.Player;

public class UpgradingFrame extends JFrame implements ActionListener {
	Player f;

	public UpgradingFrame(Player f)// Player player){
	{
		JPanel vv = new JPanel();
		vv.setLayout(null);

		BufferedImage H = scaleImage(100, 50, "Health.png"); // BufferedImage B
		BufferedImage P = scaleImage(100, 50, "Physical.jpg");
		BufferedImage K = scaleImage(100, 50, "Ki.png"); // BufferedImage S =
															// scaleImage(100,50,)
		BufferedImage S = scaleImage(100, 50, "Stamina.png");
		BufferedImage B = scaleImage(100, 50, "BlastDamage.png");

		JButton Health = new JButton(new ImageIcon(H));
		Health.setOpaque(true);
		Health.setBorderPainted(false);
		Health.setFocusable(false);
		Health.setContentAreaFilled(false);
		Health.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					f.upgradeFighter(f.getActiveFighter(), 'H');
					setVisible(false);
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(Health, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				}
			}
		});

		JButton PHYSICAL = new JButton(new ImageIcon(P));
		PHYSICAL.setOpaque(false);
		PHYSICAL.setBorderPainted(false);
		PHYSICAL.setFocusable(false);
		PHYSICAL.setContentAreaFilled(false);
		PHYSICAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f.upgradeFighter(f.getActiveFighter(), 'P');
					setVisible(false);
				} catch (NotEnoughAbilityPointsException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(PHYSICAL, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				}
			}
		});

		JButton KI = new JButton(new ImageIcon(K));
		KI.setOpaque(false);
		KI.setBorderPainted(false);
		KI.setFocusable(false);
		KI.setContentAreaFilled(false);
		KI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f.upgradeFighter(f.getActiveFighter(), 'K');
					setVisible(false);
				} catch (NotEnoughAbilityPointsException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(KI, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				}
			}
		});
		JButton Stamina = new JButton(new ImageIcon(S));
		Stamina.setOpaque(false);
		Stamina.setBorderPainted(false);
		Stamina.setFocusable(false);
		Stamina.setContentAreaFilled(false);
		Stamina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f.upgradeFighter(f.getActiveFighter(), 'S');
					setVisible(false);
				} catch (NotEnoughAbilityPointsException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(Stamina, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				}
			}
		});

		JButton Blast = new JButton(new ImageIcon(B));
		Blast.setOpaque(false);
		Blast.setBorderPainted(false);
		Blast.setFocusable(false);
		Blast.setContentAreaFilled(false);
		Blast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f.upgradeFighter(f.getActiveFighter(), 'B');
					setVisible(false);
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(Blast, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
				}
			}
		});
		Box e = Box.createHorizontalBox();
		e.add(Health);
		Box.createHorizontalGlue();
		// e.setOpaque(true );
		e.add(PHYSICAL);
		Box.createHorizontalGlue();
		e.add(KI);
		Box.createHorizontalGlue();
		e.setBounds(379, 169, 390, 100);

		vv.add(e);

		Dimension ff = Stamina.getPreferredSize();
		Stamina.setBounds(430, 281, (int) ff.getWidth(), (int) ff.getHeight());
		Blast.setBounds(600, 281, (int) ff.getWidth(), (int) ff.getHeight());
		vv.add(Stamina);
		vv.add(Blast);
		JLabel rr = new JLabel();
		try {
			BufferedImage img = ImageIO.read(new FileInputStream("Back2.jpg"));
			rr.setIcon(new ImageIcon(img));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		rr.setBounds(0, 0, 780, 440);
		vv.add(rr);
		add(vv);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		setUndecorated(true);
		setSize(780, 440);
		setVisible(true);
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

	public static void main(String[] args) {

		Player gg = new Player("David");
		gg.createFighter('F', "david");

		// gg.setActiveFighter(ff);
		UpgradingFrame e = new UpgradingFrame(gg);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}