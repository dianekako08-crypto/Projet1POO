package ipplanmanager;

public class RecommandationMargeAdresse implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getReseauAssocie() != null) {
            int capacite = vlan.getReseauAssocie().getCapacite();
            int besoinInitial = vlan.getReseauAssocie().getBesoinHotes(); // Assure-toi que ResultatVLSM stocke le besoin initial
            
            int marge = capacite - besoinInitial;

            // Si la marge est faible (moins de 10 hôtes libres)
            if (marge < 10) {
                return new Recommandation(
                    "Marge d'évolution faible",
                    "MOYENNE",
                    "Le VLAN " + vlan.getNom() + " n'a que " + marge + " adresses libres. Prévoyez un masque plus large si le nombre d'équipements augmente."
                );
            }
        }
        return null;
    }
}