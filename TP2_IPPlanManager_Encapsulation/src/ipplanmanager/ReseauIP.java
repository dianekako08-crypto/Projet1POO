package ipplanmanager;

public class ReseauIP {
    private String adresseReseau;
    private int masqueCidr;
    private String description;

    public ReseauIP(String adresseReseau, int masqueCidr, String description) {
        setAdresseReseau(adresseReseau);
        setMasqueCidr(masqueCidr);
        setDescription(description);
    }

    public String getAdresseReseau() {
        return adresseReseau;
    }

    public void setAdresseReseau(String adresseReseau) {
        if (adresseReseau == null || adresseReseau.isEmpty()) {
            System.out.println("Adresse réseau invalide.");
            this.adresseReseau = "0.0.0.0";
        } else {
            this.adresseReseau = adresseReseau;
        }
    }

    public int getMasqueCidr() {
        return masqueCidr;
    }

    public void setMasqueCidr(int masqueCidr) {
        // La correction est ici : on enlève l'accolade qui fermait la méthode trop tôt
        if (masqueCidr < 0 || masqueCidr > 32) {
            System.out.println("Masque CIDR invalide.");
            this.masqueCidr = 24;
        } else {
            this.masqueCidr = masqueCidr;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            this.description = "Aucune description";
        } else {
            this.description = description;
        }
    }

    // N'oublie pas d'ajouter la méthode afficher() pour que le Main puisse l'utiliser !
    public void afficher() {
        System.out.println("Réseau : " + adresseReseau + " / " + masqueCidr);
        System.out.println("Description : " + description);
    }
}