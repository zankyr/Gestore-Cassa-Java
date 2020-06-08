package com.rz; /**
 * classe per la gestione dei vari bottoni.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Vector;

class GestoreBottone implements ActionListener {

    private TextArea a;
    private final static String newline = "\n";
    private Pila scontrino;
    private Enumeration lista;
    private Vector v;
    private Piatto piatto;
    private TextField totale;
    private BigDecimal parziale = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    private FileWriter file = null;
    private PrintWriter fOUT = null;
    private GregorianCalendar calendar = new GregorianCalendar();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
    private JFrame frame;
    int answer;
    String message = "\n";
    boolean erase = false;

    public GestoreBottone(TextArea a, Pila p, Enumeration e, Vector vec,
                          TextField t) {
        this.a = a;
        this.scontrino = p;
        this.lista = e;
        this.v = vec;
        this.totale = t;
        // parziale= Integer.valueOf(totale.getText()).intValue();

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // identifico bottone premuto, in base al testo del bottone stesso
        String bottone = arg0.getActionCommand();

        // definizione delle diverse azioni in base al tasto premuto
        if (bottone.equals("Cancella")) {

            if (erase) {
                a.setText("");
                erase = false;

            } else {
                // tasto cancella: l'identificazione del tasto (cancBibite,
                // cancPizze o cancCucina) e' fatta nell'implementazione
                // dell'ascoltatore, ovvero, cambiano gli oggetti com.rz.Pila su cui
                // agire

                // elimino ultimo oggetto inserito, e ne memorizzo il nome.
                String prova = (String) scontrino.pop();

                // ciclo sul vettore di piatti, cercando la posizione del piatto
                // eliminato, a cui decremento la quantita' di 1 (i controlli
                // sulla
                // quantita' >= 0 sono fatti nella classe relativa)
                for (int i = 0; i < v.size(); i++) {
                    if (((Piatto) (v.elementAt(i))).getName().equalsIgnoreCase(
                            prova)) {
                        piatto = (Piatto) v.elementAt(i);
                        piatto.decrementQuantitaByOne();

                    }
                }

                // azzero parziale (valore del conto parziale che viene
                // visualizzato) per poi ricalcolarlo ciclando il vettore dei
                // piatti, moltiplicando il prezzo dei piatti che hanno una
                // quantita' superiore a 0 per la quantita' stessa.
                parziale = BigDecimal.ZERO;
                for (int i = 0; i < v.size(); i++) {
                    piatto = (((Piatto) (v.elementAt(i))));

                    if (piatto.getQuantita() > 0) {
                        parziale = parziale.add(piatto.getPrice().multiply(new BigDecimal(piatto.getQuantita())));
                    }
                }

                // ottengo la nuova lista (visiva)dei piatti
                lista = scontrino.stampa();

                // azzero la lista visiva dei piatti, per poi aggiornarla.
                a.setText("");
                while (lista.hasMoreElements()) {
                    a.append((String) lista.nextElement());
                    a.append(newline);

                }

                // aggiorno il parziale dei prezzi.
                totale.setText("" + parziale);
            }

        } else if (bottone.equals("Stampa")) {
            // stampa dello scontrino

            // Modal dialog with yes/no button
            frame = new JFrame("Confermare?");

            for (int i = 0; i < v.size(); i++) {
                piatto = (((Piatto) (v.elementAt(i))));

                if (piatto.getQuantita() > 0) {
                    message = message + piatto.getName() + " "
                            + piatto.getQuantita() + "x " + piatto.getPrice()
                            + "\n";
                }
            }

            message = message + "---------\nTotale: " + " " + totale.getText()
                    + " Euro";

            answer = JOptionPane.showConfirmDialog(frame, message,
                    "Stampa scontrino", JOptionPane.YES_NO_OPTION);
            if (answer == JOptionPane.YES_OPTION) {
                // User clicked YES.
                try {
                    file = new FileWriter("stampa.txt", true);
                    fOUT = new PrintWriter(file);
                } catch (IOException e) {
                    System.out.println("Errore nell'apertura del file");
                    System.exit(1);
                }

                fOUT.println(sdf.format(calendar.getTime()));
                fOUT.flush();

                for (int j = 0; j < v.size(); j++) {
                    piatto = (((Piatto) (v.elementAt(j))));

                    if (piatto.getQuantita() > 0) {
                        fOUT.println(piatto.getName() + "\t"
                                + piatto.getQuantita() + "x\t"
                                + piatto.getPrice());
                        fOUT.flush();
                    }

                }

                fOUT.println("Totale: " + totale.getText());
                fOUT.println("[----------------------------]");
                fOUT.flush();
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("Errore nella chiusura del file.");
                    System.exit(1);
                }

                message = "Scontrino\n";
                totale.setText("");
                for (int j = 0; j < v.size(); j++) {
                    piatto = (((Piatto) (v.elementAt(j))));
                    piatto.resetQuantita();

                }

                erase = true;
            } else {
                // User clicked NO.
                message = "Scontrino\n";
            }

        } else {

            // aggiunta di un nuovo piatto allo scontrino.
            // Viene fatta una ricerca nel vettore piatti, cercando il nome, se
            // trovato si aumenta la quantita' di uno.
            for (int i = 0; i < v.size(); i++) {
                if (((Piatto) (v.elementAt(i))).getName().equalsIgnoreCase(
                        bottone)) {
                    piatto = (Piatto) v.elementAt(i);
                    piatto.incrementQuantitaByOne();

                }
            }

            // aggiorantmento del parziale dello scontrino.
            parziale = BigDecimal.ZERO;
            for (int i = 0; i < v.size(); i++) {
                piatto = (((Piatto) (v.elementAt(i))));

                if (piatto.getQuantita() > 0) {
                    parziale = parziale.add(piatto.getPrice().multiply(new BigDecimal(piatto.getQuantita())));
                }
            }

            scontrino.Push(bottone);
            a.append(bottone);
            a.append(newline);
            totale.setText("" + parziale);

        }

    }
}
