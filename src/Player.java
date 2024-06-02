public class Player {
    private String name;
    private char player;

    public Player(String name, char player) {
        this.name = name;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return player;
    }
}
