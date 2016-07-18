package data;

// This class tries its best to represent fractions
public class Fraction {

	// Numerator and denominator
	private int n;
	private int d;

	//----------------------------------------------------
	// CONSTRUCTOR
	//----------------------------------------------------

	// Constructor for fractions
	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator cannot be zero");
		} else if (denominator < 0) {
			numerator *= -1;
			denominator *= -1;
		}
		this.n = numerator;
		this.d = denominator;
		this.reduce();
	}
	// Constructor for integers. Denominator is defaulted to 1
	public Fraction(int numerator) {
		this.n = numerator;
		this.d = 1;
	}
	// Constructor to create a blank fraction. Values are manually added, so not recommended
	public Fraction() {}

	//----------------------------------------------------
	// STATIC METHODS
	//----------------------------------------------------

	// Parses fractions
	public static Fraction parseFraction(String s) {

		// If there's a slash, it will try to create a fraction object with denominator != 1
		if (s.contains("/")) {

			// Splits string into numerator and denominator 
			String[] ators = s.split("/");
			if (ators.length > 2) throw new IllegalArgumentException("Multiple slashes detected");

			// Tries to convert string array into a new Fraction
			try {
				return new Fraction(Integer.parseInt(ators[0]), Integer.parseInt(ators[1]));
			} catch (Exception e) {throw new IllegalArgumentException("Invalid \"integers\" entered");}

		} else { // Otherwise it creates a fraction with denominator = 1
			try {
				return new Fraction(Integer.parseInt(s));
			} catch (Exception e) {throw new IllegalArgumentException("Invalid \"integer\" entered");}
		}
	}

	// Multiplies two fractions
	public static Fraction multiply(Fraction f1, Fraction f2) {
		f1.reduce();
		f2.reduce();
		Fraction f3 = new Fraction();
		f3.n = f1.n * f2.n;
		f3.d = f1.d * f2.d;
		f3.reduce();
		return f3;
	}
	// Multiplies a fraction and integer. Returns fraction
	public static Fraction multiply(Fraction f1, int a) {
		f1.reduce();
		Fraction f2 = new Fraction();
		f2.n = f1.n * a;
		f2.d = f1.d + 0; // Prevents shallow copy
		f2.reduce();
		return f2;
	}
	// Multiplies a fraction and double. Will return a double (!) with 6 decimal points of precision
	public static double multiply(Fraction f1, double a) {
		f1.reduce();
		return (f1.n * a) / (f1.d + 0.000000);
	}

	// Determines whether two fractions are equivalent
	public static boolean equals(Fraction f1, Fraction f2) {
		f1.reduce();
		f2.reduce();
		return (f1.n == f2.n && f1.d == f2.d);
	}
	// Determines whether a fraction and integer are equivalent
	public static boolean equals(Fraction f1, int a) {
		f1.reduce();
		return (f1.n == a && f1.d == 1);
	}
	// Inverse of above two functions (haha im lazy)
	public static boolean equalsNot(Fraction f1, Fraction f2) {return !equals(f1, f2);}
	public static boolean equalsNot(Fraction f1, int a) {return !equals(f1, a);}

	//----------------------------------------------------
	// INSTANCE METHODS
	//----------------------------------------------------

	// Reduces fraction to the lowest possible values. Super useful, called after everything
	public void reduce() {
		int gcd = gcd(this.n, this.d);
		this.n /= gcd;
		this.d /= gcd;
		if (this.d < 0) {
			this.n *= -1;
			this.d *= -1;
		}
	}

	// Determines whether the fraction can be simplified into an integer
	public boolean isInteger() {return (n % d == 0);}

	// Returns the fraction as an integer value if possible
	public int toInteger() {
		if (n % d == 0) return n / d;
		else throw new ArithmeticException("Numerator is not divisible by denominator");
	}

	// Returns the fraction as a double with 6 decimal points of precision
	public double toDouble() {return n / (d + 0.000000);}

	// Prints out the fraction
	public void print() {
		reduce();
		if (isInteger()) System.out.println(n);
		else System.out.println(n + "/" + d);
	}
	// Same as print() but returns an actual string
	@Override
	public String toString() {
		reduce();
		if (isInteger()) return n + "";
		else return n + "/" + d;
	}

	// Returns numerator and denominator
	public int getNumerator() {return n;}
	public int getDenominator() {return d;}

	// Calculates the gcd between two numbers
	public static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a%b);
	}

}
