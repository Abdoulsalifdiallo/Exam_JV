package entity;

public class Patient {
    private static int compteur = 1;
    private int id;
    private String nom;
    private String prenom;

    public Patient(String nom, String prenom) {
        this.id = compteur++;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }

    @Override
    public String toString() {
        return prenom + " " + nom + " (id: " + id + ")";
    }
}
