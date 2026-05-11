package ipplanmanager;

public class VLAN {
    private int id;
    private String nom;
    private ResultatVLSM reseauAssocie;
    private String description;

    public VLAN(int id, String nom, ResultatVLSM reseauAssocie, String description) {
        this.id = id;
        this.nom = nom;
        this.reseauAssocie = reseauAssocie;
        this.description = description;
    }

    // AJOUTE CES DEUX MÉTHODES :
    public int getId() { return id; }
    public String getNom() { return nom; }
    
    public void afficher() {
        System.out.println("VLAN ID : " + id);
        System.out.println("Nom : " + nom);
        System.out.println("Description : " + description);
        if (reseauAssocie != null) {
            reseauAssocie.afficher();
        }
    }
}