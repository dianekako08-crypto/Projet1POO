package ipplanmanager;
import java.util.ArrayList;

public class GestionnaireVLAN {
    // La liste doit être initialisée UNE SEULE FOIS ici
    private final ArrayList<VLAN> vlans = new ArrayList<>();

    public void ajouterVLAN(VLAN vlan) throws Exception {
        if (vlan == null) return;
        this.vlans.add(vlan);
    }

    public ArrayList<VLAN> getVlans() {
        return this.vlans;
    }
}