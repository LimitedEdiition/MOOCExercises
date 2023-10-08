import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private ArrayList<Game> games;
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.games = new ArrayList<>();
        this.scanner = scanner;
    }

    public void start() {
        while(true) {
            System.out.println("Enter a file name: ");
            String fileName = scanner.nextLine();
            // If fileName is empty
            if(fileName.isEmpty()) {
                System.out.println("No file name inputted! Try again!");
                continue;
            } else if(fileName.equalsIgnoreCase("End")) {
                break;
            } else {
                try(Scanner pathScanner = new Scanner(Paths.get(fileName))) {
                    System.out.println("Found file!");
                } catch(Exception e) {
                    System.out.println("Error! " + e);
                }
            }
        }

    }

    /*public ArrayList<Game> createGame() {

    }*/

}
