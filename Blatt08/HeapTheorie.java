/*
Heap: Theorie

Erläutern Sie die Datenstruktur Heap (MinHeap, wie in der Vorlesung vorgestellt)
an einem Beispiel und nennen Sie die Eigenschaften des Heap.

Zeigen Sie die Darstellung des Heap in einem Feld.

In einem MinHeap seien alle Elemente verschieden.
Wo befindet sich das größte Element?

Ist ein Feld, das in aufsteigend sortierter Reihenfolge vorliegt, ein Heap?

Beschreiben Sie das Vorgehen, um ein ungeordnetes Feld in einen MinHeap
zu überführen an folgendem Beispiel:
  E, A, S, Y, Q, U, E, S, T, I, O, N.

Wie groß ist die Komplexität Ihres Vorgehens in O-Notation im schlechtesten Fall?
*/

/*
a)
Ein binärer MinHeap ist ein Binärbaum in dem gilt,
dass jeder Knoten (außer der Wurzel) größer ist als sein Vaterknoten.

       0
   2       3
 4   7  10   9

[0, 2, 3, 4, 7, 10, 9]

Ein Heap in dem alle Ebene bis auf die letzte vollständig
gefüllt sind und die letzte Ebene linksbündig gefüllt ist
lässt sich in einem Array darstellen.

Für einen Knoten an der Stelle k, gilt:
parent(k) = floor(k/2)
left(k)   = 2k
right(k)  = 2k+1
(einsbasiert)
bzw.
parent(k) = floor((k-1)/2)
left(k)   = 2k+1
right(k)  = 2k+2
(nullbasiert)

b)
In einem MinHeap befinden sich die größten Elemente au der tiefsten Ebene.
Ein sortiertes Feld ist ein MinHeap.

c)
1  2  3  4  5  6  7  8  9 10 11 12
E, A, S, Y, Q, U, E, S, T, I, O, N  k=6 swap(U,N)

E, A, S, Y, Q, N, E, S, T, I, O, U  k=5 swap(Q,I)

E, A, S, Y, I, N, E, S, T, Q, O, U  k=4 swap(Y,S)

E, A, S, S, I, N, E, Y, T, Q, O, U  k=3 swap(E,S)

E, A, E, S, I, N, S, Y, T, Q, O, U  k=2

E, A, E, S, I, N, S, Y, T, Q, O, U  k=1 swap(E,A)

A, E, E, S, I, N, S, Y, T, Q, O, U

O(n)
*/
