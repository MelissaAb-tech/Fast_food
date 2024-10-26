public class Compte {
    private String nomUtilisateur;
    private String codeFidelite;
    // private int nbPoints;

    // Constructeur
    public Compte(String nomUtilisateur, String codeFidelite) {
        this.nomUtilisateur = nomUtilisateur;
        this.codeFidelite = codeFidelite;
    }

    // Getters
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getCodeFidelite() {
        return codeFidelite;
    }

    // Méthode pour vérifier si deux comptes sont égaux par le code de fidélité
    public boolean verifierCode(String code) {
        return this.codeFidelite.equals(code);
    }
}
