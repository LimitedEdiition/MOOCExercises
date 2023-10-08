import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;
    private ArrayList<Team> teams;

    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore, ArrayList<Team> teams) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.teams = teams;
        //updateTeamObject(this.teams);
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void updateTeamObject(ArrayList<Team> teams) {
        // TIE
        if(homeScore == awayScore) {
            // Nothing in teams array, create the home and away team objects
            if(teams.isEmpty()) {
                Team homeTeamObj = new Team(homeTeam,0,0,1,1);
                teams.add(homeTeamObj);
                Team awayTeamObj = new Team(awayTeam,0,0,1,1);
                teams.add(awayTeamObj);
            } else{
                //
                if(isTeamInList(teams, homeTeam)) {
                    incrementTie(teams, homeTeam);
                } else {
                    createTeamObjectTie(teams, homeTeam);
                } if(isTeamInList(teams, awayTeam)) {
                    incrementTie(teams, awayTeam);
                } else {
                    createTeamObjectTie(teams, awayTeam);
                }
            }
            // HOME WIN
        } else if(homeScore > awayScore) {
            if(teams.isEmpty()) {
                Team homeTeamObj = new Team(homeTeam, 1, 0,0,1);
                teams.add(homeTeamObj);
                Team awayTeamObj = new Team(awayTeam, 0, 1, 0,1);
                teams.add(awayTeamObj);
            } else {
                if(isTeamInList(teams, homeTeam)) {
                    incrementWin(teams, homeTeam);
                } else {
                    createTeamObjectWin(teams, homeTeam);
                } if(isTeamInList(teams, awayTeam)) {
                    incrementLoss(teams, awayTeam);
                } else {
                    createTeamObjectLoss(teams, awayTeam);
                }
            }
            // AWAY WIN
        } else {
            if(teams.isEmpty()) {
                Team homeTeamObj = new Team(homeTeam,0,1,0,1);
                teams.add(homeTeamObj);
                Team awayteamObj = new Team(awayTeam,1,0,0,1);
                teams.add(awayteamObj);
            } else {
                if(isTeamInList(teams, homeTeam)) {
                    incrementLoss(teams, homeTeam);
                } else {
                    createTeamObjectLoss(teams, homeTeam);
                } if(isTeamInList(teams, awayTeam)) {
                    incrementWin(teams, awayTeam);
                } else {
                    createTeamObjectWin(teams, awayTeam);
                }
            }
        }
    }

    public boolean isTeamInList(ArrayList<Team> teams, String team) {
        for(int i=0; i<teams.size(); i++) {
            Team element = teams.get(i);
            if(element.getName().equalsIgnoreCase(team)) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfTeam(ArrayList<Team> teams, String team) {
        int index = 0;
        for(int i=0; i<teams.size(); i++) {
            Team element = teams.get(i);
            if(element.getName().equalsIgnoreCase(team)) {
                index = i;
            }
        }
        return index;
    }

    public void createTeamObjectTie(ArrayList<Team> teams, String name) {
        Team newTeam = new Team(name,0,0,1,1);
        teams.add(newTeam);
    }

    public void createTeamObjectLoss(ArrayList<Team> teams, String name) {
        Team newTeam = new Team(name, 0, 1, 0, 1);
        teams.add(newTeam);
    }

    public void createTeamObjectWin(ArrayList<Team> teams, String name) {
        Team newTeam = new Team(name, 1, 0, 0, 1);
        teams.add(newTeam);
    }

    public void incrementLoss(ArrayList<Team> teams, String name) {
        Team team = teams.get(getIndexOfTeam(teams, name));
        int losses = team.getLosses();
        team.setLosses(++losses);
        int gamesPlayed = team.getGames();
        team.setGames(++gamesPlayed);
    }

    public void incrementTie(ArrayList<Team> teams, String name) {
        Team team = teams.get(getIndexOfTeam(teams, name));
        int ties = team.getTies();
        team.setTies(++ties);
        int gamesPlayed = team.getGames();
        team.setGames(++gamesPlayed);
    }

    public void incrementWin(ArrayList<Team> teams, String name) {
        Team team = teams.get(getIndexOfTeam(teams, name));
        int wins = team.getWins();
        team.setWins(++wins);
        int gamesPlayed = team.getGames();
        team.setGames(++gamesPlayed);
    }

    @Override
    public String toString() {
        return "HOME TEAM: " + homeTeam + " " + homeScore + "  AWAY TEAM: " + awayTeam + " " + awayScore + "\n";
    }
}
