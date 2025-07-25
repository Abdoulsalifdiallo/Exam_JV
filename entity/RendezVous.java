package entity;

import java.time.LocalDateTime;

public class RendezVous {
    private static int cpt = 1;
    private int id;
    private Patient patient;
    private String specialite;
    private LocalDateTime dateHeure;
    private String statut;

    public RendezVous(Patient patient, String specialite, LocalDateTime dateHeure) {
        this.id = cpt++;
        this.patient = patient;
        this.specialite = specialite;
        this.dateHeure = dateHeure;
        this.statut = "EN_ATTENTE";
    }

    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public String getSpecialite() { return specialite; }
    public LocalDateTime getDateHeure() { return dateHeure; }
    public String getStatut() { return statut; }
    public void setStatut(String s) { statut = s; }

    @Override
    public String toString() {
        return "RV n°" + id + " | " + specialite + " | " + dateHeure + " | " + statut;
    }
}
