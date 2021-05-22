package vernandowijayaputra.jwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Write a description of class JWork here.
 *
 * @author Vernando Wijaya Putra
 * @version 2021.1.4
 */

@SpringBootApplication
public class JWork {

    public static void main(String[] args) throws RecruiterNotFoundException, EmailAlreadyExistsException, JobNotFoundException, JobSeekerNotFoundException, OngoingInvoiceAlreadyExistsException {

        Location location1 =
                new Location("Sumatera Selatan", "Lubuklinggau", "Lokasi pertama");
        Location location2 =
                new Location("Jawa Tengah", "Purworejo", "Lokasi kedua");
        Location location3 =
                new Location("Sumatera Barat", "Padang", "Lokasi ketiga");

        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Well Played",
                "wellplayed@test.com", "08123456789", location1));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "Random Guy",
                "randomguy@test.com", "08771856789", location2));
        DatabaseRecruiter.addRecruiter(new Recruiter(DatabaseRecruiter.getLastId() + 1, "John Doe",
                "johndoe@test.com", "08771856123", location3));

        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "Junior Web UI Designer", DatabaseRecruiter.getRecruiterById(1), JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 400000,
                "Professional Mobile UI Designer", DatabaseRecruiter.getRecruiterById(2), JobCategory.UI));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 900000,
                "Data Scientist", DatabaseRecruiter.getRecruiterById(3), JobCategory.DataScientist));
        DatabaseJob.addJob(new Job(DatabaseJob.getLastId() + 1, 300000,
                "React Developer", DatabaseRecruiter.getRecruiterById(3), JobCategory.WebDeveloper));


        DatabaseJobseeker.addJobseeker(new Jobseeker(DatabaseJobseeker.getLastId() + 1, "Vernando Wijaya Putra",
                "vernando.wijaya@ui.ac.id", "Randomperson123", 2021, 3, 4));

        DatabaseInvoice.addInvoice(new BankPayment(DatabaseInvoice.getLastId() + 1, DatabaseJob.getJobDatabase(), DatabaseJobseeker.getJobseekerById(1),
                1000));
    }

}