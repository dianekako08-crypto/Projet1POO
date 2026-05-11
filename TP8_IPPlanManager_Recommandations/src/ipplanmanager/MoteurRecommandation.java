package ipplanmanager;
import java.util.ArrayList;

public class MoteurRecommandation {
    private ArrayList<RegleRecommandation> regles;

    public MoteurRecommandation() {
        this.regles = new ArrayList<>();
    }

    public void ajouterRegle(RegleRecommandation regle) {
        this.regles.add(regle);
    }

    public ArrayList<Recommandation> analyserVLANs(ArrayList<VLAN> vlans) {
        ArrayList<Recommandation> recommandations = new ArrayList<>();
        for (VLAN vlan : vlans) {
            for (RegleRecommandation regle : regles) {
                Recommandation rec = regle.analyser(vlan);
                if (rec != null) {
                    recommandations.add(rec);
                }
            }
        }
        return recommandations;
    }

    public void afficherRecommandations(ArrayList<Recommandation> recommandations) {
        if (recommandations.isEmpty()) {
            System.out.println("Aucune recommandation particulière.");
            return;
        }
        for (Recommandation rec : recommandations) {
            rec.afficher();
        }
    }
}