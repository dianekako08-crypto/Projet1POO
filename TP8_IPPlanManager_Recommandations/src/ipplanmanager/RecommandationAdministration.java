package ipplanmanager;

public class RecommandationAdministration implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        String nom = vlan.getNom().toUpperCase();
        if (nom.contains("ADMIN") || nom.contains("ADMINISTRATION")) {
            return new Recommandation(
                "Sécurité Administration",
                "CRITIQUE",
                "Le VLAN " + vlan.getNom() + " contient des flux de gestion. L'accès doit être restreint aux administrateurs réseau via des ACLs strictes."
            );
        }
        return null;
    }
}