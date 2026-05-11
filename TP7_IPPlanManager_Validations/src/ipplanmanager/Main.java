package ipplanmanager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager : TP7 - Travail Demandé =====");

        // TEST 1 : Adresse de départ invalide (Point 17.1)
        System.out.println("\n1. Test Adresse Invalide :");
        String ipDepart = "192.168.300.0";
        if (!CalculateurReseau.estAdresseIPValide(ipDepart)) {
            System.out.println("[DÉTECTÉ] L'adresse " + ipDepart + " est invalide.");
        }

        // TEST 2 : Chevauchement manuel (Point 17.2)
        System.out.println("\n2. Test de Chevauchement :");
        try {
            ResultatVLSM r1 = new ResultatVLSM("TECH", "192.168.1.0", 25, 126);
            ResultatVLSM r2 = new ResultatVLSM("WIFI", "192.168.1.64", 26, 62);
            ValidateurPlanAdressage.verifierChevauchement(r1, r2);
        } catch (ChevauchementReseauException e) {
            System.err.println("[ERREUR] " + e.getMessage());
        }

        // TEST 3 : Réseau insuffisant (Point 18)
        System.out.println("\n3. Test Réseau Insuffisant :");
        try {
            int besoinTotal = 500; // Besoin fictif
            int capaciteReseau = CalculateurReseau.calculerNombreHotes(24); // 254 hôtes
            if (besoinTotal > capaciteReseau) {
                throw new ReseauInsuffisantException("Besoin (" + besoinTotal + ") dépasse la capacité du /24 (" + capaciteReseau + ")");
            }
        } catch (ReseauInsuffisantException e) {
            System.err.println("[ERREUR] " + e.getMessage());
        }

        // TEST 4 : Conflit VLAN (Point 17.3)
        System.out.println("\n4. Test Conflit VLAN :");
        try {
            ArrayList<VLAN> vlans = new ArrayList<>();
            vlans.add(new VLAN(10, "V1", null, ""));
            vlans.add(new VLAN(20, "V2", null, ""));
            vlans.add(new VLAN(30, "V3", null, ""));
            vlans.add(new VLAN(10, "V4", null, "")); // Doublon ID 10
            ValidateurPlanAdressage.verifierConflitsVLAN(vlans);
        } catch (ConflitVLANException e) {
            System.err.println("[ERREUR] " + e.getMessage());
        }
    }
}