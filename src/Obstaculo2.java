import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Obstaculo2 extends JLabel {

	@SuppressWarnings("unused")
	private Personagem personagem;

	public Obstaculo2(Personagem personagem) {

		setSize(70, 70);

		setIcon(new ImageIcon(
				new ImageIcon("estrela.png").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST)));

	}

	public void start() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				Random random = new Random();

				int x = getX();
				int o = x;
				boolean i = true;
				int y = getY();
				while (i) {

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
					try {
						Thread.sleep(random.nextInt(15));
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				}
			}
		}).start();

	}
}
