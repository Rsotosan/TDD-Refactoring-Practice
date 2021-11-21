package designpatterns.connect4.views.console;

import designpatterns.connect4.types.Error;
import designpatterns.utils.views.Console;

class ErrorView extends designpatterns.connect4.views.ErrorView {

    @Override
    public void writeln(Error error) {
        if (!error.isNull()) {
            Console.getInstance().writeln(ErrorView.MESSAGES[error.ordinal()]);
        }
    }

}
