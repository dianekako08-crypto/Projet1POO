package ipplanmanager;
import java.util.ArrayList;

public class ValidateurPlanAdressage {

    // Détection de chevauchement (Point 17.2)
    public static void verifierChevauchement(ResultatVLSM r1, ResultatVLSM r2) throws ChevauchementReseauException {
        int debut1 = CalculateurReseau.convertirIpEnEntier(r1.getAdresse());
        int fin1 = CalculateurReseau.calculerAdresseFin(r1.getAdresse(), r1.getCidr());

        int debut2 = CalculateurReseau.convertirIpEnEntier(r2.getAdresse());
        int fin2 = CalculateurReseau.calculerAdresseFin(r2.getAdresse(), r2.getCidr());

        // Logique mathématique de chevauchement
        if (debut1 <= fin2 && debut2 <= fin1) {
            throw new ChevauchementReseauException("Le réseau " + r1.getNomBesoin() + " chevauche " + r2.getNomBesoin());
        }
    }

    // Détection de conflit VLAN (Point 17.3)
    public static void verifierConflitsVLAN(ArrayList<VLAN> vlans) throws ConflitVLANException {
        for (int i = 0; i < vlans.size(); i++) {
            for (int j = i + 1; j < vlans.size(); j++) {
                if (vlans.get(i).getId() == vlans.get(j).getId()) {
                    throw new ConflitVLANException("L'identifiant VLAN " + vlans.get(i).getId() + " est déjà utilisé.");
                }
            }
        }
    }
}