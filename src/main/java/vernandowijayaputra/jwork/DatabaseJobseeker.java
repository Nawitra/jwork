package vernandowijayaputra.jwork;

import javax.sql.rowset.JoinRowSet;
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

    public static ArrayList<Jobseeker> getJobseekerDatabase() {
        return JOBSEEKER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

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
