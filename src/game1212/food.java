package game1212;

import java.awt.Color;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class food extends JButton {

	public food(int x, int y) {
		setLocation(x, y);
		setSize(30, 30);
		setEnabled(false);
		setBackground(Color.RED);
	}

	public boolean passouCima(cobrinha cobra) {

		for (cobrinha c : cobra.cobrinhas) {
			if (c.getX() == this.getX() & c.getY() == this.getY()) {
				cobra.pontos += 1;
				System.out.println("passou por cima");
				System.out.println(cobra.pontos);
				this.novoLugar();
				return true;
			}
		}
		
		return false;

	}

	public void novoLugar() {
		int locX = (((int) (Math.random() * 10)) * 60) + 10;
		int locY = (((int) (Math.random() * 10)) * 60) + 100;
		this.setLocation(locX, locY);
	}

}
