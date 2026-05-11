package ipplanmanager;

public class ReseauIP {
    private String adresseReseau;
    private int masqueCidr;
    private String description;

    public ReseauIP(String adresseReseau, int masqueCidr, String description) {
        this.adresseReseau = adresseReseau;
        this.masqueCidr = masqueCidr;
        this.description = description;
    }

    public void afficher() {
        System.out.println("Réseau : " + adresseReseau + " /" + masqueCidr);
        System.out.println("Description : " + description);
        
        // Appels sécurisés aux méthodes statiques
        System.out.println("Classe réseau : " + CalculateurReseau.obtenirClasseReseau(adresseReseau));
        System.out.println("Masque décimal : " + CalculateurReseau.obtenirMasqueDecimal(masqueCidr));
        System.out.println("Capacité maximale : " + CalculateurReseau.calculerNombreHotes(masqueCidr) + " hôtes");
        
        if (CalculateurReseau.estReseauPrive(adresseReseau)) {
            System.out.println("Type : Réseau Privé");
        } else {
            System.out.println("Type : Réseau Public");
        }
    }
}