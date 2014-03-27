
import java.util.ArrayList;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * PAQL20099109
 *
 * @author Laurier
 * @param <T>
 */
public class ListeDoublonsChainee<T> implements ListeDoublons<T> {

    MaillonD<T> debut = null; //maillon de début de la liste 
    MaillonD<T> fin = null; //maillon de la fin de la liste

    //pointe sur le premier des doublons en fin de liste 
    int nbrElements = 0; //nombre d’éléments distincts dans la liste 

    ListeDoublonsChainee() {
    }

    @Override
    public boolean estVide() {
        return nbrElements == 0;
    }

    @Override
    public int longueur() {
        return nbrElements;
    }

    @Override
    public void ajouter(Object element) {

        MaillonD<T> temp = debut;
        MaillonD<T> temp2 = new MaillonD(element);
        if (element != null) {
            while (temp != null && !element.equals(temp.getInfo())) {
                temp = temp.getSuivant();
            }
            if (temp != null && element.equals(temp.getInfo())) {
                while (temp.getDoublonSuivant() != null) {
                    temp = temp.getDoublonSuivant();
                }
                temp.setDoublonSuivant(temp2);
            } else {
                if (debut == null) {
                    debut = temp2;
                    fin = temp2;
                    nbrElements++;
                } else {
                    fin.setSuivant(temp2);
                    fin = temp2;
                    nbrElements++;
                }
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public ArrayList<T> obtenirDoublons(Object element) {

        ArrayList<T> listeRetour = new ArrayList<>();
        MaillonD<T> temp = debut;

        if (element != null) {
            while (temp != null && !element.equals(temp.getInfo())) {
                temp = temp.getSuivant();
            }
            while (temp != null) {
                listeRetour.add((T) temp.getInfo());
                temp = temp.getDoublonSuivant();
            }
        }
        return listeRetour;
    }

    @Override
    public ArrayList<T> obtenirElementsDistincts() {

        ArrayList<T> listeRetour = new ArrayList<>();
        MaillonD<T> temp = debut;

        while (temp != null) {
            listeRetour.add((T) temp.getInfo());
            temp = temp.getSuivant();
        }
        return listeRetour;
    }

    @Override
    public boolean supprimerTous(Object element) {
        boolean retour = false;
        MaillonD temp = debut;
        MaillonD temp2 = temp;
        if (element != null) {
            while (temp != null && !element.equals(temp.getInfo())) {
                temp2 = temp;
                temp = temp.getSuivant();
            }
            if (temp != null) {
                if (temp == debut && temp == fin) {
                    debut = null;
                    fin = null;
                    retour = true;
                } else if (temp == fin) {
                    temp2.setSuivant(null);
                    fin = temp2;
                    retour = true;
                } else if (temp == debut) {
                    debut = temp.getSuivant();
                    retour = true;
                } else if (temp != null) {
                    temp2.setSuivant(temp.getSuivant());
                    retour = true;
                }
            }
        }
        setNbrEement();
        return retour;
    }

    @Override
    public int nbrOccurrences(Object element) {
        int nbOccurence = 0;
        MaillonD temp = debut;

        if (element != null) {
            while (temp != null && !element.equals(temp.getInfo())) {
                temp = temp.getSuivant();
            }
            while (temp != null) {
                nbOccurence++;
                temp = temp.getDoublonSuivant();
            }
        }
        return nbOccurence;
    }

    @Override
    public boolean existe(Object element) {
        boolean existe = false;
        MaillonD temp = debut;
        if (element != null) {
            while (temp != null && !existe) {
                if (element.equals(temp.getInfo())) {
                    existe = true;
                }
                temp = temp.getSuivant();
            }
        }
        return existe;
    }

    @Override
    public void vider() {
        debut = null;
        fin = null;
        nbrElements = 0;
    }

    @Override
    public T premier() {
        if (nbrElements == 0) {
            throw new NoSuchElementException();
        }
        return (T) debut.getInfo();
    }

    @Override
    public T dernier() {
        if (nbrElements == 0) {
            throw new NoSuchElementException();
        }
        return (T) fin.getInfo();
    }

    private void setNbrEement() {
        MaillonD temp = debut;
        int nbElement = 0;

        while (temp != null) {
            nbElement++;
            temp = temp.getSuivant();
        }
        nbrElements = nbElement;
    }

    public String toString() {
        String s = "";
        MaillonD<T> p;
        MaillonD<T> p2;

        if (estVide()) {
            s = "Liste vide";
        } else {
            p = debut;
            while (p != null) {
                s = s + p.getInfo();
                if (p.getDoublonSuivant() != null || p.getSuivant() != null) {
                    s = s + ", ";
                }
                p2 = p;
                //parcourir la liste des doublons, s'il y a lieu 
                while (p2.getDoublonSuivant() != null) {
                    p2 = p2.getDoublonSuivant();
                    s = s + p2.getInfo();
                    if (!(p == fin && p2.getDoublonSuivant() == null
                            && p2.getSuivant() == null)) {
                        s = s + ", ";
                    }
                }
                p = p.getSuivant();
            }
        }
        return s;
    }
}
