/**
 * Class yang akan menampung list dari pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.03.18
 */
public class DatabaseJob
{
    private String[] listJob;

    public DatabaseJob()
    {
        listJob = new String[255];
    }
    
    public boolean addJob(Job job) {
        return false;
    }
    
    public boolean remove(Job job) {
        return false;   
    }
    
    public Job getJob() {
        return null;   
    }
    
    public String[] getListJob() {
        return listJob;
    }
}
