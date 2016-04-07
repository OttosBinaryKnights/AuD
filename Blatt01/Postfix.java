package Blatt01;

/*
 * "(3-4*5)*(6+5-2)" 
 * Stack			String
 * []				""
 * [(]				""
 * [(]				"3"
 * [(,-]			"3"
 * [(,-]			"3 4"
 * [(,-,*]			"3 4"
 * [(,-,*]			"3 4 5"
 * [(,-]			"3 4 5 *"
 * [(]				"3 4 5 * -"
 * [(,)]			"3 4 5 * -"
 * [(,),*]			"3 4 5 * -"
 * [(,),*,(]		"3 4 5 * -"
 * [(,),*,(]		"3 4 5 * - 6"
 * [(,),*,(,+]		"3 4 5 * - 6"
 * [(,),*,(,+]		"3 4 5 * - 6 5"
 * [(,),*,(]		"3 4 5 * - 6 5 +"
 * [(,),*,(,-]		"3 4 5 * - 6 5 +"
 * [(,),*,(,-]		"3 4 5 * - 6 5 + 2"
 * [(,),*,(]		"3 4 5 * - 6 5 + 2 -"
 * [(,),*,(,)]		"3 4 5 * - 6 5 + 2 -"
 * []				"3 4 5 * - 6 5 + 2 - *"
 */

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Postfix {

	private static boolean lastWasDigit = false;
	
	private static final char[][] precedences = { { '(', ')' }, { '+', '-' },
			{ '*', '/' } };

	private static int precedence(Character c) {
		for (int i = 0; i < precedences.length; i++) {
			for (int j = 0; j < precedences[i].length; j++)
				if (precedences[i][j] == c)
					return i; // get the priority
		}
		throw new NoSuchElementException();
	}

	private static boolean isAlphaNumeric(Character c) {
		return (c + "").matches("^[0-9a-zA-Z]*$"); // decide if operator or not
	}

	public static String toPostfixNotation(String infix) {
		Stack<Character> ops = new Stack<Character>();
		String postfix = "";
		lastWasDigit = false;
		
		for (int i = 0; i < infix.length(); i++) {
			Character tmp = infix.charAt(i);
			if (tmp.equals(' ')) // ignore whitespaces
				continue;
			if (!isAlphaNumeric(tmp)) {
				if (tmp == ')') {
					try {
						while (ops.lastElement() != '(')
							postfix += ops.pop() + " "; // pop operators in
														// paranthesis
						ops.pop();
					} catch (Exception e) {
						throw new InputMismatchException();
					}
				} else if ((ops.empty()) || (tmp == '(')
						|| (precedence(tmp) > precedence(ops.lastElement()))) {
					ops.push(tmp); // higher priority operator -> push
				} else {
					while (!ops.empty()
							&& (precedence(tmp) <= precedence(ops.lastElement())))
						postfix += ops.pop() + " "; // lower/same priority ->
													// firt pop
					ops.push(tmp); // then push new op
				}
				lastWasDigit = false;
			} else {
				if (lastWasDigit) 
					postfix = postfix.substring(0, postfix.length() - 1);
				postfix += tmp + " "; // digit/variable -> in output
				lastWasDigit = true;
			}
		}
		while (!ops.empty())
			postfix += ops.pop() + " "; // pop remaining ops
		return postfix;
	}

	public static void main(String[] args) {
		String[] data = { "12+2+3+4+5", "1+a*3+b*5", "(3-4*5)*(6+5-2)",
				"((3-4)*5)*((6+5)-2*1)" };
		for (int i = 0; i < data.length; i++)
			System.out.printf("%s -> %s \n", data[i],
					toPostfixNotation(data[i]));
	}
}
