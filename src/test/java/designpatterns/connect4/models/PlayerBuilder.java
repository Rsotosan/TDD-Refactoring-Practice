package designpatterns.connect4.models;

import designpatterns.connect4.types.Color;
import designpatterns.utils.models.ConcreteCoordinate;

import java.util.List;

public class PlayerBuilder {

    private Color color;
    private Player player;
    private String[] rows;

    public PlayerBuilder(){
        this.rows = new String[6];
        for(int i = 0; i < 6; i++){
            this.rows[i] = "       ";
        }
    }

    public Player build() {
        Board board = new BoardBuilder().build();
        this.player = new Player(this.color, board);
        this.putTokens();
        return this.player;
    }

    public void putTokens(){
        Board board = new BoardBuilder().rows(this.rows).build();
        List<ConcreteCoordinate> coordinates = board.getCoordinates(this.color);
        while (!coordinates.isEmpty()){
            this.player.putToken(coordinates.get(0).getColumn());
            coordinates.remove(0);
        }
    }

    public PlayerBuilder rows(String... rows){
        this.rows = rows;
        return this;
    }

    public PlayerBuilder turn(Color color){
        this.color = color;
        return this;
    }
}
