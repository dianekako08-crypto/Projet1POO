package ipplanmanager;
import java.util.ArrayList;

public class GestionnaireVLAN {
    private ArrayList<VLAN> vlans = new ArrayList<>();

    public void ajouterVLAN(VLAN vlan) {
        vlans.add(vlan);
    }

    public void afficherTousLesVLANs() {
        for (VLAN v : vlans) {
            v.afficher();
            System.out.println();
        }
    }

    public VLAN rechercherVLAN(int id) {
        for (VLAN v : vlans) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    // Méthode demandée au point 16
    public void afficherVLANsCritiques() {
        System.out.println("===== DÉTECTION DES VLANS CRITIQUES (> 100 hôtes) =====");
        for (VLAN v : vlans) {
            // On vérifie la capacité via le réseau associé
            if (v.getReseauAssocie() != null && v.getReseauAssocie().getCapacite() > 100) {
                System.out.println("VLAN critique détecté : ");
                System.out.println("VLAN " + v.getId() + " - " + v.getNom() + " - " + v.getReseauAssocie().getCapacite() + " hôtes");
            }
        }
    }

    // Pour le point 15 : Trouver la plus grande capacité
    public void afficherVLANPlusGrand() {
        if (vlans.isEmpty()) return;
        VLAN plusGrand = vlans.get(0);
        for (VLAN v : vlans) {
            if (v.getReseauAssocie().getCapacite() > plusGrand.getReseauAssocie().getCapacite()) {
                plusGrand = v;
            }
        }
        System.out.println("VLAN possédant la plus grande capacité : " + plusGrand.getNom() + " (" + plusGrand.getReseauAssocie().getCapacite() + " hôtes)");
    }

    public int getNombreTotalVLANs() {
        return vlans.size();
    }
}