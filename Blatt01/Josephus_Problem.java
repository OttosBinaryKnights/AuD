/*
Queue-Anwendung: Josephus-Problem

Von dem Geschichtsschreiber Josephus (1. Jhd.) ist uns ein interessantes mathematisches Problem überliefert:

n Personen stehen in einem Kreis und werden solange mit einem k-silbigen Abzählvers ausgezählt,
bis nur noch eine bestimmte Anzahl von Personen übrig bleibt. Josephus interessierte wie er und
seine Freunde stehen müssen, damit sie alleine übrig bleiben.

Lösen Sie das Josephus-Problem mit Hilfe der Klasse Queue.
a) Beschreiben Sie zunächst die Lösungsidee kurz mit Worten.
b) Schreiben Sie in der Klasse JosephusProblem eine Methode

  public static Queue<T> josephus(T[] children, int numbSyl),

die eine Liste der Personen und die Anzahl der Silben übergeben bekommt und die vollständige Liste der "Ausgezählten" als Queue<T> zurück gibt (die Queue enthält also alle Personen in der "ausgezählten" Reihenfolge).
c) Es sollen 13 Personen mit einem 7-silbigen Abzählreim ausgezählt werden. An welche Positionen müssen sich Josephus und seine fünf Freunde stellen, damit sie übrig bleiben?

Hinweise:
Hier finden Sie AbstractQueue und Queue aus der Vorlesung..
Die Klasse Queue<T> muss für die Backend-Kontrolle importiert werden mit
import aud.Stack;
*/

/*
 * a)
 * Wir erzeugen eine Queue mit L�nge = Anzahl der Kinder,
 * Danach wird abgez�hlt, jedes "getroffenes" Kind r�ckt an den Anfang der Queue
 * und wird im folgenden ignoriert, dass wird wiederholt bis alle abgez�hlt wurden.
 *
 * c)
 * c h b e f bleiben �brig, falls 5 �brig bleiben sollen
 * wenn nur einer �brig bleibt muss josephus muss josephus also an der 6. Stelle stehen
 * ansonsten sind die stellen 2, 3, 5, 6, 8 �brig
 */

 import aud.Queue;

 public class JosephusProblem {

 	public static <T> Queue<T> josephus(T[] children, int numbSyl) {
 		Queue<T> q = new Queue<T>();
 		Queue<T> out = new Queue<T>();

 		for (int i = 0; i < children.length; i++)
             q.enqueue(children[i]);

 		while (!q.is_empty()) {
             for (int i = 0; i < numbSyl - 1; i++)
                 q.enqueue(q.dequeue());
             out.enqueue(q.dequeue());
         }
         return out;
     }

 	public static void main(String[] args) {
 		String[] kids = {"a","b","c","d","e","f","g","h","i","j","k","l","m"};
 		System.out.println(josephus(kids,7).toString());
 	}
 }
