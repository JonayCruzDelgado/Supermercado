package es.ulpgc.eite.hello.android.screen.moreProducts.view;

import es.ulpgc.eite.framework.android.AndroidScreenView;
import es.ulpgc.eite.hello.android.R;

/**
 * Created by Jonay on 21/04/2016.
 */
public abstract class MoreProductsView extends AndroidScreenView implements I_MoreProductsView {

    public abstract int getLayout();

    @Override
    public void setLayout() {
        debug("setLayout");
        setContentView(getLayout());
    }

    @Override
    public void setListener() {

    }
}
