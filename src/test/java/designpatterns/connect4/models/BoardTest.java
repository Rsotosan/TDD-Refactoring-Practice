package designpatterns.connect4.models;

import designpatterns.connect4.types.Color;
import designpatterns.utils.models.ConcreteCoordinate;
import designpatterns.utils.models.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardTest {

    BoardBuilder boardBuilder;
    @BeforeEach
    public void beforeEach(){
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenEmptyBoardWhenStartThenIsEmpty(){
        Board board = this.boardBuilder.build();
        assertEmpty(board);
    }

    @Test
    public void testGivenEmptyBoardWhenPutTokenAndResetThenIsEmpty(){
        Board board = this.boardBuilder.build();
        board.putToken(1, Color.RED);
        board.reset();
        assertEmpty(board);
    }

    @Test
    public void testGivenEmptyBoardWhenPutTokenThenIsOccupiedCoordinate(){
        Board board = this.boardBuilder.build();
        board.putToken(1, Color.RED);
        assertThat(board.getColor(new ConcreteCoordinate(0,0)), is(Color.RED));
    }

    @Test
    public void testGivenNotEmptyBoardWhenResetThenIsEmpty(){
        Board board = this.boardBuilder.rows(
                "YRYRYRY",
                "RYRYRYR",
                "Y     R"
        ).build();
        board.reset();
        assertEmpty(board);
    }

    @Test
    public void testGivenEmptyBoardWhenIsConnect4ThenFalse(){
        Board board = this.boardBuilder.build();
        assertThat(board.isConnect4(), is(false));
    }

    @Test
    public void testGivenBoardWithConnect4VerticalWhenIsConnect4ThenTrue(){
        Board board = this.boardBuilder.rows(
                "Y      ",
                "Y      ",
                "Y      ",
                "Y      "
        ).build();
        assertThat(board.isConnect4(), is(true));
    }

    @Test
    public void testGivenBoardWithConnect4HorizontalWhenIsConnect4ThenTrue(){
        Board board = this.boardBuilder.rows(
                "YYYY   "
        ).build();
        assertThat(board.isConnect4(), is(true));
    }

    @Test
    public void testGivenBoardWithConnect4DiagonalWhenIsConnect4ThenTrue(){
        Board board = this.boardBuilder.rows(
                "YRRR   ",
                "RYRR   ",
                "RRYR   ",
                "   Y   "
        ).build();
        assertThat(board.isConnect4(), is(true));
    }
    @Test
    public void testGivenBoardWithConnect4WhenIsConnect4FromOtherCoordinateThenFalse(){
        Board board = this.boardBuilder.rows(
                "YR     ",
                "Y      ",
                "Y      ",
                "Y      "
        ).build();
        assertThat(board.isConnect4(new ConcreteCoordinate(0,1)), is(false));
    }

    @Test
    public void testGivenBoardWithConnect4WhenIsConnect4InOtherDirectionThenFalse(){
        Board board = this.boardBuilder.rows(
                "Y      ",
                "Y      ",
                "Y      ",
                "Y      "
        ).build();
        assertThat(board.isConnect4(new ConcreteCoordinate(0,0), Direction.EAST), is(false));
    }

    @Test
    public void testGivenFullBoardWhenIsAvaiableMoveAnyThenFalse(){
        Board board = this.boardBuilder.rows(
                "YRYRYRY",
                "RYRYRYR",
                "YRYRYRY",
                "RYRYRYR",
                "YRYRYRY",
                "RYRYRYR"
        ).build();

        assertThat(board.isAvailableMove(1), is(false));
        assertThat(board.isAvailableMove(2), is(false));
        assertThat(board.isAvailableMove(3), is(false));
        assertThat(board.isAvailableMove(4), is(false));
        assertThat(board.isAvailableMove(5), is(false));
        assertThat(board.isAvailableMove(6), is(false));
        assertThat(board.isAvailableMove(7), is(false));

    }

    public static void assertEmpty(Board board) {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                assertThat(board.isEmpty(new ConcreteCoordinate(i, j)), is(true));
            }
        }
    }
}
