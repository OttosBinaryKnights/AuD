/*
BinaryTree: Maximale Teilbäume, maximale Wege und Höhe

Gegeben sei ein (ungeordneter) binärer Baum, dessen Knoten zufällig positive
und negative ganze Zahlen als Werte enthalten. Die Summe der Werte eines
Baumes ist die Summe aller seiner Knotenwerte.

Der Wert eines Pfades (das ist der Weg von der Wurzel des Baumes bis zu einem Blatt)
ist die Summe aller Knotenwerte, die auf diesem Pfad liegen. Da auch negative
Werte erlaubt sind, können größere Teilbäume oder längere Pfade durchaus
kleinere Werte haben als ihre Teilbäume/-pfade.


Schreiben Sie die drei Java-Methoden:
  public int height()
für die Berechnung der Höhe des (Teil-)Baumes.
  public int maxSum()
für die Ermittlung der Summe des maximalen Teilbaums. Zunächst ist die Summe des linken und rechten Teilbaumes (von this aus) zu berechnen. Zurückgeliefert werden soll die maximale Summe der beiden Teilbäume. Im Beispiel ist maxSum = max(4+6-11+10, 1+5+7) = 13, wenn man den Baum ab Knoten -8 (ausschließlich) betrachtet. Die Summe der Werte eines leeren Teilbaumes sei 0.
  public int maxPath()
für das Finden des maximalen Pfadwertes von der Wurzel bis zu einem Blatt (im Beispiel ist von Knoten -8 aus betrachtet maxPath 12).


Hinweise:
Die Klasse BinaryTree<T> finden Sie unter den "Folien und Materialien" auf der Seite "Code/Beispiele".
Die Klasse BinaryTree<T> steht im Backend zur Verfügung und sollte mit
import aud.BinaryTree;
eingebunden werden.
*/


public class IntBinTree extends BinaryTree<Integer> {

	public IntBinTree(int data) {
		super(data);
	}

	public IntBinTree(int data, IntBinTree left, IntBinTree right) {
		super(data, left, right);
	}

	public IntBinTree getLeft() {
		return (IntBinTree) super.getLeft();
	}

	public IntBinTree getRight() {
		return (IntBinTree) super.getRight();
	}

	public int height() {
		if (isLeaf()) return 1;
		int heightLeft=0,heightRight=0;
		if (!(getLeft()==null)) heightLeft = getLeft().height();
		if (!(getRight()==null)) heightRight = getRight().height();
		if (heightLeft>heightRight) return heightLeft+1;
		return heightRight+1;
	}

	public int maxSum() {
		return getLeft().sum() > getRight().sum() ? getLeft().sum() : getRight().sum();
	}

	public int sum() {
		if (isLeaf()) return getData();
		int sumLeft=0,sumRight=0;
		if (!(getLeft()==null)) sumLeft = getLeft().sum();
		if (!(getRight()==null)) sumRight = getRight().sum();
		return getData()+sumLeft+sumRight;
	}

	public int maxPath() {
		if (isLeaf()) return getData();
		int pathLeft=0,pathRight=0;
		if (!(getLeft()==null)) pathLeft = getLeft().maxPath();
		if (!(getRight()==null)) pathRight = getRight().maxPath();
		return pathLeft > pathRight ? pathLeft+getData() : pathRight+getData();
	}

	public static void main(String[] args) {
		IntBinTree tree = new IntBinTree(-8);
		tree.setLeft(new IntBinTree(4));
		tree.getLeft().setLeft(new IntBinTree(6));
		tree.getLeft().setRight(new IntBinTree(-11));
		tree.setRight(new IntBinTree(1));
		tree.getRight().setLeft(new IntBinTree(5));
		tree.getRight().setRight(new IntBinTree(7));
		tree.getLeft().getLeft().setLeft(new IntBinTree(10));
		System.out.println(tree.height());
		System.out.println(tree.maxSum());
		System.out.println(tree.maxPath());
	}
}

/*
 * Antwort Teil a.)
 *
 * 	Wert linker Teilbaum: 9
 * 	Wert rechter Teilbaum: 13
 * 	Pfad zu 10: 12
 * 	Pfad zu -11: -15
 * 	Pfad zu 5: -2
 * 	Pfad zu 7: 0
 */
