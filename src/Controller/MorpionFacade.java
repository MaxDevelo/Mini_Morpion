package Controller;

import Model.Board;
import Model.Game;
import Model.Player;
import Model.TypeTeam;
import p21.td6.View.GameView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MorpionFacade {
    private Board _board;
    private Game _game;
    public void newGame(){
        _game = new Game("Maxime", "Théo");
        _board = new Board();
        _board.addListener(new GameView(this));
    }
    public Boolean playPlayer(int row, int column) throws InterruptedException {
        TypeTeam morpion;

        if(TypeTeam.X.equals(_game.getPlayerPlay().getType())){
            morpion = TypeTeam.X;
        }else{
            morpion = TypeTeam.O;
        }
        if(_board.takeSquare(row, column, morpion)){
            _board.changeSquare(row, column);
            if(checkVictory(_game.getPlayerPlay())){
                JOptionPane.showConfirmDialog(null, _game.getPlayerPlay().getName() + " a gagné", "ok", JOptionPane.CLOSED_OPTION);
                _board.resetGame();
            }
            if(checkMatchNull()){
                JOptionPane.showConfirmDialog(null, "MATCH NULL", "ok", JOptionPane.CLOSED_OPTION);
                _board.resetGame();
            }
            _game.chanegTurn();
            return true;
        }
        return false;
    }

    public Player getPlayerPlay(){
        return (_game.getPlayers().get(0).play() == true) ? _game.getPlayers().get(0) : _game.getPlayers().get(1);
    }

    public Boolean checkVictory(Player player){
        return _board.verifyIfWinner(player);
    }
    public Boolean checkMatchNull(){
        return _board.verifyMatchNull();
    }

}
