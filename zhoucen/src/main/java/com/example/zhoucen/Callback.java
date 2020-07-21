package com.example.zhoucen;

import java.util.List;

public interface Callback {
    void Send(List<Bean.DataBean.DatasBean> bean);
    void File(String str);
}
