public class Team {
    private String name;
    private int wins;
    private int losses;
    private int ties;
    private int games;

    public Team(String name, int wins, int losses, int ties, int games) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.games = games;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return ("Games: " + games + "\nWins: " + wins + "\nLosses: " + losses + "\nTies: " + ties + "\n");
    }
}
