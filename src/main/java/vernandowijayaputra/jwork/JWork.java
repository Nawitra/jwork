package vernandowijayaputra.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class yang digunakan untuk melakukan pengujian terhadap class-class lain yang telah dibuat
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */

@SpringBootApplication
public class JWork {

    public static void main(String[] args) throws RecruiterNotFoundException, EmailAlreadyExistsException, JobNotFoundException, JobSeekerNotFoundException, OngoingInvoiceAlreadyExistsException, ReferralCodeAlreadyExistsException {
        //Untuk pengujian referral code
        //DatabaseBonus.addBonus(new Bonus(1, "AX101", 10000, 5000, true));

        /*
        Location location1 =
                new Location(1, "Sumatera Selatan", "Lubuklinggau", "Lokasi pertama");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Well Played",
                "wellplayed@test.com", "08123456789", location1));

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "Junior Web UI Designer", DatabaseRecruiter.getRecruiterById(1), JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "React Developer", DatabaseRecruiter.getRecruiterById(1), JobCategory.WebDeveloper));
         */

        /*
        System.out.println("Trying to insert jobseeker into the database...");
        DatabaseJobseekerPostgre.insertJobseeker(new Jobseeker(DatabaseJobseekerPostgre.getLastJobseekerId() + 1, "Nando", "nandowp@gmail.com",
                "Nandowp1", 2021, 3, 6));
        System.out.println("Should be done.");
         */

/*
        System.out.println("Trying to insert location into the database...");
        DatabaseLocationPostgre.insertLocation(new Location(1, "Sumatera Selatan", "Lubuklinggau", "Lokasi pertama"));
        System.out.println("Should be done");

        System.out.println("Trying to insert recruiter into the database...");
        DatabaseRecruiterPostgre.insertRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Well Played",
                "wellplayed@test.com", "08123456789", DatabaseLocationPostgre.getLocationById(1)));
        System.out.println("Should be done");

        System.out.println("Trying to insert job into the database...");
        DatabaseJobPostgre.insertJob((new Job(DatabaseJob.getLastId() + 1, 300000,
                "Junior Web UI Designer", DatabaseRecruiterPostgre.getRecruiterById(1), JobCategory.UI)));
        System.out.println("Should be done.");

        System.out.println("Trying to insert job into the database...");
        DatabaseJobPostgre.insertJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "React Developer", DatabaseRecruiterPostgre.getRecruiterById(1), JobCategory.WebDeveloper));
        System.out.println("Should be done.");

        System.out.println("Trying to insert bonus into the database...");
        DatabaseBonusPostgre.insertBonus(new Bonus(1, "AX101", 10000, 5000, true));
        System.out.println("Should be done.");

 */
        SpringApplication.run(JWork.class, args);
    }

}