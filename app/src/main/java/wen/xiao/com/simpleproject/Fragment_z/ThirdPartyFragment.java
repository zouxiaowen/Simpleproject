package wen.xiao.com.simpleproject.Fragment_z;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhy.autolayout.AutoRelativeLayout;

import wen.xiao.com.simpleproject.Base_z.BaseFragment;
import wen.xiao.com.simpleproject.R;


public class ThirdPartyFragment extends BaseFragment {


    @Override
    protected View initView() {

        View view=LayoutInflater.from(mContext).inflate(R.layout.activity_search, null);
        TextView line1= (TextView) view.findViewById(R.id.gaouda);
        int statusHeight = getStatusBarHeight();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) line1.getLayoutParams();
        params.height = statusHeight;
        line1.setLayoutParams(params);
        return view;
    }


}
