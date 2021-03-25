
/**
 * Enum yang menampung kategori-kategori pekerjaan
 *
 * @author Vernando Wijaya Putra
 * @version 2021.3.25
 */
public enum JobCategory
{
    WebDeveloper, FrontEnd, BackEnd, UI, UX, Devops, DataScientist, DataAnalyst;
    
    public String toString() {
        switch(this) {
            case WebDeveloper:
                return "WebDeveloper";
            case FrontEnd:
                return "FrontEnd";
            case BackEnd:
                return "BackEnd";
            case UI:
                return "UI";
            case UX:
                return "UX";
            case Devops:
                return "Devops";
            case DataScientist:
                return "DataScientist";
            case DataAnalyst:
                return "DataAnalyst";
            default:
                return null;
        }
    }
}


