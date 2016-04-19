/*
DList erweitern

Aus der Vorlesung kennen Sie die doppelt verkettete Liste DList. Erweitern Sie diese Klasse um:
eine Instanzmethode

  public void append(MyDList li)

zum Verketten zweier Listen. Dabei soll die aufrufende Liste verändert werden, die Liste li aber nicht.
und um die Instanzmethode

  public void insert(int n, MyDList li)

zum Einbetten der Liste li in die aufrufende Liste ab Position n (nullbasiert).
Testen Sie beide Methoden an geeigneten Beispielen.

Hinweise:
Wird eine Liste an sich selbst angehängt, oder in sich selbst eingefügt, soll ihr Inhalt kopiert werden. Beispiel: li = [a, b]
li.append(li) == [a, b, a, b]
Analoges gilt für insert, Beispiel: list = [1,2,3,4] --> list.insert(2, list) == [1,2,1,2,3,4,3,4]
Die Klasse DList finden Sie unter Sie unter "Folien und Materialien" auf der Seite "Code/Beispiele"..
Die Klasse DList steht im Backend zur Verfügung und muss mit
  import aud.DList;
eingebunden werden.
*/

import aud.DList;

public class MyDList<T> extends DList<T> {

	public MyDList() {
		super();
	}

	@Override
	protected MyDList<T> clone() {
		MyDList<T> res = new MyDList<T>();
		for (int i = 0; i < this.size(); i++)
			res.push_back(this.at(i));
		return res;
	}

	public void append(MyDList<T> li) {
		MyDList<T> tmp = li.clone();
		for (int i = 0; i < tmp.size(); i++)
			this.push_back(tmp.at(i));
	}

	public void insert(int n, MyDList<T> li) {
		MyDList<T> tmp = li.clone();
		for (int i = 0; i < tmp.size(); i++)
			this.insert(n + i, tmp.at(i));
	}

	public static void main(String[] args) {
		MyDList<Integer> a = new MyDList<Integer>();
		MyDList<Integer> b = new MyDList<Integer>();
		for (int i = 0; i < 4; i++) {
			a.insert(i, i);
			b.insert(i, i);
		}
		System.out.println(a.toString());
		a.append(a);
		System.out.println(a.toString());
		System.out.println();
		System.out.println(b.toString());
		b.insert(2, b);
		System.out.println(b.toString());

	}
}
