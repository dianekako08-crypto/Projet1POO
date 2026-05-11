package ipplanmanager;

public class RecommandationWifiInvite implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("WIFI")) {
            return new Recommandation(
                "Isolation du WiFi",
                "ÉLEVÉE",
                "Le VLAN " + vlan.getNom() + " doit être isolé des réseaux internes sensibles."
            );
        }
        return null;
    }
}