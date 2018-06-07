package dragonball.view;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.dragon.DragonWishType;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;

public class DragonWindow extends JFrame {
	Game g;
	Dragon lol;

	public DragonWindow(Game l, Dragon lol) {
		this.g = l;
		this.lol = lol;
		JPanel w = new JPanel();
		w.setLayout(null);

		BufferedImage f = scaleImage(1000, 500, "Dragon.jpg");
		JLabel e = new JLabel(new ImageIcon(f));

		e.setBounds(0, 0, 1000, 500);

		BufferedImage i1 = scaleImage(250, 100, "Senzu.png");
		BufferedImage i2 = scaleImage(250, 100, "UltimateAttack.jpg");
		BufferedImage i3 = scaleImage(250, 100, "Super.jpg");
		BufferedImage i4 = scaleImage(250, 100, "New.jpg");

		JButton f1 = new JButton(new ImageIcon(i1));
		f1.setToolTipText("Senzu Beans");
		f1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				g.getPlayer().chooseWish(
						new DragonWish(lol, DragonWishType.SENZU_BEANS));
				setVisible(false);
			}

		});
		JButton f2 = new JButton(new ImageIcon(i2));
		f2.setToolTipText("UltimateAttack");
		f2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				g.getPlayer().chooseWish(
						new DragonWish(lol, DragonWishType.ULTIMATE_ATTACK));
				setVisible(false);
			}
		});
		JButton f3 = new JButton(new ImageIcon(i3));
		f3.setToolTipText("SuperAttack");
		f3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				g.getPlayer().chooseWish(
						new DragonWish(lol, DragonWishType.SUPER_ATTACK));
				setVisible(false);
			}
		});
		JButton f4 = new JButton(new ImageIcon(i4));
		f4.setToolTipText("AbilityPoints");
		f4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				g.getPlayer().chooseWish(
						new DragonWish(lol, DragonWishType.ABILITY_POINTS));
				setVisible(false);
			}
		});

		f1.setBounds(0, 250, 250, 100);
		f2.setBounds(250, 250, 250, 100);
		f3.setBounds(500, 250, 250, 100);
		f4.setBounds(750, 250, 250, 100);

		w.add(f1);
		w.add(f2);
		w.add(f3);
		w.add(f4);
		w.add(e);

		add(w);
		setSize(1000, 500);
		setUndecorated(true);
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

	public static void main(String[] args) throws MissingFieldException,
			UnknownAttackTypeException {
		Game w = new Game();
		ArrayList<Dragon> f = w.getDragons();
		Random ff = new Random();
		Dragon lol = f.get(ff.nextInt(f.size()));
		DragonWindow e = new DragonWindow(w, lol);
	}
}
