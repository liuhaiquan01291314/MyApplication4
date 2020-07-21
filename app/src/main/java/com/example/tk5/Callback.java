package com.example.tk5;

import java.util.List;

import bean.TaBean;

public interface Callback {
    void Send(List<TaBean.DataBean> beans);
    void File(String str);
}
