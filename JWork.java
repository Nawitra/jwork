public class JWork
{
    public static void main(String[] args) {
        
        /*
         * Membuat objek Location baru, dengan parameter:
         * province = "Sumatera Selatan"
         * city = "Lubuklinggau"
         * description = "Kota lama"
         
        Location location1 = new Location("Sumatera Selatan", "Lubuklinggau", "Kota lama");
        
        //Memanggil getter
        System.out.println(location1.getProvince());
        
        //Memanggil setter
        location1.setProvince("Sumatera Selatan2");
        
        //Memanggil getter setelah melakukan set
        System.out.println(location1.getProvince());
        
        /*
         * Membuat objek Recruiter baru dengan parameter:
         * id = 1
         * name = "Random"
         * email = "random@test.com"
         * phoneNumber = "1234567"
         * Location = location1
         
        Recruiter recruiter1 = new Recruiter(1, "Random", "random@test.com", "1234567", location1);
        
        //Memanggil getter
        System.out.println(recruiter1.getName());
        
        //Memanggil setter
        recruiter1.setName("Random2");
        
        //Memanggil getter setelah melakukan set
        System.out.println(recruiter1.getName());
        
        /*
         * Membuat objek Job baru, dengan parameter:
         * id = 1
         * fee = 100
         * name = "programmer"
         * category = "new_category"
         * recruiter = recruiter1
         
        Job job1 = new Job(1, 100, "programmer", "new_category", recruiter1);
        
        //Memanggil getter
        System.out.println(job1.getCategory());
        
        //Memanggil setter
        job1.setCategory("old_category");
        
        //Memanggil getter setelah melakukan get
        System.out.println(job1.getCategory());
        
        /*
         * Membuat objek Jobseeker baru, dengan parameter:
         * id = 1
         * name = "person"
         * email = "person@test.com"
         * password = "personguys"
         * joinDate = "10 february"
         
        Jobseeker jobseeker1 = new Jobseeker(1, "person", "person@test.com", "personguys", "10 february");
        
        //Memanggil getter
        System.out.println(jobseeker1.getEmail());
        
        //Memanggil setter
        jobseeker1.setEmail("person2@test.com");
        
        //Memanggil getter setelah melakukan set
        System.out.println(jobseeker1.getEmail());
        
        /*
         * Membuat objek invoice baru dengan parameter:
         * id = 1
         * idJob = 1
         * date = "10 february"
         * totalFee = 100
         * jobseeker = jobseeker1
         
        Invoice invoice1 = new Invoice(1, 1, "10 february", 100, jobseeker1);
        
        //Memanggil getter
        System.out.println(invoice1.getTotalFee());
        
        //Memanggil setter
        invoice1.setTotalFee(200);
        
        //Memanggil getter setelah melakukan set
        System.out.println(invoice1.getTotalFee());
        
        /*
         * Post test
         
        Location locationPT = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");
        Recruiter recruiterPT = new Recruiter(2, "Vernando Wijaya Putra", "vernandowijayaputra@gmail.com", "087743031638", locationPT);
        Job jobPT = new Job(2, 350, "designer", "all_category", recruiterPT);
        Jobseeker jobseekerPT = new Jobseeker(2, "Job Seek", "jobseeker@test.com", "personhere", "15 february");
        Invoice invoicePT = new Invoice(2, 2, "15 february", 350, jobseekerPT);
        
        System.out.println(recruiterPT.getName());
        recruiterPT.setName("IM");
        System.out.println(recruiterPT.getName());
        
        jobPT.printData();
        */
       
        /*
         * Modul 3
         */
        
        /* 
         * Ini merupakan bagian kode untuk menunjukkan JobCategory
         * 
        for (JobCategory jobCategory: JobCategory.values()) {
            System.out.println(jobCategory);
        }
        
        System.out.println(JobCategory.WebDeveloper);
        System.out.println(JobCategory.FrontEnd);
        System.out.println(JobCategory.BackEnd);
        System.out.println(JobCategory.UI);
        System.out.println(JobCategory.UX);
        System.out.println(JobCategory.Devops);
        System.out.println(JobCategory.DataScientist);
        System.out.println(JobCategory.DataAnalyst);        
        System.out.println(JobCategory.random);
        */
       
        /*
         * Ini merupakan bagian kode untuk menunjukkan PaymentType
         
        for (PaymentType paymentType: PaymentType.values()) {
            System.out.println(paymentType);
        }
        
        System.out.println(PaymentType.BankPayment);
        System.out.println(PaymentType.EwalletPayment);        
        System.out.println(PaymentType.random);
        */
       
        Location locationCS3 = new Location("Sumatera Selatan", "Lubuklinggau", "Tempat lahir");
        Recruiter recruiterCS3 = new Recruiter(8, "Vernando Wijaya Putra", "vernandowijayaputra@gmail.com", "08777123556", locationCS3);
        Job jobCS3 = new Job(9, 50000, "designer", recruiterCS3, JobCategory.UI);
        jobCS3.printData();
    }
}
