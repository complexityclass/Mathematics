import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

class MyPanel extends JPanel {
	public static int x1;
	public static int x2;
	public static int y1;
	public static int y2;

	public int pointsCount = 200000;
	public double sX = 0.005;
	public double sY = 0.005;

	public MyPanel() {
		setLayout(null);
	}

	public static void setCoord(int c1, int c2, int c3, int c4) {
		x1 = c1;
		x2 = c2;
		y1 = c3;
		y2 = c4;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < pointsCount; i++) {
			Random r = new Random();
			double prob = (double) (0.0 + r.nextInt(100 + 1) * 0.01);
			double t = sX;

			if (prob <= 0.85) {
				sX = 0.84 * sX + 0.04 * sY;
				sY = 0.04 * t + 0.85 * sY + 1.6;
				g.setColor(Color.GREEN);

			} else if (prob < 0.93) {
				sX = 0.20 * sX - 0.26 * sY;
				sY = 0.26 * t + 0.212 * sY + 0.44;
				g.setColor(Color.darkGray);

			} else if (prob < 0.99) {
				sX = -0.15 * sX + 0.28 * sY;
				sY = 0.26 * t + 0.24 * sY + 0.44;
				g.setColor(Color.red);
			} else {
				sX = 0.0;
				sY = 0.16 * sY;
				g.setColor(Color.black);
			}
			g.drawLine((int) (sX * 60 + 400), (int) (sY * 60 + 25), (int) (sX * 60 + 400),
					(int) (sY * 60 + 25));

		}
	}
}
