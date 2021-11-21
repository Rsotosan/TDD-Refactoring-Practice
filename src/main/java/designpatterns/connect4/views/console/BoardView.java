package designpatterns.connect4.views.console;

import designpatterns.connect4.controllers.Controller;
import designpatterns.connect4.views.Message;
import designpatterns.connect4.models.Board;
import designpatterns.utils.models.ConcreteCoordinate;
import designpatterns.utils.views.Console;

class BoardView {

    void write(Controller controller) {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = Board.ROWS-1; i >= 0; i--) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0 ; j < Board.COLUMNS; j++) {
                new ColorView().write(controller.getColor(new ConcreteCoordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }

}
