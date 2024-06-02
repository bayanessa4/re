public class Board {
    private char[][] grid;
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
     // מגדיר קווים ועמודות 
    public Board() {
        grid = new char[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = ' ';
            }
        }
    }
//הדפסה הבורד
    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print("| " + grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("_____________________________");
        System.out.println("  0  1   2   3   4   5   6 ");
        //ידפיס המשחק 
    }
//בדוק אם המקום פנוי
    public boolean isValidMove(int column) {
        return column >= 0 && column < COLUMNS && grid[0][column] == ' ';
    }
//מבצעת את ה מוו
    public void makeMove(int column, char symbol) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column] == ' ') {
                grid[i][column] = symbol;
                break;
            }
            
            
            
            
            
            
            
        }
    }

    public boolean checkWin(char symbol) {
        // Check rows
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLUMNS - 4; j++) {
                if (grid[i][j] == symbol && grid[i][j + 1] == symbol && grid[i][j + 2] == symbol && grid[i][j + 3] == symbol) {
                    return true;
               
                }
            }

            // Check columns
            for (int i1 = 0; i1 <= ROWS - 4; i1++) {
                for (int j = 0; j < COLUMNS; j++) {
                    if (grid[i1][j] == symbol && grid[i1 + 1][j] == symbol && grid[i1 + 2][j] == symbol && grid[i1 + 3][j] == symbol) {
                        return true;
                    }
                }
            }

            // Check diagonals (top-left to bottom-right)
            for (int i1 = 0; i1 <= ROWS - 4; i1++) {
                for (int j = 0; j <= COLUMNS - 4; j++) {
                    if (grid[i1][j] == symbol && grid[i1 + 1][j + 1] == symbol && grid[i1 + 2][j + 2] == symbol && grid[i1 + 3][j + 3] == symbol) {
                        return true;
                    }
                }
            }

            // Check diagonals (top-right to bottom-left)
            for (int i1 = 0; i1 <= ROWS -             4; i1++) {
                for (int j = 3; j < COLUMNS; j++) {
                    if (grid[i1][j] == symbol && grid[i1 + 1][j - 1] == symbol && grid[i1 + 2][j - 2] == symbol && grid[i1 + 3][j - 3] == symbol) {
                        return true;
                    }
                }
            }

        } return false;
        }

        public boolean isBoardFull() {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    if (grid[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
    }

