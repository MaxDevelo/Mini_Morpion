package tests;

import Model.Board;
import Model.TypeTeam;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testBoardTest {


    @Test
    void verifyMatchNull() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.getBoard()[i][j].setSquare(TypeTeam.X);
            }
        }
        assertTrue(board.verifyMatchNull());

        board.getBoard()[0][0].setSquare(null);
        assertFalse(board.verifyMatchNull());
    }

    @Test
    void verifyLine() {
        Board board = new Board();
        // Compléter la ligne de 'X'
        for (int i = 0; i < 3; i++) {
            board.getBoard()[0][i].setSquare(TypeTeam.X);
        }
        // Vérifier que cela renvoie bien Vrai
        assertTrue(board.verifyLine(0, TypeTeam.X));

        // Compléter la ligne  de 'O'
        for (int i = 0; i < 3; i++) {
            board.getBoard()[1][i].setSquare(TypeTeam.O);
        }
        // Vérifier que cela renvoie bien Vrai
        assertTrue(board.verifyLine(1, TypeTeam.O));

        // Clear la première case de la deuxième ligne
        board.getBoard()[1][0].setSquare(null);
        // Cela renvoie Faux car il n'y a pas de 3 'O' consécutuve
        assertFalse(board.verifyLine(1, TypeTeam.X));
    }



    @Test
    void verifyColumn() {
        Board board = new Board();
        // Compléter la colonne de 'X'
        for (int i = 0; i < 3; i++) {
            board.getBoard()[i][0].setSquare(TypeTeam.X);
        }
        // Vérifier que cela renvoie bien Vrai
        assertTrue(board.verifyColumn(0, TypeTeam.X));

        // Compléter la colonne de 'O'
        for (int i = 0; i < 3; i++) {
            board.getBoard()[i][1].setSquare(TypeTeam.O);
        }
        // Vérifier que cela renvoie bien Vrai
        assertTrue(board.verifyColumn(1, TypeTeam.O));

        // Clear la prmeière case
        board.getBoard()[0][0].setSquare(null);
        // Cela renvoie Faux car il n'y a pas de 3 'O' consécutuve
        assertFalse(board.verifyColumn(0, TypeTeam.X));
    }

    @Test
    void verifyDiagonalLeft() {
        Board board = new Board();
        // Compléter la diagonale de 'X'
        for(int i=0; i<3; i++){
            board.getBoard()[i][i].setSquare(TypeTeam.X);
        }
        // Vérifier que cela renvoie bien Vrai
        assertTrue(board.verifyDiagonalLeft(0, TypeTeam.X));

        // Clear la première case
        board.getBoard()[0][0].setSquare(null);
        assertFalse(board.verifyDiagonalLeft(0, TypeTeam.X));
    }

    @Test
    void verifyDiagonalRight() {
        Board board = new Board();
        // Compléter la diagonale de 'X'
        int line = 0;
        for(int i=2; i >= 0; i--){
            board.getBoard()[line][i].setSquare(TypeTeam.X);
            line++;
        }
        // Vérifier que cela renvoie bien Vrai
        assertTrue(board.verifyDiagonalRight(0, TypeTeam.X));

        // Clear la première case
        board.getBoard()[0][2].setSquare(null);
        assertFalse(board.verifyDiagonalRight(0, TypeTeam.X));
    }



}