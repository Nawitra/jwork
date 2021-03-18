
/**
 * Write a description of class DatabaseJob here.
 *
 * @author Vernando Wijaya Putra
 * @version 2.0
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
