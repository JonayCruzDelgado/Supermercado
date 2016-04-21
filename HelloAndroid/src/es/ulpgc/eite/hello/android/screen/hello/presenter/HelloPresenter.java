package es.ulpgc.eite.hello.android.screen.hello.presenter;


import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;
import es.ulpgc.eite.hello.android.screen.bye.model.I_ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.state.ByeState;
import es.ulpgc.eite.hello.android.screen.bye.view.ByeView;
import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;
import es.ulpgc.eite.hello.android.screen.hello.model.I_HelloModel;
import es.ulpgc.eite.hello.android.screen.hello.state.HelloState;
import es.ulpgc.eite.hello.android.screen.hello.view.I_HelloView;

public class HelloPresenter
        extends AndroidScreenPresenter implements I_HelloPresenter, I_ScreenObserver {

    private Boolean _btnClicked;

    public Boolean getBtnClicked() {
        return _btnClicked;
    }

    public void setBtnClicked(Boolean btnClicked) {
        _btnClicked = btnClicked;
    }

    private I_HelloView getHelloView() {
        return (I_HelloView) getScreenView();
    }

    private I_HelloModel getHelloModel(){
        return (I_HelloModel) getScreenModel();
    }

    @Override
    public void buttonClicked(){
        debug("buttonClicked");

        setBtnClicked(true);
        getHelloView().showMessage();
        startNextScreenWithObserver(this, HelloMediatorCode.CLICK);
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getHelloView().setLayout();
        getHelloView().setListener();
        getHelloView().hideMessage();
        setBtnClicked(false);
        getHelloModel().setData(new HelloData(
                I_HelloModel.TXT_MSG, I_HelloModel.TXT_BTN, I_HelloModel.TXT_MoreProduct));

    }

    @Override
    public void backScreen() {

    }

    @Override
    public void resumeScreen() {
        debug("resumeScreen", "clicked", getBtnClicked());

        getHelloView().setData(getHelloModel().getData());

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

        debug("setScreenState", "clicked", getBtnClicked());

        if(state != null) {
            HelloState _state = (HelloState) state;
            getHelloModel().setData(_state.getData());
            setBtnClicked(_state.getBtnClicked());
        }
    }

    @Override
    public I_ScreenState getScreenState() {
        debug("getScreenState");

        HelloState state = new HelloState();
        state.setData(getHelloModel().getData());
        state.setBtnClicked(getBtnClicked());

        debug("getScreenState", "clicked", getBtnClicked());

        return state;
    }

    @Override
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "code", code);
        debug("getNextState", "view", view.getSimpleName());

        debug("getNextState", "clicked", getBtnClicked());

        if(view.equals(ByeView.class) && code == HelloMediatorCode.CLICK){
            ByeState state = new ByeState();
            state.setData(new ByeData(I_ByeModel.TXT_MSG, I_ByeModel.TXT_BTN));
            return state;
        }

        return null;
    }

    @Override
    public I_ScreenState updateObserverState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        return null;
    }
}
