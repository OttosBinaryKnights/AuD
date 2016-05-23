/*
2-3-4 Baum

Was ist ein 2-3-4 Baum?

Zeigen Sie anhand folgenden Beispiels, dass die Reihenfolge des Einfügens
von Werten für die Struktur des 2-3-4 Baumes entscheidend ist:

Fügen Sie in folgender Reihenfolge die Zahlen 2, 6, 4, 14, 16, 8, 12, 20, 10 und 18
in einen 2-3-4 Baum sowohl mit der bottom-up als auch mit der top-down-Methode ein.
Bauen Sie nun in der veränderten Reihenfolge 2, 4, 6, 8, 10, 12, 14, 16, 18 und 20
einen weiteren 2-3-4 Baum (wieder mit beiden Methoden) auf.

Kontrollieren Sie Ihre Schritte mit dem Dotviewer und SingleStepper.
*/

import aud.A234Tree;
import aud.util.DotViewer;
import aud.util.SingleStepper;

/*****************
answer a)
Ein 2-3-4-Baum ist  B-Baum des Verzweigungsgrades 2,
er ist ein Baum, in dem jeder Knoten 2, 3 oder 4 Kinder besitzt
und entsprechend 1, 2 oder 3 Schlüssel speichert, die aufsteigend sortiert sind.
Er ist ein balancierter Suchbaum.

answer b)
2, 6, 4, 14, 16, 8, 12, 20, 10, 18
buttom up:
	2  ->  2|6     ->    2|4|6     ->     4        ->      4
		                                   /  \             /  \
                                      2   6|14         2   6|14|16


       4|8       ->    4|8        ->        4|8|14      ->      4|8|14
      / | \           / | \               /  / \  \           / / \    \
     2  6  14|16     2  6  12|14|16      2  6  12  16|20    2  6  10|12 16|20

      4|8|14
   /  /  \    \
  2 6  10|12 16|18|20

top down:
	2  ->  2|6     ->    2|4|6     ->     4        ->      4
		                                   /  \             /  \
                                      2   6|14         2   6|14|16


       4|14       ->    4|14      ->        4|14      ->      4|8|14
     /  |  \          /  |   \            /  |   \           / / \    \
    2  6|8  16      2  6|8|12  16       2  6|8|12 16|20    2  6  10|12 16|20

         8
      /     \
     4        14
    / \     /    \
  2   6|8  10|12  16|18|20


2, 4, 6, 8, 10, 12, 14, 16, 18, 20

buttom up:
	2  ->  2|4     ->    2|4|6     ->     4        ->      4
		                                   /  \             /  \
                                     2    6|8         2    6|8|10


       4|8       ->    4|8        ->        4|8|12      ->      4|8|12
      / | \           / | \               /  / \  \           /  / \   \
     2  6  10|12     2  6  10|12|14      2  6  10  14|16     2  6   10  14|16|18

       8
      / \
     4   12|16
   /  \  /  |  \
  2   6  10 14  18|20

top down:
	2  ->  2|4     ->    2|4|6     ->     4        ->      4
		                                  /  \              /  \
                                     2    6|8         2    6|8|10


       4|8       ->    4|8        ->        4|8|12      ->      4|8|12
      / | \           / | \               /  / \  \           / / \    \
     2  6  10|12     2  6  10|12|14      2  6  10  14|16    2  6  10   14|16|18

       8
      / \
     4    12|16
   /  \  /  | \
  2   6  10 14 18|20

*********************/


public class A234Example {
   public static void main(String[] args) {
      // TODO: Test with DotViewer and SingleStepper
	   A234Tree<Integer> tree=new A234Tree<Integer>();
		SingleStepper s=new SingleStepper("aud.util.SingleStepper");
	    System.out.println(tree);
	    Integer[] keys={2,4,6,8,10,12,14,16,18,20};

	    for (Integer key : keys) {
	      tree.insert(key);
	      System.out.println(tree); s.halt();
	      tree.checkConsistency();
	      DotViewer.displayWindow(tree,"A234");
   }
  }
}
