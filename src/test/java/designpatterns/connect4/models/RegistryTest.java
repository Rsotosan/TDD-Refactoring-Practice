package designpatterns.connect4.models;

import org.junit.jupiter.api.Test;

import designpatterns.connect4.types.Color;
import designpatterns.utils.models.ConcreteCoordinate;
import designpatterns.utils.models.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RegistryTest {

    @Test
    public void givenEmptyRegistryWhenIsUndoableThenFalse(){
        assertThat(new Registry().isUndoable(), is(false));
    }

    @Test
    public void givenRegistryWhenIsUndoableThenTrue(){
        Registry registry = new Registry();
        Board board = new Board();
        registry.register(board, new Turn(board));
        assertThat(registry.isUndoable(), is(true));
    }

    @Test
    public void givenRegistryAndResetWhenIsUndoableThenFalse(){
        Registry registry = new Registry();
        Board board = new Board();
        registry.register(board, new Turn(board));
        registry.reset();
        assertThat(registry.isUndoable(), is(false));
    }

    @Test
    public void givenRegistryWhenUndoThenGetBoardAndTurn(){
        Registry registry = new Registry();
        Board board = new Board();
        Turn turn = new Turn(board);
        registry.register(board, turn);
        Memento memento = registry.undo();
        assertThat(memento.getBoard(), equalToObject(board));
        assertThat(memento.getTurn(), equalToObject(turn));
    }

    @Test
    public void givenRegistryWhenUndoTwoTimesThenGetBoardAndTurn(){
        Registry registry = new Registry();
        Board board = new Board();
        Turn turn = new Turn(board);
        registry.register(board, turn);
        registry.register(new Board(), new Turn(new Board()));
        registry.undo();
        Memento memento = registry.undo();
        assertThat(memento.getBoard(), equalToObject(board));
        assertThat(memento.getTurn(), equalToObject(turn));
    }
}
