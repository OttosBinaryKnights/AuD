/*
Stack-Anwendung: Palindrom

Eine gegebene Zeichenkette (String) ist ein Palindrom, wenn sie vorwärts und rückwärts gelesen gleich ist.
Schreiben Sie eine Methode

  public static boolean isPalindrome(String str),

die bei einem übergebenen String str ermittelt, ob str ein Palindrom ist oder nicht.
Dabei sollen in str Leer-, Sonder- und Satzzeichen überlesen werden.
Außerdem soll die Unterscheidung von Groß- und Kleinbuchstaben entfallen.
Benutzen Sie bei der Lösung nicht die vordefinierte Methode reverse, sondern die Klasse Stack<T>

Als Testdaten können Sie folgende Palindrome benutzen:
  Reliefpfeiler	           Madam
  Lagerregal	             Marktkram
  Ein Esel lese nie.  	   Gurken hol ohne Krug!
  Na, Fakir, Paprika-Fan?	 O, Streit irritiert so!
  Eine Horde bedrohe nie!


Hinweise:
Hier finden Sie AbstractStack und Stack aus der Vorlesung. Wenn Sie die Klasse Stack<T> aus der Vorlesung nutzen möchten, importiert Sie diese mit
import aud.Stack;
Sie können aber auch die vordefinierte Klasse java.util.Stack<T> nutzen. Dann müssen Sie die Klasse Stack importieren mit
import java.util.Stack;
*/

import java.util.Stack;
import java.lang.Object;

public class Palindrome {
	   public static boolean isPalindrome(String text) {
	    Stack s1 = new Stack();
		Stack s2 = new Stack();
		int length=0;

		for(int i=0; i< text.length(); i++) {
			char t = text.charAt(i);

			if(Character.isLetter(t)) {
				if(Character.isUpperCase(t)) 	t=Character.toLowerCase(t);
				s1.push(Character.valueOf(t));
				length++;
				}
		}

		for(int i=0; i<length/2; i++)
			s2.push(s1.pop());

		if(length%2!=0) s1.pop();

		while(!s1.isEmpty())
			if(s1.pop()!=s2.pop())
				return false;

		return true;
	   }


	   public static void main(String[] args) {
	    System.out.println(isPalindrome("Reliefpfeiler"));
	    System.out.println(isPalindrome("Lagerregal"));
	    System.out.println(isPalindrome("Ein Esel lese nie."));
	    System.out.println(isPalindrome("Na, Fakir, Paprika-Fan?"));
	    System.out.println(isPalindrome("O, Streit irritiert so!"));
	    System.out.println(isPalindrome("Gurken hol ohne Krug!"));
	    System.out.println(isPalindrome("Marktkram"));
	    System.out.println(isPalindrome("Madam"));
	   }
	}
