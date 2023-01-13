package p21.td6;

import Controller.MorpionFacade;
import Model.Board;
import p21.td6.View.GameView;

public class Main {

    public static void main(String[] args) {
        MorpionFacade facade = new MorpionFacade();
        facade.newGame();
    }
}
