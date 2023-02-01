import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    private Square[][] board;
    private int windowWidth;
    private int windowHeight;

    private TicTacToe game;

    public TicTacToeViewer(int windowWidth, int windowHeight, Square[][] board, TicTacToe game) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.board = board;

        this.setTitle("Tic Tac Toe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(windowWidth, windowHeight);
        this.setVisible(true);
        this.game = game;

    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.setFont(new Font("SERIF", Font.PLAIN,30));
        // Drawing the axes of the board
        g.drawString("0", 80, 200);
        g.drawString("1", 80, 312);
        g.drawString("2", 80, 430);
        g.drawString("0", 170, 100);
        g.drawString("1", 287, 100);
        g.drawString("2", 410, 100);
        // Draw board by drawing each of the 9 boxes one by one
        for(int i = 0; i < this.board.length; i++) {
            for(int j = 0; j< this.board[i].length; j++) {
                board[i][j].draw(g);
            }
        }

        // Write if it's a tie or who won if the game is over
        if (game.getGameOver()) {
            g.setColor(Color.black);
            if (game.checkTie()) {
                g.drawString("It's a Tie!", 247, 580);
            }
            else if (game.getWinner().equals(TicTacToe.X_MARKER)) {
                g.drawString("X wins!", 247, 580);
            }
            else if (game.getWinner().equals(TicTacToe.O_MARKER)) {
                g.drawString("O wins!", 247, 580);
            }
        }
    }
}
