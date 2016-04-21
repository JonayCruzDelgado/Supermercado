package es.ulpgc.eite.hello.android.screen.moreProducts.state;

import es.ulpgc.eite.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.hello.android.screen.moreProducts.data.MoreProductsData;

/**
 * Created by Jonay on 21/04/2016.
 */
public class MoreProductsState implements I_ScreenState{
    private MoreProductsData _data;
    public MoreProductsState(){
        setData(new MoreProductsData());
    }
    public MoreProductsData get_data(){
        return _data;
    }

    public void setData(MoreProductsData data) {
        data = _data;
    }
}
