package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.DatabaseJobseekerPostgre;
import vernandowijayaputra.jwork.Jobseeker;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class yang digunakan untuk menangani methods yang berkaitan dengan jobseeker
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
@RequestMapping("/jobseeker")
@RestController
public class JobseekerController {

    /**
     * Method placeholder yang digunakan untuk menampilkan pesan
     *
     * @return string Hello, disertai dengan nama yang telah dipassing
     */
    @RequestMapping("")
    public String indexPage(@RequestParam(value = "name", defaultValue = "world") String name) {
        return "Hello " + name;
    }

    /**
     * Method yang digunakan untuk mendapatkan jobseeker berdasarkan id
     *
     * @param id yang merupakan id acuan untuk mendapatkan jobseeker
     * @return objek jobseeker
     */
    @RequestMapping("/{id}")
    public Jobseeker getJobseekerById(@PathVariable int id) {
        Jobseeker jobseeker = null;
        jobseeker = DatabaseJobseekerPostgre.getJobseekerById(id);
        return jobseeker;
    }

    /**
     * Method yang digunakan untuk menyimpan jobseeker baru ke dalam database
     *
     * @param name merupakan nama dari jobseeker
     * @param email merupakan email dari jobseeker
     * @param password merupakan password dari jobseeker
     * @return objek jobseeker yang telah berhasil dimasukkan ke dalam database, null bila gagal
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Jobseeker registerJobseeker(@RequestParam(value = "name") String name,
                                       @RequestParam(value = "email") String email,
                                       @RequestParam(value = "password") String password) {
        String regexEmail = "^[^.][a-zA-Z0-9&*_~]+([.{1}]?[a-z]+)+@[^-][a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(email);

        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if(matcherEmail.matches() && matcherPassword.matches()) {
            Jobseeker jobseeker = new Jobseeker(DatabaseJobseekerPostgre.getLastJobseekerId() + 1,
                    name, email, password,
                    Calendar.getInstance().get(Calendar.YEAR) + 1,
                    Calendar.getInstance().get(Calendar.MONTH) + 2,
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1);
            DatabaseJobseekerPostgre.insertJobseeker(jobseeker);
            return jobseeker;
        }
        return null;
    }

    /**
     * Method yang digunakan untuk login atau masuk ke dalam aplikasi
     *
     * @param email merupakan email dari jobseeker
     * @param password merupakan password dari jobseeker
     * @return objek jobseeker yang berhasil login atau masuk ke dalam aplikasi
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Jobseeker loginJobseeker(@RequestParam(value = "email") String email,
                                    @RequestParam(value = "password") String password) {
        return DatabaseJobseekerPostgre.getJobseekerLogin(email, password);
    }
}