package ipplanmanager;

public class ResultatVLSM {
    private String nomBesoin;
    private String adresseReseau; // Vérifie bien le nom ici
    private int cidr;
    private int capacite;

    public ResultatVLSM(String nomBesoin, String adresseReseau, int cidr, int capacite) {
        this.nomBesoin = nomBesoin;
        this.adresseReseau = adresseReseau;
        this.cidr = cidr;
        this.capacite = capacite;
    }

    // Ces noms doivent correspondre à ce que le Validateur utilise
    public String getNomBesoin() { return nomBesoin; }
    public String getAdresse() { return adresseReseau; } // On l'appelle getAdresse() pour le validateur
    public int getCidr() { return cidr; }
    public int getCapacite() { return capacite; }
}