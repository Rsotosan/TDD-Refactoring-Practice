package designpatterns.connect4.models;

import designpatterns.connect4.types.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TurnTest {

    private Turn turn;

    @BeforeEach
    public void beforeEach() {
        this.turn = new Turn(new Board());
    }

    @Test
    public void testGivenNewTurnWhenNullBoardThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> this.turn = new Turn(null));
    }

    @Test
    public void testGivenTurnWhenBeforeAndAfterNextThenActivePlayersColorMatchesActiveColor(){
        assertThat(this.turn.getActivePlayer().getColor(), is(Color.RED));
        assertThat(this.turn.getActiveColor(), is(Color.RED));

        this.turn.next();

        assertThat(this.turn.getActivePlayer().getColor(), is(Color.YELLOW));
        assertThat(this.turn.getActiveColor(), is(Color.YELLOW));
    }

    @Test
    public void testGivenTurnWhenResetThenActivePlayerIs0() {
        this.turn.next();
        this.turn.reset();
        assertThat(this.turn.getActivePlayer().getColor(), is(Color.RED));
    }

    @Test
    public void testGivenNewTurnWhenGetActivePlayerThenReturn() {
        assertThat(this.turn.getActivePlayer().getColor(), is(Color.RED));
    }

    @Test
    public void testGivenNewTurnWhenGetActiveColorThenCorrectColorIsCaptured() {
        assertThat(this.turn.getActiveColor(), is(Color.RED));
    }

    @Test
    public void testGivenTurnWhenNextThenNextTurn() {
        this.turn.next();
        assertThat(this.turn.getActiveColor(), is(Color.YELLOW));
        this.turn.next();
        assertThat(this.turn.getActiveColor(), is(Color.RED));
    }

}
