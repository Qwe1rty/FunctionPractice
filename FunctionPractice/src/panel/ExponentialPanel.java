package panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

import data.Fraction;
import data.Function;

public class ExponentialPanel extends FunctionPanel {

	// Labels
	private static final JLabel ob = new JLabel("(");
	private static final JLabel cb = new JLabel(")");
	// Text Area
	private static final JTextField b = new JTextField(4);

	public ExponentialPanel() {

		// Calls parent
		super();

		// Panel settings
		functionType = Function.TYPE_EXPONENTIAL;

		// Generates a random quadratic function on startup
		generate();

		// Component properties
		// Fonts
		ob.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		cb.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		lp.setFont(new Font("Cambria Math", Font.ITALIC, 17));

		// Adds components
		// Inherited
		add(a);
		add(lp);
		add(p);
		add(lq);
		add(q);
		// Private
		add(ob);
		add(b);
		add(cb);

		// Positions components
		// Inherited
		a.setBounds(funcPos[0] + 85, funcPos[1] + 3, 35, 30);
		lp.setBounds(funcPos[0] + 210, funcPos[1] - 5, 40, 20);
		p.setBounds(funcPos[0] + 237, funcPos[1] - 5, 30, 25);
		lq.setBounds(funcPos[0] + 275, funcPos[1], 30, 30);
		q.setBounds(funcPos[0] + 310, funcPos[1] + 3, 35, 30);
		// Private
		ob.setBounds(funcPos[0] + 125, funcPos[1], 20, 30);
		b.setBounds(funcPos[0] + 150, funcPos[1] + 3, 35, 30);
		cb.setBounds(funcPos[0] + 190, funcPos[1], 20, 30);

	}

	// Selfish exponential panel wants its own special version of this all by himself *hmph*
	// Clear modified to b is also cleared
	@Override
	public void clear() {
		b.setText("");
		a.setText("");
		p.setText("");
		q.setText("");
		results.setText("");
	}
	// Check modified so b is also added
	@Override
	public void check() {
		try {

			// Decided not to chain all this because it'd go off the screen x5
			Fraction a = Fraction.parseFraction(this.a.getText());
			Fraction b = Fraction.parseFraction(this.b.getText());
			Fraction p = Fraction.parseFraction(this.p.getText());
			Fraction q = Fraction.parseFraction(this.q.getText());
			if (!p.isInteger() || !q.isInteger()) {
				results.setForeground(Color.RED);
				results.setText("Invalid input! 'p' and 'q' values cannot be fractions!");
				throw new ArrayIndexOutOfBoundsException("lazy coding");
			}
			int ip = p.toInteger();
			int iq = q.toInteger();
			Function input = new Function(functionType, a, ip, iq, b);

			// Checking part
			if (Function.equals(input, this.function)) {
				results.setForeground(Color.GREEN);
				results.setText("Correct!");
			} else {
				results.setForeground(Color.BLACK);
				results.setText("Incorrect! The correct answer is " + function.returnValues());
			}

		} catch (IllegalArgumentException e) {
			results.setForeground(Color.RED);
			results.setText("Invalid input!");
		} catch (ArrayIndexOutOfBoundsException ex) {}
	}

}
