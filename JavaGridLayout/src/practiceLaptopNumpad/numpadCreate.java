package practiceLaptopNumpad;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class numpadCreate extends JFrame {

	private static final long serialVersionUID = -4923779513374364257L;

	public numpadCreate() {
		this.setTitle("Laptop Numpad");
		this.setSize(1000, 1000);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLayout(new GridLayout(6, 3, 10, 10)); // rows, columns, x elements margins, y elements margins

		this.add(new JButton("*"));
		this.add(new JButton("/"));
		this.add(new JButton("0"));
		this.add(new JButton("+"));
		this.add(new JButton("-"));
		this.add(new JButton("Num Lk"));
		this.add(new JButton("<html> 7 <br> Home </html>"));
		this.add(new JButton("<html> 8 <br> ⬆️ </html>"));
		this.add(new JButton("<html> 9 <br> PgUp </html>"));
		this.add(new JButton("<html> 4 <br> ⬅️ </html>"));
		this.add(new JButton("5"));
		this.add(new JButton("<html> 6 <br> ➡️ </html>"));
		this.add(new JButton("<html> 1 <br> End </html>"));
		this.add(new JButton("<html> 2 <br> ⬇️ </html>"));
		this.add(new JButton("<html> 3 <br> PgDn </html>"));
		this.add(new JButton("<html> 0 <br> Insert </html>"));
		this.add(new JButton("<html> . <br> Delete </html>"));
		this.add(new JButton("<html> Enter <br> [] </html>"));

		this.setVisible(true);
	}

}
