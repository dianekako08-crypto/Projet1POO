package ipplanmanager;

public class VLAN {
    private int id;
    private String nom;
    private ResultatVLSM reseauAssocie;

    public VLAN(int id, String nom, ResultatVLSM reseauAssocie, String description) {
        this.id = id;
        this.nom = nom;
        this.reseauAssocie = reseauAssocie;
    }

    public String getNom() { return nom; }
    public ResultatVLSM getReseauAssocie() { return reseauAssocie; }
    public int getId() { return id; }
}