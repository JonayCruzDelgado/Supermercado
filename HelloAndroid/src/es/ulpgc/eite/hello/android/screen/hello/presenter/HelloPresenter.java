package es.ulpgc.eite.hello.android.screen.hello.presenter;


import es.ulpgc.eite.framework.android.AndroidScreenPresenter;
import es.ulpgc.eite.framework.core.screen.I_ScreenObserver;
import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.framework.core.screen.I_ScreenView;
import es.ulpgc.eite.hello.android.landscape.LandscapeByeView;
import es.ulpgc.eite.hello.android.landscape.LandscapeHelloView;
import es.ulpgc.eite.hello.android.mediator.HelloMediatorCode;
import es.ulpgc.eite.hello.android.portrait.PortraitByeView;
import es.ulpgc.eite.hello.android.portrait.PortraitHelloView;
import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;
import es.ulpgc.eite.hello.android.screen.bye.model.I_ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.state.ByeState;
import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;
import es.ulpgc.eite.hello.android.screen.hello.model.I_HelloModel;
import es.ulpgc.eite.hello.android.screen.hello.state.HelloState;
import es.ulpgc.eite.hello.android.screen.hello.view.I_HelloView;
import es.ulpgc.eite.hello.android.screen.moreProducts.data.MoreProductsData;
import es.ulpgc.eite.hello.android.screen.moreProducts.state.MoreProductsState;
import es.ulpgc.eite.hello.android.screen.moreProducts.view.MoreProductsView;

public abstract class HelloPresenter
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

    private I_HelloModel getHelloModel() {
        return (I_HelloModel) getScreenModel();
    }

    @Override
    public void buttonClicked() {
        debug("buttonClicked");

        setBtnClicked(true);
        getHelloView().showMessage();
        transition();

    }

    public void transition() {
        debug("transition", "pantalla", getScreenView().getClass().getSimpleName());
        if (getScreenView().getClass().getSimpleName().equalsIgnoreCase("PortraitHelloView")) {
            startNextScreenWithObserver(this, HelloMediatorCode.CLICK);
        }
        if (getScreenView().getClass().getSimpleName().equalsIgnoreCase("LandscapeHelloView")) {
            startNextScreenWithObserver(this, HelloMediatorCode.CLICK_land);
        }
    }
    public void transitionMore() {
        debug("transitionMore", "pantalla", getScreenView().getClass().getSimpleName());
        if (getScreenView().getClass().getSimpleName().equalsIgnoreCase("PortraitHelloView")) {
            startNextScreenWithObserver(this, HelloMediatorCode.CLIC_more);
        }
        if (getScreenView().getClass().getSimpleName().equalsIgnoreCase("LandscapeHelloView")) {
            startNextScreenWithObserver(this, HelloMediatorCode.CLICK_more_land);
        }
    }


    @Override
    public void buttonClickedMore() {
        debug("buttonClicked");

        setBtnClicked(true);
        getHelloView().showMessage();
        transitionMore();
    }

    public void changeRotation(int code) {
        debug("changeRotation", "code", code);

        startNextScreenWithFinish(code, true);
    }

    @Override
    public void createScreen() {
        debug("createScreen");

        getHelloView().setLayout();
        getHelloView().setListener();
        getHelloView().setListenerMoreProducts();
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

        if (state != null) {
            HelloState _state = (HelloState) state;
            getHelloModel().setData(_state.getData());
            setBtnClicked(_state.getBtnClicked());
            _state.set_presentview(view.getSimpleName());
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

        if (view.equals(PortraitByeView.class) && code == HelloMediatorCode.CLICK) {

            ByeState state = new ByeState();
            state.setData(new ByeData(I_ByeModel.TXT_MSG, I_ByeModel.TXT_BTN));
            return state;
        }
        if (view.equals(LandscapeByeView.class) && code == HelloMediatorCode.CLICK_land) {

            ByeState state = new ByeState();
            state.setData(new ByeData(I_ByeModel.TXT_MSG, I_ByeModel.TXT_BTN));
            return state;
        }
        if (view.equals(MoreProductsView.class) && code == HelloMediatorCode.CLIC_more) {
            MoreProductsState state = new MoreProductsState();
            state.setData(new MoreProductsData());
            return state;
        }
        if ((view.equals(LandscapeHelloView.class)
                && code == HelloMediatorCode.hello_landscape)
                || (view.equals(PortraitHelloView.class)
                && code == HelloMediatorCode.hello_portrait)) {
            HelloState state = new HelloState();
            state.setData(getHelloModel().getData());
            state.setBtnClicked(getBtnClicked());
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
