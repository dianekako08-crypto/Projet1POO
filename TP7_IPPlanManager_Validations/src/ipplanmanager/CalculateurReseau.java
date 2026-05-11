package ipplanmanager;

public class CalculateurReseau {
    // 17.1 : Validation IP
    public static boolean estAdresseIPValide(String ip) {
        if (ip == null || !ip.matches("^(\\d{1,3}\\.){3}\\d{1,3}$")) return false;
        String[] segments = ip.split("\\.");
        for (String s : segments) {
            int val = Integer.parseInt(s);
            if (val < 0 || val > 255) return false;
        }
        return true;
    }

    public static int convertirIpEnEntier(String ip) {
        String[] parts = ip.split("\\.");
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res |= (Integer.parseInt(parts[i]) << (24 - (8 * i)));
        }
        return res;
    }

    public static String convertirEntierEnIp(int ipInt) {
        return ((ipInt >> 24) & 0xFF) + "." + ((ipInt >> 16) & 0xFF) + "." +
               ((ipInt >> 8) & 0xFF) + "." + (ipInt & 0xFF);
    }

    public static int calculerAdresseFin(String ip, int cidr) {
        int debut = convertirIpEnEntier(ip);
        int taille = (int) Math.pow(2, 32 - cidr);
        return debut + taille - 1;
    }

    public static int calculerNombreHotes(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }
}