
/**
 * Classe qui modelise un Maillon pouvant aussi chainer des doublons. La methode
 * setSuivant permet de chainer les maillons dont l'info est differente tandis
 * que la methode setDoublonsSuivant permet de chainer entre eux les maillons
 * dont l'info est egale (les doublons). Les doublons suivants forment des
 * sous-chaines d'elements egaux a l'interieur de la chaine de maillons chaines
 * de suivant en suivant.
 *
 * @author Melanie Lord
 * @version Hiver 2014
 */
public class MaillonD<T> {

  
   //-----------------------
   // VARIABLES D'INSTANCE 
   //-----------------------
   
   //information contenu dans ce maillon
   private T info;
   
   //pour le chainage des elements distincts
   private MaillonD<T> suivant;
   
   //pour le chainage des doublons
   private MaillonD<T> doublonSuivant;

   //-----------------------
   // CONSTRUCTEURS
   //-----------------------
   
   /**
    * Cree un nouveau maillon n'ayant pas de maillon suivant et n'ayant
    * aucun doublons.
    *
    * @param info l'information qui sera stockee dans le maillonDoublon.
    */
   public MaillonD(T info) {
      this(info, null);
   }

   /**
    * Cree un nouveau maillon ayant un autre maillon existant comme suivant mais
    * n'ayant aucun doublons.
    *
    * @param info l'information qui sera stockee dans le maillon
    * @param suivant le maillon qui sera le suivant du maillon cree
    */
   public MaillonD(T info, MaillonD<T> suivant) {
      this.info = info;
      this.suivant = suivant;
   }

   //-----------------------
   // GETTERS ET SETTERS 
   //-----------------------
   
   /**
    * Retourne l'info de ce maillonD.
    *
    * @return l'info de ce maillonD.
    */
   public T getInfo() {
      return info;
   }

   /**
    * Modifie l'info de ce maillonD par l'info donnee en parametre.
    *
    * @param info la nouvelle info pour ce maillonD.
    */
   public void setInfo(T info) {
      this.info = info;
   }

   /**
    * Retourne le suivant de ce maillonD.
    *
    * @return le suivant de ce maillonD.
    */
   public MaillonD<T> getSuivant() {
      return suivant;
   }

   /**
    * Modifie le suivant de ce maillonD par le suivant donne en parametre.
    *
    * @param suivant le nouveau suivant pour ce maillonD.
    */
   public void setSuivant(MaillonD<T> suivant) {
      this.suivant = suivant;
   }

   /**
    * Retourne le doublon suivant de ce maillonD.
    *
    * @return le doublon suivant de ce maillonD.
    */
   public MaillonD<T> getDoublonSuivant() {
      return doublonSuivant;
   }

   /**
    * Modifie le doublon suivant de maillonD par le doublonsSuivant donne en
    * parametre.
    *
    * @param doublonSuivant le nouveau doublonSuivant de ce maillonD.
    */
   public void setDoublonSuivant(MaillonD<T> doublonSuivant) {
      this.doublonSuivant = doublonSuivant;
   }
}
