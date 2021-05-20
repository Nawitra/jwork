package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.*;

import java.util.ArrayList;

@RequestMapping("/recruiter")
@RestController
public class RecruiterController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Recruiter> getAllRecruiter() {
        return DatabaseRecruiter.getRecruiterDatabase();
    }

    @RequestMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable int id) {
        Recruiter recruiter = null;
        try {
            recruiter = DatabaseRecruiter.getRecruiterById(id);
        } catch (RecruiterNotFoundException error) {
            error.getMessage();
            return null;
        }
        return recruiter;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Recruiter addRecruiter(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "phoneNumber") String phoneNumber,
                                  @RequestParam(value = "province") String province,
                                  @RequestParam(value = "description") String description,
                                  @RequestParam(value = "city") String city) {
        Recruiter recruiter = new Recruiter(DatabaseRecruiter.getLastId() + 1,
                name, email, phoneNumber, new Location(province, city, description));

        try {
            DatabaseRecruiter.addRecruiter(recruiter);
        } catch (Exception error) {
            error.printStackTrace();
            return null;
        }
        return recruiter;
    }
}
