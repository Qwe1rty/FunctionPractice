package data;

import java.util.Random;

// This is mostly just for fun, but there are some useful things in here too
public class Protip {
	
	// Counts number of protips generated
	private static int PROTIPS_GENERATED = 0;
	
	// Big list of possible protips
	private static final String[] PROTIPS = {
		// Actually useful ones
		"For fractional values, enter (numerator)/(denominator)",
		"The 'p' and 'q' values can only be integers!",
		"The 'a' value cannot be a zero, ever",
		"Be wary of negative numbers!",
		"The asymptotes are represented by purple lines",
		"There are no fractional values above 1",
		"There are no fractional values below -1",
		"The max and min of any value is " + Function.UPPER_BOUND + " and " + Function.LOWER_BOUND,
		"Only " + (Function.FRACTIONAL_STATICS.length + 1) + " fractional values exist (incl. negatives)",
		"The numerator of fractional values is always 1",
		"You cannot use decimal values",
		"The denominator of frational values is 2, 3, or 4",
		"The 'b' value for exponential functions can be fractions",
		"Entering letters will not work!",
		// Slightly less useful ones
		"You should be glad there is no 'k' value",
		"'1 + 1' is equal to both '2' and '2!'",
		"It's possible to lead a cow upstairs... but not downstairs",
		"Pound for pound, hamburgers cost more than new cars",
		"10% of the Russian gov't income comes from vodka sales",
		"Around 100 people choke to death on ballpoint pens per year",
		"Potatoes are delicious!",
		"Computer science is just math but more awesome",
		"American cars beep in the tone of F",
		"Fill in the missing values for the function displayed above!"
	};

	// Returns a random protip
	public static String requestProtip() {
		
		// Increments number of protips generated
		PROTIPS_GENERATED++;
		
		// Hardcoded messages at certain points
		if (PROTIPS_GENERATED == 1) {return "Protip: For fractional values, enter (numerator)/(denominator)";}
		else if (PROTIPS_GENERATED == 10) {return "Protip: There are " + (PROTIPS.length + 1) + " protips in total!";}
		else if (PROTIPS_GENERATED == 20) {return "Protip: These are fun to read, eh?";}
		else if (PROTIPS_GENERATED == 40) {return "Protip: Only about half of these protips are actually useful";}
		else if (PROTIPS_GENERATED == 70) {return "Protip: Stop reading these, you've seen them all";}
		else if (PROTIPS_GENERATED == 110) {return "Protip: You should probably take a break";}
		else if (PROTIPS_GENERATED == 160) {return "Protip: If you're seeing this, you have no life";}
		else if (PROTIPS_GENERATED == 200) {return "Protip: Holy crap! You've generated 200 protips, stop already!";}
		else if (PROTIPS_GENERATED == 300) {return "Something is wrong with you, see a doctor";}
		else {
			Random random = new Random();
			return "Protip: " + PROTIPS[random.nextInt(PROTIPS.length)];
		}
		
	}
	
}
