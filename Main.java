import java.awt.event.*;

import javax.swing.*;

public class Main {
	static JFrame frame;
	static Puzzle puzzle;
	
	public static void main(String [] args) {
		frame = new JFrame("Puzzlegame ©FreakySheldon");
		frame.setSize(327, 348);
		
		puzzle = new Puzzle(new ImageIcon(Main.class.getResource("/Image.png")).getImage());
		
		frame.add(puzzle);
		
		frame.setLocationRelativeTo(null);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!puzzle.started) puzzle.start();
				else if (puzzle.mixing) puzzle.mixing = false;
				else puzzle.onClick(e);
			}
		});
	}

}
