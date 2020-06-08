package com.rz;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Programma per la gestione della cassa in una festa. Dato un elenco di piatti,
 * suddivisi in bevande, pizzeria, cucina, viene generata una lista di tasti
 * indicanti le pietanze, con elenchi diversi per ogni tipologia. Viene inoltre
 * mostrato il totale parziale dello scontrino attuale. I tasti cancella
 * permettono di eliminare l'ultimo piatto inserito. Il tasto stampa visualizza
 * una finestra di dialogo con il riepilogo dello scontrino (prodotto,
 * quantita', prezzo unitario) e il totale da pagare. Alla pressione del tasto
 * conferma, lo scontrino andra' in stampa (non ancora implementata) la
 * pressione del tasto annulla permette di modificare lo scontrino.
 *
 * @author gioconno (p3mal88 [at] gmail [dot] com)
 * @version 1.1.0
 */

public class ApplicazioneCassa {

    private static String versione = "v1.1.0";

    public static void main(String[] args) {
        // definizione della finestra e del titolo da visualizzare
        Frame finestra = new Frame("Gestione cassa " + versione);

        // definizione degli oggetti com.rz.Pila per mantenere la lista visiva degli
        // ordini
        Pila scontrinoBibite = new Pila();
        Pila scontrinoPizza = new Pila();
        Pila scontrinoCucina = new Pila();

        Enumeration elenco = null;

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

        // definizione dei vari bottoni
        // bevande
        Button btnBirraBionda = new Button("Bionda");
        Button btnBirraRossa = new Button("Rossa");
        Button btnCocaCola = new Button("CocaCola");
        Button btnLattina = new Button("Lattina");
        Button btnAcqua = new Button("Acqua");
        Button btnCaffe = new Button("Caffe");
        Button btnCaffeCorretto = new Button("Caffe Corretto");
        Button btnAmaro = new Button("Amaro");
        Button btnBaileys = new Button("Baileys");
        Button btnVino = new Button("Vino");
        Button cancBibite = new Button("Cancella");

        // pizze
        Button btnMargherita = new Button("Margherita");
        Button btnAmericana = new Button("Americana");
        Button btnProsciutto = new Button("Prosciutto");
        Button btnProsciuttoFunghi = new Button("Prosciutto Funghi");
        Button btnSalamino = new Button("Salamino");
        Button btnCapricciosa = new Button("Capricciosa");
        Button btnSalsicciaCipolle = new Button("Salsiccia Cipolle");
        Button btnTonno = new Button("Tonno");
        Button cancPizza = new Button("Cancella");

        // cucina
        Button btnCasoncelli = new Button("Casoncelli");
        Button btnLasagne = new Button("Lasagne");
        Button btnPastaAmatriciana = new Button("Pasta Amatriciana");
        Button btnPastaAOP = new Button("Pasta AOP");
        Button btnCosciotto = new Button("Cosciotto");
        Button btnhamburger = new Button("Hamburger");
        Button btnAlette = new Button("Alette");
        Button btnCostine = new Button("Costine");
        Button btnSalamella = new Button("Salamella");
        Button btnGrigliata = new Button("Grigliata");
        Button btnPatatine = new Button("Patatine");
        Button btnDolce = new Button("Dolce");
        Button cancCucina = new Button("Cancella");

        Button btnStampa = new Button("Stampa");
        btnStampa.setBackground(Color.green);
        cancBibite.setBackground(Color.red);
        cancPizza.setBackground(Color.red);
        cancCucina.setBackground(Color.red);

        // definizione delle caselle di testo per visualizzare i diversi
        // scontrini (bibite, pizze e cucina)
        // ed il totale parziale. Aggiunta anche di etichette vuote per
        // formattare la disposizione degli elementi.
        TextArea listaBibita = new TextArea(5, 20);
        TextArea listaPizze = new TextArea(5, 20);
        TextArea listaCucina = new TextArea(5, 20);
        TextField totale = new TextField("0", 10);
        listaBibita.setEditable(false);
        listaPizze.setEditable(false);
        listaCucina.setEditable(false);
        totale.setEditable(false);
        Label totaleScontrino = new Label("Totale", Label.CENTER);
        Label lblVuoto1 = new Label();
        Label lblVuoto2 = new Label();
        Label lblVuoto3 = new Label();
        Label lblVuoto4 = new Label();
        Label lblVuoto5 = new Label();
        Label lblVuoto6 = new Label();
        Label lblVuoto7 = new Label();

        Label lblVuoto8 = new Label();

        // definizione del pannello
        Panel pannelloBevande = new Panel();
        Panel pannelloPizze = new Panel();
        Panel pannelloCucina = new Panel();
        Panel pannelloTotale = new Panel();
        Panel pannelloFinestra = new Panel();
        pannelloBevande.setLayout(new GridLayout(12, 1, 10, 10));
        pannelloPizze.setLayout(new GridLayout(12, 1, 10, 10));
        pannelloCucina.setLayout(new GridLayout(12, 1, 10, 10));
        pannelloTotale.setLayout(new GridLayout(12, 1, 10, 10));
        pannelloFinestra.setLayout(new GridLayout(1, 3));

        // definizione del layout dei pannelli
        // bevande
        pannelloBevande.add(listaBibita);
        pannelloBevande.add(cancBibite);
        pannelloBevande.add(btnBirraBionda);
        pannelloBevande.add(btnBirraRossa);
        pannelloBevande.add(btnCocaCola);
        pannelloBevande.add(btnLattina);
        pannelloBevande.add(btnAcqua);
        pannelloBevande.add(btnCaffe);
        pannelloBevande.add(btnCaffeCorretto);
        pannelloBevande.add(btnAmaro);
        pannelloBevande.add(btnBaileys);
        pannelloBevande.add(btnVino);

        // pizze
        pannelloPizze.add(listaPizze);
        pannelloPizze.add(cancPizza);
        pannelloPizze.add(btnMargherita);
        pannelloPizze.add(btnAmericana);
        pannelloPizze.add(btnProsciutto);
        pannelloPizze.add(btnProsciuttoFunghi);
        pannelloPizze.add(btnSalamino);
        pannelloPizze.add(btnCapricciosa);
        pannelloPizze.add(btnSalsicciaCipolle);
        pannelloPizze.add(btnTonno);
        pannelloPizze.add(lblVuoto1);
        pannelloPizze.add(lblVuoto2);

        // cucina
        pannelloCucina.add(listaCucina);
        pannelloCucina.add(cancCucina);
        pannelloCucina.add(btnCasoncelli);
        pannelloCucina.add(btnLasagne);
        pannelloCucina.add(btnPastaAmatriciana);
        pannelloCucina.add(btnPastaAOP);
        pannelloCucina.add(btnCosciotto);
        pannelloCucina.add(btnhamburger);
        pannelloCucina.add(btnAlette);
        pannelloCucina.add(btnCostine);
        pannelloCucina.add(btnSalamella);
        pannelloCucina.add(btnGrigliata);

        // totale
        pannelloTotale.add(totaleScontrino);
        pannelloTotale.add(totale);

        pannelloTotale.add(btnStampa);
        pannelloTotale.add(btnPatatine);
        pannelloTotale.add(btnDolce);
        pannelloTotale.add(lblVuoto3);
        pannelloTotale.add(lblVuoto4);
        pannelloTotale.add(lblVuoto5);
        pannelloTotale.add(lblVuoto6);
        pannelloTotale.add(lblVuoto7);
        pannelloTotale.add(lblVuoto1);

        // definizione del layout della finestra e aggiunta pannelli
        pannelloFinestra.add(pannelloBevande);
        pannelloFinestra.add(pannelloPizze);
        pannelloFinestra.add(pannelloCucina);
        pannelloFinestra.add(pannelloTotale);

        finestra.add(pannelloFinestra);

        // definizione degli ascoltatori: per ogni bottone viene referenziato la
        // casalla del parziale, la lista relativa al bottone
        btnBirraBionda.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnBirraRossa.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnCocaCola.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnLattina.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));

        btnAcqua.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnCaffe.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnCaffeCorretto.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnAmaro.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnBaileys.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        btnVino.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));
        cancBibite.addActionListener(new GestoreBottone(listaBibita,
                scontrinoBibite, elenco, elencoPiatti, totale));

        btnMargherita.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        btnAmericana.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        btnProsciutto.addActionListener((new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale)));
        btnProsciuttoFunghi.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        btnSalamino.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        btnCapricciosa.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        btnSalsicciaCipolle.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        btnTonno.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));
        cancPizza.addActionListener(new GestoreBottone(listaPizze,
                scontrinoPizza, elenco, elencoPiatti, totale));

        btnLasagne.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));

        btnPastaAOP.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));

        btnCostine.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnSalamella.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnGrigliata.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnPatatine.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnCasoncelli.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnPastaAmatriciana.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnCosciotto.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnhamburger.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnAlette.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        btnDolce.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));
        cancCucina.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));

        btnStampa.addActionListener(new GestoreBottone(listaCucina,
                scontrinoCucina, elenco, elencoPiatti, totale));

        // definizione dimensioni della finestra, settata come non espandibile
        finestra.setSize(1024, 768);
        finestra.setVisible(true);
        finestra.setResizable(true);
        finestra.addWindowListener(new GestoreFinestra());

    }

}
