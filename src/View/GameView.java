package View;

import Controller.MorpionFacade;
import Model.GameObserver;
import Model.Player;
import Model.TypeTeam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView extends JFrame implements GameObserver {
    private JButton[][] _board = new JButton[3][3];
    private MorpionFacade _facade;
    public GameView(MorpionFacade facade){
        this._facade = facade;
        setSize(400,400);
        setTitle("Jeu de Morpion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Centrer l'applciation
        Toolkit toolKit = getToolkit();
        Dimension size = toolKit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setLayout( new GridLayout(3,3));
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                JButton square = new JButton();
                square.setPreferredSize(new Dimension(100, 100));
                square.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        try {
                            clickSquare(square);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                add(square);
                this._board[i][j] = square;
            }
        }


        setVisible(true);
        setResizable(false);
    }

    public void clickSquare(JButton square) throws InterruptedException {
        _facade.playPlayer(square.getLocation().y / 100, square.getLocation().x / 100 );
    }
    @Override
    public void updateBoard(int row, int column) {
        if(TypeTeam.X.equals(_facade.getPlayerPlay().getType())){
            _board[row][column].setText("X");
            _board[row][column].setForeground(Color.RED);
        }else{
            _board[row][column].setText("O");
            _board[row][column].setForeground(Color.GREEN);
        }
        _board[row][column].setFont(new Font("Arial", Font.BOLD, 40));
        _board[row][column].repaint();
    }

    @Override
    public void resetGame() {

        MorpionFacade facade = new MorpionFacade();
        facade.newGame();
        dispose(); // Suppression du JFrame EndGameView
    }
}
