package es.ulpgc.eite.hello.android.mediator;


import es.ulpgc.eite.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.framework.core.mediator.MediatorTransition;
import es.ulpgc.eite.hello.android.screen.bye.model.ByeModel;
import es.ulpgc.eite.hello.android.screen.bye.presenter.ByePresenter;
import es.ulpgc.eite.hello.android.screen.bye.view.ByeView;
import es.ulpgc.eite.hello.android.screen.hello.model.HelloModel;
import es.ulpgc.eite.hello.android.screen.hello.presenter.HelloPresenter;
import es.ulpgc.eite.hello.android.screen.hello.view.HelloView;

public class HelloMediatorConfig extends MediatorConfig{

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
                HelloView.class, HelloPresenter.class, HelloModel.class));
        getScreens().add(new MediatorScreen(
                ByeView.class, ByePresenter.class, ByeModel.class));
    }

    private void setHelloTransitionCollection() {
        getTransitions().add(new MediatorTransition(
                HelloView.class, ByeView.class, HelloMediatorCode.CLICK));
    }
}
