/*
Verkettete Knoten

Diese Aufgabe wird ***nicht*** automatisch getestet.
Schreiben Sie eine Klasse LinkedNode zur Erzeugung von einfach verketteten Knoten in der abgebildeten Form.
Die Klasse soll die Atribute

  public class LinkedNode<T> {
    T data_;
    LinkedNode<T> next_;
    ...
  }

enthalten. Schreiben Sie entsprechende Konstruktoren und die Getter-und Setter-Methoden.
Schreiben Sie eine Methode

  public String toText(),

die die Knoteninhalte von this bis zum Ende (null) der verketteten Knoten ausgibt.
Erzeugen Sie in main die unten abgebildeten verketteten Knoten. Geben Sie diese
Liste zur Kontrolle mit Hilfe der Funktion toText() aus.
Fügen Sie anschließend (in main) an den geeigneten Stellen die Knoten "Mensa gehen",
"Vorlesung besuchen" und andere Knoten Ihrer Wahl ein und geben Sie auch diese Liste aus.
Wer sich mit dem "Tagesablauf" nicht anfreunden kann oder möchte, nimmt als
Ausgangsliste die Wochentage Montag, Donnerstag und Freitag. Anschließend ist der
Knoten Dienstag und danach der Knoten Mittwoch in der richtigen kalendarischen
Ordnung einzufügen. Geben Sie zur Kontrolle jeweils die gesamte Liste aus.
*/

public class LinkedNode<T> {
	T data_ = null;
	LinkedNode<T> next_ = null;

	public LinkedNode(T data_, LinkedNode<T> next_) { 	//Constructor
		this.data_ = data_;
		this.next_ = next_;
	}

	public T getData_() { 					//Getter
		return data_;
	}

	public void setData_(T data_) { 			//Setter
		this.data_ = data_;
	}

	public LinkedNode<T> getNext_() {
		return next_;
	}

	public void setNext_(LinkedNode<T> next_) {
		this.next_ = next_;
	}

	String toText() {
		String ausgabestring = "";
		while (this.next_ != null) {
			ausgabestring += this.getNext_().getData_() + "\n";
			this.setData_(this.next_.getData_());
			this.setNext_(this.next_.getNext_());
		}
		return ausgabestring;
	}

	public static void main(String[] args) {
		LinkedNode<String> linker3 = new LinkedNode<String>("LaundryNight", null);
		LinkedNode<String> linker2 = new LinkedNode<String>("Soupantation", linker3);
		LinkedNode<String> linker1 = new LinkedNode<String>("Oatmeal", linker2);
		LinkedNode<String> linker0 = new LinkedNode<String>(null, linker1);

		//System.out.println(linker0.toText());

		LinkedNode<String> linker5 = new LinkedNode<String>("ComicBookNight", linker2);
		LinkedNode<String> linker4 = new LinkedNode<String>("Cheesecake", linker5);

		linker1.setNext_(linker4);

		//System.out.println(linker0.toText());
	}
}
