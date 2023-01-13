package Model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> _players = new ArrayList<>();
    private Player _playerPlay;

    public Game(String namePlayerOne, String namePlayerTwo){
        Player player1 = new Player(namePlayerOne, 'X');
        player1.setPlay(true);
        _players.add(player1);
        this._playerPlay = player1;
        System.out.println(_playerPlay);
        Player player2 = new Player(namePlayerTwo, 'O');
        player2.setPlay(false);
        _players.add(player2);
    }

    public List<Player> getPlayers(){
        return this._players;
    }

    public Player getPlayerPlay(){
        return this._playerPlay;
    }

    public void chanegTurn(){
        for(Player player: _players){
            if(player.play()){
                player.setPlay(false);
            }else{
                player.setPlay(true);
                this._playerPlay = player;
            }
        }
    }

}
