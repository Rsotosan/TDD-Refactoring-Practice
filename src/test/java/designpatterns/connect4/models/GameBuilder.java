package designpatterns.connect4.models;

import designpatterns.connect4.types.Color;
import designpatterns.utils.models.ConcreteCoordinate;

import java.util.List;

public class GameBuilder {
    private Color color;
    private Game game;
    private String[] rows;

    public GameBuilder(){
        this.rows = new String[6];
        for(int i = 0; i < 6; i++){
            this.rows[i] = "       ";
        }
    }

    public Game build(){
        this.game = new Game();
        this.buildBoard();
        if (this.color != null && this.game.getActiveColor() != this.color) {
            this.game.next();
        }
        return this.game;
    }

    public void buildBoard(){
        Board board = new BoardBuilder().rows(this.rows).build();

        for (int i = 0; i < 2; i++) {
            List<ConcreteCoordinate> coordinates = board.getCoordinates(this.color);
            if (!coordinates.isEmpty()){
                this.game.next();
            }
            while(!coordinates.isEmpty()){
                this.game.putToken(coordinates.get(0).getColumn() + 1);
                coordinates.remove(0);
            }
        }
    }

    public GameBuilder rows(String... rows){
        this.rows = rows;
        return this;
    }

    public GameBuilder turn(Color color){
        this.color = color;
        return this;
    }
}
