import java.util.Random;

public class Equation {

	private int one, two, three, four, five, answer, kindOfEquation, items;
	private boolean flip, s1, s2, s3;	//s1, s2, s3 are symbols. True for +, false for -. Flip 
	private Random random;
	private String equation, title, symbol1, symbol2, symbol3;
	
	Equation(int level) {
		equation = "";
		random = new Random();
		switch(level) {
		//Tens +
		case 0:
			title = "Level 1: Tens";
			items = 3;
			one = random.nextInt(11);
			two = 10 - one;
			three = one + two;
			s1 = true;
			equation =  equationStringer(3, one, s1, two, true, three, true, 0, 0);
			return;
		//Tens-
		case 1:
			title = "Level 2: Tens minus";
			one = 10;
			two = random.nextInt(10);
			three = one-two;
			s1 = false;
			equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
			return;
		//Plus one
		case 3:
			title = "Level 3: Plus one";
			flip = random.nextBoolean();
			one = random.nextInt(101);
			if (flip) {
				two = one;
				one = 1;
				three = one + two;
			} else {
				two = 1;
				three = one + two;
			}
			s1 = true;
			equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
			return;
		default:
			equation = "NA";
			return;
		}
	}
	
	private String equationStringer(int items, int one, boolean s1, int two, boolean s2, int three, boolean s3, int four, int five) {
		switch (items) {
		case 0:
			return "";
		case 1:
			return "";
		case 2:
			return "";
		case 3:
			kindOfEquation = random.nextInt(3);
			symbol1 = symbolString(s1);
			if(kindOfEquation == 0) {
				answer = three;
				return "" + one + symbol1 + two + " = X";
			} else if(kindOfEquation == 1) {
				answer = one;
				return "X" + symbol1 + two + " = " + three;
			} else {
				answer = two;
				return "" + one + symbol1 + "X = " + three;
			}
		case 4:
			kindOfEquation = random.nextInt(4);
			symbol1 = symbolString(s1);
			symbol2 = symbolString(s2);
			if(kindOfEquation == 0) {
				answer = four;
				return "" + one + symbol1 + two + symbol2 + three + " = X";
			} else if (kindOfEquation == 1) {
				answer = one;
				return "X" + symbol1 + two + symbol2 + three + " = " + four;
			} else if (kindOfEquation == 2) {
				answer = two;
				return "" + one + symbol1 + "X" + symbol2 + three + " = " + four;
			} else if (kindOfEquation == 3) {
				answer = three;
				return "" + one + symbol1 + two + symbol2 + "X = " + four;
			}
		case 5:
			kindOfEquation = random.nextInt(5);
			symbol1 = symbolString(s1);
			symbol2 = symbolString(s2);
			symbol3 = symbolString(s3);
			if(kindOfEquation == 0) {
				answer = five;
				return "" + one + symbol1 + two + symbol2 + three + symbol3 + four + " = X";
			} else if (kindOfEquation == 1) {
				answer = one;
				return "X" + symbol1 + two + symbol2 + three + symbol3 + four + " = " + five;
			} else if (kindOfEquation == 2) {
				answer = two;
				return "" + one + symbol1 + "X" + symbol2 + three + symbol3 + four + " = " + five;
			} else if (kindOfEquation == 3) {
				answer = three;
				return "" + one + symbol1 + two + symbol2 + "X" + symbol3 + four + " = " + five;
			} else if (kindOfEquation == 4) {
				answer = four;
				return "" + one + symbol1 + two + symbol2 + three + symbol3 + "X = " + five;
			}
		default:
			return "";
		}
	}
	
	private String symbolString(boolean s) {
		if(s) {
			return " + ";
		} else {
			return " - ";
		}
	}
	
	public String equation() {
		return equation;
	}
	
	public String title() {
		return title;
	}
	
	public boolean feedback(int n) {
		if(n == answer) {
			return true;
		} else {
			return false;
		}
	}
	
}
