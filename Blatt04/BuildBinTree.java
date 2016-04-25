/*
BinaryTree: Anwendung

Diese Aufgabe wird ***nicht*** automatisch getestet.

Schreiben Sie eine Klasse BuildBinTree, die den abgebildeten Baum mit Hilfe
der Klasse BinaryTree<T> aufbaut und in den Traversierungen

  preorder
  inorder
  postorder
  levelorder
  ausgibt.

Der Baum ist außerdem mit Hilfe von DotViewer zu visualisieren.

![Tree](binTree.jpg)

Hinweis:
Die Klasse BinaryTree<T> finden Sie unter den "Folien und Materialien" auf der Seite "Code/Beispiele".
*/

import aud.BinaryTree;
import aud.util.DotViewer;

public class BuildBinTree {

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>(-8);
		tree.setLeft(new BinaryTree<Integer>(4));
		BinaryTree<Integer> tmp = tree.getLeft();
		tmp.setLeft(new BinaryTree<Integer>(6));
		tmp.setRight(new BinaryTree<Integer>(-11));
		tree.setRight(new BinaryTree<Integer>(1));
		tmp = tree.getRight();
		tmp.setLeft(new BinaryTree<Integer>(5));
		tmp.setRight(new BinaryTree<Integer>(7));

		System.out.println("Preorder:");
		String out = "";
		for (BinaryTree<Integer> x: tree.preorder())
			out += x.getData() + " ";
		System.out.println(out);

		System.out.println("Postorder:");
		out = "";
		for (BinaryTree<Integer> x: tree.postorder())
			out += x.getData() + " ";
		System.out.println(out);

		System.out.println("Inorder:");
		out = "";
		for (BinaryTree<Integer> x: tree.inorder())
			out += x.getData() + " ";
		System.out.println(out);

		System.out.println("Levelorder:");
		out = "";
		for (BinaryTree<Integer> x: tree.levelorder())
			out += x.getData() + " ";
		System.out.println(out);

		DotViewer.displayWindow(tree, "Graph");
	}

}
