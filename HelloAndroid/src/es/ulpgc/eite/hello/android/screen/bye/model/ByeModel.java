package es.ulpgc.eite.hello.android.screen.bye.model;


import es.ulpgc.eite.framework.android.AndroidScreenModel;
import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;
import es.ulpgc.eite.hello.android.screen.bye.presenter.I_ByePresenter;

public class ByeModel extends AndroidScreenModel implements I_ByeModel {

//    private final static String TXT_MSG = "Bye World!";
//    private final static String TXT_BTN = "Say Bye";

    private ByeData _data;

    public ByeModel() {
        //setData(new ByeData(TXT_MSG, TXT_BTN));
        setData(new ByeData());
    }

    @Override
    public ByeData getData() {
        return _data;
    }

    @Override
    public void setData(ByeData data) {
        _data = data;
    }

    private I_ByePresenter getByePresenter(){
        return (I_ByePresenter) getScreenPresenter();
    }

}
