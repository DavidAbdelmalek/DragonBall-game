package dragonball.view;

import dragonball.model.game.*;
import javafx.scene.layout.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class StartMenu extends JFrame implements ActionListener {
	public StartMenu() {
		JPanel e = new JPanel();

		JButton j3 = new JButton("NEW GAME");
		j3.setFont(new Font("Serif", Font.ITALIC, 30));
		j3.setBackground(Color.LIGHT_GRAY);
		Dimension b = j3.getPreferredSize();
		j3.setBounds(566, 380, (int) (b.getWidth()), (int) b.getHeight());
		e.add(j3);

		j3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton j = ((JButton) e.getSource());
				if (j.getActionCommand().equals("NEW GAME")) {
					Info f = new Info();
					f.setVisible(true);
					j3.setVisible(false);
				}
			}
		});

		JButton j4 = new JButton("LOAD GAME");
		j4.setFont(new Font("Serif", Font.ITALIC, 30));

		j4.setBackground(Color.LIGHT_GRAY);
		j4.setBounds(566, 449, (int) (b.getWidth()), (int) b.getHeight());

		e.add(j4);
		j4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ObjectInputStream ois = new ObjectInputStream(
							new FileInputStream(new File("SAVED")));
					Game g = (Game) ois.readObject();
					ois.close();
					Grid h = new Grid(g);
					h.setVisible(true);
					j4.setVisible(false);
					dispose();
					Window r = new Window(
							"Your game has been successfully loaded");
					r.setSize(850, 200);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(j4, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(j4, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
				} catch (ClassNotFoundException e1) {
					JOptionPane.showMessageDialog(j4, e1.getMessage(),
							"Warning", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		JButton j5 = new JButton("Exit");
		j5.setFont(new Font("Serif", Font.ITALIC, 50));
		j5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane
						.showConfirmDialog(j5,
								"Are you sure that you want to exit",
								"Warning", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
			}

		});

		// f.add(j5);

		 e.add(j5);
		e.setBounds(566, 366, 100 + (int) (b.getWidth()),
				2 * (int) b.getHeight() + 100);
		e.setOpaque(false);
		// e.s
		add(e);
		JPanel nn = new JPanel();
		JLabel j6 = new JLabel("Welcome to DragonBall Adventures");
		// j6.setC
		// j6.setC
		Dimension yy = j6.getPreferredSize();
		j6.setFont(new Font("Serif", Font.PLAIN, 50));
		j6.setBounds(300, 60, 6 * (int) yy.getWidth(), 6 * (int) yy.getHeight());
		nn.add(j6);
		nn.setBounds(130, 60, 6 * (int) yy.getWidth(), 6 * (int) yy.getHeight());
		nn.setOpaque(false);
		add(nn);
		BufferedImage g = scaleImage(1366, 768,
				"dragonball_resurrection_cover.jpg");
		JLabel m = new JLabel(new ImageIcon(g));

		add(m);
		m.setBounds(0, 0, 1366, 768);

		setLayout(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1366, 768);
		setUndecorated(true);
		setVisible(true);
		// addWindowListener(new WindowDestroyer());
		// addMouseListener(this);

	}

	public static void main(String[] args) {
		StartMenu s = new StartMenu();
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

	public void actionPerformed(ActionEvent e) {
		JButton j = ((JButton) e.getSource());
		if (j.getActionCommand().equals("LOAD GAME")) {
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(new File("SAVED")));
				Game g = (Game) ois.readObject();
				ois.close();
				Grid h = new Grid(g);
				h.setVisible(true);
				this.setVisible(false);
				dispose();
				Window r = new Window("Your game has been successfully loaded");
				r.setSize(850, 200);
				// System.out.println(g.getPlayer().getName());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				new Window("You have no saved files");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (j.getActionCommand().equals("Exit")) {
			JOptionPane f = new JOptionPane();
		}
	}
}
