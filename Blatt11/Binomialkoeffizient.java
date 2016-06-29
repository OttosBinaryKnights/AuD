/*
Binomialkoeffizient (mit Pascalschem Dreieck)

Beschreiben Sie im Pseudocode den Algorithmus,
um den Binomialkoeffizienten unter Ausnutzung der Rekursionsformel

mit Hilfe des Pascalschen Dreiecks zu berechnen.
Wie groß ist die Komplexität in O-Notation in Abhängigkeit von n und k?

Geben Sie zur Illustration der Arbeitsweise des Algorithmusses die
berechnete Tabelle an für die Eingaben n = 7 und k = 5.
Formulieren Sie für die Berechnung des Binomialkoeffizienten mit
Pascalschem Dreieck eine iterative Implementierung für die Funktion

public static int binom(int n, int k)

Überlegen Sie, wie die Anzahl der Rechenschritte reduziert werden kann.
Vergleichen Sie den Aufwand zur Berechnung mit einer rekursiven Lösung,
indem Sie die obige Rekursionsformel direkt (Baumrekursion) verwenden.
*/

/**
 * Pseudocode siehe Funktion binom :) Wieder komplette Tabelle ausrechnen, also
 * O(n*m)
1 | 0 | 0 | 0 | 0 | 0 |
1 | 1 | 0 | 0 | 0 | 0 |
1 | 2 | 1 | 0 | 0 | 0 |
1 | 3 | 3 | 1 | 0 | 0 |
1 | 4 | 6 | 4 | 1 | 0 |
1 | 5 | 10 | 10 | 5 | 1 |
1 | 6 | 15 | 20 | 15 | 6 |
1 | 7 | 21 | 35 | 35 | 21 |
 *
 * c) Der Algorithmus ist schon so gut...denke spielt auf das j <= Math.min(i, k) an
 *
 * d) Zeit in nanosekdungen bei n=35 und k=20 dynamisch 55048 rekursiv
 * 10659988928
 *
 * dynamisch ist also in diesem Beispiel ca. 193.648 mal schneller als rekursiv
 */

public class MyBinom {

	public static int binom(int n, int k) {
		int[][] array = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i)
					array[i][j] = 1;
				else
					array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
			}
		}
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[0].length;j++) {
				System.out.print(array[i][j]+" | ");
			}
			System.out.println();
		}

		return array[n][k];
	}

	public static int rec_binom(int n, int k) {
		if (k == 0 || n == k)
			return 1;
		return rec_binom(n - 1, k) + rec_binom(n - 1, k - 1);
	}

	public static void main(String[] args) {
		// hier bitte Testrahmen eingeben (nebst Ausgabe in geforderter Form)

//		System.out.println(binom(5, 2)); // 10 correct
		System.out.println(binom(7, 5)); // 21 correct

		// long start=System.nanoTime();
		// binom(35,20);
		// long end=System.nanoTime();
		// System.out.println(end-start);
		//
		// start=System.nanoTime();
		// rec_binom(35,20);
		// end=System.nanoTime();
		// System.out.println(end-start);
	}
}
