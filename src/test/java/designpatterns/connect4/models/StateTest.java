package designpatterns.connect4.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class StateTest {
    private State state;

    @Mock
    StateValue stateValue;

    @BeforeEach
    public void beforeEach(){
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenStateValueThenIsINITIAL(){
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenNewStateWhenNextThenStateValueIsIN_GAME(){
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }

    @Test
    public void testGivenNewStateWhenNextAndResetThenStateValueIsINITIAL(){
        this.state.next();
        this.state.reset();
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenNewStateWhenFourNextThenAssertionError4() {
        this.state.next();
        this.state.next();
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.EXIT));
    }

    /*

    @Test
    public void testGivenNewStateWhenFourNextThenAssertionError() {
        try(MockedStatic<StateValue> stateValue = mockStatic(StateValue.class)) {
            stateValue.when().thenReturn(this.stateValue);
            assertThrows(AssertionError.class, () -> this.state.next());
        }
    } */

}
