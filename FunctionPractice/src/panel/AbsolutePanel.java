package panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import data.Function;

public class AbsolutePanel extends FunctionPanel {

	// Labels
	private static final JLabel ob = new JLabel("|");
	private static final JLabel cb = new JLabel("|");

	public AbsolutePanel() {

		// Calls parent
		super();

		// Panel settings
		functionType = Function.TYPE_ABSOLUTE;

		// Generates a random quadratic function on startup
		generate();

		// Component properties
		// Fonts
		ob.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		cb.setFont(new Font("Cambria Math", Font.ITALIC, 30));

		// Adds components
		// Inherited
		add(a);
		add(lp);
		add(p);
		add(lq);
		add(q);
		// Private
		add(ob);
		add(cb);

		// Positions components
		// Inherited
		a.setBounds(funcPos[0] + 85, funcPos[1] + 3, 35, 30);
		lp.setBounds(funcPos[0] + 140, funcPos[1], 40, 30);
		p.setBounds(funcPos[0] + 180, funcPos[1] + 3, 35, 30);
		lq.setBounds(funcPos[0] + 235, funcPos[1], 25, 30);
		q.setBounds(funcPos[0] + 270, funcPos[1] + 3, 35, 30);
		// Private
		ob.setBounds(funcPos[0] + 125, funcPos[1], 20, 30);
		cb.setBounds(funcPos[0] + 215, funcPos[1], 20, 30);

	}

}
