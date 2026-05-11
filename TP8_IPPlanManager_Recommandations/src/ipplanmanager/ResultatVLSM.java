package ipplanmanager;

public class ResultatVLSM {
    private String nomBesoin;
    private String adresseReseau;
    private int cidr;
    private int capacite;
    private int besoinHotes; // Ajout pour le calcul de la marge

    public ResultatVLSM(String nomBesoin, String adresseReseau, int cidr, int capacite, int besoinHotes) {
        this.nomBesoin = nomBesoin;
        this.adresseReseau = adresseReseau;
        this.cidr = cidr;
        this.capacite = capacite;
        this.besoinHotes = besoinHotes;
    }

    public String getAdresse() { return adresseReseau; }
    public String getNomBesoin() { return nomBesoin; }
    public int getCidr() { return cidr; }
    public int getCapacite() { return capacite; }
    public int getBesoinHotes() { return besoinHotes; }
}