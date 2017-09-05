package wen.xiao.com.simpleproject.callback;


import android.app.Activity;
import android.support.annotation.Nullable;


import com.lzy.okgo.request.BaseRequest;

import wen.xiao.com.simpleproject.View_z.simpleview.ProgressHUD;

/**
 * ================================================
 * 作    者：廖子尧
 * 版    本：1.0
 * 创建日期：2016/1/14
 * 描    述：对于网络请求是否需要弹出进度对话框
 * 修订历史：
 * ================================================
 */
public abstract class DialogCallback<T>  {

    private ProgressHUD dialog;

    //private ProgressDialog dialog;

    private void initDialog(Activity activity) {
        dialog=ProgressHUD.show(activity, "正在加载", false, false, null);
//        dialog = new ProgressDialog(activity);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        dialog.setMessage("请求网络中...");

    }

    public DialogCallback(Activity activity) {
        super();
        initDialog(activity);
    }




}
