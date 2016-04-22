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
    }

    private void setHelloTransitionCollection() {
        getTransitions().add(new MediatorTransition(
                PortraitHelloView.class, PortraitMoreProductsView.class, HelloMediatorCode.CLIC_more));
        getTransitions().add(new MediatorTransition(
                PortraitHelloView.class, PortraitByeView.class, HelloMediatorCode.CLICK));
        getTransitions().add(new MediatorTransition(
                PortraitHelloView.class, LandscapeHelloView.class, HelloMediatorCode.hello_landscape));
        getTransitions().add(new MediatorTransition(
                LandscapeHelloView.class, PortraitHelloView.class, HelloMediatorCode.hello_portrait));
        getTransitions().add(new MediatorTransition(
                LandscapeHelloView.class, LandscapeHelloView.class, HelloMediatorCode.bye_landscape));
        getTransitions().add(new MediatorTransition(
                LandscapeHelloView.class, LandscapeMoreProductsView.class, HelloMediatorCode.more_landscape));
        getTransitions().add(new MediatorTransition(
                LandscapeMoreProductsView.class, PortraitMoreProductsView.class, HelloMediatorCode.more_portrait));
        getTransitions().add(new MediatorTransition(
                PortraitMoreProductsView.class, LandscapeMoreProductsView.class, HelloMediatorCode.more_landscape));
        getTransitions().add(new MediatorTransition(
                LandscapeByeView.class, PortraitByeView.class, HelloMediatorCode.bye_portrait));
        getTransitions().add(new MediatorTransition(
                PortraitByeView.class, LandscapeByeView.class, HelloMediatorCode.bye_landscape));
    }
}
