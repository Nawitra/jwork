import java.util.ArrayList;

/**
 * Write a description of class DatabaseBonus here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */
public class DatabaseBonus
{
    private static final ArrayList<Bonus> BONUS_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Bonus getBonusById(int id) {
        Bonus dummy = null;
        for(int i = 0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getId() == id) {
                dummy = BONUS_DATABASE.get(i);
            }
        }
        return null;
    }

    public static Bonus getBonusByReferralCode(String referralCode) {
        Bonus dummy = null;
        for(int i = 0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getReferralCode() == referralCode) {
                dummy = BONUS_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addBonus(Bonus bonus) {
        for(int i = 0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getReferralCode() != "") {
                return false;
            }
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    public static boolean activateBonus(int id) {
        for(int i = 0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(true);
                return true;
            }
        }
        return false;
    }

    public static boolean deactivateBonus(int id) {
        for(int i = 0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(false);
                return true;
            }
        }
        return false;
    }

    public static boolean removeBonus(int id) {
        for(int i = 0; i < BONUS_DATABASE.size(); i++) {
            if(BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }
}
