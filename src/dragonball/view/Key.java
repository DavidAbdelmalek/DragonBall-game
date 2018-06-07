package dragonball.view;

import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Key extends KeyAdapter implements java.awt.event.KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//((Button) ((JFrame) e.getComponent()).getContentPane().getComponent(0)).setLabel("LOL");
		//System.exit(0);
		//System.out.println("helllllllo");
		System.out.println(e.getKeyCode());
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//displayInfo(e, "KEY TYPED: ");
		//System.out.println(e.getKeyCode());
	}

}
