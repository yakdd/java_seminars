/**
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

public class Homework54 {
    static char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
    static int size = 8;
    static int count = 0;

    public static void main(String[] args) {
        char[][] chessBoard = new char[size][size];

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                chessBoard[i][j] = ' ';

        int currentRow = 0;
        putQueen(chessBoard, currentRow);
    }

    private static void putQueen(char[][] chessBoard, int currentRow) {

        if (currentRow == size) {
            count++;
            System.out.printf("\nВариант №_%d: \n", count);
            printBoard(chessBoard);
            return;
        }

        for (int col = 0; col < size; col++) {
            if (chessBoard[currentRow][col] == ' ') {
                char[][] newBoard = copyArray(chessBoard);
                changeChessBoard(newBoard, currentRow, col);
                newBoard[currentRow][col] = 'Ф';
                putQueen(newBoard, currentRow + 1);
            }
        }
    }

    private static char[][] copyArray(char[][] previous) {
        char[][] next = new char[size][size];
        for (int i = 0; i < size; i++)
            next[i] = previous[i].clone();
        return next;
    }

    private static void changeChessBoard(char[][] chessBoard, int row, int col) {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if ((i == row || j == col) || (i == j - col + row || j == col + row - i))
                    chessBoard[i][j] = '.';
    }

    private static void printBoard(char[][] chessBoard) {
        int line = size;
        System.out.println(" +------------------------+");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d|", line--);
            for (int j = 0; j < size; j++)
                System.out.printf(" %c ", chessBoard[i][j]);
            System.out.println("|");
        }
        System.out.println(" +------------------------+");
        System.out.print("  ");
        for (char let : letters)
            System.out.printf(" %c ", let);
        System.out.println();
    }
}
