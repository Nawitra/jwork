package vernandowijayaputra.jwork;

import java.util.ArrayList;

/**
 * Kelas untuk menampung list perekrut.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.20
 */
public class DatabaseRecruiter {
    private static final ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    /**
     * Method ini digunakan untuk mendapatkan database recruiter
     *
     * @return semua entry dari database recruiter
     */
    public static ArrayList<Recruiter> getRecruiterDatabase() {
        return RECRUITER_DATABASE;
    }

    /**
     * Method ini digunakan untuk mendapatkan id terakhir dari database recruiter
     *
     * @return lastId sebagai id terakhir
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method yang digunakan untuk mendapatkan recruiter berdasarkan id
     *
     * @param id sebagai acuan untuk mendapatkan recruiter
     * @return objek recruiter
     * @throws RecruiterNotFoundException
     */
    public static Recruiter getRecruiterById(int id) throws RecruiterNotFoundException {
        Recruiter dummy = null;
        try {
            for (int i = 0; i < RECRUITER_DATABASE.size(); i++) {
                if (RECRUITER_DATABASE.get(i).getId() == id) {
                    dummy = RECRUITER_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new RecruiterNotFoundException(id);
        }
        throw new RecruiterNotFoundException(id);
    }

    /**
     * Method yang digunakan untuk menambahkan recruiter baru ke dalam database recruiter
     *
     * @param recruiter sebagai objek yang akan ditambahkan
     * @return true apabila berhasil
     */
    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    /**
     * Method yang digunakan untuk menghapus suatu objek recruiter dari database
     *
     * @param id dari recruiter yang ingin dihapus
     * @return true apabila berhasil
     * @throws RecruiterNotFoundException
     */
    public static boolean removeRecruiter(int id) throws RecruiterNotFoundException {
        try {
            for (int i = 0; i < RECRUITER_DATABASE.size(); i++) {
                if (RECRUITER_DATABASE.get(i).getId() == id) {
                    RECRUITER_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new RecruiterNotFoundException(id);
        }
        throw new RecruiterNotFoundException(id);
    }

}
