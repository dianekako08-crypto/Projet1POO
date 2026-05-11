package ipplanmanager;

public class CalculateurReseau {

    // Calcule le nombre d'hôtes utilisables : 2^(32-CIDR) - 2 [cite: 81, 86]
    public static int calculerNombreHotes(int cidr) {
        if (cidr < 0 || cidr > 32) return 0;
        int bitsHotes = 32 - cidr;
        return (int) Math.pow(2, bitsHotes) - 2; // [cite: 113, 178]
    }

    // Détermine la classe A, B ou C selon le premier octet [cite: 183]
    public static String obtenirClasseReseau(String adresseIP) {
        String[] parties = adresseIP.split("\\."); // [cite: 184]
        int premierOctet = Integer.parseInt(parties[0]);
        
        if (premierOctet >= 1 && premierOctet <= 126) return "Classe A"; // [cite: 126]
        if (premierOctet >= 128 && premierOctet <= 191) return "Classe B"; // [cite: 133]
        if (premierOctet >= 192 && premierOctet <= 223) return "Classe C"; // [cite: 136]
        return "Classe inconnue";
    }

    // Convertit le CIDR en format décimal pointé [cite: 195]
    public static String obtenirMasqueDecimal(int cidr) {
        switch (cidr) {
            case 8: return "255.0.0.0";
            case 16: return "255.255.0.0";
            case 24: return "255.255.255.0";
            default: return "Masque non disponible";
        }
    }

    // TRAVAIL SUPPLÉMENTAIRE : Détection des réseaux privés [cite: 330, 331]
    public static boolean estReseauPrive(String adresseIP) {
        String[] parties = adresseIP.split("\\.");
        int oct1 = Integer.parseInt(parties[0]);
        int oct2 = Integer.parseInt(parties[1]);
        
        // Plages privées : 10.x, 172.16-31.x, 192.168.x [cite: 331]
        if (oct1 == 10) return true;
        if (oct1 == 172 && (oct2 >= 16 && oct2 <= 31)) return true;
        if (oct1 == 192 && oct2 == 168) return true;
        
        return false;
    }
}