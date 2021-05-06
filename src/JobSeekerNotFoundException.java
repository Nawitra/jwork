public class JobSeekerNotFoundException extends Exception {
    private int jobseeker_error;

    public JobSeekerNotFoundException (int jobseeker_input) {
        super("Jobseeker ID: ");
        jobseeker_error = jobseeker_input;
    }

    public String getMessage() {
        return super.getMessage() + jobseeker_error + " not found";
    }
}
