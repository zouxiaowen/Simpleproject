package wen.xiao.com.simpleproject.Fragment_z;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import wen.xiao.com.simpleproject.Base_z.BaseFragment;
import wen.xiao.com.simpleproject.R;


public class two_fragment extends BaseFragment {


    @Override
    protected View initView() {

        View view=LayoutInflater.from(mContext).inflate(R.layout.two, null);

        return view;
    }


}
