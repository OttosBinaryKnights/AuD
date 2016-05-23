/*
AVL-Tree

Erklären Sie den Begriff AVL-Baum. Weshalb ist es erforderlich, binäre Bäume auszugleichen?

Erläutern Sie den Algorithmus für das Einfügen von Knoten in einen AVL-Baum am Beispiel des
Einfügens der natürlichen Zahlen 14, 15, 17, 7, 5, 10 und 16 in dieser Reihenfolge.
Skizzieren Sie den AVL-Baum nach jedem Einfügen eines Elementes und kontrollieren
Sie Ihre Schritte mit dem Dotviewer und SingleStepper.
*/

import aud.AVLTree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

/*****************
answer a)
Ein AVL Baum ist ein spezieller binärer Baum, der maximal einen Höhenunterschied von 1 für jeden Teilbaum (Knoten) hat.
Dadurch entsteht ein ausbalancierter Baum.

Das ausgleichen ist nötig, da ein Baum sonst degenerieren kann und im schlechtesten Fall zu einer Liste wird.
Dadurch verliert ein Suchbaum seinen Aufwandsvorteil von O(log n).

answer b)
Einfügen von: 14, 15, 17, 7, 5, 10, 16:

_______________
14 Einfügen:

	    14
______________
15 Einfügen:

		14
   		\
		   15
______________
17 Einfügen:

		14
	    \
		   15
	 	     \
		      17

AVL - Eigenschaft verletzt! -> einfach Rotation

      15
	   /  \
	  14   17
_________________
17 Einfügen:

      15
	   /  \
	  14   17
	  /
	 7
_________________
5 Einfügen:

      15
	   /  \
	  14   17
	  /
	7
 /
5

AVL - Eigenschaft verletzt! -> einfach Rotation

 	    15
	   /  \
	  7   17
	 /  \
	5   14
____________________________
10 Einfügen:

 	    15
	   /  \
	  7   17
	 / \
	5   14
  /
10

AVL - Eigenschaft verletzt! -> Doppelrotation

      15
	   /  \
	  14   17
	 /  \
	7   10
      /
    5

    	14
	   /  \
	  7   15
  / \	    \
 5   10   17

____________________________
16 Einfügen:

    	 14
	    /  \
	  7     15
	 / \    / \
	5  10 16  17

Fertig -> ausbalanciert, sogar voll und vollständig.
*********************/
public class AVLExample {

   public static void main(String[] args) {

	   	AVLTree<Integer, String> test = new AVLTree<Integer, String>();
	  	SingleStepper stepper = new SingleStepper("hi");
	  	DotViewer v = DotViewer.displayWindow(test, "Dot Viewer");

		 stepper.halt();
		 test.insert(14, "a");
		 v.display(test);

		 stepper.halt();
		 test.insert(15, "b");
		 v.display(test);

		 stepper.halt();
		 test.insert(17, "c");
		 v.display(test);

		 stepper.halt();
		 test.insert(7, "d");
		 v.display(test);

		 stepper.halt();
		 test.insert(5, "e");
		 v.display(test);

		 stepper.halt();
		 test.insert(10, "f");
		 v.display(test);

		 stepper.halt();
		 test.insert(16, "g");
		 v.display(test);

   }
}
