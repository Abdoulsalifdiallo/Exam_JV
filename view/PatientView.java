package view;

import entity.Patient;
import entity.RendezVous;
import service.PatientService;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PatientView {
    private PatientService service;
    private Patient patient;

    public PatientView(PatientService s, Patient p) {
        this.service = s;
        this.patient = p;
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int rep = -1;
        while (rep != 0) {
            System.out.println("\n----- Menu Patient -----");
            System.out.println("1. Demander un rendez-vous");
            System.out.println("2. Voir mes rendez-vous");
            System.out.println("3. Demander l'annulation d'un RV");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            rep = sc.nextInt();
            sc.nextLine();

            if (rep == 1) {
                System.out.print("Spécialité (Généraliste, Dentaire, Cardiologue,...) : ");
                String spec = sc.nextLine();
                System.out.print("Date et heure (ex: 2025-07-29 13:30) : ");
                String dateStr = sc.nextLine();
                try {
                    LocalDateTime date = LocalDateTime.parse(dateStr.replace(" ", "T"));
                    service.demanderRendezVous(patient, spec, date);
                    System.out.println("OK, demande envoyée !");
                } catch (Exception e) {
                    System.out.println("Attention, format de date incorrect ! (essaye genre 2025-08-01 14:00)");
                }
            } else if (rep == 2) {
                var mesRV = service.getRendezVousByPatient(patient);
                if (mesRV.isEmpty()) {
                    System.out.println("Tu n’as aucun rendez-vous pour le moment.");
                } else {
                    for (RendezVous rv : mesRV) {
                        System.out.println(rv);
                    }
                }
            } else if (rep == 3) {
                System.out.print("Numéro du RV à annuler : ");
                int num = sc.nextInt();
                sc.nextLine();
                boolean fait = service.demanderAnnulation(patient, num);
                if (fait) {
                    System.out.println("Demande d’annulation prise en compte !");
                } else {
                    System.out.println("Impossible : soit RV inexistant, soit délai dépassé !");
                }
            } else if (rep == 4) {
                System.out.println("Au Revoir");
            } else {
                System.out.println("Choix invalide !");
            }
        }
    }
}
