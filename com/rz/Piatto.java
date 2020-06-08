package com.rz;

import java.math.BigDecimal;

/**
 * Classe che modifica una com.rz.Pila standard, per memorizzare i piatti ordinati.
 *
 * @author gioconno (p3mal88 [at] gmail [dot] com)
 * @version 1.0.0
 */
public class Piatto {
    private String nome;
    private BigDecimal prezzo;
    private int quantita = 0;

    public Piatto(String nome, BigDecimal prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }


    public String getName() {
        return this.nome;
    }

    public BigDecimal getPrice() {
        return this.prezzo;
    }

    public int getQuantita() {
        return this.quantita;
    }


    public void incrementQuantitaByOne() {
        this.quantita++;
    }

    public void decrementQuantitaByOne() {
        if (this.quantita > 0)
            this.quantita--;
    }

    public void resetQuantita() {
        this.quantita = 0;
    }

}
