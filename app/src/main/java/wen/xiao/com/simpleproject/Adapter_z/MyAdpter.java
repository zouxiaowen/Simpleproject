package wen.xiao.com.simpleproject.Adapter_z;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import wen.xiao.com.simpleproject.R;
import wen.xiao.com.simpleproject.callback.A_DialogCallback;
import wen.xiao.com.simpleproject.entity.Image_url;
import wen.xiao.com.simpleproject.entity.meinv;

/**
 * Created by Administrator on 2017/5/26.
 */

public class MyAdpter extends BaseQuickAdapter<meinv.TngouBean,BaseViewHolder> {
    Context context;
    public MyAdpter(Context context, List<meinv.TngouBean> data) {
        super(R.layout.layout_item, data);
        this.context=context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final meinv.TngouBean item) {
        helper.setText(R.id.tv_ce,item.getTitle());
        //final  ImageView imageView=helper.getView(R.id.iamge_url);
        //imageView.setTag(item.getImg());
       // imageView.setImageResource(R.drawable.cry);
//        OkGo.get("http://tnfs.tngou.net/image"+item.getImg())//
//                .tag(this)//
//                .execute(new BitmapCallback() {
//                    @Override
//                    public void onSuccess(Bitmap bitmap, Call call, Response response) {
//                        // bitmap 即为返回的图片数据
//                        //helper.setImageBitmap(R.id.iamge_url,bitmap);
//                        if (imageView.getTag()!=null&&imageView.getTag().equals(item.getImg())){
//                            imageView.setImageBitmap(bitmap);
//                        }
//                    }
//                });

//        Glide.with(context)
//                .load("http://tnfs.tngou.net/image"+item.getImg())
//                .into(imageView);

//        Uri uri = Uri.parse("http://tnfs.tngou.net/image"+item.getImg());
        SimpleDraweeView draweeView = (SimpleDraweeView) helper.getView(R.id.my_image_view);
//        draweeView.setImageURI(uri);

        int width = 50, height = 50;
        Uri uri;
        uri = Uri.parse( "http://tnfs.tngou.net/image"+item.getImg());
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setProgressiveRenderingEnabled(true)

                .build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setOldController(draweeView.getController())
                .setTapToRetryEnabled(true)

                .build();
        draweeView.setController(controller) ;
        draweeView.setAspectRatio(1.33f);
    }



}
