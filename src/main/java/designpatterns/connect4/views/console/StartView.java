package designpatterns.connect4.views.console;

import designpatterns.connect4.controllers.StartController;
import designpatterns.connect4.views.Message;

class StartView{

    void interact(StartController startController) {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(startController);
        startController.nextState();
    }

}
