package wen.xiao.com.simpleproject.callback;

import android.app.Activity;
import android.support.annotation.Nullable;


import com.lzy.okgo.request.BaseRequest;

import wen.xiao.com.simpleproject.View_z.simpleview.ProgressHUD;

/**
 * Created by Administrator on 2017/5/17.
 */

public abstract class A_DialogCallback<T> extends A_type<T> {

    private ProgressHUD dialog;

    //private ProgressDialog dialog;

    private void initDialog(Activity activity) {
        dialog= ProgressHUD.show(activity, "正在加载", false, false, null);


    }

    public A_DialogCallback(Activity activity) {
        super();
        initDialog(activity);
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
        //网络请求前显示对话框
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onAfter(@Nullable T t, @Nullable Exception e) {
        super.onAfter(t, e);
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
