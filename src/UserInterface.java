import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private ArrayList<Game> games;
    private ArrayList<Team> teams;
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.games = new ArrayList<>();
        this.teams = new ArrayList<>();
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

        System.out.println("All data has been added.\nWhich team statistic do you want to know about?");
        teamInfoUI();

    }

    public void teamInfoUI() {
        while(true) {
            System.out.println("Team: ");
            String teamName = scanner.nextLine();
            if(teamName.equalsIgnoreCase("End")) {
                System.out.println("Ending");
                break;
            }
            if(isTeamInList(teams, teamName)) {
                System.out.println(teams.get(indexOfTeam(teams,teamName)));
            } else {
                System.out.println("Invalid team name! Try again");
                continue;
            }
        }

        //printGameObjects(games);
        printTeamObjects(teams);
    }

    public boolean isTeamInList(ArrayList<Team> teams, String name) {
        for(int i=0; i<teams.size();i++) {
            Team element = teams.get(i);
            if(name.equalsIgnoreCase(element.getName())) {
                return true;
            }
        }
        return false;
    }

    public int indexOfTeam(ArrayList<Team> teams, String name) {
        int indexVal = 0;
        for(int i=0; i<teams.size(); i++) {
            Team element = teams.get(i);
            if(name.equalsIgnoreCase(element.getName())) {
                indexVal = i;
            }
        }
        return indexVal;
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
        }
    }

    public Game parseGameObject(String[] object) {
        String homeTeam = object[0];
        String awayTeam = object[1];
        int homeScore = Integer.valueOf(object[2]);
        int awayScore = Integer.valueOf(object[3]);
        Game newGame = new Game(homeTeam,awayTeam,homeScore,awayScore,teams);
        newGame.updateTeamObject(teams);
        return newGame;
    }

    public void printGameObjects(ArrayList<Game> games) {
        for(Game game: games) {
            System.out.println(game);
        }
    }

    public void printTeamObjects(ArrayList<Team> teams) {
        for(Team team: teams) {
            System.out.println(team);
        }
    }

}
