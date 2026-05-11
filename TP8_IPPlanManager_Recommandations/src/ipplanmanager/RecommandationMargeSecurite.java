package ipplanmanager;

public class RecommandationMargeSecurite implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getReseauAssocie() != null) {
            int capacite = vlan.getReseauAssocie().getCapacite();
            // Si le réseau est petit (ex: moins de 10 hôtes libres), on alerte
            if (capacite < 10) {
                return new Recommandation(
                    "Marge de sécurité faible",
                    "MOYENNE",
                    "Le VLAN " + vlan.getNom() + " a une capacité très limitée. Attention aux futures extensions."
                );
            }
        }
        return null;
    }
}