/*
BinaryTree: maxWidth

Schreiben Sie die Klasse MyBinTree als Erweiterung der Klasse BinaryTree<T>.

Die Methode

  public int maxWidth(),

soll für den gegebenen binären (Teil-)Baum die größte Breite (d.h. die maximale Anzahl von Knoten in der gleichen Ebene) zurück geben.

Für folgenden Binärbaum ist z. B. drei die größte Breite.



Hinweise:
Die Klasse BinaryTree<T> finden Sie unter den "Folien und Materialien" auf der Seite "Code/Beispiele".
Die Klasse BinaryTree<T> steht im Backend zur Verfügung und sollte mit
import aud.BinaryTree;
eingebunden werden.
Die Klasse Queue steht im Backend zur Verfügung und sollte mit
import aud.Queue; eingebunden werden.
*/

import java.util.ArrayList;

public class MyBinTree<T> extends BinaryTree<T>
{
    public MyBinTree(T data)
    {
        super(data);
    }

    public MyBinTree(T data, BinaryTree<T> left, BinaryTree<T> right)
    {
        super(data, left, right);
    }

    // get level of 'this' (root level = 1)
    private int getLevel()
    {
        BinaryTree<T> node = this;
        int level = 1;
        while (!node.isRoot())
        {
            ++level;
            node = node.getParent();
        }
        return level;
    }

    public int maxWidth()
    {
        // store every level's width by using levelorder traverse
        int currentLevel = 1, currentWidth = 0;
        ArrayList<Integer> widthList = new ArrayList<Integer>();
        for (BinaryTree<T> current : levelorder())
        {
            int level = ((MyBinTree<T>)current).getLevel();
            if (level == currentLevel)
                ++currentWidth;
            else
            {
                ++currentLevel;     // advance to the next level
                widthList.add(currentWidth);
                currentWidth = 1;
            }
        }

        // find largest width
        int maxWidth = 0;
        for (int width : widthList)
        {
            if (width > maxWidth)
                maxWidth = width;
        }
        return maxWidth;
    }

    public static void main(String[] args)
    {
        MyBinTree<Integer> root = new MyBinTree<Integer>(-8);
        root.setLeft(new MyBinTree<Integer>(4));
        root.setRight(new MyBinTree<Integer>(1));
        root.getLeft().setLeft(new MyBinTree<Integer>(6));
        root.getLeft().setRight(new MyBinTree<Integer>(-11));
        root.getRight().setLeft(new MyBinTree<Integer>(5));
        root.getRight().setRight(new MyBinTree<Integer>(7));
        root.getLeft().getLeft().setLeft(new MyBinTree<Integer>(10));

        System.out.println("maxWidth: " + root.maxWidth()); // 4
    }
}
