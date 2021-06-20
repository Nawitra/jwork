package vernandowijayaputra.jwork;

import java.util.ArrayList;

/**
 * Class yang akan menampung list dari pencari pekerjaan.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.25
 */
public class DatabaseJobseeker {
    private static final ArrayList<Jobseeker> JOBSEEKER_DATABASE = new ArrayList<Jobseeker>();
    private static int lastId = 0;

    /**
     * Method yang digunakan untuk mendapatkan database jobseeker
     *
     * @return semua entry dari dataabase jobseeker
     */
    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        return JOBSEEKER_DATABASE;
    }

    /**
     * Method yang digunakan untuk mendapatkan id terakhir dari database jobseeker
     *
     * @return lastId sebagai id terakhir
     */
    public static int getLastId() {
        return lastId;
    }

    /**
     * Method yang digunakan untuk mendapatkan jobseeker berdasarkan id yang diberikan
     *
     * @param id merupakan id acuan untuk mendapatkan objek jobseeker
     * @return objek jobseeker apabila berhasil
     * @throws JobSeekerNotFoundException
     */
    public static Jobseeker getJobseekerById(int id) throws JobSeekerNotFoundException {
        Jobseeker dummy = null;
        try {
            for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
                if (JOBSEEKER_DATABASE.get(i).getId() == id) {
                    dummy = JOBSEEKER_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new JobSeekerNotFoundException(id);
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * Method yang digunakan untuk menambahkan objek jobseeker baru ke dalam database
     *
     * @param jobseeker sebagai objek jobseeker yang ingin ditambahkan
     * @return true apabila berhasil
     * @throws EmailAlreadyExistsException
     */
    public static boolean addJobseeker(Jobseeker jobseeker) throws EmailAlreadyExistsException {
        try {
            for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
                if (JOBSEEKER_DATABASE.get(i).getEmail() == jobseeker.getEmail()) {
                    throw new EmailAlreadyExistsException(jobseeker);
                }
            }
        } catch (Exception error) {
            throw new EmailAlreadyExistsException(jobseeker);
        }

        JOBSEEKER_DATABASE.add(jobseeker);
        lastId = jobseeker.getId();
        return true;
    }

    /**
     * Method yang digunakan untuk menghapus suatu jobseeker dari database
     *
     * @param id sebagai id dari jobseeker yang ingin dihapus
     * @return true apabila berhasil
     * @throws JobSeekerNotFoundException
     */
    public static boolean removeJobseeker(int id) throws JobSeekerNotFoundException {
        try {
            for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
                if (JOBSEEKER_DATABASE.get(i).getId() == id) {
                    JOBSEEKER_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new JobSeekerNotFoundException(id);
        }
        throw new JobSeekerNotFoundException(id);
    }

    /**
     * Method yang digunakan untuk mendapatkan jobseeker yang digunakan untuk login
     *
     * @param email dari jobseeker
     * @param password dari jobseeker
     * @return objek jobseeker yang digunakan untuk login
     */
    public static Jobseeker getJobseekerLogin(String email, String password) {
        Jobseeker dummy = null;
        for (int i = 0; i < JOBSEEKER_DATABASE.size(); i++) {
            if (JOBSEEKER_DATABASE.get(i).getEmail().equals(email) &&
                    JOBSEEKER_DATABASE.get(i).getPassword().equals(password)) {
                dummy = JOBSEEKER_DATABASE.get(i);
                return dummy;
            }
        }
        return null;
    }
}
