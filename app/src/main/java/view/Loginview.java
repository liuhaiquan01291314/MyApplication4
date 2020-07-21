package view;

import java.util.List;

import bean.TaBean;

public interface Loginview {
    void shouToast(String str);
    void setdata(List<TaBean.DataBean> dataBeans);
}
