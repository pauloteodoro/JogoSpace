import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Obstaculo extends JLabel {

	private Personagem personagem;
	public int cont = 0;
	int placar = 0;

	public Obstaculo(Personagem personagem) {
		this.personagem = personagem;
		setSize(50, 50);
		// setOpaque(true);
		// setVisible(true);
		setIcon(new ImageIcon(
				new ImageIcon("caveira.png").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST)));
	}

	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Random random = new Random();

				int x = getX();
				int o = x, velocidade = 2;
				boolean i = true;
				int y = getY();
				int cont = 0, cont2 = 0;
				while (i) {
					cont++;
					if (cont % 200 == 0) {
						placar = cont2++;
						System.out.println(placar);
					}

					x -= 1;
					if (x == 0) {
						x = o;
						y = random.nextInt(450);
						if (y < 35) {
							y += 35;
						} else if (y > 415) {
							y -= 35;
						}
					}
					setLocation(x, y);
					if (isColidiu(personagem)) {

					} else if (getX() < 0) {
						x = o;
					}

					try {

						Thread.sleep(velocidade);
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		}).start();

	}

	public boolean isColidiu(Personagem p) {

		if (getX() > p.getX() + p.getWidth()) {

			return true;

		}

		if (getY() + getHeight() >= p.getY() && getY() <= p.getY() + p.getHeight()) {
			if (p.getY() <= getY() + getHeight() && getY() + getHeight() <= p.getY() + p.getHeight()) {

				JOptionPane.showMessageDialog(null, "YOU LOSE, SCORE : " + placar);
				System.exit(0);
			}

		}

		return false;
	}

	public boolean isColidiu(Obstaculo p) {

		if (getX() + getHeight() >= p.getY() + 40 || getY() <= p.getY() + 40 + p.getHeight() + 40) {
			if (p.getX() <= getX() + getWidth() && getX() + getWidth() <= p.getX() + p.getWidth()) {
				if (p.isAtivo()) {
					p.setAtivo(false);
					return true;
				} else {
					return false;
				}
			}

		}
		return false;

	}

	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
		new Thread(new Runnable() {

			@Override
			public void run() {
				setOpaque(false);
				setBackground(null);
				setBorder(null);
				setIcon(new ImageIcon(new ImageIcon("explosao.png").getImage().getScaledInstance(getWidth(),
						getHeight(), Image.SCALE_FAST)));
				try {
					Thread.sleep(350);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				setVisible(false);
			}
		}).start();
	}
}
