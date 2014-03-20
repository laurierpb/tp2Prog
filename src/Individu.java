
public class Individu {

    private String nom = "";
    private int age = 0;

    /**
     * Constructeur d'initialisation.
     *
     * @param nom le nom de cet individu
     * @param age l'age de cet individu
     */
    public Individu(String nom, int age) {
        if (nom != null) {
            this.nom = nom;
        }
        if (age > 0) {
            this.age = age;
        }
    }

    /**
     * Redefinition de la methode equals de la classe Object. Deux individus
     * sont consideres egaux s'ils ont le meme nom (sans tenir compte de la
     * casse).
     *
     * @param autreIndividu l'autre individu avec lequel on veut tester
     * l'egalite de cet individu.
     * @return true si cet individu est egal a autreIndividu, false autrement.
     */
    public boolean equals(Object autreIndividu) {
        return autreIndividu != null
                && this.getClass() == autreIndividu.getClass()
                && this.nom.equalsIgnoreCase(((Individu) autreIndividu).nom);
    }
}
