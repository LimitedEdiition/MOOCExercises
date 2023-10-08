import java.lang.reflect.Array;
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
                    /*while(pathScanner.hasNextLine()) {

                    }*/
                    parseFile(pathScanner);
                } catch(Exception e) {
                    System.out.println("Error! " + e);
                }
            }
        }

        printGameObjects(games);

    }

    public void parseFile(Scanner scanner) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.isEmpty()) {
                continue;
            }
            String[] elements = line.split(",");
            Game match = parseGameObject(elements);
            games.add(match);
            System.out.println("Match added");
        }
    }

    public Game parseGameObject(String[] object) {
        String homeTeam = object[0];
        String awayTeam = object[1];
        int homeScore = Integer.valueOf(object[2]);
        int awayScore = Integer.valueOf(object[3]);
        Game match = new Game(homeTeam,awayTeam,homeScore,awayScore);
        return match;
    }

    public void printGameObjects(ArrayList<Game> games) {
        for(Game game: games) {
            System.out.println("Game played at " + game.getHomeTeam());
        }
    }

}
