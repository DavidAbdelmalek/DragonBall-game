package dragonball.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import dragonball.model.battle.BattleEvent;
import dragonball.model.cell.Cell;
import dragonball.model.cell.Collectible;
import dragonball.model.cell.CollectibleCell;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Grid extends JFrame implements ActionListener, KeyListener,
		GameListener {
	JPanel qwe;
	Game g;
	JLabel f5;
	JLabel f6;
	JLabel i1;
	JLabel i2;
	JLabel i3;
	JLabel i4;

	public Grid(Game og) {
		super();
		this.g = og;

		setLayout(null);
		JPanel kk = new JPanel();
		kk.setLayout(null);
		qwe = new JPanel();
		// qwe.setBorder(BorderFactory.createLineBorder(Color.RED));
		qwe.setLayout(new GridLayout(10, 10));
		qwe.setBounds(80, 100, 1318, 650);
		kk.add(qwe);
		JLabel ok = new JLabel(new ImageIcon(scaleImage(1366, 768, "Map.jpg")));

		for (int i = 0; i < 100; i++) {
			JLabel b = new JLabel();
			b.setPreferredSize(new Dimension(40, 40));
			b.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
			b.setFocusable(true);
			// b.setBorder(get);
			qwe.add(b);
			((JComponent) qwe.getComponent(i)).setOpaque(true);
			qwe.getComponent(i).setBackground(Color.green);
			qwe.getComponent(i).addKeyListener(this);
			// b.setEnabled(false);
		}
		try {
			Image img = ImageIO.read(new FileInputStream("images.jpg"));
			((JLabel) qwe.getComponent(99)).setIcon(new ImageIcon(img));
			qwe.getComponent(99).setEnabled(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * try { Image img = ImageIO.read(new FileInputStream("Bean.jpg"));
		 * BufferedImage img2 = scaleImage(150, 150, "Ball.png"); for (int i =
		 * 0; i < 10; i++) { for (int j = 0; j < 10; j++) { Cell c =
		 * g.getWorld().getMap()[i][j]; if (c instanceof CollectibleCell) {
		 * CollectibleCell cc = (CollectibleCell) c; if
		 * (cc.getCollectible().equals(Collectible.SENZU_BEAN)) { // int xx =
		 * g.getWorld().getPlayerRow(); // int zz =
		 * g.getWorld().getPlayerColumn(); int x = j + 10 * i; ((JLabel)
		 * qwe.getComponent(x)) .setIcon(new ImageIcon(img)); } else { int x = j
		 * + 10 * i; ((JLabel) qwe.getComponent(x)) .setIcon(new
		 * ImageIcon(img2)); } } } } // g.getWorld().getMap(). } catch
		 * (IOException e) { e.printStackTrace(); }
		 */i1 = new JLabel(
				"Player's Name: "
						+ g.getPlayer().getName()
						+ "                                                                                           ");
		i1.setFont(new Font("Serif", Font.PLAIN, 35));
		i1.setBounds(0, 0, 500, 40);
		kk.add(i1);

		i2 = new JLabel(
				"Active Fighter: "
						+ g.getPlayer().getActiveFighter().getName()
						+ "                                                                                       ");
		i2.setFont(new Font("Serif", Font.PLAIN, 35));
		i2.setBounds(0, 50, 500, 40);
		kk.add(i2);

		i3 = new JLabel("Level: " + g.getPlayer().getActiveFighter().getLevel());
		i3.setFont(new Font("Serif", Font.PLAIN, 35));
		i3.setBounds(1160, 50, 500, 40);
		kk.add(i3);

		i4 = new JLabel("XP: " + g.getPlayer().getActiveFighter().getXp());
		i4.setFont(new Font("Serif", Font.PLAIN, 35));
		i4.setBounds(1160, 0, 500, 40);
		kk.add(i4);

		BufferedImage bb1 = scaleImage(80, 100, "newAttack.jpg");
		JButton f3 = new JButton(new ImageIcon(bb1));
		f3.setToolTipText("AssigenNewAttack");
		f3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		BufferedImage bb = scaleImage(80, 100, "Upgrade.png");
		JButton f4 = new RoundButton(new ImageIcon(bb));
		f4.setToolTipText("Upgrading Fighter");
		f4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpgradingFrame f = new UpgradingFrame(g.getPlayer());
			}

		});

		BufferedImage bb2 = scaleImage(80, 100, "Upgrading.png");
		JButton f1 = new JButton(new ImageIcon(bb2));
		f1.setToolTipText("Change the fighter");
		f1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseFighter e = new ChooseFighter(g.getPlayer());
			}

		});

		BufferedImage bb3 = scaleImage(80, 100, "Choose (2).jpg");
		JButton f2 = new JButton(new ImageIcon(bb3));
		f2.setToolTipText("CreateAnewFighter");
		f2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				CreateNewFighter pp = new CreateNewFighter(g);
				setVisible(false);

			}

		});

		f5 = new JLabel("No of senzu beans: " + g.getPlayer().getSenzuBeans());
		f5.setFont(new Font("Serif", Font.PLAIN, 30));
		f5.setBounds((1366 / 2) - 50, 0, 300, 50);
		kk.add(f5);

		f6 = new JLabel("No of dragon balls: " + g.getPlayer().getDragonBalls());
		f6.setFont(new Font("Serif", Font.PLAIN, 30));
		f6.setBounds((1366 / 2) - 50, 55, 300, 50);
		kk.add(f6);

		f2.setBounds(0, 150, 80, 100);
		kk.add(f2);

		f1.setBounds(0, 300, 80, 100);
		kk.add(f1);
		f3.setBounds(0, 450, 80, 100);
		kk.add(f3);

		f4.setBounds(0, 600, 80, 100);
		kk.add(f4);
		ok.setBounds(0, 0, 1366, 768);
		kk.add(ok);
		kk.setOpaque(true);
		kk.setBounds(0, 0, 1366, 768);
		add(kk);
		// add()
		// add(vv);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		setUndecorated(true);
		setSize(1366, 768);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create a new Fighter")) {
			CreateFighter fff = new CreateFighter(g);
			fff.setVisible(true);
			setVisible(false);
			dispose();
		} else if ((e.getActionCommand().equals("Choose active fighter"))) {

		} else if (e.getActionCommand().equals("Upgrade active fighter")) {

		}
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		/*
		 * for(int i=0; i<100; i++) { if(((JLabel)
		 * getContentPane().getComponent(i)).isFocusOwner())
		 * System.out.println(i); }
		 */
		// System.out.println((g.getWorld().getMap()[5][4]).getClass());
		int l = 10 * g.getWorld().getPlayerRow()
				+ g.getWorld().getPlayerColumn();
		((JLabel) qwe.getComponent(l)).setIcon(null);
		// int i = g.getWorld().getPlayerRow();
		// int j = g.getWorld().getPlayerColumn();
		// System.out.println(i);
		// System.out.println(j);
		// getContentPane().getComponent(l).setEnabled(false);
		// getContentPane().getComponent(99).setEnabled(true);
		// System.out.println((g.getWorld().getMap()[i][j]).getClass());

		try {
			if (e.getKeyCode() == e.VK_UP)
				g.getWorld().moveUp();
			if (e.getKeyCode() == 40)
				g.getWorld().moveDown();
			if (e.getKeyCode() == 39)
				g.getWorld().moveRight();
			if (e.getKeyCode() == 37)
				g.getWorld().moveLeft();
		} catch (MapIndexOutOfBoundsException lol) {

		} catch (NullPointerException ll) {

		}
		String text = "No of senzu beans: " + g.getPlayer().getSenzuBeans();
		String text1 = "No of dragon balls: " + g.getPlayer().getDragonBalls();

		f5.setText(text);
		f6.setText(text1);

		int x = g.getWorld().getPlayerColumn() + 10
				* g.getWorld().getPlayerRow();
		// getContentPane().getComponent(x).setEnabled(true);
		try {

			// getContentPane().getComponent(x).addKeyListener(this);
			Image img = ImageIO.read(new FileInputStream("images.jpg"));
			((JLabel) qwe.getComponent(x)).setIcon(new ImageIcon(img));
			// getRootPane().setDefaultButton(((JButton)getContentPane().getComponent(x)));
		} catch (IOException r) {
			r.printStackTrace();
		}

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

	public static void main(String[] args) throws MissingFieldException,
			UnknownAttackTypeException {
		Game go = new Game();
		go.getPlayer().createFighter('S', "Mo");
		Grid g = new Grid(go);
		// g.setUndecorated(true);
		// g.setVisible(true);
	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		ArrayList<Dragon> f = g.getDragons();
		Random w = new Random();
		Dragon lol = f.get(w.nextInt(f.size()));
		
		DragonWindow e = new DragonWindow(g,lol);
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
	}
}
