package wen.xiao.com.simpleproject.preview;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import wen.xiao.com.simpleproject.R;


/**
 * Description :
 * Author :fengjing
 * Email :164303256@qq.com
 * Date :2016/9/7
 */
public class ImageDetailAdapter extends PagerAdapter {
    private Context mContext;

    private List<String> pathList;



    public ImageDetailAdapter(Context context, List<String> list) {
        mContext = context;
        pathList = list;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return pathList == null ? 0 : pathList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        PhotoView view = new PhotoView(mContext);
        view.enable();
        view.setScaleType(ImageView.ScaleType.FIT_CENTER);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (longPressListener != null) longPressListener.longPress(position);
                return true;
            }
        });

        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                ((Activity) mContext).finish();
            }
        });

        String url = pathList.get(position);
        /**
         * 根据需求而定 网上的不需要这个判断  但是服务器默认可能需要处理url
         */
        if (!TextUtils.isEmpty(url)&&position<3) {
            int index = url.lastIndexOf("?");
            if (index != -1) {
                url = url.substring(0, index);
            }
        }
        Log.d("====",url);
        //Glide.with(mContext).load(url).into(view);
        Glide.with(mContext).load(url).placeholder(R.mipmap.ic_launcher).into(view);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    private onLongPressListener longPressListener;

    public void setOnLongPressListener(onLongPressListener longPressListener) {
        this.longPressListener = longPressListener;
    }

    public interface onLongPressListener {
        void longPress(int position);
    }

}
