import java.awt.Image;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class cenario extends JFrame {

	public cenario() {
		setSize(1080, 550);
		setTitle("Space");
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}

	JLabel fundo = new JLabel();
	private Personagem personagem;
	private Obstaculo2 obstaculo;
	private Obstaculo obstaculo1;
	private Obstaculo obstaculo0;
	private Obstaculo obstaculomorte;

	private void init() {

		personagem = new Personagem();
		add(personagem);
		addKeyListener(personagem);

		Random random = new Random();

		obstaculo1 = new Obstaculo(personagem);
		obstaculo1.setLocation(2000, random.nextInt(450));
		add(obstaculo1);
		obstaculo1.start();

		obstaculo = new Obstaculo2(personagem);
		obstaculo.setLocation(1500, random.nextInt(450));
		add(obstaculo);
		obstaculo.start();

		obstaculo0 = new Obstaculo(personagem);
		obstaculo0.setLocation(1500, random.nextInt(450));
		add(obstaculo0);
		// obstaculo0.start();

		obstaculomorte = new Obstaculo(personagem);
		obstaculomorte.setLocation(1500, random.nextInt(450));
		add(obstaculomorte);
		// obstaculomorte.start();

		fundo.setBounds(0, 0, getWidth(), getHeight());
		fundo.setIcon(new ImageIcon(
				new ImageIcon("perfeito.gif").getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST)));
		add(fundo);

	}
}
