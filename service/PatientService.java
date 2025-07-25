package service;

import entity.Patient;
import entity.RendezVous;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PatientService {
    private ArrayList<RendezVous> rvList = new ArrayList<>();

    public void demanderRendezVous(Patient p, String specialite, LocalDateTime date) {
        RendezVous rv = new RendezVous(p, specialite, date);
        rvList.add(rv);
    }

    public ArrayList<RendezVous> getRendezVousByPatient(Patient p) {
        ArrayList<RendezVous> mesRV = new ArrayList<>();
        for (RendezVous rv : rvList) {
            if (rv.getPatient().getId() == p.getId()) {
                mesRV.add(rv);
            }
        }
        return mesRV;
    }

    public boolean demanderAnnulation(Patient p, int idRV) {
        for (RendezVous rv : rvList) {
            if (rv.getId() == idRV && rv.getPatient().getId() == p.getId()) {
                if (rv.getDateHeure().isAfter(LocalDateTime.now().plusHours(48))) {
                    rv.setStatut("DEMANDE_ANNULATION");
                    return true;
                }
            }
        }
        return false;
    }
}
