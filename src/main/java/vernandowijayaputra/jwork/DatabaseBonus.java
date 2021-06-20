package vernandowijayaputra.jwork;

import java.util.ArrayList;

/**
 * Class ini menyimpan semua objek dari Bonus yang dibuat
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */
public class DatabaseBonus {
    private static final ArrayList<Bonus> BONUS_DATABASE = new ArrayList<>();
    private static int lastId = 0;

    /**
     * Method ini digunakan untuk mendapatkan database bonus
     *
     * @return semua entry dari database bonus
     */
    public static ArrayList<Bonus> getBonusDatabase() {
        return BONUS_DATABASE;
    }

    /**
     * Method ini digunakan untuk mendapatkan id terakhir dari database bonus
     *
     * @return lastId yang merupakan id terakhir
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method ini digunakan untuk mendapatkan bonus berdasarkan id yang diberikan
     *
     * @param id sebagai id acuan untuk mendapatkan bonus
     * @return objek bonus
     * @throws BonusNotFoundException apabila bonus tidak ada di database
     */
    public static Bonus getBonusById(int id) throws BonusNotFoundException {
        Bonus dummy = null;
        try {
            for (int i = 0; i < BONUS_DATABASE.size(); i++) {
                if (BONUS_DATABASE.get(i).getId() == id) {
                    dummy = BONUS_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new BonusNotFoundException(id);
        }
        throw new BonusNotFoundException(id);
    }

    /**
     * Method ini digunakan untuk mendapatkan bonus berdasarkan referral code yang diberikan
     *
     * @param referralCode sebagai variable yang menampung referral code
     * @return objek bonus
     */
    public static Bonus getBonusByReferralCode(String referralCode) {
        Bonus dummy = null;
        for (int i = 0; i < BONUS_DATABASE.size(); i++) {
            if (BONUS_DATABASE.get(i).getReferralCode().equals(referralCode)) {
                dummy = BONUS_DATABASE.get(i);
            }
        }
        return dummy;
    }

    /**
     * Method ini digunakan untuk menambahkan bonus ke dalam database
     *
     * @param bonus sebagai objek bonus yang ingin ditambahkan ke dalam database
     * @return true apabila berhasil
     * @throws ReferralCodeAlreadyExistsException apabila referral code sudah ada di database
     */
    public static boolean addBonus(Bonus bonus) throws ReferralCodeAlreadyExistsException {
        try {
            for (int i = 0; i < BONUS_DATABASE.size(); i++) {
                if (BONUS_DATABASE.get(i).getReferralCode() == bonus.getReferralCode()) {
                    throw new ReferralCodeAlreadyExistsException(bonus);
                }
            }
        } catch (Exception error) {
            throw new ReferralCodeAlreadyExistsException(bonus);
        }
        BONUS_DATABASE.add(bonus);
        lastId = bonus.getId();
        return true;
    }

    /**
     * Method ini digunakan untuk mengubah parameter active dari bonus menjadi true
     *
     * @param id sebagai id dari bonus yang parameternya ingin diubah
     * @return true apabila berhasil, false apabila gagal
     */
    public static boolean activateBonus(int id) {
        for (int i = 0; i < BONUS_DATABASE.size(); i++) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Method ini digunakan untuk mengubah parameter active dari bonus menjadi false
     *
     * @param id sebagai id dari bonus yang parameternya ingin diubah
     * @return true apabila berhasil, false apabila gagal
     */
    public static boolean deactivateBonus(int id) {
        for (int i = 0; i < BONUS_DATABASE.size(); i++) {
            if (BONUS_DATABASE.get(i).getId() == id) {
                BONUS_DATABASE.get(i).setActive(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Method ini digunakan untuk menghapuskan suatu bonus dari database
     *
     * @param id dari bonus yang ingin dihapus
     * @return true apabila berhasil
     * @throws BonusNotFoundException apabila bonus tidak ada di database
     */
    public static boolean removeBonus(int id) throws BonusNotFoundException {
        try {
            for (int i = 0; i < BONUS_DATABASE.size(); i++) {
                if (BONUS_DATABASE.get(i).getId() == id) {
                    BONUS_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new BonusNotFoundException(id);
        }
        throw new BonusNotFoundException(id);
    }
}
