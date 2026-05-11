package ipplanmanager;

public class ResultatVLSM {
    private String nom;
    private String adresse;
    private int cidr;
    private int capacite;

    public ResultatVLSM(String nom, String adresse, int cidr, int capacite) {
        this.nom = nom;
        this.adresse = adresse;
        this.cidr = cidr;
        this.capacite = capacite;
    }

    public String getNomBesoin() { return nom; }
    public int getCapacite() { return capacite; }

    public void afficher() {
        // Formate l'affichage : NOM -> IP/CIDR | Masque | Capacité
        String masque = CalculateurReseau.obtenirMasqueDecimal(cidr);
        System.out.println(nom + " -> " + adresse + "/" + cidr + 
                           " | Masque : " + masque + 
                           " | Capacité : " + capacite + " hôtes");
    }
}
