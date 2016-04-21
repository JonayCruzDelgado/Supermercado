package es.ulpgc.eite.hello.android.screen.hello.data;


public class HelloData {

    private String _txtMsg;
    private String _txtBtn;
    private String _TXT_MoreProduct;

    public HelloData(String txtMsg, String txtBtn, String TXT_MoreProduct) {
        setTxtMsg(txtMsg);
        setTxtBtn(txtBtn);
        setTXT_MoreProduct(TXT_MoreProduct);

    }

    public HelloData() {
        setTxtBtn("");
        setTxtMsg("");
        setTXT_MoreProduct("");
    }

    public String getTxtMsg() {
        return _txtMsg;
    }

    public void setTxtMsg(String txtMsg) {
        _txtMsg = txtMsg;
    }

    public String getTxtBtn() {
        return _txtBtn;
    }

    public void setTxtBtn(String txtBtn) {
        _txtBtn = txtBtn;
    }

    public void setTXT_MoreProduct(String TXT_MoreProduct) {
        _TXT_MoreProduct = TXT_MoreProduct;
    }

    public String getTXT_MoreProduct() {  return _TXT_MoreProduct;    }
}
