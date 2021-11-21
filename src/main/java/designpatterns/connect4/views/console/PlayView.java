package designpatterns.connect4.views.console;

import designpatterns.connect4.controllers.PlayController;
import designpatterns.connect4.views.Message;

class PlayView {

    void interact(PlayController playController) {
        do {
            new PlayerView(playController).interact();
            playController.next();
            new BoardView().write(playController);
        } while (!playController.isConnect4());
        new MessageView().writeln(Message.PLAYER_WIN, playController.getActiveColor().name());
        playController.nextState();
    }

}
