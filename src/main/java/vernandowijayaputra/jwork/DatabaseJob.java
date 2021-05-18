package vernandowijayaputra.jwork;

import java.util.ArrayList;

/**
 * Class yang akan menampung list dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class DatabaseJob {
    private static final ArrayList<Job> JOB_DATABASE = new ArrayList<Job>();
    private static int lastId = 0;

    public static ArrayList<Job> getJobDatabase() {
        return JOB_DATABASE;
    }

    public static int getLastId() {
        return lastId;
    }

    public static Job getJobById(int id) throws JobNotFoundException {
        Job dummy = null;
        try {
            for (int i = 0; i < JOB_DATABASE.size(); i++) {
                if (JOB_DATABASE.get(i).getId() == id) {
                    dummy = JOB_DATABASE.get(i);
                    return dummy;
                }
            }
        } catch (Exception error) {
            throw new JobNotFoundException(id);
        }
        throw new JobNotFoundException(id);
    }

    public static ArrayList<Job> getJobByRecruiter(int recruiterId) {
        ArrayList<Job> dummy = new ArrayList<Job>();
        for (int i = 0; i < JOB_DATABASE.size(); i++) {
            if (JOB_DATABASE.get(i).getRecruiter().getId() == recruiterId) {
                dummy.add(JOB_DATABASE.get(i));
            }
        }
        return dummy;
    }

    public static ArrayList<Job> getJobByCategory(JobCategory category) {
        ArrayList<Job> dummy = new ArrayList<Job>();
        for (int i = 0; i < JOB_DATABASE.size(); i++) {
            if (JOB_DATABASE.get(i).getCategory() == category) {
                dummy.add(JOB_DATABASE.get(i));
            }
        }
        return dummy;
    }

    public static boolean addJob(Job job) {
        JOB_DATABASE.add(job);
        lastId = job.getId();
        return true;
    }

    public static boolean removeJob(int id) throws JobNotFoundException {
        try {
            for (int i = 0; i < JOB_DATABASE.size(); i++) {
                if (JOB_DATABASE.get(i).getId() == id) {
                    JOB_DATABASE.remove(i);
                    return true;
                }
            }
        } catch (Exception error) {
            throw new JobNotFoundException(id);
        }
        throw new JobNotFoundException(id);
    }
}
