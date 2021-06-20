package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.*;

import java.util.ArrayList;

/**
 * Class yang digunakan untuk menangani methods yang berkaitan dengan job
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
@RequestMapping("/job")
@RestController
public class JobController {
    /**
     * Method yang digunakan untuk mendapatkan database job
     *
     * @return semua entry dari database job
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Job> getAllJob() {
        return DatabaseJobPostgre.getJobDatabase();
    }

    /**
     * Method yang digunakan untuk mendapatkan job berdasarkan id yang diberikan
     *
     * @param id sebagai acuan untuk mendapatkan job
     * @return objek job
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable int id) {
        Job job = null;
        job = DatabaseJobPostgre.getJobById(id);
        return job;
    }

    /**
     * Method yang digunakan untuk mendapatkan job berdasarkan recruiter
     *
     * @param recruiterId sebagai id acuan untuk mendapatkan job
     * @return objek job
     */
    @RequestMapping(value = "/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJobPostgre.getJobByRecruiter(recruiterId);
    }

    /**
     * Method yang digunakan untuk mendapatkan job berdasarkan kategori
     *
     * @param category merupakan kategori acuan untuk mendapatkan job
     * @return objek job
     */
    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJobPostgre.getJobByCategory(String.valueOf(category));
    }

    /**
     * Method yang digunakan untuk membuat job baru dan memasukkannya ke dalam database job
     *
     * @param name merupakan nama pekerjaan
     * @param fee merupakan biaya pekerjaan
     * @param category merupakan kategory pekerjaan
     * @param recruiterId merupakan id dari recruiter dari pekerjaan tersebut
     * @return objek job yang telah dibuat
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                      @RequestParam(value = "fee") int fee,
                      @RequestParam(value = "category") JobCategory category,
                      @RequestParam(value = "recruiterId") int recruiterId
    ) {
        Job job = null;
            job = new Job(DatabaseJobPostgre.getLastJobId() + 1, fee, name,
                DatabaseRecruiterPostgre.getRecruiterById(recruiterId), category);
        DatabaseJobPostgre.insertJob(job);
        return job;
    }
}
