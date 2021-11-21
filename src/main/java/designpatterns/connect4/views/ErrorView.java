package designpatterns.connect4.views;

import designpatterns.connect4.types.Error;

public abstract class ErrorView {

    public static final String[] MESSAGES = {
            "The square is not empty",
            "There is not a token of yours",
            "The origin and target squares are the same",
            "The coordinates are wrong"
    };

    public abstract void writeln(Error error);

}
