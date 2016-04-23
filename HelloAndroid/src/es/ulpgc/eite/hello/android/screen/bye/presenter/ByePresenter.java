package es.ulpgc.eite.hello.android.screen.bye.presenter;


import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.landscape.LandscapeHelloView;
import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.portrait.PortraitHelloView;
import es.ulpgc.eite.hello.android.screen.bye.model.I_ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.state.ByeState;
import es.ulpgc.eite.hello.android.screen.bye.view.I_ByeView;
import es.ulpgc.eite.hello.android.screen.hello.view.HelloView;

public abstract class ByePresenter
        extends AndroidScreenPresenter implements I_ByePresenter {

    private Boolean _btnClicked;

    private I_ByeView getByeView() {
        return (I_ByeView) getScreenView();
    }

    private I_ByeModel getByeModel(){
        return (I_ByeModel) getScreenModel();
    }

    public Boolean getBtnClicked() {
        return _btnClicked;
    }

    public void setBtnClicked(Boolean btnClicked) {
        _btnClicked = btnClicked;
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

    public void changeRotation(int code){
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
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
               if ((view.equals(PortraitHelloView.class)

                    && code == HelloMediatorCode.CLICK)
                    || (view.equals(LandscapeHelloView.class)
                    && code == HelloMediatorCode.CLICK)) {

                ByeState _state = (ByeState) state;
                getByeModel().setData(_state.getData());
                setBtnClicked(_state.getBtnClicked());
            }
        }

        debug("setScreenState", "clicked", getBtnClicked());

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
