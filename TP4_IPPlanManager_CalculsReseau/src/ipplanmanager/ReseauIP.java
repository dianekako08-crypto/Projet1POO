package ipplanmanager;

public class ReseauIP {
    private String adresseReseau;
    private int masqueCidr;
    private String description;

    // Constructeur complet (utilisé dans ton TP3)
    public ReseauIP(String adresseReseau, int masqueCidr, String description) {
        this.adresseReseau = adresseReseau;
        this.masqueCidr = masqueCidr;
        this.description = description;
    }

    // Getters et Setters (Bonne pratique d'encapsulation du TP2)
    public String getAdresseReseau() { return adresseReseau; }
    public void setAdresseReseau(String adresseReseau) { this.adresseReseau = adresseReseau; }

    public int getMasqueCidr() { return masqueCidr; }
    public void setMasqueCidr(int masqueCidr) { this.masqueCidr = masqueCidr; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    // MÉTHODE AFFICHER MISE À JOUR (TP4)
    public void afficher() {
        System.out.println("Réseau : " + adresseReseau + " /" + masqueCidr);
        System.out.println("Description : " + description);
        
        // Appels aux méthodes statiques du CalculateurReseau
        System.out.println("Classe réseau : " + CalculateurReseau.obtenirClasseReseau(adresseReseau));
        System.out.println("Masque décimal : " + CalculateurReseau.obtenirMasqueDecimal(masqueCidr));
        System.out.println("Capacité maximale : " + CalculateurReseau.calculerNombreHotes(masqueCidr) + " hôtes");
        
        // Test si le réseau est privé (Travail supplémentaire Point 15)
        if (CalculateurReseau.estReseauPrive(adresseReseau)) {
            System.out.println("Type : Réseau Privé");
        } else {
            System.out.println("Type : Réseau Public");
        }
    }
}
