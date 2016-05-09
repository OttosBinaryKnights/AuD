/*
ExpressionParser: mit Potenzieren

Die Klasse Power steht Ihnen unter "Folien und Materialien" zur Verfügung.
Als Operator für das Potenzieren kann sowohl ** als auch ^ genutzt werden.
Die Klasse Tokenizer kann bereits diese beiden Operatoren für das Potenzieren verarbeiten.
Schreiben Sie die Klasse public class ExprWithPow extends ExpressionParser mit der Methode

  public ExpressionTree power(int level),

die für die Rechenoperation "Potenzieren" zuständig ist. Sie müssen sicherlich
auch bereits vorhandene Methoden von ExpressionParser geeignet überschreiben.
Testen Sie die korrekte Arbeitsweise Ihrer Klasse an geeigneten Beispielen.


Hinweise:
Alle benötigten Klassen finden Sie unter den "Folien und Materialien"
auf der Seite "Code/Beispiele".
Für den Backendtest sollten diese Klassen importiert werden.
*/

import aud.example.expr.*;
import aud.util.*;

public class ExprWithPow extends ExpressionParser {

	/*
	 * <expression> ::= <sum>
	 *
	 * <sum> ::= <product> | <product> "+" <sum> | <product> "-" <sum>
	 *
	 * <product> ::= <power> | <power> "*" <product> | <power> "/" <product>
	 *
	 *
	 *
	 * <factor> ::= <number> | <symbol> | "-" <factor> | "+" <factor> | "("
	 * <expression> ")"
	 */
	@Override
	public ExpressionTree product(int level) {

	    ExpressionTree left=power(level+1);

	    if (lookahead()==Tokenizer.TIMES) {
	      nextToken();
	      ExpressionTree right=product(level+1);
	      return new ExpressionTree(new Times(),left,right);
	    }
	    else if (lookahead()==Tokenizer.DIVIDE) {
	      nextToken();
	      ExpressionTree right=product(level+1);
	      return new ExpressionTree(new Divide(),left,right);
	    }

	    return left;

	}
/**
 * <power> ::= <factor> | <factor> "^" <power>
 * @param level
 * @return
 */
	public ExpressionTree power(int level) {

	    ExpressionTree left=factor(level+1);

	    if (lookahead()==Tokenizer.POWER) {
	      nextToken();
	      ExpressionTree right=power(level+1);
	      return new ExpressionTree(new Power(),left,right);
	    }
	    return left;
	}

	public static void main(String[] args) {
		ExprWithPow m = new ExprWithPow();
		System.out.println(m.parse("3**3+3^2").getValue());



	}
}
