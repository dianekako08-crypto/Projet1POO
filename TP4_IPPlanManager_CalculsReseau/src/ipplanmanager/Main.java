package ipplanmanager;

public class Main {
    public static void main(String[] args) {
        InfrastructureReseau infra = new InfrastructureReseau("Test Complet Calculateur");

        // Test Classe C - Privé
        infra.ajouterSousReseau(new SousReseau("ADMIN", new ReseauIP("192.168.1.0", 24, "Réseau Local")));
        
        // Test Classe B - Privé
        infra.ajouterSousReseau(new SousReseau("DATA-CENTER", new ReseauIP("172.16.0.0", 16, "Serveurs Internes")));
        
        // Test Classe A - Privé
        infra.ajouterSousReseau(new SousReseau("WIFI-GUEST", new ReseauIP("10.0.0.0", 8, "WiFi Invités")));
        
        // Test Classe A - Public (DNS Google)
        infra.ajouterSousReseau(new SousReseau("GOOGLE-DNS", new ReseauIP("8.8.8.0", 24, "DNS Public")));

        // Affichage des résultats
        infra.afficher();
    }
}