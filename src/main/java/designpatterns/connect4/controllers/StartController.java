package designpatterns.connect4.controllers;

import designpatterns.connect4.models.Game;
import designpatterns.connect4.models.State;

public class StartController extends Controller {

    public StartController(Game game, State state) {
        super(game, state);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
