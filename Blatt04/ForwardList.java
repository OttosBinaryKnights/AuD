/*
ForwardList: Backward-Iterator

Schreiben Sie eine Klasse

  public class ForwardList<T> implements Iterable<T>,

die Daten als einfach verkettete Liste verwaltet und rückwärts über diese
iterieren kann, obwohl die Knoten keinen Rückwärtszeiger haben.

Sie können sich dabei an dem Konzept der Klasse SList orientieren.
Für den Backend-Test muss List eine Methode

  public void push_front(T obj)

enthalten.

Schreiben Sie zunächst eine rekursive Methode

  public void backTraverse(),

die die Daten der Liste rückwärts ausgibt (Ausgabe mit System.out.print(...)).
Schreiben Sie innerhalb der Klasse ForwardList die Klasse

  public class BackIterator implements java.util.Iterator,

mit den üblichen Funktionen wie hasNext() und next().
Dabei soll die Iteration rückwärts über die Elemente der Liste erfolgen
(unter Nutzung eines Stacks).

Schreiben Sie die Funktion

  public BackIterator iterator(),

in der eine Instanz Ihrer Klasse BackIterator zurück geliefert wird.

Testen Sie Ihren BackIterator in main mit der foreach-Schleife.

Beisiel:
l sei [1,2,3,4,5]
In der Schleife "for (int el : l){...}" werden dann die Elemente in der Reihenfolge 5,4,3,2,1 durchlaufen.
*/

public class ForwardList<T> implements Iterable<T>{
	class Node {
		T data_;
		Node next_ = null;

		public Node(T data, Node next) {
			data_ = data;
			next_ = next;
		}
		public void backTraverse() {
			if(next_ != null)
				next_.backTraverse();

			System.out.println(data_);
		}
	}

	Node head_ = null;

	public ForwardList() {
	}

	public void push_front(T obj) {
		Node temp = head_;
		head_ = new Node(obj, temp);
	}

	public void backTraverse(){
		head_.backTraverse();
	}

	public class BackIterator implements java.util.Iterator<T> {
		Stack<Node> nodeStack;

		public BackIterator(Node node) {
			nodeStack = new Stack<Node>();
			Node n = node;
			while(n != null)
			{
				nodeStack.push(n);
				n = n.next_;
			}
		}

		public boolean hasNext() {
			return !nodeStack.is_empty();
		}

		public T next() {
			return nodeStack.pop().data_;
		}

		public void remove() {
		}

	}

	public BackIterator iterator() {
		return new BackIterator(head_);
	}

	public static void main(String[] args) {
		ForwardList<Integer> l = new ForwardList<>();
		l.push_front(5);
		l.push_front(4);
		l.push_front(3);
		l.push_front(2);
		l.push_front(1);
		l.backTraverse();
		for(int el : l) {
			System.out.println(el);
		}
	}
}
