/*
Darstellung von Graphen

a) Was ist ein Graph?
Erläutern Sie die unterschiedlichen Arten von Graphen.

b) Geben Sie für den ungerichteten Graphen G = (V, E) mit
V = {1, 2, 3, 4, 5},
E = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 4}, {2, 5}, {3, 4}, {4, 5}}
eine bildliche Darstellung an.

c) Notieren Sie für diesen Graphen
  die Kantenliste,
  die Knotenliste,
  die Adjazenzmatrix,
  die Adjazenzliste
und geben Sie die entsprechenden Datenstrukturen in Java an.

d) Geben Sie die Algorithmen (in Java) an, die die Überführung
einer Kantenliste in eine Adjazenzmatrix,
eine Kantenliste in eine Adjazenzliste und
realisieren. Wie hoch ist jeweils der Aufwand in O-Notation?

Hinweis: Die Antwort für Teil b) dieser Aufgabe brauchen Sie
nicht im System einzureichen. Machen Sie sich hierzu Notizen auf
einem Blatt Papier und bringen Sie das zur Übung mit.
*/

/*
a.

Ein Graph ist in der Graphentheorie eine abstrakte Struktur,
die eine Menge von Objekten zusammen mit den zwischen diesen
Objekten bestehenden Verbindungen repräsentiert. Die
mathematischen Abstraktionen der Objekte werden dabei Knoten
(auch Ecken) des Graphen genannt. Die paarweisen Verbindungen
zwischen Knoten heißen Kanten (manchmal auch Bögen). Die
Kanten können gerichtet oder ungerichtet sein. Häufig werden
Graphen anschaulich gezeichnet, indem die Knoten durch Punkte
und die Kanten durch Linien dargestellt werden.
(http://de.wikipedia.org/wiki/Graph_%28Graphentheorie%29)


b.

V = {1, 2, 3, 4, 5},
E = {(1, 2), (1, 3), (1, 4), (1, 5), (2, 4), (2, 5), (3, 4), (4, 5)}

1-----2
|\\  /|
| \5  |
|  \\ |
|   \\|
3-----4


c.

Kantenliste:
int[] edgelist = { 5,8,1,2,1,3,1,4,1,5,2,4,2,5,3,4,4,5 };

Knotenliste:
int[] nodelist = { 5,8, 4,2,3,4,5, 3,1,4,5 2,1,4, 4,1,2,3,5, 3,1,2,4 };

Adjazenzmatrix:
    |  1 1 1 1|
    |1     1 1|
A = |1     1  |
    |1 1 1   1|
    |1 1   1  |
int[][] adjanzmatrix = {{0,1,1,1,1},{1,0,0,1,1},{1,0,0,1,0},{1,1,1,0,1},{1,1,0,1,0}};

Adjazenzliste:
1 -> 2,3,4,5
|
2 -> 1,4,5
|
3 -> 1,4
|
4 -> 1,2,3,5
|
5 -> 1,2,4

List<Integer>[] adjanzlist = new ArrayList<Integer>[5]();
List[0] = new ArrayList<Integer>(Arrays.asList( new String[]{2,3,4,5} ))
List[1] = new ArrayList<Integer>(Arrays.asList( new String[]{1,4,5} ))
List[2] = new ArrayList<Integer>(Arrays.asList( new String[]{1,4} ))
List[3] = new ArrayList<Integer>(Arrays.asList( new String[]{1,2,3,5} ))
List[4] = new ArrayList<Integer>(Arrays.asList( new String[]{1,2,4} ))


d.

Überführung einer Kantenliste in eine
Adjazenzmatrix für ungerichteten Graph:

int[][] adjanzmatrix = new int[edgelist[0]][edgelist[0]];
for(int i = 2; i<edgelist.length-2; i++) {
	adjanzmatrix[i][i+1] = 1;
	adjanzmatrix[i+1][i] = 1;
} -> Aufwand: O(n)

Überführung einer Kantenliste in eine
Adjazenzmatrix für gerichteten Graph:

int[][] adjanzmatrix = new int[edgelist[0]][edgelist[0]];
for(int i = 2; i<edgelist.length-2; i++) {
	adjanzmatrix[i][i+1] = 1;
} -> Aufwand: O(n)


Überführung einer Kantenliste in eine Adjazenzliste:

List<Integer>[] adjanzlist = new ArrayList<Integer>[nodelist[0]]();
int pointer = 2;
for(int i = 0; i < nodelist[0]) {
	List[i] = new ArrayList<Integer>();
	if(nodelist[pointer]!=0) {
		for(int j = 1; j <= nodelist[pointer]) {
			List[i].add(nodelist[poniter+j])
		}
	}
	pointer += (nodelist[pointer] + 1);
} -> Aufwand: O(n)
*/
