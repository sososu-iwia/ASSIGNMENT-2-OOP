import model.Institution;
import service.EducationService;
import ui.ConsoleReader;

public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        String institutionName = reader.readLine("Enter institution name: ");
        String institutionAddress = reader.readLine("Enter institution address: ");

        Institution institution = new Institution(institutionName, institutionAddress);
        EducationService service = new EducationService(institution, reader);

        service.start();
    }
}