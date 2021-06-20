package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.*;

import java.util.ArrayList;

/**
 * Class yang digunakan untuk menangani methods yang berkaitan dengan recruiter
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
@RequestMapping("/recruiter")
@RestController
public class RecruiterController {
    /**
     * Method yang digunakan untuk mendapatkan database recruiter
     *
     * @return semua entry dari database recruiter
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiterPostgre.getRecruiterDatabase();
    }

    /**
     * Method yang digunakan untuk mendapatkan recruiter berdasarkan id yang diberikan
     *
     * @param id merupakan id dari recruiter
     * @return objek recruiter
     */
    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        recruiter = DatabaseRecruiterPostgre.getRecruiterById(id);
        return recruiter;
    }

    /**
     * Method yang digunakan untuk membuat recruiter baru dan memasukkannya ke database
     *
     * @param name merupakan nama dari recruiter
     * @param email merupakan email dari recruiter
     * @param phoneNumber merupakan nomor telepon dari recruiter
     * @param province merupakan provinsi dari recruiter
     * @param description merupakan deskripsi dari lokasi recruiter
     * @param city merupakan kota dari recruiter
     * @return objek recruiter yang baru dibuat
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "province") String province,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "city") String city) {
        Recruiter recruiter = new Recruiter(DatabaseRecruiterPostgre.getLastRecruiterId() + 1,
                name, email, phoneNumber, new Location(DatabaseLocationPostgre.getLastLocationId(), province, city, description));

        try {
            DatabaseRecruiterPostgre.insertRecruiter(recruiter);
        } catch (Exception error) {
            error.printStackTrace();
            return null;
        }
        return recruiter;
    }
}
