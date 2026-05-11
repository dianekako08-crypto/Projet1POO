package ipplanmanager;

import java.util.ArrayList;

public class InfrastructureReseau {
    private String nom;
    private ArrayList<Equipement> equipements;
    private ArrayList<SousReseau> sousReseaux;

    public InfrastructureReseau(String nom) {
        this.nom = nom;
        this.equipements = new ArrayList<>();
        this.sousReseaux = new ArrayList<>();
    }

    public void ajouterEquipement(Equipement equipement) {
        equipements.add(equipement);
    }

    public void ajouterSousReseau(SousReseau sousReseau) {
        sousReseaux.add(sousReseau);
    }

    // TRAVAIL SUPPLÉMENTAIRE (Point 15)
    public void rechercherEquipement(String nomRecherche) {
        boolean trouve = false;
        for (Equipement e : equipements) {
            if (e.getNom().equalsIgnoreCase(nomRecherche)) {
                System.out.println("\n>>> Équipement trouvé !");
                e.afficher();
                trouve = true;
                break; 
            }
        }
        if (!trouve) {
            System.out.println("\n>>> Équipement introuvable : " + nomRecherche);
        }
    }

    public void afficher() {
        System.out.println("Infrastructure : " + nom);
        System.out.println("\n===== SOUS-RÉSEAUX =====");
        for (SousReseau s : sousReseaux) {
            s.afficher();
            System.out.println("-----------------------");
        }
        System.out.println("\n===== ÉQUIPEMENTS =====");
        for (Equipement e : equipements) {
            e.afficher();
            System.out.println("-----------------------");
        }
    }
}