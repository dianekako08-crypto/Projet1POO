package ipplanmanager;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== TP2 : Encapsulation et Travail Supplémentaire =====");

        // --- SECTION 14 : Travail supplémentaire (estAdresseLocale) ---
        System.out.println("--- Test de la méthode estAdresseLocale() ---");
        AdresseIP ip1 = new AdresseIP("192.168.1.1");
        AdresseIP ip2 = new AdresseIP("8.8.8.8");
        AdresseIP ipVide = new AdresseIP(""); // Cas invalide

        System.out.println(ip1.getValeur() + " est locale ? " + ip1.estAdresseLocale()); // Doit afficher true
        System.out.println(ip2.getValeur() + " est locale ? " + ip2.estAdresseLocale()); // Doit afficher false
        System.out.println(ipVide.getValeur() + " est locale ? " + ipVide.estAdresseLocale()); // Doit afficher false (0.0.0.0)

        // --- SECTION 13 : Ajout de plusieurs équipements et cas invalides ---
        InterfaceReseau interface1 = new InterfaceReseau("eth0", ip1);
        interface1.activer();

        // Équipement 1 : Routeur (Cas normal)
        Equipement routeur = new Equipement("R1_EDGE", "Routeur", interface1);

        // Équipement 2 : Serveur (Cas nom vide et type vide)
        Equipement serveur = new Equipement("", "", new InterfaceReseau("", ipVide));

        // Équipement 3 : Switch (Nouvel équipement ajouté)
        InterfaceReseau interfaceSwitch = new InterfaceReseau("vlan1", new AdresseIP("192.168.1.2"));
        Equipement switchEtage = new Equipement("SW-ETAGE-1", "Switch", interfaceSwitch);

        // --- SECTION 13 : Modification avec les setters ---
        System.out.println("\n--- Test des modifications (Setters) ---");
        System.out.println("Ancien nom du serveur : [" + serveur.getNom() + "]");
        serveur.setNom("SRV-DATA-PROD"); // On corrige le nom vide via le setter
        System.out.println("Nouveau nom du serveur : " + serveur.getNom());

        // Test validation du masque CIDR (Cas invalide 55)
        ReseauIP reseau2 = new ReseauIP("", 55, "");

        // --- AFFICHAGE FINAL ---
        System.out.println("\n===== AFFICHAGE DES RÉSULTATS FINAUX =====");
        
        System.out.println("\n----- Réseau Invalide (Corrigé par le code) -----");
        reseau2.afficher();

        System.out.println("\n----- Équipement 1 (Normal) -----");
        routeur.afficher();

        System.out.println("\n----- Équipement 2 (Nom corrigé par setter) -----");
        serveur.afficher();

        System.out.println("\n----- Équipement 3 (Nouvel équipement) -----");
        switchEtage.afficher();
    }
}