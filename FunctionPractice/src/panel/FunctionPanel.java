package panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Frame;
import data.Fraction;
import data.Function;
import data.Protip;

public class FunctionPanel extends JPanel implements KeyListener {

	// Stores function to draw and its type
	protected int functionType;
	protected Function function = new Function();
	
	// Stores graph panel
	protected GraphPanel graph;

	// Determines location of the displayed formula
	protected static final int[] funcPos = {50, 715};

	// Universal components
	// Labels - starred items means they must be added in child panels
	protected JLabel shortcutLabelHead = new JLabel("Shortcut Keys");
	protected JLabel shortcutLabelClear = new JLabel("Clear: [ESC]");
	protected JLabel shortcutLabelCheck = new JLabel("Check: [ENTER]");
	protected JLabel shortcutLabelGen = new JLabel("Generate: [CTRL]");
	protected JLabel instructions = new JLabel("Fill in the missing values for the function displayed above!");
	protected JLabel fx = new JLabel("f(x) =");
	protected JLabel lp = new JLabel("x -"); //*
	protected JLabel lq = new JLabel("+"); //*
	protected JLabel protip = new JLabel("");
	protected JLabel results = new JLabel("");
	// Buttons
	protected JButton exitButton = new JButton("Back to Main Menu");
	protected JButton clearButton = new JButton("Clear input fields");
	protected JButton checkButton = new JButton("Check answers");
	protected JButton generateButton = new JButton("Generate new function");
	// Text fields
	protected JTextField a = new JTextField(4); //*
	protected JTextField p = new JTextField(4); //*
	protected JTextField q = new JTextField(4); //*

	// Constructor that adds the graphing panel
	public FunctionPanel() {

		// Adding graphing panel
		graph = new GraphPanel(function, functionType);
		add(graph);
		graph.setBounds(50, 50, 801, 601);

		// Panel settings
		setLayout(null);
		setFocusable(true);

		// Component properties
		// Adding listeners
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.FRAME.setContentPane(new MainMenuPanel());
				Frame.FRAME.revalidate();
			}
		});
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {clear();}
		});
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {check();}
		});
		generateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				generate(); 
			}
		});
		a.addKeyListener(this);
		p.addKeyListener(this);
		q.addKeyListener(this);
		// Fonts
		shortcutLabelHead.setFont(new Font("Century Gothic", Font.BOLD, 12));
		shortcutLabelClear.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		shortcutLabelCheck.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		shortcutLabelGen.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		instructions.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		fx.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		lp.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		lq.setFont(new Font("Cambria Math", Font.ITALIC, 30));
		protip.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		results.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		// Removes components capability to attract focus
		exitButton.setFocusable(false);
		clearButton.setFocusable(false);
		checkButton.setFocusable(false);
		generateButton.setFocusable(false);

		// Adds components
		// Labels
		add(shortcutLabelHead);
		add(shortcutLabelClear);
		add(shortcutLabelCheck);
		add(shortcutLabelGen);
		add(instructions);
		add(fx);
		add(protip);
		add(results);
		// Buttons
		add(exitButton);
		add(clearButton);
		add(checkButton);
		add(generateButton);

		// Positions components
		// Labels
		shortcutLabelHead.setBounds(700, 675, 100, 20);
		shortcutLabelClear.setBounds(700, 700, 100, 20);
		shortcutLabelCheck.setBounds(700, 720, 100, 20);
		shortcutLabelGen.setBounds(700, 740, 150, 20);
		instructions.setBounds(50, 675, 400, 20);
		fx.setBounds(funcPos[0], funcPos[1], 100, 30);
		protip.setBounds(50, funcPos[1] + 45, 500, 20);
		results.setBounds(50, funcPos[1] + 75, 500, 20);
		// Buttons
		exitButton.setBounds(475, 850, 325, 50);
//		exitButton.setBounds(475, 830, 325, 50);
		generateButton.setBounds(475, 775, 200, 50);
		checkButton.setBounds(475, 725, 200, 50);
		clearButton.setBounds(475, 675, 200, 50);
		
		// Clears input fields when switching panels
		clear();
	}

	// Draws background and etc.
	public void paintComponent(Graphics g) {
		// Sets the overall background
		g.drawImage(Frame.background, 0, 0, Frame.WINDOW_WIDTH, Frame.WINDOW_HEIGHT, null);
	}

	// This will clear all input fields
	public void clear() {
		a.setText("");
		p.setText("");
		q.setText("");
		results.setText("");
	}
	// This will check whether the user's input is the same as the displayed function
	public void check() {
		try {
			
			// Decided not to chain all this because it'd go off the screen x5
			// Tries to read user input as fractions
			Fraction a = Fraction.parseFraction(this.a.getText());
			Fraction p = Fraction.parseFraction(this.p.getText());
			Fraction q = Fraction.parseFraction(this.q.getText());
			if (!p.isInteger() || !q.isInteger()) {
				results.setForeground(Color.RED);
				results.setText("Invalid input! 'p' and 'q' values cannot be fractions!");
				throw new ArrayIndexOutOfBoundsException("lazy coding");
			}
			int ip = p.toInteger();
			int iq = q.toInteger();
			Function input = new Function(functionType, a, ip, iq);
			
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
	// Generates a new function displayed
	public void generate() {
		function = new Function(functionType);
		function.printValues();
		protip.setText(Protip.requestProtip());
		results.setText("");
		graph.graphFunction(function, functionType);
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) {generate();}
		else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {clear();}
		else if (e.getKeyCode() == KeyEvent.VK_ENTER) {check();}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
	}

}
