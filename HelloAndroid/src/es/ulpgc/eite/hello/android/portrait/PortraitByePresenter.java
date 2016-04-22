package es.ulpgc.eite.hello.android.portrait;

import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.screen.bye.presenter.ByePresenter;

/**
 * Created by Jonay on 22/04/2016.
 */
public class PortraitByePresenter extends ByePresenter {
    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(HelloMediatorCode.bye_landscape);
    }
}
