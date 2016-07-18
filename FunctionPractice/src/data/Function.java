package data;

import java.util.ArrayList;
import java.util.Random;

public class Function {

	// Globally defined upper and lower bounds (for generation)
	public static final int LOWER_BOUND = -4;
	public static final int UPPER_BOUND = 4;
	// Global point values for generation
	public static final Fraction[] FRACTIONAL_STATICS = {
		new Fraction(-1, 2),
		new Fraction(-1, 3),
		new Fraction(-1, 4),
		new Fraction(1, 4),
		new Fraction(1, 3),
		new Fraction(1, 2),
	};
	public static final Fraction[] FRACTIONAL_STATICS_POSITIVE = {
		new Fraction(1, 4),
		new Fraction(1, 3),
		new Fraction(1, 2),
	};

	// Globally defined function types
	public static final int TYPE_QUADRATIC = 0;
	public static final int TYPE_CUBIC = 1;
	public static final int TYPE_SQUARE_ROOT = 2;
	public static final int TYPE_ABSOLUTE = 3;
	public static final int TYPE_RECIPROCAL = 4;
	public static final int TYPE_EXPONENTIAL = 5;

	// Stores function information
	private int type, p, q;
	private Fraction a, b;

	//----------------------------------------------------
	// CONSTRUCTOR
	//----------------------------------------------------

	// Constructors to make your delicious functions
	// This is for exponential functions that require a base
	public Function(int type, Fraction a, int p, int q, Fraction b) {
		this(type, a, p, q);
		this.b = b;
	}
	// For all other functions
	public Function(int type, Fraction a, int p, int q) {
		this.type = type;
		this.a = a;
		this.p = p;
		this.q = q;
	}
	// Randomly generate a type of function
	public Function(int type) {
		this.type = type;
		this.regenerate();
	}
	// Randomly generate any type of function
	public Function() {
		this.type = new Random().nextInt(6);
		this.regenerate();
	}

	//----------------------------------------------------
	// STATIC METHODS
	//----------------------------------------------------

	// Determines whether two functions are the same
	public static boolean equals(Function f1, Function f2) {
		if (f1.type != f2.type) return false;
		if (Fraction.equalsNot(f1.a, f2.a) || f1.p != f2.p || f1.q != f2.q) return false;
		if (f1.type == TYPE_EXPONENTIAL && Fraction.equalsNot(f1.b, f2.b)) return false;
		return true;
	}

	//----------------------------------------------------
	// INSTANCE METHODS
	//----------------------------------------------------

	// Prints out the values of the function
	public void printValues() {System.out.println(returnValues());}
	// Returns the values of function ins string form
	public String returnValues() {
		if (type == TYPE_EXPONENTIAL) return "a = " + a.toString() + ", b = " + b.toString() + ", p = " + p + ", q = " + q;  
		else return "a = " + a.toString() + ", p = " + p + ", q = " + q;
	}

	// Returns a value given an x value, where f(x) = y
	// An invalid function type will throw an error
	public double calculate(double x) {
//		if (this.type == TYPE_QUADRATIC) return (a * ((x - p) * (x - p))) + q;
//		else if (this.type == TYPE_CUBIC) return (a * ((x - p) * (x - p) * (x - p))) + q;
//		else if (this.type == TYPE_SQUARE_ROOT) {
//			if ((x - p) < 0) throw new ArithmeticException("Radicand cannot be under zero");
//			return (a * Math.sqrt(x - p)) + q;
//		}
//		else if (this.type == TYPE_ABSOLUTE) return (a * Math.abs(x - p)) + q;
//		else if (this.type == TYPE_RECIPROCAL) return (a / (x - p)) + q;
//		else if (this.type == TYPE_EXPONENTIAL) return (a * Math.pow(b, (x - p))) + q; 
//		else throw new ArithmeticException("Function could not be calculated");
		if (this.type == TYPE_QUADRATIC) return (a.toDouble() * ((x - p) * (x - p))) + q;
		else if (this.type == TYPE_CUBIC) return (a.toDouble() * ((x - p) * (x - p) * (x - p))) + q;
		else if (this.type == TYPE_SQUARE_ROOT) {
			if ((x - p) < 0) throw new ArithmeticException("Radicand cannot be under zero");
			return (a.toDouble() * Math.sqrt(x - p)) + q;
		}
		else if (this.type == TYPE_ABSOLUTE) return (a.toDouble() * Math.abs(x - p)) + q;
		else if (this.type == TYPE_RECIPROCAL) return (a.toDouble() / (x - p)) + q;
		else if (this.type == TYPE_EXPONENTIAL) return (a.toDouble() * Math.pow(b.toDouble(), (x - p))) + q; 
		else throw new ArithmeticException("Function could not be calculated");
	}

	// Generates a new random function
	public void regenerate() {

		// Creates possible values lists
		// Doubles
		ArrayList<Fraction> randomFractionSet = new ArrayList<Fraction>();
		for (int i = 1; i <= UPPER_BOUND; i++) randomFractionSet.add(new Fraction(i));
		for (int i = -1; i >= LOWER_BOUND; i--) randomFractionSet.add(new Fraction(i));
		for (int i = 0; i < FRACTIONAL_STATICS.length; i++) randomFractionSet.add(FRACTIONAL_STATICS[i]);
		// Integers
		ArrayList<Integer> randomIntegerSet = new ArrayList<Integer>();
		for (int i = 0; i <= UPPER_BOUND; i++) randomIntegerSet.add(i);
		for (int i = -1; i >= LOWER_BOUND; i--) randomIntegerSet.add(i);

		// Picks a random value from aforementioned list
		Random random = new Random();
		a = randomFractionSet.get(random.nextInt(randomFractionSet.size()));
		p = randomIntegerSet.get(random.nextInt(randomIntegerSet.size()));
		q = randomIntegerSet.get(random.nextInt(randomIntegerSet.size()));
		// Exponential functions get special treatment
		if (this.type == TYPE_EXPONENTIAL) {
			ArrayList<Fraction> randomBaseSet = new ArrayList<Fraction>();
			for (int i = 2; i <= UPPER_BOUND; i++) randomBaseSet.add(new Fraction(i));
			for (int i = 0; i < FRACTIONAL_STATICS_POSITIVE.length; i++) randomBaseSet.add(FRACTIONAL_STATICS_POSITIVE[i]);
			b = randomBaseSet.get(random.nextInt(randomBaseSet.size()));
		}

	}
	
	// Getter funtions
	public int getP() {return p;}
	public int getQ() {return q;}

}
