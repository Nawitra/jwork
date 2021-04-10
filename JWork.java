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
        *
       Jobseeker jobseekerCS51 = new Jobseeker(1, "Job Seek", "jobsee ker@test.com", "personthereafter", new GregorianCalendar(2021,8,12));
       Jobseeker jobseekerCS52 = new Jobseeker(2, "Job Seeker", "jobseeker@tester.com", "Personhere123", 2021,4,8);
       Jobseeker jobseekerCS53 = new Jobseeker(3, "Job Seekest", "jobseeker@testerest.com", "personthere873");
       System.out.println(jobseekerCS51.toString() + "\n");
       System.out.println(jobseekerCS52.toString() + "\n");
       System.out.println(jobseekerCS53.toString() + "\n");
       
       jobseekerCS51.setEmail("jobseeker.probably@test.ac.id");
       jobseekerCS51.setPassword("Randomperson1");
       System.out.println(jobseekerCS51.toString());
        */
       
        Location locationPT5 = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");
        Recruiter recruiterPT5 = new Recruiter(8, "Vernando Wijaya Putra", "vernandowijayaputra@gmail.com", "08777123556", locationPT5);
        Job jobPT5 = new Job(9, 50000, "designer", recruiterPT5, JobCategory.UI);
        Jobseeker jobseekerPT5 = new Jobseeker(1, "Job Seek", "jobseeker@test.com", "Personthereafter1", new GregorianCalendar(2021,8,12));
        BankPayment bankPT5 = new BankPayment(1, jobPT5, jobseekerPT5, InvoiceStatus.Finished);
        EwalletPayment ewalletPT5 = new EwalletPayment(2, jobPT5, jobseekerPT5, InvoiceStatus.Finished);
        bankPT5.setDate(new GregorianCalendar(2021, 8, 12));
        ewalletPT5.setDate(new GregorianCalendar(2021, 8, 12));
        bankPT5.setTotalFee();
        ewalletPT5.setTotalFee();
        System.out.println(bankPT5.toString() + "\n");
        System.out.println(ewalletPT5.toString());
    }
}
