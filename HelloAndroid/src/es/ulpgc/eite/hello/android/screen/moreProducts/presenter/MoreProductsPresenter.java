package es.ulpgc.eite.hello.android.screen.moreProducts.presenter;

import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.screen.moreProducts.view.I_MoreProductsView;

/**
 * Created by Jonay on 21/04/2016.
 */
public abstract class MoreProductsPresenter extends AndroidScreenPresenter implements I_MoreProductsPresenter {

    private I_MoreProductsView getMoreProductsView() {
     return (I_MoreProductsView)getScreenView();
    }

    @Override
    public void createScreen() {
        debug("createScreen");
        getMoreProductsView().setLayout();

    }

    @Override
    public void backScreen() {

    }

    @Override
    public void resumeScreen() {

    }

    @Override
    public void pauseScreen() {

    }
    public void changeRotation(int code){
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
    }
    @Override
    public void rotateScreen() {

    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> aClass, int i, I_ScreenState i_screenState) {

    }

    @Override
    public I_ScreenState getScreenState() {
        return null;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> aClass, int i) {
        return null;
    }
}
