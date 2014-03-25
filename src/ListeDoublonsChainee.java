
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
            while (!(element.equals(temp)) && temp != null) {
                temp = temp.getSuivant();
            }
            if (element.equals(temp)) {
                temp.setDoublonSuivant(temp2);
            } else {
                fin.setSuivant(temp2);
                fin = temp2;
            }
        }
    }

    @Override
    public ArrayList<Object> obtenirDoublons(Object element) {
        
        ArrayList<Object> listeRetour = new ArrayList<>();
        MaillonD temp = new MaillonD(element);
        temp = debut;
        
        if(element != null){
            while(temp != null){
                listeRetour.add(temp);
                temp = temp.getSuivant();
            }
        }
        return listeRetour;
    }

    @Override
    public ArrayList<Object> obtenirElementsDistincts() {
        
        ArrayList<Object> listeRetour = new ArrayList<>();
        
        
        
        return listeRetour;
    }

    @Override
    public boolean supprimerTous(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbrOccurrences(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Object element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object premier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object dernier() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
