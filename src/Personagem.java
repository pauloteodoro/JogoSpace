import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Personagem extends JLabel implements KeyListener {

	public Personagem() {

		setSize(100, 70);
		// setOpaque(true);
		setIcon(new ImageIcon(
				new ImageIcon("nave.png").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST)));
		// setVisible(true);
	}

	int maximo = 450;

	@Override
	public void keyPressed(KeyEvent arg) {
		if (arg.getKeyCode() == 40) {// cima
			setLocation(getX(), getY() + 5);
			if (getX() > maximo) {
				setLocation(maximo, getY());
			}
		} else if (arg.getKeyCode() == 38) {// baixo

			setLocation(getX(), getY() - (5));
			if (getX() < 0) {
				setLocation(0, getY());
			}

		}
		if (arg.getKeyCode() == 39) {// Direita
			setLocation(getX() + (5), getY());
			if (getX() > maximo) {
				setLocation(maximo, getY());
			}
		} else if (arg.getKeyCode() == 37) {// Esquerda

			setLocation(getX() - (5), getY());
			if (getX() < 0) {
				setLocation(0, getY());
			}

			else if (arg.getKeyCode() == 27) {// Esc
				if (JOptionPane.showConfirmDialog(null, "Deseja Sair?") == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
