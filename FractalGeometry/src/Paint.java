import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Paint extends JFrame {

	private MyPanel panel = new MyPanel();
	private JButton button = new JButton("Paint");

	public Paint() {
		JFrame mf = new JFrame("Paint Test");
		mf.setLayout(new BorderLayout());
		mf.setSize(1024, 768);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED));
		panel.setBackground(Color.WHITE);
		mf.add(panel, BorderLayout.CENTER);
		mf.add(button, BorderLayout.SOUTH);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				panel.setCoord(5, 5, 500, 500);
				panel.repaint();
			}
		});
		mf.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Paint();
			}
		});
	}
}