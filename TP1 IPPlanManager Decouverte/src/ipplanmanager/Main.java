package ipplanmanager;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== IPPlan-Manager: TP1 (Version Finale) =====");
        System.out.println("Découverte des premières classes du projet");
        System.out.println("===============================");

        // --- 1. RÉSEAUX ---
        ReseauIP reseauPrincipal = new ReseauIP("192.168.1.0", 24, "Réseau principal du laboratoire IRT");
        ReseauIP reseauAdmin = new ReseauIP("10.0.0.0", 8, "Réseau Administration"); // Deuxième réseau demandé

        // --- 2. ADRESSES IP ---
        AdresseIP ipRouteur = new AdresseIP("192.168.1.1");
        AdresseIP ipServeur = new AdresseIP("192.168.1.10");
        AdresseIP ipClient = new AdresseIP("192.168.1.50");
        AdresseIP ipSwitch = new AdresseIP("192.168.1.2");   // Nouveau
        AdresseIP ipAP = new AdresseIP("192.168.1.3");       // Nouveau

        // --- 3. INTERFACES RÉSEAU ---
        InterfaceReseau interfaceRouteur = new InterfaceReseau("eth0", ipRouteur);
        InterfaceReseau interfaceServeur = new InterfaceReseau("eth0", ipServeur);
        InterfaceReseau interfaceClient = new InterfaceReseau("wlan0", ipClient);
        InterfaceReseau interfaceSwitch = new InterfaceReseau("vlan1", ipSwitch); // Nouveau
        InterfaceReseau interfaceAP = new InterfaceReseau("wlan0", ipAP);         // Nouveau

        // Activation
        interfaceRouteur.activer();
        interfaceServeur.activer();
        interfaceSwitch.activer();
        interfaceAP.activer();
        // Note : interfaceClient reste inactive pour le test d'affichage

        // --- CAS PARTICULIER : Interface sans adresse IP (null) ---
        InterfaceReseau interfaceVide = new InterfaceReseau("eth2", null);
        interfaceVide.activer();

        // --- 4. ÉQUIPEMENTS ---
        Equipement routeur = new Equipement("R1 EDGE", "Routeur", interfaceRouteur);
        Equipement serveur = new Equipement("SRV DNS", "Serveur", interfaceServeur);
        Equipement client = new Equipement("PC_ADMIN", "Poste client", interfaceClient);
        Equipement switchPrincipal = new Equipement("SW-CORE", "Switch", interfaceSwitch);
        Equipement borneWifi = new Equipement("AP-LABO", "Point d'accès WiFi", interfaceAP);
        Equipement pcTest = new Equipement("EQ-SANS-IP", "Test", interfaceVide);

        // --- 5. AFFICHAGE DES RÉSULTATS ---
        System.out.println("\n----- LISTE DES RÉSEAUX -----");
        reseauPrincipal.afficher();
        reseauAdmin.afficher();

        System.out.println("\n----- LISTE DES ÉQUIPEMENTS -----");
        routeur.afficher();
        System.out.println();
        serveur.afficher();
        System.out.println();
        client.afficher();
        System.out.println();
        switchPrincipal.afficher();
        System.out.println();
        borneWifi.afficher();
        System.out.println();
        pcTest.afficher(); // Test de l'interface sans IP
    }
}