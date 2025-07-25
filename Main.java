import entity.Patient;
import service.PatientService;
import view.PatientView;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Ba", "Moussa");
        PatientService service = new PatientService();
        PatientView view = new PatientView(service, patient);
        view.menu();
    }
}
