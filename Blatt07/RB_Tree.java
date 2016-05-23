/*
Rot-Schwarz-Baum (RBTree) - Beispiele

Was ist ein Rot-Schwarz-Baum? Welche Eigenschaften hat er?

Führen Sie von Hand schrittweise den Algorithmus zum Aufbau eines
Rot-Schwarz-Baums mit nacheinander den Elementen der Liste [6,7,3,4,2,1] aus.
Geben Sie alle Zwischenschritte an. Wann entstehen Rot-Rot-Verstösse?

Welcher Baum entsteht? Kontrollieren Sie Ihre Schritte mit dem Dotviewer
und SingleStepper.

Führen Sie zum Vergleich den schrittweisen Aufbau eines AVL-Baums mit
nacheinander den Elementen der Liste [6,7,3,4,2,1] aus. Vergleichen Sie mit a).
2-3-4-Bäume können durch Rot-Schwarz-Bäume dargestellt werden.

Welche Korrespondenzen existieren zwischen ihnen?
*/

/*****************
 answer a) Eigenschaften
 Der Rot-Schwarz-Baum ist eine praktische Umsetzung des 2-3-4-Baumes.
 Hierbei handelt sich es um eine binäre Darstellung des 2-3-4-Baumes, mit roter und schwarzer Belegung der Kanten (praktisch: Knoten)
 Folgende Regeln müssen gelten:
 1.	Jeder Knoten ist entweder rot oder schwarz
 2. Jeder Blattknoten (Null-Knoten) ist per Definition schwarz
 3. Die Kinder jedes roten Knotens sind schwarz
 4. Für jeden Knoten k gilt: Jeder Pfad von k zu einem Blatt enthält die gleiche Anzahl schwarzer Knoten.

 answer b) - [6,7,3,4,2,1]
 ########## insert 6 ##########
 	(6B)
 ########## insert 7 ##########
 	  (6B)
       \
       (7R)
########## insert 3 ##########
	  (6B)
  	/  \
 (3R)  (7R)
 ########## insert 4 ##########
	(6B)
	/  \
 (3B)  (7B)		//3: RED -> BLACK	//7: RED -> BLACK
    \
    (4R)
########## insert 2 ##########
	  (6B)
	  /  \
   (3B)  (7B)
   /  \
(2R)  (4R)
########## insert 1 ##########
	    (6B)
	    /  \
     (3R)  (7B)	//3: BLACK -> RED
     /  \
  (2B)  (4B)	//2: RED -> BLACK	//4: RED -> BLACK
  /
(1R)
##############################

 answer c)
 (siehe Implementation unten)

 answer d)
 Der Rot-Schwarz-Baum ist eine praktische Umsetzung des 2-3-4-Baumes.
 Aus einem Knoten mit 3 Schlüsselwerten und 4 Unterkanten wird aus dem
 2-3-4-Baum im Rot-Schwarz-Baum ein roter Elternknoten mit 2 schwarzen Kindern.

 *********************/

import aud.RedBlackTree;
import aud.util.SingleStepper;
import aud.util.DotViewer;

public class RedBlackExample extends SingleStepper {

	protected RedBlackTree<?, ?> tree = null;
	protected DotViewer v = DotViewer.displayWindow((String) null, "aud.util.GraphDemo");

	public RedBlackExample(RedBlackTree<?, ?> tree) {
		super("aud.util.GraphDemo");
		this.tree = tree;
	}

	protected void onHalt() {
		if (tree != null)
			v.display(tree);
	}

	public static void main(String[] args) {
		RedBlackTree<Integer, Integer> tree = new RedBlackTree<Integer, Integer>();
		RedBlackExample app = new RedBlackExample(tree);
		tree.insert(6, 6);
		app.halt();
		tree.insert(7, 7);
		app.halt();
		tree.insert(3, 3);
		app.halt();
		tree.insert(4, 4);
		app.halt();
		tree.insert(2, 2);
		app.halt();
		tree.insert(1, 1);
		app.halt();
		app.halt("QUIT");

	}

}
