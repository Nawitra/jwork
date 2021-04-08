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
         * CS 5
         */
        Jobseeker jobseekerCS51 = new Jobseeker(1, "Job Seek", "jobsee ker@test.com", "personthereafter", new GregorianCalendar(2021,8,12));
        Jobseeker jobseekerCS52 = new Jobseeker(2, "Job Seeker", "jobseeker@tester.com", "Personhere123", 2021,4,8);
        Jobseeker jobseekerCS53 = new Jobseeker(3, "Job Seekest", "jobseeker@testerest.com", "personthere873");
        System.out.println(jobseekerCS51.toString() + "\n");
        System.out.println(jobseekerCS52.toString() + "\n");
        System.out.println(jobseekerCS53.toString() + "\n");
        
        jobseekerCS51.setEmail("jobseeker.probably@test.ac.id");
        jobseekerCS51.setPassword("Randomperson1");
        System.out.println(jobseekerCS51.toString());
    }
}
