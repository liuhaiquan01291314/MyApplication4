package Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zhoucen.Bean;
import com.example.zhoucen.MyRecyAdapter;
import com.example.zhoucen.R;

import java.util.ArrayList;
import java.util.List;

import p.Loginp;
import view.LaginView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouFragment extends Fragment implements LaginView {


    private View view;
    private RecyclerView mRecy;
    private ArrayList<Bean.DataBean.DatasBean> list;
    private MyRecyAdapter adapter;

    public ShouFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shou, container, false);
        initView(inflate);
        Loginp loginp = new Loginp(this);
        loginp.setdata();
        return inflate;
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.Recy);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();//创建集合
        adapter = new MyRecyAdapter(list, getActivity()); //创建适配器
        mRecy.setAdapter(adapter); //绑定适配器
    }


    @Override
    public void setdata(List<Bean.DataBean.DatasBean> beans) {
        list.addAll(beans); //吧数据给集合
        adapter.notifyDataSetChanged(); //刷新适配器
    }

    @Override
    public void shouToast(String string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_SHORT).show();
    }
}
