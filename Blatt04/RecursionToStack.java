/*
Rekursion mit Stack auflösen

Gegeben sei die rekursive Funktion

    public static int whatRec(int n) {
        if (n < 10)
            return n;
        else
            return whatRec(n / 10) + n % 10;
    }

Was macht whatRec?

Schreiben Sie eine nichtrekursive Funktion

  public static int whatStack(int n),

die einen Stack mit den üblichen Operationen push und pop nutzt und die gleiche Funktionalität wie whatRec bietet.


Hinweis:
Die Klasse Stack<T> finden Sie unter den "Folien und Materialien" auf der Seite "Code/Beispiele".
Die Klasse Stack<T> steht im Backend zur Verfügung und muß mit
import aud.Stack;
eingebunden werden.
*/

/*
 Antwort zu Teil a)

 Quersumme

 */

import aud.Stack;

public class RecursionToStack {

	public static int whatRec(int n) {
		if (n < 10)
			return n;
		else
			return whatRec(n / 10) + n % 10;
	}

	public static int whatStack(int n) {
		if (n < 0)
			return n;
		Stack<Integer> s = new Stack<Integer>();
		while (n > 0) {
			s.push(n % 10);
			n /= 10;
		}
		Integer res = 0;
		while (!s.is_empty())
			res += s.pop();
		return res;
	}

	public static void main(String args[]) {
		for (int i = -23; i < 30; i++) {
			System.out.println(whatRec(i) + " | " + whatStack(i));
		}
	}

}
