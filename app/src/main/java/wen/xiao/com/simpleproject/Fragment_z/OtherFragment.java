package wen.xiao.com.simpleproject.Fragment_z;


import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wen.xiao.com.simpleproject.Adapter_z.MyGridViewAdapter;
import wen.xiao.com.simpleproject.Adapter_z.MyViewPagerAdapter;
import wen.xiao.com.simpleproject.Base_z.BaseFragment;
import wen.xiao.com.simpleproject.R;
import wen.xiao.com.simpleproject.View_z.CustomActivity;
import wen.xiao.com.simpleproject.entity.ProductListBean;

public class OtherFragment extends BaseFragment implements ViewPager.OnPageChangeListener{
    private ViewGroup points;//小圆点指示器
    private ImageView[] ivPoints;//小圆点图片集合
    private ViewPager viewPager;
    private int totalPage;//总的页数
    private int mPageSize = 8;//每页显示的最大数量
    private List<ProductListBean> listDatas;//总的数据源
    private List<View> viewPagerList;//GridView作为一个View对象添加到ViewPager集合中
    private int currentPage;//当前页

    private String[] proName = {"名称0","名称1","名称2","名称3","名称4","名称5",
            "名称6","名称7","名称8","名称9","名称10","名称11","名称12","名称13",
            "名称14","名称15","名称16","名称17","名称18","名称19"};

    @Override
    protected View initView() {
       View view= LayoutInflater.from(mContext).inflate(R.layout.other, null);
        LinearLayout zhaunhaun= (LinearLayout) view.findViewById(R.id.zhaunhaun);
        initState(zhaunhaun);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        //初始化小圆点指示器
        points = (ViewGroup)view.findViewById(R.id.points);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //模拟数据源
        setDatas();
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        //总的页数，取整（这里有三种类型：Math.ceil(3.5)=4:向上取整，只要有小数都+1  Math.floor(3.5)=3：向下取整  Math.round(3.5)=4:四舍五入）
        totalPage = (int) Math.ceil(listDatas.size() * 1.0 / mPageSize);
        viewPagerList = new ArrayList<>();
        for(int i=0;i<totalPage;i++){
            //每个页面都是inflate出一个新实例
            GridView gridView = (GridView) inflater.inflate(R.layout.gridview_layout,viewPager,false);
            gridView.setAdapter(new MyGridViewAdapter(getActivity(),listDatas,i,mPageSize));
            //添加item点击监听
            /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    int pos = position + currentPage*mPageSize;
                    Log.i("TAG","position的值为："+position + "-->pos的值为："+pos);
                    Toast.makeText(MainActivity.this,"你点击了 "+listDatas.get(pos).getProName(),Toast.LENGTH_SHORT).show();
                }
            });*/
            //每一个GridView作为一个View对象添加到ViewPager集合中
            viewPagerList.add(gridView);
        }
        //设置ViewPager适配器
        viewPager.setAdapter(new MyViewPagerAdapter(viewPagerList));
        //小圆点指示器
        ivPoints = new ImageView[totalPage];
        for(int i=0;i<ivPoints.length;i++){
            ImageView imageView = new ImageView(getActivity());
            //设置图片的宽高
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20,20));


            if(i == 0){
                imageView.setBackgroundResource(R.drawable.page__selected_indicator);
            }else{
                imageView.setBackgroundResource(R.drawable.page__normal_indicator);
            }
            ivPoints[i] = imageView;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 20;//设置点点点view的左边距
            layoutParams.rightMargin = 20;//设置点点点view的右边距
            layoutParams.width=10;
            layoutParams.height=10;
            points.addView(imageView,layoutParams);
        }
        //设置ViewPager滑动监听
        viewPager.addOnPageChangeListener(this);
    }
    private void setDatas() {
        listDatas = new ArrayList<>();
        for(int i=0;i<proName.length;i++){
            listDatas.add(new ProductListBean(proName[i], R.drawable.img));
        }
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //改变小圆圈指示器的切换效果
        setImageBackground(position);
        currentPage = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /**
     * 改变点点点的切换效果
     * @param selectItems
     */
    private void setImageBackground(int selectItems) {
        for (int i = 0; i < ivPoints.length; i++) {
            if (i == selectItems) {
                ivPoints[i].setBackgroundResource(R.drawable.page__selected_indicator);
            } else {
                ivPoints[i].setBackgroundResource(R.drawable.page__normal_indicator);
            }
        }
    }
}
