package ipplanmanager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP5 - Moteur VLSM =====");
        
        // On crée l'outil moteur une seule fois
        MoteurVLSM moteur = new MoteurVLSM();

        // SCÉNARIO 2 : PETITE ENTREPRISE
        System.out.println("\n--- SCÉNARIO 2 : PETITE ENTREPRISE ---");
        ArrayList<BesoinReseau> entreprise = new ArrayList<>();
        entreprise.add(new BesoinReseau("ADMIN", 25));
        entreprise.add(new BesoinReseau("COMPTABILITE", 12));
        entreprise.add(new BesoinReseau("WIFI_INVITES", 40));
        entreprise.add(new BesoinReseau("SERVEURS", 8));

        ArrayList<ResultatVLSM> planE = moteur.genererPlan("192.168.2.0", entreprise);
        for (ResultatVLSM res : planE) { res.afficher(); }

        // SCÉNARIO 3 : CAMPUS
        System.out.println("\n--- SCÉNARIO 3 : CAMPUS ---");
        ArrayList<BesoinReseau> campus = new ArrayList<>();
        campus.add(new BesoinReseau("ETUDIANTS", 500));
        campus.add(new BesoinReseau("PERSONNEL", 120));
        campus.add(new BesoinReseau("LABORATOIRE", 60));
        campus.add(new BesoinReseau("ADMINISTRATION", 40));
        campus.add(new BesoinReseau("WIFI_PUBLIC", 200));

        ArrayList<ResultatVLSM> planC = moteur.genererPlan("10.0.0.0", campus);
        for (ResultatVLSM res : planC) { res.afficher(); }
    }
}