package designpatterns.connect4.models;

import java.util.ArrayList;
import java.util.List;

public class Registry {

    private List<Memento> mementos;
    private List<Board> boards;
    private List<Turn> turns;
    private int n;

    public Registry(){
        mementos = new ArrayList<Memento>();
    }

    public boolean isUndoable(){
        return n>0;
    }

    public void register(Board board, Turn turn) {
        mementos.add(new Memento(board, turn));
        n++;
    }

    public void reset(){
        n = 0;
    }

    public Object[] undo() {
        return new Object[] {mementos.get(n-1).getBoard(), mementos.get(n-1).getTurn()};
    }
}
