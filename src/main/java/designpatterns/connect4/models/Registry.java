package designpatterns.connect4.models;

import java.util.List;

public class Registry {

    private int n;

    public boolean isUndoable(){
        return n>0;
    }

    public void register(Board board, Turn turn) {
        n++;
    }

    public void reset(){

    }
}
