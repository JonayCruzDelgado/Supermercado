package es.ulpgc.eite.hello.android.screen.bye.presenter;


import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.screen.bye.model.I_ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.state.ByeState;
import es.ulpgc.eite.hello.android.screen.bye.view.I_ByeView;
import es.ulpgc.eite.hello.android.screen.hello.view.HelloView;

public class ByePresenter
        extends AndroidScreenPresenter implements I_ByePresenter {


    private I_ByeView getByeView() {
        return (I_ByeView) getScreenView();
    }

    private I_ByeModel getByeModel(){
        return (I_ByeModel) getScreenModel();
    }

    @Override
    public void buttonClicked(){
        debug("buttonClicked");

        getByeView().showMessage();
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getByeView().setLayout();
        getByeView().setListener();
        getByeView().hideMessage();


    }

    @Override
    public void backScreen() {

    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen");

        getByeView().setData(getByeModel().getData());
    }

    @Override
    public void pauseScreen() {

    }

    @Override
    public void rotateScreen() {

    }

    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "code", code);
        debug("setScreenState", "view", view.getSimpleName());

        if(state != null) {
            if (view.equals(HelloView.class) && code == HelloMediatorCode.CLICK) {
                ByeState _state = (ByeState) state;
                getByeModel().setData(_state.getData());
            }
        }
    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        ByeState state = new ByeState();
        state.setData(getByeModel().getData());
        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {
        return null;
    }
}