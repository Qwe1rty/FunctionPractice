package panel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import data.Function;

public class ReciprocalPanel extends FunctionPanel {

	// Labels
	private static final JLabel div = new JLabel("/");
	private static final JLabel ob1 = new JLabel("(");
	private static final JLabel cb1 = new JLabel(")");
	private static final JLabel ob2 = new JLabel("(");
	private static final JLabel cb2 = new JLabel(")");

	public ReciprocalPanel() {

		// Calls parent
		super();

		// Panel settings
		functionType = Function.TYPE_RECIPROCAL;

		// Generates a random quadratic function on startup
		generate();

		// Component properties
		// Fonts
		div.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		ob1.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		cb1.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		ob2.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		cb2.setFont(new Font("Cambria Math", Font.ITALIC, 30));

		// Adds components
		// Inherited
		add(a);
		add(lp);
		add(p);
		add(lq);
		add(q);
		// Private
		add(div);
		add(ob1);
		add(cb1);
		add(ob2);
		add(cb2);

		// Positions components
		// Inherited
		a.setBounds(funcPos[0] + 110, funcPos[1] + 3, 35, 30);
		lp.setBounds(funcPos[0] + 190, funcPos[1], 40, 30);
		p.setBounds(funcPos[0] + 230, funcPos[1] + 3, 35, 30);
		lq.setBounds(funcPos[0] + 305, funcPos[1], 25, 30);
		q.setBounds(funcPos[0] + 340, funcPos[1] + 3, 35, 30);
		// Private
		div.setBounds(funcPos[0] + 150, funcPos[1], 30, 30);
		ob2.setBounds(funcPos[0] + 85, funcPos[1], 30, 30);
		ob1.setBounds(funcPos[0] + 175, funcPos[1], 20, 30);
		cb1.setBounds(funcPos[0] + 270, funcPos[1], 20, 30);
		cb2.setBounds(funcPos[0] + 285, funcPos[1], 20, 30);

	}

}
