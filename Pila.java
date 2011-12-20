/**
 * Classe che implementa un oggetto pila (o stack) per la gestione delle liste visive dello scontrino attuale. Ogni nuovo scontrino
 * e' visto come un nuovo oggetto Pila, che contiene l'ordine per lo scontrino stesso (ovvero, bibite e cibi ordinati)
 * Ogni volta che si preme un bottone, la pietanza relativa viene aggiunta nel vettore elementi. 
 * Se si preme il bottone Cancella, l'ultima ordinazione fatta (ovvero, l'elemento top della pila), viene rimossa.
 */

import java.util.*;

public class Pila {

	private Vector elementi;

	/**
	 * Metodo costruttore. Istanzia l'oggetto di tipo Vector.
	 */
	public Pila() {
		elementi = new Vector();
	}

	/**
	 * Metodo per l'inserimento di un nuovo oggetto nel vettore.
	 * 
	 * @param obj
	 *            riferimento all'oggetto da inserire.
	 */
	public void Push(Object obj) {
		elementi.addElement(obj);
		size();
	}

	/**
	 * Metodo per l'eliminazione dell'ultimo oggetto inserito.
	 */
	public Object pop() {
		int size = elementi.size();
		Object obj = null;

		if (size > 0) {
			obj = elementi.elementAt(size - 1);
			elementi.removeElementAt(size - 1);
			System.out.println("Elemento rimosso");

		} else
			System.out.println("Nessun elemento da rimuovere");

		return obj;
	}

	/**
	 * Metodo per ritrovare l'oggetto top della Pila, ovvero l'ultimo oggetto
	 * inserito.
	 * 
	 * @return riferimento all'ultimo oggetto inserito
	 */
	public Object top() {
		Object obj = null;
		int size = elementi.size();

		if (size > 0) {
			obj = elementi.elementAt(size - 1);
		}

		return obj;
	}

	/**
	 * Metodo per verificare se la pila contiene oggetti.
	 * 
	 * @return false se la Pila contiene almeno un oggetto, vero altrimenti.
	 */
	public boolean vuota() {
		if (elementi.size() > 0)
			return false;
		else
			return true;
	}

	/**
	 * Restituisce il numero di oggetti presenti nella Pila
	 * 
	 * @return numero (integer) di elementi presenti nella pila.
	 */
	public int size() {
		System.out.println("" + elementi.size());
		return elementi.size();
	}

	public Enumeration stampa() {

		Enumeration enumScontrino = elementi.elements();
		/*
		 * while ( enumScontrino.hasMoreElements() )
		 * System.out.println(enumScontrino.nextElement());
		 */

		return enumScontrino;
		/*
		 * Object[] copia = elementi.toArray(); System.out.print(copia[1]);
		 * 
		 * for ( int i = 0 ; i < elementi.size(); i++ )
		 * System.out.println("Dio cane" + copia[i]);
		 */
	}

}
