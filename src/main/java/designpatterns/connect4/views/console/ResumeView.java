package designpatterns.connect4.views.console;

import designpatterns.connect4.controllers.ResumeController;
import designpatterns.connect4.views.Message;
import designpatterns.utils.views.YesNoDialog;

class ResumeView {

    boolean interact(ResumeController resumeController) {
        YesNoDialog isResumed = new YesNoDialog();
        isResumed.read(Message.RESUME.toString());
        if (isResumed.isAffirmative()) {
            resumeController.reset();
        } else {
            resumeController.nextState();
        }
        return isResumed.isAffirmative();
    }

}
