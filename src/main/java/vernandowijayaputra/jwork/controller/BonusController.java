package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.Bonus;
import vernandowijayaputra.jwork.DatabaseBonusPostgre;
import vernandowijayaputra.jwork.ReferralCodeAlreadyExistsException;

import java.util.ArrayList;

/**
 * Class yang digunakan untuk menangani methods yang berkaitan dengan bonus
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
@RequestMapping("/bonus")
@RestController
public class BonusController {
    /**
     * Method yang digunakan untuk mendapatkan database bonus
     *
     * @return Semua entry pada database bonus
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Bonus> getAllBonus() {
        return DatabaseBonusPostgre.getBonusDatabase();
    }

    /**
     * Method yang digunakan untuk mendapatkan bonus yang ditunjuk oleh referral code
     *
     * @param referralCode sebagai acuan untuk mendapatkan bonus
     * @return objek bonus
     */
    @RequestMapping(value = "/{referralCode}", method = RequestMethod.GET)
    public Bonus getBonusByReferralCode(@PathVariable(value = "referralCode") String referralCode) {
        return DatabaseBonusPostgre.getBonusByReferralCode(referralCode);
    }

    /**
     * Method yang digunakan untuk membuat bonus baru dan memasukkannya ke dalam database
     *
     * @param referralCode merupakan variable yang menyimpan referral code
     * @param extraFee merupakan variable yang menyimpan extra fee
     * @param minTotalFee merupakan variable yang menyimpan min total fee
     * @param active merupakan variable yang menyimpan status aktif
     * @return objek bonus yang telah dibuat dan dimasukkan ke dalam database
     * @throws ReferralCodeAlreadyExistsException
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Bonus addBonus(
            @RequestParam(value = "referralCode") String referralCode,
            @RequestParam(value = "extraFee") int extraFee,
            @RequestParam(value = "minTotalFee") int minTotalFee,
            @RequestParam(value = "active") boolean active

    ) throws ReferralCodeAlreadyExistsException {
        Bonus bonus = new Bonus(DatabaseBonusPostgre.getLastBonusId() + 1,
                referralCode, extraFee, minTotalFee, active);
        DatabaseBonusPostgre.insertBonus(bonus);
        return bonus;
    }
}
