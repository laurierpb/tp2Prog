
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
    
    /**
    * Determine si la liste est vide.
    * 
    * @return true si la liste est vide, false autrement.
    */
    @Override
    public boolean estVide() {
        return nbrElements == 0;
    }

    /**
    * Determine le nombre d'elements distincts (non egaux) dans cette liste. 
    * 
    * @return le nombre d'elements distincts dans cette liste.
    */
    @Override
    public int longueur() {
        return nbrElements;
    }

    /**
    * Ajoute l'element donne a cette liste, s'il n'est pas null. 
    * Si cette liste ne contient pas d'elements egaux a l'element donne, celui-ci
    * est ajoute a la fin de la liste. Sinon, l'element donne est ajoute a la 
    * suite du ou des elements egaux (les doublons) deja presents dans cette liste.
    * 
    * Deux elements e1 et e2 sont egaux si e1.equals(e2) retourne true.
    * 
    * @param element l'element a ajouter.
    * @throws NullPointerException si l'element donne est null.
    */
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

    /**
    * Retourne une ArrayList contenant toutes les occurrences (tous les doublons) 
    * de l'element donne en parametre, dans l'ordre ou ils apparaissent dans 
    * cette liste. Si l'element donne est null ou ne se trouve pas dans cette 
    * liste, une ArrayList vide est retournee.
    * 
    * Les occurrences d'un element donne sont tous les elements de cette liste
    * qui sont egaux a cet element. Deux elements e1 et e2 sont egaux si 
    * e1.equals(e2) retourne true.
    * 
    * @param element l'element dont on recherche toutes les occurrences (tous les 
    *                doulons) dans cette liste.
    * @return une ArrayList contenant toutes les occurrences (tous les doublons) 
    * de l'element donne en parametre, dans l'ordre ou ils apparaissent dans 
    * cette liste.
    */
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

    /**
    * Retourne une ArrayList contenant la premiere occurrence de tous les 
    * elements distincs de cette liste, dans l'ordre ou ils apparaissent dans
    * cette liste. Lorsqu'un element possede des doublons, la premiere 
    * occurrence de cet element est celle qui a ete ajoutee en premier dans 
    * cette liste. 
    * 
    * Pour toute paire d'elements e1 et e2 (e1 n'etant pas le meme element que e2),
    * dans la liste retournee, e1.equals(e2) retourne faux.
    * 
    * Si cette liste est vide, retourne une ArrayList vide.
    * 
    * @return une ArrayList contenant la premiere occurrence de tous les elements
    *         distincts de cette liste, dans l'ordre ou ils apparaissent dans 
    *         cette liste.
    */
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

    /**
    * Supprime de cette liste toutes les occurrences (tous les doublons) de 
    * l'element donne en parametre. Plus particulierement, supprime tous les
    * elements de cette liste qui sont egaux a l'element passe en parametre. 
    * 
    * Deux elements e1 et e2 sont egaux si e1.equals(e2) retourne true.
    * 
    * Si au moins un element a ete supprime, retourne vrai, 
    * sinon retourne faux.
    * 
    * @param element l'element dont on veut supprimer toutes les occurrences.
    * @return true si au moins un element a ete supprime, false sinon.
    */
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
                } else {
                    temp2.setSuivant(temp.getSuivant());
                    retour = true;
                }
            }
        }
        setNbrEement();
        return retour;
    }

    /**
    * Retourne le nombre d'occurrences (le nombre de doublons) de l'element donne.
    * Plus precisement, retourne tous les elements de cette liste qui sont egaux
    * a l'element donne en parametre.
    * 
    * Deux elements e1 et e2 sont egaux si e1.equals(e2) retourne true.
    * 
    * @param element l'element dont on veut le nombre d'occurrences (de doublons).
    * @return le nombre d'occurrences (nombre de doublons) de l'element donne.
    */
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

    /**
    * Retourne vrai si l'element donne existe dans la liste, faux sinon. Plus 
    * precisement, soit e, un element de cette liste. Cette methode retourne 
    * vrai si pour au moins un e, e.equals(element) retourne vrai.
    * 
    * @param element l'element dont on veut tester l'existence.
    * @return true si l'element donne existe dans la liste, faux sinon.
    */
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

    /**
    * Supprime tous les elements de cette liste. Apres l'appel de cette methode, 
    * l'appel de la methode estVide() retourne true et l'appel de la methode
    * longueur() retourne 0.
    */
    @Override
    public void vider() {
        debut = null;
        fin = null;
        nbrElements = 0;
    }

    /**
    * Retourne le premier element de la liste (le premier des doublons en 
    * debut de liste).
    * 
    * @return le premier element de la liste.
    * @throws NoSuchElementException si la liste est vide.
    */
    @Override
    public T premier() {
        if (nbrElements == 0) {
            throw new NoSuchElementException();
        }
        return (T) debut.getInfo();
    }

    /**
    * Retourne le premier des derniers doublons de la liste.
    * 
    * @return le premier des derniers doublons de la liste.
    * @throws NoSuchElementException si la liste est vide.
    */
    @Override
    public T dernier() {
        if (nbrElements == 0) {
            throw new NoSuchElementException();
        }
        return (T) fin.getInfo();
    }

    /*
    * Ajuste le nombre d'élément distinc dans la liste
    *
    * @return le nombre d'élément distinc dans la liste
    */
    private void setNbrEement() {
        MaillonD temp = debut;
        int nbElement = 0;

        while (temp != null) {
            nbElement++;
            temp = temp.getSuivant();
        }
        nbrElements = nbElement;
    }

    @Override
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
