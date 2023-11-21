import java.util.Scanner;

public class WheelAndCross {
    private static char[][] board = new char[3][3];

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        game();

    }

    public static void printBoards() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("  -----");
        }
    }

    public static boolean checkingTheWinner(char player) {
        // Sprawdzanie wierszy i kolumn
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][0] == player) {
                return true;
            }
            if (board[1][i] == player && board[2][i] == player && board[0][i] == player) {
                return true;
            }
        }

        // Sprawdzenie przekątnych

        if (board[0][0] == player && board[1][1] == player && board[0][0] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        // jEŚLI NIE MA ZWYCIĘZCY
        return false;
    }

    public static void playerMove(char player) {
        Scanner sc = new Scanner(System.in);
        int row;
        int col;

        do {
            System.out.println("Gracz " + player + ", podaj wiersz i kolumnę (1-3): ");
            row = sc.nextInt() -1;
            col = sc.nextInt() -1;
        } while (row < 0 || row > 2 || col < 0 || col < 2 || board[row][col] != '-');

        board[row][col]  = player;
    }
    public static void game() {
        boolean playerX = true;
        boolean gameOver = false;

        while (!gameOver) {
            printBoards();
            playerMove(playerX ? 'X' : 'O');
            gameOver = checkingTheWinner(playerX ? 'X' : 'O');
            playerX = !playerX;

        }

        System.out.println("Gra zakończona!");
        printBoards();
    }

}
