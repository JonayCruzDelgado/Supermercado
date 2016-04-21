package es.ulpgc.eite.hello.android.screen.moreProducts.view;

import es.ulpgc.eite.framework.android.AndroidScreenView;
import es.ulpgc.eite.hello.android.R;

/**
 * Created by Jonay on 21/04/2016.
 */
public class MoreProductsView extends AndroidScreenView implements I_MoreProductsView {

    @Override
    public void setLayout() {
        debug("setLayout");
        setContentView(R.layout.more_products_view);
    }

    @Override
    public void setListener() {

    }
}
