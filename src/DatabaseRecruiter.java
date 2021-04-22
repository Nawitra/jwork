import java.util.ArrayList;

/**
 * Kelas untuk menampung list perekrut.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.20
 */
public class DatabaseRecruiter
{
    private static final ArrayList<Recruiter> RECRUITER_DATABASE = new ArrayList<Recruiter>();
    private static int lastId = 0;

    public static ArrayList<Recruiter> getRecruiterDatabase() {
        return RECRUITER_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Recruiter getRecruiterById(int id) {
        for(int i = 0; i < RECRUITER_DATABASE.size(); i++) {
            if(RECRUITER_DATABASE.get(i).getId() == id) {
                return RECRUITER_DATABASE.get(i);
            }
        }
        return null;
    }

    public static boolean addRecruiter(Recruiter recruiter) {
        RECRUITER_DATABASE.add(recruiter);
        lastId = recruiter.getId();
        return true;
    }

    public static boolean removeRecruiter(int id) {
        for(int i = 0; i < RECRUITER_DATABASE.size(); i++) {
            if(RECRUITER_DATABASE.get(i).getId() == id) {
                RECRUITER_DATABASE.remove(i);
                return true;
            }
        }
        return false;
    }

}
