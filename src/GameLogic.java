public class GameLogic {

    private char[][] board;
    private char currentPlayer;

    public GameLogic() {
        board = new char[3][3];
        resetGame();
    }

    public void resetGame() {

        currentPlayer = 'X';

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {

        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }

    }

    public boolean makeMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != ' ') {
            return false;
        }

        board[row][col] = currentPlayer;

        return true;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public boolean checkWinner() {

        // Cek baris
        for (int i = 0; i < 3; i++) {

            if (board[i][0] != ' ' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {

                return true;
            }

        }

        // Cek kolom
        for (int i = 0; i < 3; i++) {

            if (board[0][i] != ' ' &&
                board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {

                return true;
            }

        }

        // Cek diagonal utama
        if (board[0][0] != ' ' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {

            return true;
        }

        // Cek diagonal kedua
        if (board[0][2] != ' ' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {

            return true;
        }

        return false;
    }

    public boolean isBoardFull() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == ' ') {
                    return false;
                }

            }

        }

        return true;
    }

}
