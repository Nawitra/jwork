package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.*;

import java.util.ArrayList;

@RequestMapping("/job")
@RestController
public class JobController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Job> getAllJob() {
        return DatabaseJob.getJobDatabase();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable int id) {
        Job job = null;
        try {
            job = DatabaseJob.getJobById(id);
        } catch (JobNotFoundException error) {
            error.getMessage();
            return null;
        }
        return job;
    }

    @RequestMapping(value = "/recruiter/{recruiterId}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByRecruiter(@PathVariable int recruiterId) {
        return DatabaseJob.getJobByRecruiter(recruiterId);
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public ArrayList<Job> getJobByCategory(@PathVariable JobCategory category) {
        return DatabaseJob.getJobByCategory(category);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Job addJob(@RequestParam(value = "name") String name,
                      @RequestParam(value = "fee") int fee,
                      @RequestParam(value = "category") JobCategory category,
                      @RequestParam(value = "recruiterId") int recruiterId
    ) {
        Job job = null;
        try {
            job = new Job(DatabaseJob.getLastId() + 1, fee, name,
                    DatabaseRecruiter.getRecruiterById(recruiterId), category);
        } catch (RecruiterNotFoundException error) {
            error.getMessage();
        }
        boolean isDone = DatabaseJob.addJob(job);
        return isDone ? job : null;
    }
}
