package designpatterns.connect4.models;

import org.junit.jupiter.api.Test;

import designpatterns.connect4.types.Color;
import designpatterns.utils.models.ConcreteCoordinate;
import designpatterns.utils.models.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RegistryTest {

    @Test
    public void givenNewRegistryWhenIsUndoableThenFalse(){
        assertThat(new Registry().isUndoable(), is(false));
    }

    @Test
    public void givenRegistryUndoableWhenIsUndoableThenTrue(){
        Registry registry = new Registry();
        Board board = new Board();
        registry.register(board, new Turn(board));
        assertThat(registry.isUndoable(), is(true));
    }
}
