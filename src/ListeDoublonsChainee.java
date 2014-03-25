
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Laurier
 */
public class ListeDoublonsChainee implements ListeDoublons<Object> {

    MaillonD debut = null; //maillon de début de la liste 
    MaillonD fin = null; //maillon de la fin de la liste 

    //pointe sur le premier des doublons en fin de liste 
    int nbrElements = 0; //nombre d’éléments distincts dans la liste 

    public ListeDoublonsChainee() {
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

        MaillonD temp = debut;
        MaillonD temp2 = new MaillonD(element);
        if (element != null) {
            while (!(element.equals(temp.getInfo())) && temp != null) {
                temp = temp.getSuivant();
            }
            if (element.equals(temp.getInfo())) {
                while (temp.getDoublonSuivant() != null) {
                    temp = temp.getDoublonSuivant();
                }
                temp.setDoublonSuivant(temp2);
            } else {
                fin.setSuivant(temp2);
                fin = temp2;
                nbrElements++;
            }
        }
    }

    @Override
    public ArrayList<Object> obtenirDoublons(Object element) {

        ArrayList<Object> listeRetour = new ArrayList<>();
        MaillonD temp = debut;

        if (element != null) {
            while (!element.equals(temp.getInfo()) && temp != null) {
                temp = temp.getSuivant();
            }
            while (temp != null) {
                listeRetour.add(temp);
                temp = temp.getDoublonSuivant();
            }
        }
        return listeRetour;
    }

    @Override
    public ArrayList<Object> obtenirElementsDistincts() {

        ArrayList<Object> listeRetour = new ArrayList<>();
        MaillonD temp = debut;

        while (temp != null) {
            listeRetour.add(temp);
            temp = temp.getSuivant();
        }
        return listeRetour;
    }

    @Override
    public boolean supprimerTous(Object element) {
        boolean retour = false;
        MaillonD temp = debut;
        MaillonD temp2;
        if (element != null) {
            while (!element.equals(temp.getSuivant().getInfo()) && temp != null) {
                temp = temp.getSuivant();
            }
            if (temp != null) {
                temp2 = temp;
                temp = temp.getSuivant();
                temp2.setSuivant(temp.getSuivant());
                retour = true;
            }
            //regarde si le suivant du nouveau pointeur est null ou non
            if (temp.getSuivant().getSuivant() == null) {
                fin = temp.getSuivant();
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
            while (!element.equals(temp.getInfo()) && temp != null) {
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

        while (!element.equals(temp.getInfo()) && temp != null) {
            temp = temp.getSuivant();
            if (temp.getInfo().equals(element)) {
                existe = true;
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
    public Object premier() {
        return debut;
    }

    @Override
    public Object dernier() {
        return fin;
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
                if (p.getDoublonSuivant() != null|| p.getSuivant() != null) {
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
