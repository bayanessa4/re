import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayerIndex;
//  מגדרים שני מערכים השחקנים
    public Game() {
        board = new Board();
        players = new Player[2];
        players[0] = new Player("Player 1", 'R');
        players[1] = new Player("Player 2", 'Y');
        currentPlayerIndex = 0;
    }
     ////ניצחון
    public void play() {
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
// ללולה ויל אם המשחק עדיין לא סיים
        while (!gameOver) {
            System.out.println("Current board:");
            board.printBoard();
//הי מדפיסה שם השחקן 
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println(currentPlayer.getName() + ", enter your column (0-6):");
            int column = scanner.nextInt();
// אם המספר שביקשתה  קיים
            if (board.isValidMove(column)) {
                board.makeMove(column, currentPlayer.getSymbol());
//بفحص اذا كل شروط الفوز تحققت
                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    gameOver = true;
                    board.printBoard();
                } else if (board.isBoardFull()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                    board.printBoard();
                } else {
                    currentPlayerIndex = (currentPlayerIndex + 1) % 2;
                }
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
        
        scanner.close();
    }
}
