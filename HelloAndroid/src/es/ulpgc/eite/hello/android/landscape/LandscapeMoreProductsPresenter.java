package es.ulpgc.eite.hello.android.landscape;

import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.screen.moreProducts.presenter.MoreProductsPresenter;

/**
 * Created by Jonay on 22/04/2016.
 */
public class LandscapeMoreProductsPresenter extends MoreProductsPresenter {
    @Override
    public void rotateScreen() {
        debug("rotateScreen");

        changeRotation(HelloMediatorCode.more_portrait);
    }
}
