package Model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<GameObserver> _listeners = new ArrayList<>();
    private Square[][] _board;
    public Board(){
        this._board = new Square[3][3];
        // génération du tableau
        generatedBoard();
    }
    public void generatedBoard(){
        for(int l = 0; l<3; l++){
            for(int c = 0; c<3; c++){
                this._board[l][c] = new Square(l, c);
            }
        }
    }

    public void changeSquare(int row, int column)
    {
        for (GameObserver listener : _listeners)
        {
            listener.updateBoard(row, column);
        }
    }

    public void resetGame()
    {
        for (GameObserver listener : _listeners)
        {
            listener.resetGame();
        }
    }

    public void addListener(GameObserver listener)
    {
        this._listeners.add(listener);
    }



    public Boolean verifySquareIsEmpty(int row, int column){
        return this._board[row][column].getSquare() == null;
    }
    public Boolean takeSquare(int row, int column, TypeTeam morpion){
        if(verifySquareIsEmpty(row, column)){
            _board[row][column].setSquare(morpion);
            return true;
        }
        return false;
    }

    public Boolean verifyIfWinner(Player player){
        TypeTeam square;

        if(TypeTeam.X.equals(player.getType())){
            square = TypeTeam.X;
        }else{
            square = TypeTeam.O;
        }

        for(int l = 0; l<3; l++){
            if(verifyLine(l, square)){
                return true;
            }
        }
        for(int c = 0; c<3; c++){
            if(verifyColumn(c, square)){
                return true;
            }
        }
        if(verifyDiagonalLeft(0, square) || verifyDiagonalRight(0, square)){
            return true;
        }

        return false;
    }
    public Boolean verifyMatchNull(){

        for(int l = 0; l<3; l++){
            for(int c = 0; c<3; c++){
                if(this._board[l][c].getSquare() == null){
                    return false;
                }
            }
        }
        return true;
    }
    public Boolean verifyLine(int line, TypeTeam type){
        for(int i = 0; i<3; i++){
            if(!type.equals(_board[line][i].getSquare())){
                return false;
            }
        }
        return true;
    }
    public Boolean verifyColumn(int column, TypeTeam type){
        for(int i = 0; i<3; i++){
            if(!type.equals(_board[i][column].getSquare())){
                return false;
            }
        }
        return true;
    }
    public Boolean verifyDiagonalLeft(int line, TypeTeam type){
        int l = line;
        for(int i = 0; i<3; i++){
            if(!type.equals(_board[l][i].getSquare())){
                    return false;
            }
            l++;
        }

        return true;
    }
    public Boolean verifyDiagonalRight(int line, TypeTeam type){
        int l = line;

        for(int i = 2; i >= 0; i--){
            System.out.println("row: " + l  + " column: " + i);
            if(!type.equals(_board[l][i].getSquare())){
                return false;
            }
            l++;
        }
        return true;
    }

}
