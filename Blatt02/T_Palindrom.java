/*
T-Palindrome

T-Palindrome (eine nette Erfindung von Prof. Tönnies) sind Palindrome über einem
Alphabeth aus den Konstanten {a, b, c, ..., z} und {(, ), *}. Dabei ist * eine Funktion,
die rekursiv als geklammertes T-Palindrom definiert ist, d.h. wenn ein Klammerausdruck
ein Palindrom ist, wird er durch * ersetzt.

Beispiele für T-Palindrome sind:

     "otto"
     "al(otto)la" = "al*la"
     "abc(aha)(u)cba" = "abc**cba"
     "abc(ah(otto)v(atta)ha)cba"= "abc(ah*v*ha)cba"="abc*cba"

Keine T-Palindrome sind z.B.:
     "abc"
     "abc(ah(otto)h)cba" = "abc(ah*h)cba" (weil "ah*h" kein Palindrom ist)

Schreiben Sie eine Methode

  public static boolean isTPalindrome(String text),

mit der Sie unter Benutzung eines Stacks feststellen, ob eine gegebene Zeichenkette,
bestehend aus dem Alphabet {"a","b","c",...} und {" (",")"} ein T-Palindrom ist.

Hinweise:
Um für eine gegebene Zeichenkette den T-Palindromtest durchzuführen, muss geprüft werden,
ob ein geklammerter Ausdruckdurch das Zeichen "*" ersetzt werden kann (was nur geht,
wenn der in Klammern stehende Teil selbst ein T-Palindrom ist).

Wenn Sie zum ersten Mal eine ")" gefunden haben, dann können Sie sicher sein,
dass es sich um die innerste Klammer handelt. Zwischen dieser und der dazugehörenden "("
können also keine weiteren Klammern stehen. Der Ausdruck dazwischen ist also
entweder ein Palindrom, und kann durch "*" ersetzt werden oder er ist es nicht
und dann ist der Gesamtausdruck kein T-Palindrom
*/

import java.util.Stack;
import java.lang.Object;

public class Palindrome {

	public static boolean isTPalindrome(String text) {

		Stack<Character> stack = new Stack<Character>();
		String stringFinal = new String("");

		char[] charArray = text.toCharArray();

		if (isValid(charArray) == false) {
			System.out.println("Zeichenkette ist nicht gueltig => kein T-Palindrom \n");
			return false;
		}

		else {

			for (int i = 0; i < charArray.length; i++) {

				if (charArray[i] != ')') {			// alle Zeichen in den Stack bis zur schliessenden Klammer
					stack.push(charArray[i]);
				}

				else {
					String string = new String("");

					while (stack.peek() != '(') {		// alles in Klammern raus aus dem Stack und in einen String
						string += stack.pop();
					}
					stack.pop(); 				// oeffnende Klammer raus aus dem Stack


					if (isPalindrome (string) == false) {
						System.out.println("Kein Palindrom in Klammern => kein T-Palindrom \n");
						return false;
					}
						else {
							stack.push('*');	// Palindrom in Klammern durch * ersetzen
						}
				}
			}

			for (int i = 0; !stack.isEmpty(); i++) {
				stringFinal += stack.pop();			// alles raus aus dem Stack und in einen String
			}

			if (isPalindrome (stringFinal) == false) return false;

		}

		return true;
	}





	public static boolean isValid(char[] charArray) {		// Hilfsmethode: prueft, ob die Zeichenkette gueltig ist
		for (int i = 0; i < charArray.length; i++) {
			if (!Character.isLowerCase(charArray[i]) && charArray[i] != '('	&& charArray[i] != ')') {
				return false;
			}
		}
		return true;
	}

	   public static boolean isPalindrome(String text) {
	    Stack s1 = new Stack();
		Stack s2 = new Stack();
		int length=0;

		for(int i=0; i< text.length(); i++) {
			char t = text.charAt(i);

			if(Character.isLetter(t)) {
				if(Character.isUpperCase(t)) 	t=Character.toLowerCase(t);
				s1.push(Character.valueOf(t));
				length++;
				}
		}

		for(int i=0; i<length/2; i++)
			s2.push(s1.pop());

		if(length%2!=0) s1.pop();

		while(!s1.isEmpty())
			if(s1.pop()!=s2.pop())
				return false;

		return true;
	   }



	public static void main(String[] args) {

		System.out.println("'abc(ah(otto)v(atta)ha)cba' is a T-Palindrome: " + isTPalindrome("abc(ah(otto)v(atta)ha)cba"));
		System.out.println();
		System.out.println("'abc(aha)(u)cba' is a T-Palindrome: " + isTPalindrome("abc(aha)(u)cba"));
		System.out.println();
		System.out.println("'abc(ah(otto)h)cba' is a T-Palindrome: " + isTPalindrome("abc(ah(otto)h)cba"));
		System.out.println();

	}
}
