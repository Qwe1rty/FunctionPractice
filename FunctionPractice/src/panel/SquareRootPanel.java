package panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import data.Function;

public class SquareRootPanel extends FunctionPanel {

	// Labels
	private static final JLabel sqrt = new JLabel("sqrt(");
	private static final JLabel cb = new JLabel(")");

	public SquareRootPanel() {

		// Calls parent
		super();

		// Panel settings
		functionType = Function.TYPE_SQUARE_ROOT;

		// Generates a random quadratic function on startup
		generate();

		// Component properties
		// Font
		sqrt.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		cb.setFont(new Font("Cambria Math", Font.ITALIC, 30));

		// Adds components
		// Inherited
		add(a);
		add(lp);
		add(p);
		add(lq);
		add(q);
		// Private
		add(sqrt);
		add(cb);

		// Positions components
		// Inherited
		a.setBounds(funcPos[0] + 85, funcPos[1] + 3, 35, 30);
		lp.setBounds(funcPos[0] + 190, funcPos[1], 40, 30);
		p.setBounds(funcPos[0] + 230, funcPos[1] + 3, 35, 30);
		lq.setBounds(funcPos[0] + 293, funcPos[1], 25, 30);
		q.setBounds(funcPos[0] + 332, funcPos[1] + 3, 35, 30);
		// Private
		sqrt.setBounds(funcPos[0] + 125, funcPos[1], 100, 30);
		cb.setBounds(funcPos[0] + 270, funcPos[1], 30, 30);

	}

	//	// Draws the radical sign
	//	public void paintComponent(Graphics g) {
	//		
	//		g.setColor(Color.BLACK);
	//		g.drawLine(funcPos[0] + 100, funcPos[1] + 15, funcPos[0] + 105, funcPos[1] + 15);
	//		g.drawLine(funcPos[0] + 105, funcPos[1] + 15, funcPos[0] + 110, funcPos[1] + 30);
	//		g.drawLine(funcPos[0] + 110, funcPos[1] + 30, funcPos[0] + 115, funcPos[1]);
	//		g.drawLine(funcPos[0] + 115, funcPos[1], funcPos[0] + 180, funcPos[1]);
	//		
	//	}

}
