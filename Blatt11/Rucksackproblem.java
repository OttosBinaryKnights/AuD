/*
Rucksackproblem am Beispiel

Nehmen Sie an, Sie sollen die (möglichste viele der) folgenden
vier Objekte in einen Rucksack der Größe 15 packen. Dabei soll der
Wert der eingepackten möglichst groß sein.
Objekt	Größe	Wert
a1      3     3
a2      4     5
a3      6     8
a4      7     9

Packen Sie nun die Gegenstände mit dem Greedy-Prinzip nach einem von
Ihnen selbst gewählten Greedy-Kriterium. Ist diese Lösung optimal?

Erklären Sie das Prinzip der dynamischen Programmierung am obigen
Rucksackproblem. (Folgen Sie dazu dem Link und lesen Sie sich Erklärung und Algorithmus durch.)
*/

/*
a)
Beim Rucksackproblem hat man eine Reihe von Gegenständen mit Gewicht und Wert gegeben und muss für eine
gegebene obere Schranke des Gesamtgewichts die Zusammenstellung von Gegenständen finden, die den größten
Gesamtwert besitzt. Dieses Optimierungsproblem könnte man rechenaufwändig mit Bruteforce lösen, oder nach
dem Greedy-Prinzip vorgehen, bei dem man eine gute Lösung bekommt aber nicht zwangsläufig die beste.
Eine dritte Alternative wäre die dynamische Programmierung.
Man Kann das Rucksackproblem in Teilprobleme aufteilen, indem man den größtmöglichen Profit für jedes
Gesamtgewicht 1-c und jede Anzahl an Gegenständen 1-k bestimmt.
Es ergibt sich hier beispielsweise:

  p(0,g) = 0
  p(k,g) = {
  p(k-1,g)            falls(gk > g)
  max{p(k-1,g),
  p(k-1,g-gk)+wk} sonst }

Man löst das Problem also Rekursiv, wobei die Anzahl der Rekursionsaufrufe exponentiell steigt, was nicht sehr
effektiv ist. Die gleichen Teilprobleme werden häufig mehrfach gelöst.
Der Ansatz der Dynamischen Programmierung ist es, die Ergebnisse dieser Teilprobleme in eine Tabelle zu
speichern und die gespeicherten Ergebnisse zum generieren weiterer Ergebnisse zu nutzen. Diese Tabelle
wird bottom up aufgebaut und hat anschließend im untersten rechten Feld die Lösung des Problems.

Beispiel:

k\g|00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|15
---+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--+--
0  | 0| 0| 0| 0| 0| 0| 0| 0| 0| 0| 0| 0| 0| 0| 0| 0
1  | 0| 0| 0| 3| 3| 3| 3| 3| 3| 3| 3| 3| 3| 3| 3| 3
2  | 0| 0| 0| 3| 3| 3| 3| 8| 8| 8| 8| 8| 8| 8| 8| 8
3  | 0| 0| 0| 3| 3| 3| 3| 8| 8|11|13|13|13|16|16|16
4  | 0| 0| 0| 3| 3| 3| 3| 9| 9|11|13|14|14|17|17|17 -> 17 ist der maximale Gesamtwert mit den Gegenständen 3 und 4

b)
Greedy-Kriterium: Packe immer zuerst die kleinsten Gegenstände in den Rucksack -> erreiche maximale Anzahl an Gegenständen
->Gegenstände nach Größe sortiert: 1<2<3<4
->Beim 4. Gegenstand ist die Kapazität überschritten. Daher: 1+2+3
->Gesamtwert = 16
->Gesamtgewicht = 13
->keine optimale Lösung(17)

Greedy-Kriterium: Packe immer zuerst die wertvollsten Gegenstände in den Rucksack
->Gegenstände nach Wert sortiert: 4>3>2>1
->Beim 3. Gegenstand ist die Kapazität überschritten. Daher: 4+3
->Gesamtwert = 17
->Gesamtgewicht = 13
->optimale Lösung

Greedy-Kriterium: Packe zuerst die Gegenstände mit dem besten Verhältnis aus Gewicht und Wert
->Gegenstände nach Wert/Gewicht sortiert: 3>4>2>1
->Beim 3. Gegenstand ist die Kapazität überschritten. Daher: 4+3
->Gesamtwert = 17
->Gesamtgewicht = 13
->optimale Lösung
*/
