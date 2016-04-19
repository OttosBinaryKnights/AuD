/*
Doppelt verketteter Ring

Vervollständigen Sie die Klasse MyCircle (siehe Antwortvorlage).
Es soll ein doppelt verketteter Ring analog der doppelt verketteten Liste DList erstellt werden.

Ähnlich wie bei einer Kette gibt es einen Verschluss head_.
Hier kann man vor oder nach head_ die Kette erweitern bzw. abbauen.
Die Eigenschaft eines Rings - head_ zeigt auf das erste Element der Kette
und das letzte Element der Kette zeigt auf head_ - ist jeweils abzusichern.

Schreiben Sie die Methoden

  public int size()

zur Bestimmung der Anzahl Elemente in der Kette,

  public void push_back(T obj),

die ein Element am "Ende" der Kette (also vor head_)einfügt (und die Kette wieder verschließt)
und

  public void pop_front(),

die ein Kettenglied aus dem "Anfang" der Kette entfernt.

 public class MyCircle {
   class Node {
	T data_ = null;
	Node next_ = null;
	Node prev_ = null;

	Node(T obj, Node prv, Node nxt) {
		data_ = obj;
		prev_ = prv;
		next_ = nxt;
	}
   }
   protected Node head_ = null;
   public MyCircle() {
      // do not change
      head_ = null;
   }
   public T front() {
      return head_.data_;
   }
   public String toString() {
      // do not change (because of backend-control)
      if (empty())
	return "[]";
      String rv = "[";
      Node node = head_;
      do{
	rv += node.data_.toString();
	if (node.next_ != head_)
	   rv += ",";
	node = node.next_;
      }while(node != head_);
      rv += "]";
      return rv;
   }
   public int size() {
      // TODO: Implementation
   }
   public boolean empty() {
      // TODO: Implementation
   }

   public void push_back(T obj) {
      // TODO: Implementation
   }
   public void pop_front() {
      // TODO: Implementation
   }

   public static void main(String[] args) {
      // TODO: test
   }
}
*/

public class MyCircle<T> {
	class Node {
		T data_ = null;
		Node next_ = null;
		Node prev_ = null;

		Node(T obj, Node prv, Node nxt) {
			data_ = obj;
			prev_ = prv;
			next_ = nxt;
		}

		public void setPrev(Node n) {
			this.prev_ = n;
		}

		public void setNext(Node n) {
			this.next_ = n;
		}

		public String toString() {
			return "[ " + this.data_ + " ]";
		}
	}

	protected Node head_ = null;

	// dont change:
	public MyCircle() {
		head_ = null;
	}

	public T front() {
		return head_.data_;
	}

	// dont change:

	public String toString() {
		// do not change (because of backend-control)
		if (empty())
			return "[]";
		String rv = "[";
		Node node = head_;
		do {
			rv += node.data_.toString();
			if (node.next_ != head_)
				rv += ",";
			node = node.next_;
		} while (node != head_);
		rv += "]";
		return rv;
	}

	public int size() {

		if (empty()) {
			return 0;
		} else {
			Node tmp = head_;
			int i = 1;

			while (!tmp.next_.equals(head_)) {
				tmp = tmp.next_;
				i++;
			}

			return i;
		}

	}

	public boolean empty() {
		if (head_ == null || head_.data_ == null)
			return true;
		return false;

	}

	public void push_back(T obj) {
		if (head_ == null) {
			head_ = new Node(obj, null, null);
			head_.setNext(head_);
			head_.setPrev(head_);
		} else {
			Node tmp = head_.prev_;
			Node create = new Node(obj, null, null);
			tmp.setNext(create);
			head_.setPrev(create);
			create.setNext(head_);
			create.setPrev(tmp);

		}
	}

	public void pop_front() {

		if (size() == 1) {
			head_ = null;
		} else {
			Node prev = head_.prev_;

			head_ = head_.next_;
			head_.setPrev(prev);
			prev.setNext(head_);
		}
	}

	public static void main(String[] args) {
		MyCircle<Integer> a = new MyCircle<Integer>();
		a.push_back(1);

		System.out.println(a.size());
		System.out.println(a);



	}
}
