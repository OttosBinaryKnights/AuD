/*
Iterator für einfach verkettete Liste

Schreiben Sie eine Klasse MySList, die ganzzahlige Daten als einfach verkettete
Liste verwaltet und über die ungeraden Zahlen iterieren kann.
Sie können sich dabei an dem Konzept der Klasse SList orientieren.
Für den Backend-Test muss MySList eine Methode

  public void push_back(int obj)

enthalten.
Schreiben Sie innerhalb der Klasse MySList die Klasse

  public class Iterator implements java.util.Iterator,

mit den üblichen Funktionen wie hasNext() und next(). Dabei soll die Iteration nur über die ungeraden Elemente einer Liste von ganzen Zahlen erfolgen.
Schreiben Sie die Funktion

  public Iterator iterator(),

in der eine Instanz Ihrer Klasse Iterator zurück geliefert wird.

Testen Sie Ihren Iterator in main mit der foreach-Schleife.
Beisiel:
l sei [85,72,93,81,74,42]
In der Schleife "for (int el : l){...}" dürfen dann nur die ungeraden Elemente 85, 93 und 81 durchlaufen werden.

Hinweise:
Die Klasse SList finden Sie unter Sie unter "Folien und Materialien" auf der Seite "Code/Beispiele"..
Für das Backend muss in der Klasse Iterator auch die Methode remove enthalten sein (ohne was zu bewirken).
*/

import java.util.NoSuchElementException;

public class MySList implements Iterable<Integer> {

	class Node {
		int _value = Integer.MAX_VALUE;
		Node _next = null;

		public Node(int value, Node next) {
			_value = value;
			_next = next;
		}
	}

	Node _head = null;

	public MySList() {}

	public void push_back(int value) {
		if (_head == null) {
			_head = new Node(value, null);
			return;
		}
		if (_head._next == null) {
			_head._next = new Node(value, null);
			return;
		}
		Node tmp = _head._next;
		while (tmp._next != null)
			tmp = tmp._next;
		tmp._next = new Node(value, null);
	}

	public class Iterator implements java.util.Iterator<Integer> {

		Node _node = null;

		Iterator(Node node) {
			_node = node;
			while ((_node._value % 2) == 0) {
				_node = _node._next;
				if (_node == null)
					return;
			}
		}

		@Override
		public boolean hasNext() {
			return _node != null;
		}

		@Override
		public Integer next() {
			if (_node == null)
				throw new NoSuchElementException();
			Integer value = _node._value;
			do {
				_node = _node._next;
				if (_node == null)
					break;
			} while ((_node._value % 2) == 0);
			return value;
		}

		@Override
		public void remove() {
			Node tmp = _head;
			while (!tmp._next.equals(_node)) {
				tmp = tmp._next;
			}

		}

		@Override
		public boolean equals(Object other) {
			return _node == ((Iterator) other)._node;
		}

	}

	public Iterator iterator() {
		return new Iterator(_head);
	}

	@Override
	public String toString() {
		String res = "[";
		Node tmp = _head;
		while (tmp != null) {
			res += tmp._value + ", ";
			tmp = tmp._next;
		}
		res = res.substring(0, res.length() - 2);
		res += "]";
		return res;
	}

	public static void main(String[] args) {
		MySList l = new MySList();
		for (int i = 0; i < 10; i++)
			l.push_back(i);
		System.out.println(l.toString());

		for (int el : l) {
			System.out.println(el);
		}
	}
}
