public class JWork
{
    public static void main(String[] args) {
        //location
        Location location1 = new Location("Sumatera Selatan", "Lubuklinggau", "Kota lama");
        System.out.println(location1.getProvince());
        location1.setProvince("Sumatera Selatan2");
        
        //recruiter
        Recruiter recruiter1 = new Recruiter(1, "Random", "random@test.com", "1234567", location1);
        System.out.println(recruiter1.getName());
        recruiter1.setName("Random2");
        
        //job
        Job job1 = new Job(1, 100, "programmer", "new_category", recruiter1);
        System.out.println(job1.getCategory());
        job1.setCategory("old_category");
        
        //jobseeker
        Jobseeker jobseeker1 = new Jobseeker(1, "person", "person@test.com", "personguys", "10 february");
        System.out.println(jobseeker1.getEmail());
        jobseeker1.setEmail("person2@test.com");
        
        //invoice
        Invoice invoice1 = new Invoice(1, 1, "10 february", 100, jobseeker1);
        System.out.println(invoice1.getTotalFee());
        invoice1.setTotalFee(200);
    }
}
