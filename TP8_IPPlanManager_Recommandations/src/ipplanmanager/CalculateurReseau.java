package ipplanmanager;

public class CalculateurReseau {

    // Méthode manquante qui causait l'erreur (Point 16 du Main)
    public static int calculerCidrPourHotes(int nombreHotes) {
        // +2 pour l'adresse réseau et le broadcast
        int totalNecessaire = nombreHotes + 2;
        int bitsHotes = (int) Math.ceil(Math.log(totalNecessaire) / Math.log(2));
        return 32 - bitsHotes;
    }

    public static int calculerNombreHotes(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }

    public static int calculerTailleBloc(int cidr) {
        return (int) Math.pow(2, 32 - cidr);
    }

    public static int convertirIpEnEntier(String ip) {
        String[] segments = ip.split("\\.");
        int resultat = 0;
        for (int i = 0; i < 4; i++) {
            resultat |= (Integer.parseInt(segments[i]) << (24 - (8 * i)));
        }
        return resultat;
    }

    public static String convertirEntierEnIp(int ipInt) {
        return ((ipInt >> 24) & 0xFF) + "." +
               ((ipInt >> 16) & 0xFF) + "." +
               ((ipInt >> 8) & 0xFF) + "." +
               (ipInt & 0xFF);
    }

    public static String obtenirMasqueDecimal(int cidr) {
        int mask = (cidr == 0) ? 0 : 0xffffffff << (32 - cidr);
        return convertirEntierEnIp(mask);
    }
}