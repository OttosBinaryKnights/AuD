/*
BTree: Beispiele, height

Wieviel Schlüssel können in einem B-Baum mit m = 2 und der Höhe 3 gespeichert werden?
Geben Sie die miminale und maximale Anzahl an.
Fügen Sie nacheinander in dieser Reihenfolge die Integer-Werte
7,19, 23, 4, 12, 17, 8, 11, 2 , 9 und 13 mit insert in einen
anfangs leeren BTree mit m=2 ein.
Visualisieren Sie den BTree in den einzelnen Etappen mit dem DotViewer.
Achtung: Visualisierung mit DotViewer beim Einreichen auskommentieren!
Schreiben Sie eine Methode

  public int height()

zur Ermittlung der Höhe des B-Baumes.
Testen Sie diese Methode, indem Sie eine Millionen zufällig generierte
Werte bei unterschiedlichen Seitengrößen in den B-Baum einfügen und die
jeweilige Höhe bestimmen (ohne Visualisierung mit DotViewer!).

Hinweis:
Jede Seite eines B-Baumes enthält i geordnete Schlüsselwerte, wobei es
einen Wert m gibt, so dass m<=i<=2m gilt. Der Verzweigungsgrad ist 2*m+1.
*/

/**
 *
 *
 *
 *a) maximal= 124 (31 Knoten mal 4)
 *	 minimal= 17
 *
 *
 */
import aud.BTree;
import aud.KTreeNode;
import aud.util.*;
public class BTreeTest2<T> extends BTree {

	public BTreeTest2(int m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SingleStepper s= new SingleStepper("1-2-Step");
		BTreeTest2<Integer> a=new BTreeTest2<Integer>(2);
		DotViewer look=DotViewer.displayWindow(a, "test");
	    a.insert(7);
	    s.halt();
	    look.display(a);
	    a.insert(19);
	    s.halt();look.display(a);
	    a.insert(23);
	    s.halt();look.display(a);
	    a.insert(4);
	    s.halt();look.display(a);
	    a.insert(12);
	    s.halt();look.display(a);
	    a.insert(17);
	    s.halt(); look.display(a);
	    a.insert(8);
	    s.halt(); look.display(a);
	    a.insert(11);
	    s.halt(); look.display(a);
	    a.insert(2);
	    s.halt();  look.display(a);
	    a.insert(9);
	    s.halt(); look.display(a);
	    a.insert(13);
	    look.display(a);
	    System.out.println(a.height());
	    for(int i=0;i<1000000;i++) {
	    	a.insert(i);
	    }
	    System.out.println(a.height());
	}

	public int height() {
		KTreeNode temp=this.root_;
		int height=0;
	    while(temp!=null) {
	    	height++;
	    	temp=temp.getChild(0);
	    }
		return height;
	}
}
