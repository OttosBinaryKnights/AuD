/*
Eigener SearchTree

Schreiben Sie eine Klasse SimpleTree<T extends Comparable<T>>,
die einen binären Suchbaum für vergleichbare Werte aufbauen kann.
Diese Klasse soll nur die folgenden Methoden enthalten.
Die Methode

  public void insert(T obj)

dient dem geordneten Einfügen von obj in den binären Suchbaum.
Ist obj bereits enthalten, soll es nicht eingefügt werden.
Die Methode

  public boolean search(T obj)

soll obj im Baum suchen und true(für gefunden) bzw. false (nicht enthalten) zurück liefern.
Die Methode

  public String toString()

soll die Knoteninhalte des Baumes (beliebige Reihenfolge) anzeigen.


Hinweise:
Die interne Klasse Node soll einen Verweis auf den Elternknoten enthalten.
Nutzen Sie keine der vordefinierten Klassen aus dem Ordner "Folien und Materialien",
sondern bemühen Sie sich um eine möglichst einfache eigene Implementation.
*/

import java.util.Random;

public class SimpleTree<T extends Comparable<T>> {

	public class Node {
		public Node _parent;
		public Node _left, _right;
		public T _data;

		public Node(T data) {
			_parent = null;
			_data = data;
			_left = null;
			_right = null;
		}

		public Node(T data, Node parent, boolean right) {
			_parent = parent;
			_data = data;
			if (right)
				_parent._right = this;
			else
				_parent._left = this;
			_left = null;
			_right = null;
		}

		@Override
		public String toString() {
			String res = "[" + _data.toString() + "]";
			if (_left != null)
				res += " " + _left.toString();
			if (_right != null)
				res += " " + _right.toString();
			return res;
		}
	}

	protected Node root;

	public SimpleTree() {
		root = null;
	}

	public void insert(T obj) {
		if (root == null) {
			root = new Node(obj);
			return;
		}

		Node tmp = root;
		Node prev = null;
		boolean ready = false;
		while (!ready) {
			int res = tmp._data.compareTo(obj);
			if (res == 0)										// same value, don't insert
				return;
			prev = tmp;
			if (res > 0) {
				tmp = tmp._left;								// node-value is bigger -> traverse left
				if (tmp == null) {
					prev._left = new Node(obj, prev, false);
					ready = true;
				}
			} else {											// node-value is smaller -> traverse right
				tmp = tmp._right;
				if (tmp == null) {
					prev._right = new Node(obj, prev, true);
					ready = true;
				}
			}
		}
	}

	public boolean search(T obj) {
		if (root == null)
			return false;
		Node tmp = root;
		while (tmp != null) {
			int res = tmp._data.compareTo(obj);
			if (res == 0)										// same value -> true
				return true;
			if (res > 0) {
				tmp = tmp._left;								// node-value is bigger -> traverse left
			} else {
				tmp = tmp._right;								// node-value is smaller -> traverse right
			}
		}
		return false;
	}

	public String toString() {
		if (root != null)
			return "preOrder: " + root.toString();
		else
			return "[]";
	}

	public static void main(String[] args) {
		Random r = new Random();
		SimpleTree<Integer> tree = new SimpleTree<Integer>();
		for (int i = 0; i <= 10; i++) {
			tree.insert(r.nextInt(10));
		}
		System.out.println(tree.toString());
		System.out.println("Contains 5: " + tree.search(5));
	}
}
