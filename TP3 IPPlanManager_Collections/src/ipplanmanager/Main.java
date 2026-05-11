package ipplanmanager;

public class Main {
    public static void main(String[] args) {
        InfrastructureReseau infra = new InfrastructureReseau("Réseau IUT Bandjoun");

        // 1. Création des 3 sous-réseaux + 1 WiFi (Point 14)
        SousReseau admin = new SousReseau("ADMIN", new ReseauIP("192.168.1.0", 24, "Réseau Admin"));
        SousReseau tech = new SousReseau("TECH", new ReseauIP("192.168.2.0", 24, "Réseau Technique"));
        SousReseau wifi = new SousReseau("WIFI_PUBLIC", new ReseauIP("10.0.0.0", 8, "Accès WiFi"));
        
        infra.ajouterSousReseau(admin);
        infra.ajouterSousReseau(tech);
        infra.ajouterSousReseau(wifi);

        // 2. Ajout du Serveur et du Switch (plusieurs interfaces)
        Equipement srv = new Equipement("SRV-PROD", "Serveur");
        srv.ajouterInterface(new InterfaceReseau("eth0", new AdresseIP("192.168.1.10")));
        srv.ajouterInterface(new InterfaceReseau("eth1", new AdresseIP("192.168.2.10")));
        infra.ajouterEquipement(srv);

        Equipement sw = new Equipement("SW-CORE", "Switch");
        sw.ajouterInterface(new InterfaceReseau("VLAN1", new AdresseIP("192.168.1.254")));
        sw.ajouterInterface(new InterfaceReseau("VLAN2", new AdresseIP("192.168.2.254")));
        infra.ajouterEquipement(sw);

        // 3. Ajout de 5 équipements supplémentaires avec plusieurs interfaces
        String[] noms = {"PC-Diane", "PC-Labo", "Smart-Dir", "Tab-Etudiant", "Imprimante"};
        for (int i = 0; i < noms.length; i++) {
            Equipement eq = new Equipement(noms[i], "Client");
            eq.ajouterInterface(new InterfaceReseau("Ethernet", new AdresseIP("192.168.1." + (20+i))));
            eq.ajouterInterface(new InterfaceReseau("WiFi", new AdresseIP("10.0.0." + (20+i))));
            infra.ajouterEquipement(eq);
        }

        // 4. Affichage général
        infra.afficher();

        // 5. TEST DE LA RECHERCHE (Point 15)
        System.out.println("\n=== TESTS DE RECHERCHE ===");
        infra.rechercherEquipement("SRV-PROD"); // Cas positif
        infra.rechercherEquipement("PC-Inconnu"); // Cas négatif
    }
}