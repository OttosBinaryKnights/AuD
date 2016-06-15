/*
Adjazenzmatrix - Operationen

Wir betrachten im Folgenden Adjazenzmatrizen vom Typ int[][] m.
Die Indizierung der Knoten beginnt bei Null. Der Knotenname sei sein Index.
Schreiben Sie für diese Matrizen verschiedene Methoden:

a) Bestimmung des Eingangsgrades eines übergebenen Knotens mit der Methode

  public static int inDegree(int k, int[][] m)

b) Bestimmung des Ausgangsgrades eines übergebenen Knotens mit der Methode

  public static int outDegree(int k, int[][] m)

c) Ausgabe aller adjazenten (direkt zu erreichenden) Knoten eines gegebenen Knotens k mit der Methode

  public static List adjacent(int k, int[][] m)

d) Ein Dreieck in einem Graph ist ein Zyklus der Länge 3.
Untersuchen Sie, ob der durch die folgende Adjazenzmatrix gegebene Graph Dreiecke
enthält und geben Sie diese gegebenenfalls an.

          | 0 1 0 0 1 |
          | 0 0 0 1 0 |
      A = | 0 1 0 0 0 |
          | 0 0 1 0 0 |
          | 0 0 0 1 0 |
Schreiben Sie eine Java-Methode

  public static boolean hasTriangle(int[][] m),

in der Sie für eine gegebene Adjazenzmatrix entscheiden können, ob sie Dreiecke enthält oder nicht.
Zunächst können Sie davon ausgehen, dass der Graph keinen Knoten enthält, der auf sich selbst zeigt (Zyklus der Länge 1).
Was muss geändert werden, wenn Sie Zyklen der Länge 1 zulassen?

e) Überprüfen Sie Ihre Methoden an geeigneten Testdaten.
*/

import java.util.*;

public class AdjMatrix {

	public static int inDegree(int k, int[][] m) {
		int deg = 0;
		for (int i = 0; i < m.length; i++)
			deg += m[i][k];
		return deg;
	}

	public static int outDegree(int k, int[][] m) {
		int deg = 0;
		for (int i = 0; i < m.length; i++)
			deg += m[k][i];
		return deg;
	}

	public static List<Integer> adjacent(int k, int[][] m) {
		LinkedList<Integer> adj = new LinkedList<Integer>();
		for (int i = 0; i < m.length; i++)
			if (m[k][i]>0)
				adj.add(i);
		return adj;
	}

	public static boolean hasTriangle(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			List<Integer> adjsI = adjacent(i,m);
			for (Integer j : adjsI) {
				List<Integer> adjsJ = adjacent(j,m);
				for (Integer k : adjsJ) {
					List<Integer> adjsK = adjacent(k,m);
					for (Integer l : adjsK) {
						if (i != j && i != k && i == l) {
							System.out.println("Triangle: " + i + "->" + j + "->" + k + "->" + l + ".");
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public static String matrixToString(int[][] matrix) {
		String res = "";
		for (int i = 0; i < matrix.length; i++) {
			res += Arrays.toString(matrix[i]) + "\n";
		}
		return res;
	}

	public static void main(String args[]) {
		int[][] matrix = {
				{ 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 1, 0 },
				{ 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 1, 0 }
		};

		System.out.println(matrixToString(matrix));

		System.out.println(hasTriangle(matrix));

		for (int i = 0; i < 5; i++) {
			int inDegree = inDegree(i, matrix);
			System.out.println("\nIndegree " + i + ": " + inDegree);
			int outDegree = outDegree(i, matrix);
			System.out.println("Outdegree " + i + ": " + outDegree);
			List<Integer> adjs = adjacent(i, matrix);
			System.out.println("Neighbours " + i + ": " + adjs.toString());
		}
	}
}
