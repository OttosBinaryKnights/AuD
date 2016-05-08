/*
ExpressionParser, ExpressionTree: Einführung

Diese Aufgabe wird ***nicht*** automatisch getestet.
Machen Sie sich mit dem ExpressionParser und ExpressionTree vertraut,
indem Sie verschiedene arithmetische Ausdrücke (mit den 4 Grundrechenarten) testen:
Geben Sie die Ausdrücke in den verschiedenen Ordnungen (inorder-, postorder und preorder) aus.
Berechnen Sie die Werte der Ausdrücke.
Visualisieren Sie die Ausdrücke mit dem DotViewer.
*/

import aud.example.expr.*;
import aud.util.DotViewer;

public class ExampleExpression {
	   public static void main(String[] args) {
		   String exp = "(1.12+2.32)*(6-3)+5.5";

	       ExpressionParser p = new ExpressionParser();
	       p.setVerbose(true);
	       ExpressionTree t = p.parse(exp);

	       System.out.println("Output: " + t + "\n");
	       System.out.println("Postorder: " + t.postorder().toString() + "\n");
	       System.out.println("Inorder: " + t.inorder().toString() + "\n");
	       System.out.println("Preorder: " + t.preorder().toString() + "\n");

	       System.out.println("Ergebnis: " + t.getValue());

	       DotViewer dot = DotViewer.displayWindow(t, "");
	   }
	}
