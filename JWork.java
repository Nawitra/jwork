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
         * CS modul 4
         *
        Jobseeker jobseekerCS4 = new Jobseeker(1, "Job Seek", "jobseeker@test.com", "personthere", "28 february");
        Bonus bonusCS41 = new Bonus(1, "AX443GG", 1000000, 5000, true);
        Bonus bonusCS42 = new Bonus(1, "BX443JJ", 5000, 100000, true);
        Location locationCS4 = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");
        Recruiter recruiterCS4 = new Recruiter(2, "Vernando Wijaya Putra", "vernandowijayaputra@gmail.com", "087743031638", locationCS4);
        Job jobCS4 = new Job(1, 13500, "designer", recruiterCS4, JobCategory.UI);
        EwalletPayment wallet1 = new EwalletPayment(1, jobCS4, "10 August 2021", jobseekerCS4, InvoiceStatus.Finished);
        EwalletPayment wallet2 = new EwalletPayment(2, jobCS4, "11 August 2021", jobseekerCS4, bonusCS42, InvoiceStatus.Finished);
        EwalletPayment wallet3 = new EwalletPayment(3, jobCS4, "12 August 2021", jobseekerCS4, bonusCS41, InvoiceStatus.Finished);
        EwalletPayment wallet4 = new EwalletPayment(4, jobCS4, "15 August 2021", jobseekerCS4, bonusCS42, InvoiceStatus.Finished);
        wallet1.setTotalFee();
        wallet2.setTotalFee();
        wallet3.setTotalFee();
        wallet4.setTotalFee();
        wallet1.printData();
        wallet2.printData();
        wallet3.printData();
        wallet4.printData();
        */
       
        /*
         * Post Test Modul 4
         */
        Jobseeker jobseekerPT4 = new Jobseeker(1, "Vocation Seeker", "jobseeker@test.com", "thyshallbe", "29 february");
        Location locationPT4 = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");
        Recruiter recruiterPT4 = new Recruiter(2, "Vernando Wijaya Putra", "vernandowijayaputra@gmail.com", "087743031638", locationPT4);
        Job jobPT4 = new Job(1, 18000, "programmer", recruiterPT4, JobCategory.UI);
        BankPayment bankPT41 = new BankPayment(1, jobPT4, "3 April 2021", jobseekerPT4, InvoiceStatus.Finished);
        BankPayment bankPT42 = new BankPayment(1, jobPT4, "3 April 2021", jobseekerPT4, InvoiceStatus.Finished, 5000);
        bankPT41.setTotalFee();
        bankPT42.setTotalFee();
        bankPT41.printData();
        bankPT42.printData();
    }
}
