package vernandowijayaputra.jwork;

/**
 * Class yang menangani exception apabila referral code telah ada
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
public class ReferralCodeAlreadyExistsException extends Exception {
    private Bonus referral_error;

    public ReferralCodeAlreadyExistsException(Bonus referral_input) {
        super("Referral Code: ");
        referral_error = referral_input;
    }

    /**
     * Method yang digunakan untuk menampilkan pesan error apabila exception terjadi
     *
     * @return pesan error
     */
    public String getMessage() {
        return super.getMessage() + referral_error.getReferralCode() + " already exists.";
    }
}