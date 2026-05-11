package ipplanmanager;

public class ResultatVLSM {
    private String nom;
    private String adresseReseau;
    private int cidr;
    private int capacite;
    private String premiereAdresseUtilisable;
    private String derniereAdresseUtilisable;

    public ResultatVLSM(String nom, String adresseReseau, int cidr, int capacite) {
        this.nom = nom;
        this.adresseReseau = adresseReseau;
        this.cidr = cidr;
        this.capacite = capacite;
        // Calcul automatique des plages dès la création du résultat
        this.premiereAdresseUtilisable = CalculateurReseau.calculerPremiereAdresseUtilisable(adresseReseau);
        this.derniereAdresseUtilisable = CalculateurReseau.calculerDerniereAdresseUtilisable(adresseReseau, cidr);
    }

    public void afficher() {
        System.out.println(nom + " -> " + adresseReseau + "/" + cidr + 
            " | Plage : " + premiereAdresseUtilisable + " - " + derniereAdresseUtilisable + 
            " | Capacité : " + capacite + " hôtes");
    }
}