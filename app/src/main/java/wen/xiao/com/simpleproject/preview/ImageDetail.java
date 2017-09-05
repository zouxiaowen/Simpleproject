package wen.xiao.com.simpleproject.preview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wen.xiao.com.simpleproject.R;


public class ImageDetail extends Activity {


     /**
     * 传图片地址 逗号分隔
     */
    public static final String KEY_IMG_PATH = "infoList";
    /**
     * 当前显示item
     */
    public static final String KEY_ITEM_NUM = "itemNum";
    ViewPager photoDetailVp;
    TextView imgCountRecord;
    private ImageDetailAdapter imageDetailAdapter;
    private String imgPaths;
    private List<String> pathList;
    private int currItem;
    private int totalCounts;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_image_detail);
        initValues();
        initListener();
    }


    protected void initValues() {

    	photoDetailVp=(ViewPager) findViewById(R.id.photodetail_vp);
    	imgCountRecord=(TextView) findViewById(R.id.photodetail_img_count);
        pathList= getIntent().getStringArrayListExtra(KEY_IMG_PATH);
        imageDetailAdapter = new ImageDetailAdapter(this, pathList);
        photoDetailVp.setAdapter(imageDetailAdapter);
        currItem = getIntent().getIntExtra(KEY_ITEM_NUM, 0);

        if (pathList!=null) {
        	totalCounts = pathList.size();
		}
        
        if (totalCounts != 0) {
            imgCountRecord.setText("1 / " + totalCounts);
        } else {
            imgCountRecord.setVisibility(View.GONE);
        }

        if (currItem != 0) {
            photoDetailVp.setCurrentItem(currItem);
            imgCountRecord.setText((currItem + 1) + " / " + totalCounts);
        }

    }

    private static final String TAG = "ImageDetail";


    protected void initListener() {
        photoDetailVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int currentPage = position + 1;
                imgCountRecord.setText(currentPage + " / " + totalCounts);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }




}
