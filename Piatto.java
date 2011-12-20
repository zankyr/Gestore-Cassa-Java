/**
 * 
 * Classe che modifica una Pila standard, per memorizzare i piatti ordinati.
 * 
 * @author gioconno (p3mal88 [at] gmail [dot] com)
 *  @version 1.0.0
 *
 */
 public class Piatto {
	private String nome;
	private float prezzo;
	private int quantita = 0;

	/**
	 * Costruttore.
	 * @param n Nome da assegnare al piatto
	 * @param f Prezzo da assegnare al piatto
	 */
	public Piatto(String n, float f) {
		this.nome = n;
		this.prezzo = f;
	}

	/**
	 * Restituisce il nome del piatto.
	 * @return nome del piatto attuale (string)
	 */
	public String getName() {
		return this.nome;
	}

	/**
	 * Restituisce il prezzo del piatto.
	 * @return prezzo del piatto (float)
	 */
	public float getPrice() {
		return this.prezzo;
	}

	/**
	 * Ritorna il numero delle ordinazioni per il piatto.
	 * @return quantita' ordinazioni(integer)
	 */
	public int getQuantita() {
		return this.quantita;
	}

	/**
	 * Aumenta la quantita' di un'unita'.
	 */
	public void setQuantitaPlus() {
		this.quantita++;
	}

	/**
	 * Diminuisce la quantita' di un'unita'.
	 */
	public void setQuantitaMinus() {
		if (this.quantita > 0)
			this.quantita--;
	}

	/**
	 * Azzera la quantita' del piatto.
	 */
	public void resetQuantita() {
		this.quantita = 0;
	}

}
