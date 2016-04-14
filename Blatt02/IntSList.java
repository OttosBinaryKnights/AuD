/*
Filter für SList

Diese Aufgabe wird ***nicht*** automatisch getestet.
Schreiben Sie eine Klasse

  public class IntSList {
    SList<Integer> li;
    ...
  }

mit dem Attribut li. Diese Klasse soll eine einfach verkettete Liste mit
ganzzahligen Daten erstellen und filtern können. Sie können Funktionen aus SList
nutzen, um eine derartige Liste aufzubauen, zum Beispiel:

  public void push_front(int obj){
      li.push_front(obj);
  }

Schreiben Sie eine Funktion

  public IntSList filter(Predicate p),

die ein Prädikat p übergeben bekommt und alle Elemente - die dieses Prädikat
erfüllen - in eine neue Liste aufsammelt. Beachten Sie, dass es für li einen
Iterator gibt (in SList definiert). Das Interface

  public interface Predicate {
     public boolean test(int el);
  }

ist gegeben.

Zum Test sollen aus der ganzzahligen Liste alle geraden Elemente heraus gefiltert werden.
Beisiel:
  l sei [85,72,93,81,74,42]
  l.filter(p) liefert dann die Liste [42,74,72] (Reihenfolge wegen push_front).
  Wie muss p definiert werden? Gibt es verschiedene Varianten?

Hinweise: Die Klasse SList finden Sie unter Sie unter "Folien und Materialien" auf der Seite "Code/Beispiele"..
*/

import java.util.Iterator;
import aud.SList;

public class IntSList implements Iterable<Integer> {
	SList<Integer> li;

	public IntSList() {
		li = new SList<Integer>();
	}

	public String toString() {
		return li.toString();
	}

	public void push_front(int obj) {
		li.push_front(obj);
	}

	public void push_back(int obj) {
		li.push_back(obj);
	}

	public int at(int index) {
		return li.at(index);
	}

	public Iterator<Integer> iterator() {
		return li.iterator();
	}

	public void insert(int i, int value) {
		li.insert(i, value);
	}

	public void erase(int i) {
		li.erase(i);
	}

	public void pop_front() {
		li.pop_back();
	}

	public void pop_back() {
		li.pop_back();
	}

	public IntSList filter(Predicate p) {
		IntSList res = new IntSList();
		for (int tmp : li) {
			if (p.test(tmp))
				res.push_front(tmp);
		}
		return res;
	}

	public static void main(String args[]) {
		IntSList l = new IntSList();
		Integer data[] = {85,72,93,81,74,42};
		for (int i = 0; i < data.length; i++)
			l.push_back(data[i]);
		System.out.println(l.toString());
		System.out.println(l.filter(new PredicateEvenNr()).toString());
	}
}
