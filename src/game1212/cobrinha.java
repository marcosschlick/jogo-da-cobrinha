package game1212;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Predicate;

import javax.swing.JButton;
import javax.swing.JFrame;

public class cobrinha extends JButton {

	ArrayList<cobrinha> cobrinhas = new ArrayList<cobrinha>();
	int pontos = 0;
	boolean perdeu = false;

	public cobrinha(int x, int y) {
		setSize(30, 30);
		setEnabled(false);
		setBackground(Color.GREEN);
		cobrinhas.add(this);
		this.setLocation(x, y);

	}

	public cobrinha() {
		setSize(30, 30);
		setLocation(10, 100);
		setEnabled(false);
		setBackground(Color.black);
		cobrinhas.add(this);
	}

	public void moveUp(food f) {
		int x = 0;
		int y = 0;
		for (cobrinha c : cobrinhas) {
			if (cobrinhas.get(0) == c) {
				x = c.getX();
				y = c.getY();
				c.setLocation(c.getX(), c.getY() - 30);
			} else {
				int a = c.getX();
				int b = c.getY();

				c.setLocation(x, y);
				x = a;
				y = b;

			}

		}

		if (f.passouCima(this)) {
			this.addCabeca(0, +30);
		}

	}

	public void moveBackward(food f) {
		int x = 0;
		int y = 0;
		for (cobrinha c : cobrinhas) {
			if (cobrinhas.get(0) == c) {
				x = c.getX();
				y = c.getY();
				c.setLocation(c.getX(), c.getY() + 30);
			} else {
				int a = c.getX();
				int b = c.getY();

				c.setLocation(x, y);
				x = a;
				y = b;

			}

		}
		if (f.passouCima(this)) {
			this.addCabeca(0, -30);
		}

	}

	public void moveLeft(food f) {

		int x = 0;
		int y = 0;
		for (cobrinha c : cobrinhas) {
			if (cobrinhas.get(0) == c) {
				x = c.getX();
				y = c.getY();
				c.setLocation(c.getX() - 30, c.getY());
			} else {
				int a = c.getX();
				int b = c.getY();

				c.setLocation(x, y);
				x = a;
				y = b;

			}

		}
		if (f.passouCima(this)) {
			this.addCabeca(+30, 0);
		}

	}

	public void moveRight(food f) {
		int x = 0;
		int y = 0;
		for (cobrinha c : cobrinhas) {
			if (cobrinhas.get(0) == c) {
				x = c.getX();
				y = c.getY();
				c.setLocation(c.getX() + 30, c.getY());
			} else {
				int a = c.getX();
				int b = c.getY();

				c.setLocation(x, y);
				x = a;
				y = b;

			}

		}
		if (f.passouCima(this)) {
			this.addCabeca(-30, 0);
		}
	}

	public void addCabeca(int x, int y) {
		cobrinhas.add(new cobrinha(cobrinhas.getLast().getX() + x, cobrinhas.getLast().getY() + y));
	}

	public void seTocou() {
		for (int i = 1; i < this.cobrinhas.size(); i++) {
			if (this.cobrinhas.get(0).getX() == this.cobrinhas.get(i).getX()
					& this.cobrinhas.get(0).getY() == this.cobrinhas.get(i).getY()) {
				this.perdeu = true;

			}

		}

	}

}
