
import java.util.ArrayList;

/**
 * Classe de tests (partiels) pour tester les services de l'interface ListeDoublons.
 * Les tests sont ici effectues avec l'implementation ListeDoublonsChainee.
 * 
 * Verifiez ce qui s'affiche a la console pour savoir si l'execution des tests
 * a reussi : 
 *    - Normalement, la valeur obtenue est affichee en premier suivie 
 *      de la valeur attendue, entre parentheses. Deux valeurs identiques 
 *      indiquent un test reussi.
 * 
 *    - Pour les tests de listes, vous avez sur une ligne "Liste obtenue  : ..."
 *      et sur la ligne suivante, Liste attendue : ... Les deux listes doivent etre
 *      les memes pour un test reussi.
 * 
 *   - Aussi, parfois il peut y avoir le mot ERREUR (au lieu de OK) et ceci veut 
 *     dire qu'un test a echoue.
 * 
 * @author Melanie Lord
 * @version Hiver 2014
 */
public class TestsPartielsListeDoublonsChainee {
   
   public static void tests () {
      
      Personne p1 = new Personne("Luc", "245-5667");
      Personne p2 = new Personne("Luc", "233-2345");
      Personne p3 = new Personne("Bob", "777-2345");
      Personne p4 = new Personne("Lucie", "123-9876");
      Personne p5 = new Personne("Julie", "348-2907");
      Personne p6 = new Personne("Julie", "223-0098");
      Personne p7 = new Personne("Julie", "348-2907");
      Personne p8 = new Personne("Hubert", "333-3333");
      Personne p9 = new Personne("Ali", "276-0328");
      Personne p10 = new Personne("Mel", "256-3449");
      Personne p11 = new Personne("Justine", "348-2907");
      Personne p12 = new Personne("Bob", "222-2222");
      ArrayList<Personne> tous;
      boolean b;
      
      System.out.println("--------------------------");
      System.out.println("TEST AJOUTER");
      System.out.println("--------------------------");
      ListeDoublons<Personne> liste = 
                                 new ListeDoublonsChainee<Personne>();
      
      System.out.println(liste.estVide() + " (true)");
      System.out.println(liste.longueur() + " (0)");
      
      try {
         liste.ajouter(null);
         System.out.println("ERREUR, devrait lever NullPointeurException.");
      } catch (NullPointerException npe) {
         System.out.println("OK NullPointeurException.");
      }
      System.out.println(liste + " (Liste vide)");  
      liste.ajouter(p3);
      System.out.println(liste.estVide() + " (false)");
      System.out.println(liste.longueur() + " (1)");
      System.out.println(liste + " (Bob:777-2345)"); 
      
      liste.ajouter(p6);
      liste.ajouter(p9);
      liste.ajouter(p2);
      System.out.println(liste.longueur() + " (4)");
      System.out.println("Liste obtenue  : " + liste 
              + "\nListe attendue : Bob:777-2345, Julie:223-0098, Ali:276-0328, "
              + "Luc:233-2345"); 
      
      liste.ajouter(p5);  
      liste.ajouter(p12); 
      liste.ajouter(p7);  
                           
      liste.ajouter(new Personne("Luc", "454-0945"));
      liste.ajouter(new Personne("Luc", "111-0987"));
      
      //ajout de doublons
      System.out.println(liste.longueur() + " (4)");
      System.out.println("Liste obtenue  : " + liste 
              + "\nListe attendue : Bob:777-2345, Bob:222-2222, Julie:223-0098, "
              + "Julie:348-2907, Julie:348-2907, Ali:276-0328, Luc:233-2345, "
              + "Luc:454-0945, Luc:111-0987"); 
      
      System.out.println("\n--------------------------");
      System.out.println("TEST PREMIER ET DERNIER");
      System.out.println("--------------------------");
      System.out.println("premier : " + liste.premier() + " (Bob:777-2345)");
      System.out.println("dernier : " + liste.dernier() + " (Luc:233-2345)");
      
      System.out.println("\n--------------------------");
      System.out.println("TEST OBTENIR TOUS");
      System.out.println("--------------------------");
      
      tous = liste.obtenirDoublons(null);
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : []");
      System.out.println();
      
      tous = liste.obtenirDoublons(new Personne("Patof", "234-0049"));
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : []");
      System.out.println();
      
      tous = liste.obtenirDoublons(p12);
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : [Bob:777-2345, Bob:222-2222]");
      System.out.println();
      
      tous = liste.obtenirDoublons(p3);
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : [Bob:777-2345, Bob:222-2222]");
      System.out.println();
      
      tous = liste.obtenirDoublons(p6);
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : [Julie:223-0098, Julie:348-2907, Julie:348-2907]");
      System.out.println();
      
      tous = liste.obtenirDoublons(p7);
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : [Julie:223-0098, Julie:348-2907, Julie:348-2907]");
      System.out.println();
      
      tous = liste.obtenirDoublons(p5);
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : [Julie:223-0098, Julie:348-2907, Julie:348-2907]");
      System.out.println();
      
      System.out.println("\n--------------------------------");
      System.out.println("TEST OBTENIR ELEMENTS DISTINCTS");
      System.out.println("--------------------------------");
      tous = liste.obtenirElementsDistincts();
      System.out.println("Liste obtenue  : " + tous);
      System.out.println("Liste attendue : [Bob:777-2345, Julie:223-0098, Ali:276-0328, Luc:233-2345]");
      
      System.out.println("\n--------------------------");
      System.out.println("TEST NBR OCCURRENCES");
      System.out.println("--------------------------");
      System.out.println(liste.nbrOccurrences(null) + " (0)");
      System.out.println(liste.nbrOccurrences(p10) + " (0)");
      System.out.println(liste.nbrOccurrences(p1) + " (3)");
      System.out.println(liste.nbrOccurrences(new Personne("Ali", "121-8765")) + " (1)");
      System.out.println(liste.nbrOccurrences(new Personne("Bob", "898-7776")) + " (2)");
      System.out.println(liste.nbrOccurrences(new Personne("Luc", "234-8989")) + " (3)");
      System.out.println(liste.nbrOccurrences(p6) + " (3)"); 
      
      System.out.println("\n--------------------------");
      System.out.println("TEST EXISTE");
      System.out.println("--------------------------");
      System.out.println(liste.existe(null) + " (false)");
      System.out.println(liste.existe(p10) + " (false)");
      System.out.println(liste.existe(p1) + " (true)");
      System.out.println(liste.existe(new Personne("Ali", "121-8765")) + " (true)");
      System.out.println(liste.existe(new Personne("Bob", "898-7776")) + " (true)");
      System.out.println(liste.existe(new Personne("Luc", "234-8989")) + " (true)");
      System.out.println(liste.existe(p6) + " (true)"); 
      
      System.out.println("\n--------------------------");
      System.out.println("TEST SUPPRIMER TOUS");
      System.out.println("--------------------------");
      
      b = liste.supprimerTous(null);
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Bob:777-2345, Bob:222-2222, "
              + "Julie:223-0098, Julie:348-2907, Julie:348-2907, Ali:276-0328, "
              + "Luc:233-2345, Luc:454-0945, Luc:111-0987");
      System.out.println(b + " (false)");
      System.out.println(liste.longueur() + " (4)");
      System.out.println();
      System.out.println(p10.getNom());
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Bob:777-2345, Bob:222-2222, "
              + "Julie:223-0098, Julie:348-2907, Julie:348-2907, Ali:276-0328, "
              + "Luc:233-2345, Luc:454-0945, Luc:111-0987");
      System.out.println(b + " (false)");
      System.out.println(liste.longueur() + " (4)");
      System.out.println();
      
      b = liste.supprimerTous(p12);
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Julie:223-0098, Julie:348-2907, "
              + "Julie:348-2907, Ali:276-0328, Luc:233-2345, Luc:454-0945, "
              + "Luc:111-0987");
      System.out.println(b + " (true)");
      System.out.println(liste.longueur() + " (3)");
      System.out.println();
      
      b = liste.supprimerTous(p9);
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Julie:223-0098, Julie:348-2907, "
              + "Julie:348-2907, Luc:233-2345, Luc:454-0945, Luc:111-0987");
      System.out.println(b + " (true)");
      System.out.println(liste.longueur() + " (2)");
      System.out.println();
      
      b = liste.supprimerTous(p2);
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Julie:223-0098, Julie:348-2907, "
              + "Julie:348-2907");
      System.out.println(b + " (true)");
      System.out.println(liste.longueur() + " (1)");
      System.out.println();
      
      b = liste.supprimerTous(p7);
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Liste vide");
      System.out.println(b + " (true)");
      System.out.println(liste.longueur() + " (0)");
      System.out.println();
      
      b = liste.supprimerTous(p10);
      System.out.println("Liste obtenue  : " + liste);
      System.out.println("Liste attendue : Liste vide");
      System.out.println(b + " (false)");
      System.out.println(liste.longueur() + " (0)");
      
      System.out.println("\n--------------------------");
      System.out.println("TEST VIDER");
      System.out.println("--------------------------");
      
      System.out.println("Liste avant : " + liste + " (Liste vide)");
      liste.vider();
      System.out.println("Liste apres : " + liste + " (Liste vide)");
      System.out.println(liste.estVide() + " (true)");
      System.out.println(liste.longueur() + " (0)");
      System.out.println();
      
      System.out.println("Ajout de 5 elements...");
      liste.ajouter(p1);
      liste.ajouter(p2);
      liste.ajouter(p3);
      liste.ajouter(p4);
      liste.ajouter(p5);
      System.out.println("Liste avant : " + liste);
      liste.vider();
      System.out.println("Liste apres : " + liste + " (Liste vide)");
      System.out.println(liste.estVide() + " (true)");
      System.out.println(liste.longueur() + " (0)");
      System.out.println();
   }
   
   public static void main (String [] args) {
      tests ();
   }
}

