package es.ulpgc.eite.hello.android.screen.bye.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.hello.android.screen.bye.data.ByeData;

public class ByeState implements I_ScreenState {

    private ByeData _data;

    public ByeState() {
        setData(new ByeData());
    }

    public ByeData getData() {
        return _data;
    }

    public void setData(ByeData data) {
        _data = data;
    }


}
