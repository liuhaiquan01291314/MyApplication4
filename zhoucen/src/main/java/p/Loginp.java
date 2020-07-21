package p;

import com.example.zhoucen.Bean;
import com.example.zhoucen.Callback;

import java.util.List;

import m.LoginM;
import view.LaginView;

public class Loginp implements Callback {
    private LaginView laginView;
    private LoginM loginM;

    public Loginp(LaginView laginView) {
        this.laginView = laginView;
           loginM=new LoginM();
    }

    @Override
    public void Send(List<Bean.DataBean.DatasBean> bean) {
         laginView.setdata(bean);
    }

    @Override
    public void File(String str) {
      laginView.shouToast(str);
    }

    public void setdata() {
        loginM.getdata(this);
    }
}
