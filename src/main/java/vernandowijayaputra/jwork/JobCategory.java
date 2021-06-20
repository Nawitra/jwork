package vernandowijayaputra.jwork;

/**
 * Enum yang menampung kategori-kategori pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.25
 */
public enum JobCategory
{
    WebDeveloper("WebDeveloper"), 
    FrontEnd("FrontEnd"), 
    BackEnd("BackEnd"), 
    UI("UI"), 
    UX("UX"), 
    Devops("Devops"), 
    DataScientist("DataScientist"), 
    DataAnalyst("DataAnalyst");
    
    private String category;

    /**
     * Method yang digunakan untuk mengganti nilai kategori
     *
     * @param category sebagai kategori baru untuk menggantikan kategori lama
     */
    private JobCategory(String category) {
        this.category = category;    
    }

    /**
     * Method yang digunakan untuk mengembalikan nilai category dalam bentuk string
     *
     * @return category
     */
    @Override
    public String toString() {
        return category;    
    }
    
    //pembuktian
    public static void main(String[] args) {
        JobCategory webdev = JobCategory.WebDeveloper;
        JobCategory frontend = JobCategory.FrontEnd;
        JobCategory backend = JobCategory.BackEnd;
        JobCategory ui = JobCategory.UI;
        JobCategory ux = JobCategory.UX;
        JobCategory devops = JobCategory.Devops;
        JobCategory datasci = JobCategory.DataScientist;
        JobCategory danalyst = JobCategory.DataAnalyst;
        
        System.out.println(webdev);
        System.out.println(frontend);
        System.out.println(backend);
        System.out.println(ui);
        System.out.println(ux);
        System.out.println(devops);
        System.out.println(datasci);
        System.out.println(danalyst);
    }
}


