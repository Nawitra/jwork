import java.util.GregorianCalendar;

/**
 * Write a description of class JWork here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */

public class JWork
{
    public static void main(String[] args) {
        /*
        CS 6
         */
        Location locationCS6 = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Well Played",
                "wellplayed@test.com", "08123456789", locationCS6));

        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Vernando Wijaya Putra",
                "vernando.wijaya@ui.ac.id", "Randomperson123", 2021, 03, 4));

        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Vernando Wijaya Putra",
                "vernando.wijaya@ui.ac.id", "Randomperson456", 2021, 03, 4));

        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Ilham Mulya Rafid",
                "ilhamrafid@test.com", "Asisten123", 2021, 04, 4));

        System.out.println(DatabaseJobseeker.getJobseekerById(1));
        System.out.println("");
        System.out.println(DatabaseJobseeker.getJobseekerById(2));
        System.out.println("");
        System.out.println(DatabaseJobseeker.getJobseekerById(3));
        System.out.println("");

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "Junior Web UI Designer", DatabaseRecruiter.getRecruiterById(1), JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 400000,
                "Professional Mobile UI Designer", DatabaseRecruiter.getRecruiterById(1), JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "React Developer", DatabaseRecruiter.getRecruiterById(1), JobCategory.WebDeveloper));

        System.out.println(DatabaseJob.getJobByCategory(JobCategory.UI));
        System.out.println("");
        System.out.println(DatabaseJob.getJobByCategory(JobCategory.WebDeveloper));
    }
}
