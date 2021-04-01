/**
 * Write a description of class JWork here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */

public class JWork
{
    public static void main(String[] args) {
        Jobseeker jobseekerCS4 = new Jobseeker(1, "Job Seek", "jobseeker@test.com", "personthere", "28 february");
        Bonus bonusCS41 = new Bonus(1, "AX443GG", 10000, 5000, true);
        Bonus bonusCS42 = new Bonus(1, "BX443JJ", 5000, 100000, true);
        Location locationCS4 = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");
        Recruiter recruiterCS4 = new Recruiter(2, "Vernando Wijaya Putra", "vernandowijayaputra@gmail.com", "087743031638", locationCS4);
        Job jobCS4 = new Job(1, 13500, "designer", recruiterCS4, JobCategory.UI);
        EwalletPayment wallet1 = new EwalletPayment(1, jobCS4, "10 August 2021", jobseekerCS4, InvoiceStatus.Finished);
        EwalletPayment wallet2 = new EwalletPayment(2, jobCS4, "11 August 2021", jobseekerCS4, bonusCS42, InvoiceStatus.Finished);
        EwalletPayment wallet3 = new EwalletPayment(3, jobCS4, "11 August 2021", jobseekerCS4, bonusCS41, InvoiceStatus.Finished);
        wallet1.printData();
        wallet2.printData();
        wallet3.printData();
    }
}
