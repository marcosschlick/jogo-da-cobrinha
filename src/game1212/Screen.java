package game1212;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Screen {

	public void execute() {
		cobrinha cobrinha = new cobrinha();
		int locX = (((int) (Math.random() * 10)) * 60) + 10;
		int locY = (((int) (Math.random() * 10)) * 60) + 100;
		food f = new food(locX, locY);

		JLabel label = new JLabel();
		label.setSize(600, 100);
		label.setText("Pontuação: " + cobrinha.pontos);
		label.setLocation(0, 0);
		label.setFont(new Font("", Font.BOLD, 30));
		label.setHorizontalAlignment(0);

		JFrame screen = new JFrame();
		screen.setLayout(null);
		screen.setSize(640, 750);
		screen.setBackground(Color.WHITE);
		screen.setLocationRelativeTo(null);
		screen.setDefaultCloseOperation(3);
		screen.setFocusable(true);

		KeyAdapter keyadapt = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				int key = e.getKeyCode();
				if (key == KeyEvent.VK_UP & cobrinha.getY() >= 130) {
					cobrinha.moveUp(f);

				} else if (key == KeyEvent.VK_UP & cobrinha.getY() < 130) {
					cobrinha.perdeu = true;

				}

				else if (key == KeyEvent.VK_DOWN & cobrinha.getY() < 660) {
					cobrinha.moveBackward(f);

				} else if (key == KeyEvent.VK_DOWN & cobrinha.getY() > 660) {
					cobrinha.perdeu = true;

				} else if (key == KeyEvent.VK_LEFT & cobrinha.getX() >= 30) {
					cobrinha.moveLeft(f);

				} else if (key == KeyEvent.VK_LEFT & cobrinha.getX() < 30) {
					cobrinha.perdeu = true;

				} else if (key == KeyEvent.VK_RIGHT & cobrinha.getX() <= 550) {
					cobrinha.moveRight(f);

				} else if (key == KeyEvent.VK_RIGHT & cobrinha.getX() > 550) {
					cobrinha.perdeu = true;

				}

				for (cobrinha c : cobrinha.cobrinhas) {
					screen.add(c);
				}
				cobrinha.seTocou();

				label.setText("Pontuação: " + cobrinha.pontos);

				if (cobrinha.perdeu) {
					screen.removeKeyListener(this);
					label.setText("Sua pontuação foi " + cobrinha.pontos + ", até a próxima!");
				}

			}
		};
		screen.addKeyListener(keyadapt);
		screen.add(label);
		for (cobrinha c : cobrinha.cobrinhas) {
			screen.add(c);
		}
		screen.add(f);
		screen.setVisible(true);
	}
}
