/*
Endrekursion

a) Beschreiben Sie kurz was eine Endrekursion (iterative Rekursion, engl.tail recursion) ist.
b) Schreiben Sie jeweils eine endrekursive Hilfsmethode.

Es soll mit der Methode

  public static int pot2TailRec(int n)

die Zweierpotenz einer natürlichen Zahl n berechnet werden. So soll beispielsweise pot2TailRec(5) die Zahl 32 liefern. Hinweis: pot2Tail muss eine endrekursive Hilfsmethode aufrufen.
Für die Bestimmung der befreundeten Zahlen (siehe Blatt03 Wintersemester) benötigt man die Summe der Teiler einer natürlichen Zahl n. Dabei wird 1 als Teiler von n betrachtet und mit summiert, die Zahl n selbst aber nicht. Beispielsweise ist die Summe der Teiler von 6 gleich 1 + 2 + 3. Schreiben Sie eine Methode

  public static int sumFacTailRec(int n)

zur Berechnung der Summe der Teiler von n. Hinweis: sumFacTailRec muss eine endrekursive Hilfsmethode aufrufen.
*/

// Eine Funktion ist endrekursiv, wenn der rekursive Funktionsaufruf
// die letzte Aktion der Funktion ist.

public class TailRecursive
{
	public static int pot2TailRec(int n)
	{
		if (n < 0) throw new ArithmeticException();
		if (n == 0) return 1;
		return _pot2TailRec(2, n);
	}

	public static int _pot2TailRec(int n, int i)
	{
		if (i == 1) return n;
		else return _pot2TailRec(n * 2, i - 1);
	}

	public static int sumFacTailRec(int n)
	{
		if (n < 0) throw new ArithmeticException();
		if (n == 0) return 0;
		return _sumFacTailRec(n, 2, 1);
	}

	public static int _sumFacTailRec(int n, int i, int sum)
	{
		if (i > n/2) return sum;
		else return _sumFacTailRec(n, i+1, n % i == 0 ? sum+i : sum);
	}

	public static void main(String[] args)
	{
		System.out.println(pot2TailRec(0));
		System.out.println(pot2TailRec(1));
		System.out.println(pot2TailRec(10));
		System.out.println(pot2TailRec(20));
		System.out.println(sumFacTailRec(0));
		System.out.println(sumFacTailRec(1));
		System.out.println(sumFacTailRec(6));
		System.out.println(sumFacTailRec(8));
		System.out.println(sumFacTailRec(64));
        }
}
