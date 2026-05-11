package ipplanmanager;

public class CalculateurReseau {

    // Convertit une IP String en entier (Indispensable pour l'erreur image_cdd861.png)
    public static int convertirIpEnEntier(String ip) {
        String[] octets = ip.split("\\.");
        return (Integer.parseInt(octets[0]) << 24) | (Integer.parseInt(octets[1]) << 16) |
               (Integer.parseInt(octets[2]) << 8) | Integer.parseInt(octets[3]);
    }

    // Convertit un entier en format IP String
    public static String convertirEntierEnIp(int ipEntier) {
        return String.format("%d.%d.%d.%d", 
               (ipEntier >>> 24) & 0xFF, (ipEntier >>> 16) & 0xFF,
               (ipEntier >>> 8) & 0xFF, ipEntier & 0xFF);
    }

    // Calcule le CIDR nécessaire pour un nombre d'hôtes
    public static int calculerCidrPourHotes(int nbHotes) {
        for (int cidr = 30; cidr >= 0; cidr--) {
            if (Math.pow(2, 32 - cidr) - 2 >= nbHotes) return cidr;
        }
        return 32;
    }

    // Calcule la capacité réelle (2^(32-cidr) - 2)
    public static int calculerNombreHotes(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }

    // Retourne le masque décimal (Indispensable pour l'erreur image_cdd480.png)
    public static String obtenirMasqueDecimal(int cidr) {
        int masque = 0xFFFFFFFF << (32 - cidr);
        return convertirEntierEnIp(masque);
    }

    // Calcule la taille du bloc (ex: /26 -> 64)
    public static int calculerTailleBloc(int cidr) {
        return (int) Math.pow(2, 32 - cidr);
    }

    // Méthodes pour les adresses utilisables (Point 16 du TP)
    public static String calculerPremiereAdresseUtilisable(String adresseReseau) {
        return convertirEntierEnIp(convertirIpEnEntier(adresseReseau) + 1);
    }

    public static String calculerDerniereAdresseUtilisable(String adresseReseau, int cidr) {
        int ipInt = convertirIpEnEntier(adresseReseau);
        int broadcast = ipInt + (calculerTailleBloc(cidr) - 1);
        return convertirEntierEnIp(broadcast - 1);
    }
}