/**
 * Classe modelisant une Personne ayant un nom et un numero de telephone.
 * @author Melanie Lord
 * @version Hiver 2014
 */
class Personne {
   
   //constante de classe
   public final static String SANS_NOM = "anonyme";
   
   //attributs d'instance
   private String nom;
   private String noTel;
   
   /**
    * Constructeur d'initialisation.
    * @param nom le nom de cette personne.  Si null, le nom sera initialise a
    *        SANS_NOM.
    * @param noTel le numero de telephone de cette personne.
    */
   public Personne(String nom, String noTel)  {
      if (nom != null) {
         this.nom = nom;
      } else {
         this.nom = SANS_NOM;
      }
      this.noTel = noTel;
   }

   /**
    * Retourne le nom de cette Personne.
    * @return le nom de cette Personne.
    */
   public String getNom() {
      return nom;
   }

   /**
    * Modifie le nom de cette Personne par le nom donne.
    * @param nom le nouveau nom de cette Personne. Si null, le nouveau nom sera
    *        SANS_NOM.
    */
   public void setNom(String nom) {
      if (nom != null) {
         this.nom = nom;
      } else {
         this.nom = SANS_NOM;
      }  
   }

   /**
    * Retourne le numero de telephone de cette Personne.
    * @return le numero de telephone de cette Personne.
    */
   public String getNoTel() {
      return noTel;
   }

   /**
    * Modifie le numero de telephone de cette Personne avec le noTel donne.
    * @param noTel le nouveau numero de telephone de cette Personne.
    */
   public void setNoTel(String noTel) {
      this.noTel = noTel;
   }
   
   /**
    * Retourne une representation sous forme de chaine de caracteres de cette 
    * Personne.
    * @return une representation sous forme de chaine de caracteres de cette
    *         Personne.
    */
   public String toString() {
      return nom + ":" + noTel;
   }
   
   
   /**
    * Redefinition de la methode equals de la classe Object.
    * Teste si cette Personne est egale a l'objet autre passe en parametre.
    * @param autre l'autre personne a comparer avec cette Personne.
    * @return true si autre est une Personne qui a le meme non que cette 
    *         Personne, false sinon.
    */
   public boolean equals(Object autre) {
      return autre != null 
              && getClass() == autre.getClass()
              && nom.equals(((Personne)autre).nom);
   }
}