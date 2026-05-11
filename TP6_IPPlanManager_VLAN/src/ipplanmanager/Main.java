package ipplanmanager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP6 - SCÉNARIO UNIVERSITÉ =====");
        
        // 1. Création des besoins du campus
        ArrayList<BesoinReseau> besoinsU = new ArrayList<>();
        besoinsU.add(new BesoinReseau("ETUDIANTS", 500));
        besoinsU.add(new BesoinReseau("WIFI_PUBLIC", 200));
        besoinsU.add(new BesoinReseau("ENSEIGNANTS", 120));
        besoinsU.add(new BesoinReseau("LABORATOIRES", 60));
        besoinsU.add(new BesoinReseau("SERVEURS", 30));

        // 2. Génération automatique via le moteur VLSM
        MoteurVLSM moteur = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats = moteur.genererPlan("10.0.0.0", besoinsU);

        // 3. Création automatique des VLANs
        GestionnaireVLAN gestionnaire = new GestionnaireVLAN();
        int idVlan = 100; // On commence à 100 pour l'université

        for (ResultatVLSM res : resultats) {
            VLAN v = new VLAN(idVlan, res.getNomBesoin(), res, "Réseau pédagogique " + res.getNomBesoin());
            gestionnaire.ajouterVLAN(v);
            idVlan += 10;
        }

        // 4. Affichage des résultats demandés au point 15
        System.out.println("\n--- RÉSULTATS DU CAMPUS ---");
        gestionnaire.afficherTousLesVLANs();

        System.out.println("Nombre total de VLANs : " + gestionnaire.getNombreTotalVLANs());
        
        // Affichage des VLANs critiques (> 100 hôtes)
        gestionnaire.afficherVLANsCritiques();
        
        // Affichage du VLAN avec la plus grande capacité
        gestionnaire.afficherVLANPlusGrand();
    }
}