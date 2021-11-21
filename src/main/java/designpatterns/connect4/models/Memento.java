package designpatterns.connect4.models;

public class Memento {
    private Board board;
    private Turn turn;

    public Memento(Board board, Turn turn){
        this.board = board;
        this.turn = turn;
    }

    public Board getBoard() {
        return board;
    }

    public Turn getTurn() {
        return turn;
    }
}
