/*
Differenzieren: Summe und Produkt

Schreiben Sie die Klasse public class Differentiation mit der Methode

public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var),

die einen gegebenen ExpressionTree t nach der Variablen var ableiten kann und
als Ergebnis einen neuen ExpressionTree liefert. Realisieren Sie dabei nur die Summen-
und die Produktregel:

(x+y)' = x' + y', (x-y)' = x' - y' bzw. (x*y)' = x'*y + x*y'

Hinweis:
BinaryTree<AtomicExpression> t;
Test z.B. auf Operation "+" mit
if(t.getData().getType() == AtomicExpression.Type.OpPlus)

Beispiel:
Der arithmetische Ausdruck "x+x*y" ergibt den ExpressionTree

Die Differenzierung nach "y" ergibt daraus den ExpressionTree

Hinweise:
Alle benötigten Klassen finden Sie unter den "Folien und Materialien"
auf der Seite "Code/Beispiele".
Für den Backendtest sollten diese Klassen importiert werden.
*/

import aud.*;
import aud.example.expr.*;
import aud.example.expr.Number;
import aud.util.*;

public class Differentiation
{

   public static ExpressionTree differentiate(BinaryTree<AtomicExpression> t, String var)
   {
	  ExpressionTree tree = new ExpressionTree(t.getData());

	  if (t.getData().getType() == AtomicExpression.Type.OpPlus)
	  {
		  if(containsVar(t.getLeft(), var) == false)
			  tree.setLeft(	new BinaryTree<AtomicExpression>(new Number(0)));
		  else
			  tree.setLeft(differentiate (t.getLeft(), var));


		  if(containsVar(t.getRight(), var) == false)
			  tree.setRight(	new BinaryTree<AtomicExpression>(new Number(0)));
		  else
			  tree.setRight( differentiate (t.getRight(), var));

	  }

	  else if (t.getData().getType() == AtomicExpression.Type.OpTimes)
	  {
		  tree.setData(new Plus());
		  tree.setLeft(new BinaryTree<AtomicExpression>(new Times(), differentiate (t.getLeft(), var) ,t.getRight()));
		  tree.setRight(new BinaryTree<AtomicExpression>(new Times(), differentiate (t.getRight(), var) ,t.getLeft()));
	  }

	  else if (t.getData().getType() == AtomicExpression.Type.TSymbol)
	  {
		  if( t.getData().toString() == var)
		  {
			  t.setData(new Number(1.0));
		  }
		  else
			  t.setData(new Number(0.0));
	  }
	  return tree;


   }

   private static boolean containsVar(BinaryTree<AtomicExpression> t, String var)
   {

	   if(t.isLeaf())
	   {
		   if(t.getData().toString() == var) return true;
		   else return false;
	   }

	   else if(t.getData().toString() == var)
	   {
		   return true;
	   }

	   else
	   {
		   return  containsVar(t.getLeft(), var) | containsVar(t.getRight(), var);
	   }

   }

   public static void main(String[] args)
   {
	   //ExpressionParser parser = new ExpressionParser();
	   //ExpressionTree tree = parser.parse("x + (x * y)");
	   ExpressionTree tree  = new ExpressionTree(new Plus(),  new ExpressionTree(new Symbol ("x")), new ExpressionTree(new Times(), new ExpressionTree(new Symbol ("x")), new ExpressionTree(new Symbol ("y"))));

	   System.out.println ( "Tree: "+ tree ) ;
	   DotViewer.displayWindow(tree.toDot() , "Tree");
	   DotViewer.displayWindow(differentiate(tree, "y").toDot() , "Differentiated Tree");
   }
}
