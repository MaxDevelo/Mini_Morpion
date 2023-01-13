package Model;

public class Square {
    private TypeTeam _nameSquare;
    private int _posX, _posY;
    public Square(int posX, int posY){
        _nameSquare = null;
        this._posX = posX;
        this._posY = posY;
    }
    public void setSquare(TypeTeam nameSquare){
        System.out.println(nameSquare);
        this._nameSquare = nameSquare;
    }
    public TypeTeam getSquare(){
        return _nameSquare;
    }
    public int getRow(){
        return this._posX;
    }
    public int getColumn(){
        return this._posY;
    }

}
