package designpatterns.connect4.models;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameTest {

    @Test
    public void givenMementoWhenSetMementoThenChangeBoardAndTurn(){
        Game game = new Game();
        Board board = new Board();
        Turn turn = new Turn(board);
        turn.next();
        Memento memento = new Memento(board, turn);
        game.setMemento(memento);
        assertThat(turn.getActivePlayer().getColor(), is(game.getActiveColor()));
    }
}
