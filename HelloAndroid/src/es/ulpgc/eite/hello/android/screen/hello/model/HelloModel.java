package es.ulpgc.eite.hello.android.screen.hello.model;


import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;
import es.ulpgc.eite.hello.android.screen.hello.presenter.I_HelloPresenter;

public class HelloModel extends AndroidScreenModel implements I_HelloModel {

//    private final static String TXT_MSG = "Hello World!";
//    private final static String TXT_BTN = "Say Hello";

    private HelloData _data;

    public HelloModel() {
        //setData(new HelloData(TXT_MSG, TXT_BTN));
        setData(new HelloData());
    }

    @Override
    public HelloData getData() {
        return _data;
    }

    @Override
    public void setData(HelloData data) {
        _data = data;
    }

    private I_HelloPresenter getHelloPresenter(){
        return (I_HelloPresenter) getScreenPresenter();
    }

}
