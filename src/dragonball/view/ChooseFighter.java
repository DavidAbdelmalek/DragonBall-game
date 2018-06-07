package dragonball.view;

import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.game.Game;
import dragonball.model.player.Player;

public class ChooseFighter extends JFrame {
	Player g;
	static int x = 0;
	static int y = 0;
	static int i = 0;

	public ChooseFighter(Player og) {
		this.g = og;

		JPanel vv = new JPanel();
		vv.setLayout(new FlowLayout());

		ArrayList<PlayableFighter> fighter = og.getFighters();

		for (int i = 0; i < fighter.size(); i++) {
			JButton e = new JButton(new ImageIcon(
					checkForFigher(fighter.get(i))));
			e.setOpaque(false);
			e.setBorderPainted(false);
			e.setFocusable(false);
			e.setContentAreaFilled(false);
			// e.setBounds(x, y, 100, 100);
			e.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					g.setActiveFighter((PlayableFighter) arg0.getSource());
				}

			});
			vv.add(e);
			// x += 100;
			// y += 100;
		}
		BufferedImage uu = scaleImage(1366, 768, "ChooseFighterBack.jpg");
		JLabel Back = new JLabel(new ImageIcon(uu));

		Back.setLayout(null);
		// vv.setBounds(0, 0, 1366, 768);
		 Back.add(vv);
		// set Layout(null);
		add(Back);
		// setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		setUndecorated(true);
		setSize(1366, 768);
		setVisible(true);
	}

	public Image checkForFigher(PlayableFighter f) {
		BufferedImage gg = null;
		if (f instanceof Frieza) {
			gg = scaleImage(100, 100, "Frieza.png");
		} else {
			if (f instanceof Namekian) {
				gg = scaleImage(100, 100, "Namekian.png");
			} else {
				if (f instanceof Majin) {
					gg = scaleImage(100, 100, "Majin.png");
				} else {
					if (f instanceof Saiyan) {
						gg = scaleImage(100, 100, "Saiyn.jpg");
					} else {
						gg = scaleImage(100, 100, "Earthling.png");
					}
				}
			}
		}
		return gg;
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
		Player qwe = new Player("david");
		ChooseFighter e = new ChooseFighter(qwe);
	}
}
