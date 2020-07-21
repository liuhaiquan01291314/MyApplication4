package view;

import com.example.zhoucen.Bean;

import java.util.ArrayList;
import java.util.List;

public interface LaginView {
    void setdata(List<Bean.DataBean.DatasBean> beans);
    void shouToast(String string);
}
