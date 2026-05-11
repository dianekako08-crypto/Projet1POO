package ipplanmanager;

public class InterfaceReseau {
    private String nom;
    private AdresseIP adresseIP;

    public InterfaceReseau(String nom, AdresseIP adresseIP) {
        this.nom = nom;
        this.adresseIP = adresseIP;
    }

    // Méthode d'affichage utilisée par Equipement
    public void afficher() {
        System.out.println("  Interface : " + nom);
        if (adresseIP != null) {
            adresseIP.afficher(); // On suppose que AdresseIP a une méthode afficher()
        }
    }

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public AdresseIP getAdresseIP() { return adresseIP; }
    public void setAdresseIP(AdresseIP adresseIP) { this.adresseIP = adresseIP; }
}
