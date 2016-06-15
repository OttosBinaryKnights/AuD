/*
Breiten- und Tiefensuche am Beispiel

a) Geben Sie an, in welcher Reihenfolge Sie bei einer Breitensuche den obigen
Graphen die einzelnen Knoten (mit den dazugehörigen Distanzen) erreichen,
wenn Sie im Knoten 8 starten. Wenn mehrere Knoten als nächstes besucht werden
können, wählen Sie jeweils den mit dem wertmäßig kleinsten Wert.

b) Beschreiben Sie dabei kurz den zugrunde liegende Algorithmus.
Beschreiben Sie den Algorithmus zur Tiefensuche am obigen Beispiel.
Welche Reihenfolge ergibt sich bei einer Tiefensuche, wenn Sie im Knoten 8 starten?

c) Erzeugen und visualisieren Sie für den den obigen Graphen die Breiten- und Tiefensuche
mit Hilfe der Klassen MyGraph, BreadthFirstSearch, DepthFirstSearch, ...
(siehe Code/Beispiele unter Folien und Materialien).
*/

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import aud.example.graph.BreadthFirstSearch;
import aud.example.graph.DepthFirstSearch;
import aud.example.graph.MyGraph;
import aud.example.graph.MyNode;
import aud.example.graph.Traversal;
import aud.util.DotViewer;
import aud.util.SimpleDecorator;
import aud.util.SingleStepper;

/*
 * Breitensuche: 8,2,3,5,1,4,6,7
 *    Es werden zuerst alle direkt benachbarten Knoten durchgegangen, dann vom kleinsten
 *    jeweils seine benachbarten Knoten, danach vom n‰chstgrˆﬂeren usw. udn danach von disen
 *    erenut.
 *
 * Tiefensuche:  8,2,1,3,6,4,5,7
 *    Statt alle benachbarten Knoten durchzugehen, wird hier immer der erste benachbarte und
 *    darauf folgend dessen erster benachbarter Knoten usw. besucht, wenn es nicht mehr
 *    weitergeht wird backtracing verwendet.
 *
 */

class SingleStepperWithDotViewer extends SingleStepper {

	protected DotViewer viewer_ = DotViewer.displayWindow((String) null, "Graph");

	public MyGraph graph = null;

	public SingleStepperWithDotViewer() {
		super("Graph");
	}


	@Override
	protected void onHalt() {
		if (graph != null)
			viewer_.display(graph);
	}

}

public class GraphSearch {

	public static void main(String[] args) {
		MyGraph g = new MyGraph(false);
		MyNode[] n = { new MyNode(), g.addNode(), g.addNode(), g.addNode(),
				g.addNode(), g.addNode(), g.addNode(), g.addNode(), g.addNode() };

		for (int i = 0; i < n.length; ++i)
			n[i].setLabel("" + i);

		// Beispiel-Matrix
		g.addEdge(n[5], n[4]);
		g.addEdge(n[5], n[7]);
		g.addEdge(n[4], n[6]);
		g.addEdge(n[7], n[1]);
		g.addEdge(n[6], n[1]);
		g.addEdge(n[5], n[8]);
		g.addEdge(n[1], n[2]);
		g.addEdge(n[1], n[3]);
		g.addEdge(n[2], n[8]);
		g.addEdge(n[3], n[8]);
		g.addEdge(n[5], n[6]);

		// Auswahl des Verfahrens
		JFrame dlg = new JFrame();
		String[] options = new String[2];
		options[0] = new String("Breadth-Search");
		options[1] = new String("Depth-Search");
		int res = JOptionPane.showOptionDialog(dlg.getContentPane(),
				"Select the desired algorithm:", "Graph Search", 0,
				JOptionPane.QUESTION_MESSAGE, null, options, null);

		Traversal algorithm = null;
		if (res == 0)
			algorithm = new BreadthFirstSearch(g);
		else if (res == 1)
			algorithm = new DepthFirstSearch(g);
		if (algorithm == null)
			return;
		JFrame frame = new JFrame("Graph");
		frame.setSize(600, 400);

		SingleStepperWithDotViewer stepper = new SingleStepperWithDotViewer();
		stepper.graph = g;

		algorithm.singlestepper = stepper;
		algorithm.verbose = 0;

		// Startknoten 8
		stepper.halt(algorithm.name() + " from 8");
		algorithm.start(n[8]);

		((SimpleDecorator) g.getDecorator()).highlightNode(null);
		((SimpleDecorator) g.getDecorator()).highlightEdge(null);

		stepper.halt("DONE");

		System.out.println(g);

		System.exit(0);
	}
}
