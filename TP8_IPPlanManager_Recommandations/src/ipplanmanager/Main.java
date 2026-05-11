package ipplanmanager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== DIAGNOSTIC IPPlan-Manager TP8 =====");

        ArrayList<BesoinReseau> besoins = new ArrayList<>();
        besoins.add(new BesoinReseau("ADMINISTRATION", 50));
        besoins.add(new BesoinReseau("WIFI_INVITES", 120));
        besoins.add(new BesoinReseau("SERVEURS", 20));

        MoteurVLSM moteur = new MoteurVLSM();
        ArrayList<ResultatVLSM> resultats = moteur.genererPlan("192.168.10.0", besoins);

        // --- TRACE 1 : Vérification du Moteur VLSM ---
        System.out.println("Nombre de résultats générés par le moteur : " + resultats.size());

        GestionnaireVLAN gestionnaire = new GestionnaireVLAN();
        int vlanId = 10;

        for (ResultatVLSM res : resultats) {
            try {
                VLAN vlan = new VLAN(vlanId, res.getNomBesoin(), res, "Zone " + res.getNomBesoin());
                gestionnaire.ajouterVLAN(vlan);
                
                // --- TRACE 2 : Vérification de l'ajout ---
                System.out.println("Ajout du VLAN : " + vlan.getNom() + " (ID: " + vlanId + ")");
                
                vlanId += 10;
            } catch (Exception e) {
                System.out.println("Erreur lors de l'ajout : " + e.getMessage());
            }
        }

        // --- TRACE 3 : Vérification finale de la liste ---
        ArrayList<VLAN> listeFinale = gestionnaire.getVlans();
        System.out.println("Nombre de VLANs dans le gestionnaire : " + listeFinale.size());

        if (listeFinale.size() > 0) {
            MoteurRecommandation moteurRec = new MoteurRecommandation();
            moteurRec.ajouterRegle(new RecommandationWifiInvite());
            moteurRec.ajouterRegle(new RecommandationAdministration());
            moteurRec.ajouterRegle(new RecommandationMargeAdresse());

            System.out.println("\n--- Affichage des Recommandations ---");
            ArrayList<Recommandation> conseils = moteurRec.analyserVLANs(listeFinale);
            moteurRec.afficherRecommandations(conseils);
        } else {
            System.out.println("\nERREUR CRITIQUE : Le gestionnaire est resté vide.");
        }
    }
}