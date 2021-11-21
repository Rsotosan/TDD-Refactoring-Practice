package designpatterns.connect4.models;

import designpatterns.connect4.types.Color;
import designpatterns.connect4.types.Error;

class Player {

    private Color color;
    private Board board;

    Player(Color color, Board board) {
        assert !color.isNull();
        assert board != null;

        this.color = color;
        this.board = board;
    }

    void putToken(int column) {
        this.board.putToken(column, this.color);
    }

    Error getPutTokenError(int column) {
        if (!this.board.thereIsEmpty(column)) {
            return Error.NOT_EMPTY;
        }
        return Error.NULL;
    }

    Color getColor() {
        return this.color;
    }
    
}
