package es.ulpgc.eite.hello.android.landscape;

import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.screen.bye.presenter.ByePresenter;

/**
 * Created by Jonay on 22/04/2016.
 */
public class LandscapeByePresenter extends ByePresenter {
    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(HelloMediatorCode.bye_portrait);
    }
}
