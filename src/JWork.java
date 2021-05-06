import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Write a description of class JWork here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */

public class JWork
{
    public static void main(String[] args) throws EmailAlreadyExistsException, ReferralCodeAlreadyExistsException, RecruiterNotFoundException, BonusNotFoundException {
        /*
        CS Modul 7
         */

        //4 objek jobseeker baru
        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Vernando Wijaya Putra",
                    "vernando.wijaya@ui.ac.id", "Randomperson123", 2021, 5, 4));
        } catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Vernando Wijaya Putra",
                    "vernando.wijaya@ui.ac.id", "Randomperson456", 2021, 5, 4));
        } catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Ilham Mulya Rafid",
                    "ilhamrafid@test.com", "Asisten123", 2021, 5, 4));
        } catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Randomguy123",
                    "randood@test.com", "Person12kdm", 2021, 5, 4));
        } catch (EmailAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        //2 objek bonus kode sama
        try {
            DatabaseBonus.addBonus(new Bonus(1, "AX101", 10000, 5000, false));
        } catch (ReferralCodeAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseBonus.addBonus(new Bonus(2, "AX101", 10000, 5000, true));
        } catch (ReferralCodeAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        //2 objek bonus dengan data bebas
        try {
            DatabaseBonus.addBonus(new Bonus(3, "BX101", 35000, 5000, true));
        } catch (ReferralCodeAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        try {
            DatabaseBonus.addBonus(new Bonus(4, "CX101", 90000, 5000, true));
        } catch (ReferralCodeAlreadyExistsException error) {
            System.out.println(error.getMessage());
        }

        //Pengujian getJobseekerById
        try {
            DatabaseJobseeker.getJobseekerById(4);
        } catch(JobSeekerNotFoundException error) {
            System.out.println(error.getMessage());
        }

        //Pengujian getRecruiterById
        try {
            DatabaseRecruiter.getRecruiterById(3);
        } catch(RecruiterNotFoundException error) {
            System.out.println(error.getMessage());
        }

        //Pengujian getJobById
        try {
            DatabaseJob.getJobById(3);
        } catch(JobNotFoundException error) {
            System.out.println(error.getMessage());
        }

        //Pengujian getBonusById
        try {
            DatabaseBonus.getBonusById(2);
        } catch(BonusNotFoundException error) {
            System.out.println(error.getMessage());
        }

        System.out.println("\n===Jobseeker===");
        System.out.println(DatabaseJobseeker.getJobseekerDatabase());

        System.out.println("\n===Recruiter===");
        System.out.println(DatabaseRecruiter.getRecruiterDatabase());

        System.out.println("\n===Job===");
        System.out.println(DatabaseJob.getJobDatabase());

        System.out.println("\n===Bonus===");
        System.out.println(DatabaseBonus.getBonusDatabase());
    }

    
}
