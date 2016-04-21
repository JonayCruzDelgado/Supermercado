package es.ulpgc.eite.hello.android.screen.hello.model;


import es.ulpgc.eite.hello.android.screen.hello.data.HelloData;

public interface I_HelloModel {

    String TXT_MSG = "Cesta de la compra";
    String TXT_BTN = "Compra";
    String TXT_MoreProduct = "Añadir productos";

    HelloData getData();
    void setData(HelloData data);
}
