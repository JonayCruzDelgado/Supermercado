package es.ulpgc.eite.hello.android.mediator;


import es.ulpgc.eite.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.framework.core.mediator.MediatorTransition;
import es.ulpgc.eite.hello.android.landscape.*;
import es.ulpgc.eite.hello.android.portrait.*;
import es.ulpgc.eite.hello.android.screen.bye.model.ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.presenter.ByePresenter;
import es.ulpgc.eite.hello.android.screen.bye.view.ByeView;
import es.ulpgc.eite.hello.android.screen.hello.model.HelloModel;
import es.ulpgc.eite.hello.android.screen.hello.presenter.HelloPresenter;
import es.ulpgc.eite.hello.android.screen.hello.view.HelloView;
import es.ulpgc.eite.hello.android.screen.moreProducts.model.MoreProductsModel;
import es.ulpgc.eite.hello.android.screen.moreProducts.presenter.MoreProductsPresenter;
import es.ulpgc.eite.hello.android.screen.moreProducts.view.MoreProductsView;
import es.ulpgc.eite.hello.android.screen.category.view.CategoryMasterView;
import es.ulpgc.eite.hello.android.screen.category.presenter.CategoryMasterPresenter;
import es.ulpgc.eite.hello.android.screen.category.model.CategoryMasterModel;
import es.ulpgc.eite.hello.android.database.DatabaseMasterDetail;
import es.ulpgc.eite.hello.android.screen.product.presenter.ProductMasterPresenter;
import es.ulpgc.eite.hello.android.screen.product.model.ProductMasterModel;
import es.ulpgc.eite.hello.android.screen.product.view.ProductMasterView;
import es.ulpgc.eite.hello.android.screen.detail.view.DetailView;
import es.ulpgc.eite.hello.android.screen.detail.presenter.DetailPresenter;
import es.ulpgc.eite.hello.android.screen.detail.model.DetailModel;

public class HelloMediatorConfig extends MediatorConfig {

    public HelloMediatorConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setHelloConfig();
    }

    private void setHelloConfig() {
        setHelloScreenCollection();
        setHelloTransitionCollection();
    }

    private void setHelloScreenCollection() {
        getScreens().add(new MediatorScreen(
                PortraitHelloView.class, PortraitHelloPresenter.class, HelloModel.class));
        getScreens().add(new MediatorScreen(
                LandscapeHelloView.class, LandscapeHelloPresenter.class, HelloModel.class));
        getScreens().add(new MediatorScreen(
                PortraitByeView.class, PortraitByePresenter.class, ByeModel.class));
        getScreens().add(new MediatorScreen(
                LandscapeByeView.class, LandscapeByePresenter.class, ByeModel.class));
        getScreens().add(new MediatorScreen(
                LandscapeMoreProductsView.class, LandscapeMoreProductsPresenter.class, MoreProductsModel.class));
        getScreens().add(new MediatorScreen(
                PortraitMoreProductsView.class, PortraitMoreProductsPresenter.class, MoreProductsModel.class));
        getScreens().add(new MediatorScreen(
                CategoryMasterView.class, CategoryMasterPresenter.class,
                CategoryMasterModel.class, DatabaseMasterDetail.class));
        getScreens().add(new MediatorScreen(
                ProductMasterView.class, ProductMasterPresenter.class,
                ProductMasterModel.class, DatabaseMasterDetail.class));
        getScreens().add(new MediatorScreen(
                DetailView.class, DetailPresenter.class,
                DetailModel.class, DatabaseMasterDetail.class));
    }

    private void setHelloTransitionCollection() {
        getTransitions().add(new MediatorTransition(
                PortraitHelloView.class, CategoryMasterView.class, HelloMediatorCode.CLIC_more));
        getTransitions().add(new MediatorTransition(
                PortraitHelloView.class, PortraitByeView.class, HelloMediatorCode.CLICK));

        getTransitions().add(new MediatorTransition(
                PortraitHelloView.class, LandscapeHelloView.class, HelloMediatorCode.hello_landscape));
        getTransitions().add(new MediatorTransition(
                LandscapeHelloView.class, PortraitHelloView.class, HelloMediatorCode.hello_portrait));

        getTransitions().add(new MediatorTransition(
                LandscapeHelloView.class, LandscapeByeView.class, HelloMediatorCode.CLICK_land));
        getTransitions().add(new MediatorTransition(
                LandscapeHelloView.class, CategoryMasterView.class, HelloMediatorCode.CLICK_more_land));

        getTransitions().add(new MediatorTransition(
                LandscapeMoreProductsView.class, PortraitMoreProductsView.class, HelloMediatorCode.more_portrait));
        getTransitions().add(new MediatorTransition(
                PortraitMoreProductsView.class, LandscapeMoreProductsView.class, HelloMediatorCode.more_landscape));

        getTransitions().add(new MediatorTransition(
                LandscapeByeView.class, PortraitByeView.class, HelloMediatorCode.bye_portrait));
        getTransitions().add(new MediatorTransition(
                PortraitByeView.class, LandscapeByeView.class, HelloMediatorCode.bye_landscape));
        getTransitions().add(new MediatorTransition(CategoryMasterView.class,
                ProductMasterView.class, HelloMediatorCode.SELECT));

        getTransitions().add(new MediatorTransition(ProductMasterView.class,
                DetailView.class, HelloMediatorCode.SELECT));
    }
}
