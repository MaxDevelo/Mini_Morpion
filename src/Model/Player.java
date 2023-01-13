package Model;

public class Player {
    private String _name;
    private TypeTeam _type;
    private Boolean _play;
    public Player(String name, char type){
        this._name = name;
        if(type == 'X'){
            _type = TypeTeam.X;
        }else{
            _type = TypeTeam.O;
        }
    }
    public String getName(){
        return this._name;
    }
    public TypeTeam getType(){
        return _type;
    }
    public void setPlay(Boolean play){
        this._play = play;
    }
    public Boolean play(){
        return _play;
    }

}
