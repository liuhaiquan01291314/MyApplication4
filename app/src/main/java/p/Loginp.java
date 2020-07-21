package p;

import com.example.tk5.Callback;

import java.util.List;

import bean.TaBean;
import m.Loginm;
import view.Loginview;

public class Loginp implements Callback {
    private Loginview loginview;
    private Loginm loginm;

    public Loginp(Loginview loginview) {
        this.loginview = loginview;
         this.loginm=new Loginm();
    }

    public void getData() {
        loginm.getData(this);
    }

    @Override
    public void Send(List<TaBean.DataBean> beans) {
        loginview.setdata(beans);
    }

    @Override
    public void File(String str) {
       loginview.shouToast(str);
    }
}
