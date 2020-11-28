package com.rz;

import java.math.BigDecimal;
import java.util.Vector;

public class PiattoBuilder {
    public static Vector buildElencoPiatti() {
        // definizione dei piatti: struttura del tipo [nome, prezzo, quantita' =
        // 0]

        // bevande
        Piatto birraBionda = new Piatto("Bionda", new BigDecimal(3));
        Piatto birraRossa = new Piatto("Rossa", new BigDecimal(4));
        Piatto cocaCola = new Piatto("CocaCola", new BigDecimal(2));
        Piatto lattina = new Piatto("Lattina", new BigDecimal(3));
        Piatto acqua = new Piatto("Acqua", new BigDecimal(1));
        Piatto caffe = new Piatto("Caffe", new BigDecimal(1));
        Piatto caffeCorretto = new Piatto("Caffe Corretto", new BigDecimal(1.2));
        Piatto amaro = new Piatto("Amaro", new BigDecimal(2.5));
        Piatto baileys = new Piatto("Baileys", new BigDecimal(3));
        Piatto vino = new Piatto("Vino", new BigDecimal(1));

        // pizze
        Piatto margherita = new Piatto("Margherita", new BigDecimal(5));
        Piatto americana = new Piatto("Americana", new BigDecimal(6));
        Piatto prosciutto = new Piatto("Prosciutto", new BigDecimal(5));
        Piatto capricciosa = new Piatto("Capricciosa", new BigDecimal(6));
        Piatto salamino = new Piatto("Salamino", new BigDecimal(6));
        Piatto salsicciaCipolle = new Piatto("Salsiccia Cipolle", new BigDecimal(6));
        Piatto prosciuttoFunghi = new Piatto("Prosciutto Funghi", new BigDecimal(6));
        Piatto tonno = new Piatto("Tonno", new BigDecimal(6));

        // cucina
        Piatto casoncelli = new Piatto("Casoncelli", new BigDecimal(4.5));
        Piatto lasagne = new Piatto("Lasagne", new BigDecimal(4.5));
        Piatto pastaAmatriciana = new Piatto("Pasta Amatriciana", new BigDecimal(3.5));
        Piatto pastaAOP = new Piatto("Pasta AOP", new BigDecimal(3));
        Piatto costine = new Piatto("Costine", new BigDecimal(4.5));
        Piatto salamella = new Piatto("Salamella", new BigDecimal(2.5));
        Piatto grigliata = new Piatto("Grigliata", new BigDecimal(7.5));
        Piatto cosciotto = new Piatto("Cosciotto", new BigDecimal(5));
        Piatto hamburger = new Piatto("Hamburger", new BigDecimal(3));
        Piatto patatine = new Piatto("Patatine", new BigDecimal(2));
        Piatto alette = new Piatto("Alette", new BigDecimal(3));
        Piatto dolce = new Piatto("Dolce", new BigDecimal(2.5));

        // vettore contentente le ordinazione dello scontrino attuale
        Vector elencoPiatti = new Vector();

        // aggiunta dei piatti allo scontrino: tutti i piatti inizialmente hanno
        // quantita' = 0
        elencoPiatti.addElement(birraBionda);
        elencoPiatti.addElement(birraRossa);
        elencoPiatti.addElement(cocaCola);
        elencoPiatti.addElement(lattina);
        elencoPiatti.addElement(acqua);
        elencoPiatti.addElement(caffe);
        elencoPiatti.addElement(caffeCorretto);
        elencoPiatti.addElement(amaro);
        elencoPiatti.addElement(baileys);
        elencoPiatti.addElement(vino);
        elencoPiatti.addElement(margherita);
        elencoPiatti.addElement(americana);
        elencoPiatti.addElement(prosciutto);
        elencoPiatti.addElement(capricciosa);
        elencoPiatti.addElement(salamino);
        elencoPiatti.addElement(salsicciaCipolle);
        elencoPiatti.addElement(prosciuttoFunghi);
        elencoPiatti.addElement(tonno);
        elencoPiatti.addElement(casoncelli);
        elencoPiatti.addElement(lasagne);
        elencoPiatti.addElement(pastaAmatriciana);
        elencoPiatti.addElement(pastaAOP);
        elencoPiatti.addElement(costine);
        elencoPiatti.addElement(salamella);
        elencoPiatti.addElement(grigliata);
        elencoPiatti.addElement(cosciotto);
        elencoPiatti.addElement(hamburger);
        elencoPiatti.addElement(patatine);
        elencoPiatti.addElement(alette);
        elencoPiatti.addElement(dolce);

        return elencoPiatti;
    }
}
