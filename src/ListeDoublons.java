
import java.util.ArrayList;

/**
 * Type de donnees abstrait representant une liste d'elements de type T pouvant
 * contenir des doublons et n'acceptant pas les elements null. L'ordre d'ajout
 * des elements ainsi que des doublons doit etre conserve.
 * 
 * Des doublons sont des elements egaux. Soit e1 et e2. Si e1.equals(e2) retourne
 * vrai, alors e1 et e2 sont des doublons. Le type (T) des elements de cette liste 
 * doit donc redefinir la methode equals pour determiner les doublons.
 * 
 * @author Melanie Lord
 * @version Hiver 2014
 */
public interface ListeDoublons<T> {
   
   /**
    * Determine si la liste est vide.
    * 
    * @return true si la liste est vide, false autrement.
    */
   public boolean estVide();

   /**
    * Determine le nombre d'elements distincts (non egaux) dans cette liste. 
    * 
    * @return le nombre d'elements distincts dans cette liste.
    */
   public int longueur();
   
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
   public void ajouter (T element);
   
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
   public ArrayList<T> obtenirDoublons(T element);
   
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
   public ArrayList<T> obtenirElementsDistincts();
   
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
   public boolean supprimerTous (T element);
   
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
   public int nbrOccurrences (T element);
   
   /**
    * Retourne vrai si l'element donne existe dans la liste, faux sinon. Plus 
    * precisement, soit e, un element de cette liste. Cette methode retourne 
    * vrai si pour au moins un e, e.equals(element) retourne vrai.
    * 
    * @param element l'element dont on veut tester l'existence.
    * @return true si l'element donne existe dans la liste, faux sinon.
    */
   public boolean existe (T element);
   
   /**
    * Supprime tous les elements de cette liste. Apres l'appel de cette methode, 
    * l'appel de la methode estVide() retourne true et l'appel de la methode
    * longueur() retourne 0.
    */
   public void vider();
   
   /**
    * Retourne le premier element de la liste (le premier des doublons en 
    * debut de liste).
    * 
    * @return le premier element de la liste.
    * @throws NoSuchElementException si la liste est vide.
    */
   public T premier();
   
   /**
    * Retourne le premier des derniers doublons de la liste.
    * 
    * @return le premier des derniers doublons de la liste.
    * @throws NoSuchElementException si la liste est vide.
    */
   public T dernier();
   
}
