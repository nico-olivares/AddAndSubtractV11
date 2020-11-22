package upgrade3;
import java.util.Random;

public class EquationV3 {

	private int one, two, three, four, five, answer, kindOfEquation, items;
	private boolean flip, s1, s2, s3;	//s1, s2, s3 are symbols. True for +, false for -. Flip 
	private Random random;
	private String equation, title, symbol1, symbol2, symbol3;
	
	EquationV3(int level) {
		equation = "";
		random = new Random();
		switch(level) {
		//Tens +
		case 0:
			title = "Level 1: Tens";
			level1();
			return;
		//Tens-
		case 1:
			title = "Level 2: Tens minus";
			level2();
			return;
		//Plus one
		case 2:
			title = "Level 3: Plus one";
			level3();
			return;
		case 3:
			title = "Level 4: Minus one";
			level4();
			return;
		case 4:
			title = "Level 5: Review";
			one = random.nextInt(4);
			if (one == 0) {
				level1();
			} else if (one == 1) {
				level2();
			} else if (one == 2) {
				level3();
			} else if (one == 3) {
				level4();
			}
			return;
		case 5:
			title = "Level 6: Plus two";
			level6();
			return;
		case 6:
			title = "Level 7: Minus two";
			level7();
			return;
		case 7:
			title = "Level 8: Doubles";
			level8();
			return;
		case 8:
			title = "Level 9: Doubles plus one or two";
			level9();
			return;
		case 9:
			title = "Level 10: Review";
			one = random.nextInt(4);
			if (one == 0) {
				level6();
			} else if (one == 1) {
				level7();
			} else if (one == 2) {
				level8();
			} else if (one == 3) {
				level9();
			}
			return;
		//Two digit addition with a one digit to ten ie 43+7
		case 10:
			title = "Level 11: Two digit addition with a one digit to ten";
			level11();
			return;
		case 11:
			title = "Level 12: Plus and minus 10";
			level12();
			return;
		case 12:
			title = "Level 13: Plus combinations of 10";
			level13();
			return;
		//Add two digit addition that makes tens ie 46 + 34
		case 13:
			title = "Level 14: Two digit addition with combinations of ten";
			level14();
			return;
		case 14:
			title = "Level 15: Review";
			one = random.nextInt(4);
			if (one == 0) {
				level11();
			} else if (one == 1) {
				level12();
			} else if (one == 2) {
				level13();
			} else if (one == 3) {
				level14();
			}
			return;
		case 15:
			title = "Level 16: Plus and minus 100";
			level16();
			return;
		case 16:
			title = "Level 17: Two digit addends";
			level17();
			return;
		case 17:
			title = "Level 18: Two digit subtraction";
			level18();
			return;
		case 18:
			title = "Level 19: Three two-digit addends";
			level19();
			return;
		case 19:
			title = "Level 20: Review";
			one = random.nextInt(4);
			if (one == 0) {
				level16();
			} else if (one == 1) {
				level17();
			} else if (one == 2) {
				level18();
			} else if (one == 3) {
				level19();
			}
			return;
		case 20:
			title = "Level 21: Three digit addition";
			level21();
			return;
		case 21:
			title = "Level 22: Three digit subtraction";
			level22();
			return;
		default:
			equation = "NA";
			return;
		}
	}
	//Tens
	private void level1() {
		items = 3;
		one = random.nextInt(11);
		two = 10 - one;
		three = one + two;
		s1 = true;
		equation =  equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//tens minus
	private void level2() {
		one = 10;
		two = random.nextInt(10);
		three = one-two;
		s1 = false;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//plus one
	private void level3() {
		flip = random.nextBoolean();	//to determine if 1 is first or second
		one = random.nextInt(101);
		if (flip) {
			two = one;
			one = 1;
			three = one + two;
		} else {
			two = 1;
			three = one + two;
		}
		s1 = true;			//true for +, false for -
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//minus one
	private void level4() {
		one = random.nextInt(101);
		two = 1;
		three = one - two;
		s1 = false;
		equation = equationStringer(3, one, s1, two, true, three, true, 0,0);
	}
	//plus 2
	private void level6() {
		flip = random.nextBoolean();	//to determine if 1 is first or second
		one = random.nextInt(101);
		if (flip) {
			two = one;
			one = 2;
			three = one + two;
		} else {
			two = 2;
			three = one + two;
		}
		s1 = true;			//true for +, false for -
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//minus 2
	private void level7() {
		one = random.nextInt(101);
		two = 2;
		three = one - two;
		s1 = false;
		equation = equationStringer(3, one, s1, two, true, three, true, 0,0);
	}
	//doubles
	private void level8() {
		one = random.nextInt(29);
		if(one == 26) {
			one = 50;
		} else if (one == 27) {
			one = 75;
		} else if (one == 28) {
			one = 100;
		}
		two = one;
		three = one + two;
		s1 = true;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//doubles plus one or two
	private void level9() {
		flip = random.nextBoolean();
		one = random.nextInt(29);
		if(one == 26) {
			one = 50;
		} else if (one == 27) {
			one = 75;
		} else if (one == 28) {
			one = 100;
		}
		if(flip) {
			two = one;
			one++;
		} else {
			two = one+1;
		}
		three = one + two;
		s1 = true;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Two digit addition with a one digit to ten ie 43+7
	private void level11() {
		one = random.nextInt(100-20)+20;
		two = one % 10;
		three = one + two;
		s1 = true;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Plus and minus 10
	private void level12() {
		flip = random.nextBoolean();
		one = random.nextInt(101-15) + 15;
		if(flip) {
			two = 10;
			three = one - 10;
			s1 = false;
		} else {
			flip = random.nextBoolean();
			s1 = true;
			if(flip) {
				two = 10;
			} else {
				two = one;
				one = 10;
			}
			three = one + two;
		}
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Plus combinations of 10
	private void level13() {
		one = random.nextInt(91);
		two = random.nextInt(10);
		three = random.nextInt(4);
		s1 = true;
		s2 = true;
		if(three == 0) {
			three = 10-two;
		} else if (three == 1) {
			three = two;
			two = one;
			one = 10 - three;
		} else if (three == 2) {
			three = one;
			one = 10 - two;
		}
		four = one + two + three;
		equation = equationStringer(4, one, s1, two, s2, three, true, four, 0);
	}
	//Add two digit addition that makes tens ie 46 + 34
	private void level14() {
		one = random.nextInt(100-10)+10;
		two = random.nextInt(9)+1;
		three = one % 10;
		two = (two*10)+three;
		three = one + two;
		s1 = true;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Plus and minus 100
	private void level16() {
		flip = random.nextBoolean();
		one = random.nextInt(891-15) + 15;
		if(flip) {
			two = 100;
			three = one - 100;
			s1 = false;
		} else {
			flip = random.nextBoolean();
			s1 = true;
			if(flip) {
				two = 100;
			} else {
				two = one;
				one = 100;
			}
			three = one + two;
		}
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Two digit addition
	private void level17() {
		one = random.nextInt(100);
		two = random.nextInt(100);
		s1 = true;
		three = one + two;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Two digit subtraction
	private void level18() {
		three = random.nextInt(10-5)+5;
		four = random.nextInt(5);
		one = (three*10) + four;
		three = random.nextInt(5);
		four = random.nextInt(10-5)+5;
		two = (three*10)+four;
		three = one - two;
		s1 = false;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);		
	}
	//Three two-digit addends
	private void level19() {
		one = random.nextInt(101);
		two = random.nextInt(101);
		three = random.nextInt(101);
		four = one + two + three;
		s1 = true;
		s2 = true;
		equation = equationStringer(4, one, s1, two, s2, three, true, four, 0);
	}
	//Three digit addition
	private void level21() {
		one = random.nextInt(900-100)+100;
		two = random.nextInt(900-100)+100;
		three = one + two;
		s1 = true;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
	}
	//Three digit subtraction
	private void level22() {
		one = random.nextInt(1000-500)+500;
		two = random.nextInt(500-100)+100;
		three = one - two;
		s1 = false;
		equation = equationStringer(3, one, s1, two, true, three, true, 0, 0);
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
