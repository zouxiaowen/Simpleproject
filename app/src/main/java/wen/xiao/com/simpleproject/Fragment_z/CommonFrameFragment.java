package wen.xiao.com.simpleproject.Fragment_z;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.OkGo;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;
import wen.xiao.com.simpleproject.Adapter_z.MyAdpter;
import wen.xiao.com.simpleproject.Base_z.BaseFragment;
import wen.xiao.com.simpleproject.Manager_z.MeinvDaoOpe;
import wen.xiao.com.simpleproject.R;
import wen.xiao.com.simpleproject.Utils.URLUtisl;
import wen.xiao.com.simpleproject.callback.A_DialogCallback;
import wen.xiao.com.simpleproject.callback.A_type;
import wen.xiao.com.simpleproject.entity.Image_url;
import wen.xiao.com.simpleproject.entity.ces;
import wen.xiao.com.simpleproject.entity.meinv;
import   wen.xiao.com.simpleproject.entity.meinv.TngouBean;
import wen.xiao.com.simpleproject.preview.ImageDetail;

public class CommonFrameFragment extends BaseFragment implements   SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener,BaseQuickAdapter.OnItemClickListener{
    private RecyclerView recycler;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    /**
     * 传图片地址 逗号分隔
     */
    public static final String KEY_IMG_PATH = "infoList";
    /**
     * 当前显示item
     */
    public static final String KEY_ITEM_NUM = "itemNum";
//    private static final int TOTAL_COUNTER = 18; //总计数器
//    private static final int PAGE_SIZE = 6;     //页大小
//    private int delayMillis = 1000;            //延迟一秒
//    private int mCurrentCounter = 0;            //获取list大小
//    private boolean isErr;                  //是否异常
//    private boolean mLoadMoreEndGone = false;//加载结束
    private MyAdpter myAdpter;
    @Override
    protected View initView() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.common, null);
        recycler= (RecyclerView) view.findViewById(R.id.rv_list);
        LinearLayout ll_bar= (LinearLayout) view.findViewById(R.id.ll_bar);
        initState(ll_bar);
        mSwipeRefreshLayout= (SwipeRefreshLayout) view.findViewById(R.id.swipeLayout);

        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));//设置布局管理器

        InitView();
    }

    private void InitView() {
        OkGo.get(URLUtisl.URL_MEINV)
                .tag(this)
                .execute(new A_DialogCallback<meinv>(getActivity()) {
                    @Override
                    public void onSuccess(meinv meinv, Call call, Response response) {
                        if (meinv!=null){
                            myAdpter=new MyAdpter(getActivity(),meinv.getTngou());
                            myAdpter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);//开启动画
                            myAdpter.setOnLoadMoreListener(CommonFrameFragment.this, recycler);
                            recycler.setAdapter(myAdpter);
                            Database_Manipulation(meinv.getTngou());
                            myAdpter.setOnItemClickListener(CommonFrameFragment.this);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        List<ces> students = MeinvDaoOpe.queryAll(mContext);
                        for (int i = 0; i < students.size(); i++) {
                            Log.i("Log", students.get(i).getTest());
                        }

//                        myAdpter=new MyAdpter(getActivity(),students);
//                        myAdpter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);//开启动画
//                        recycler.setAdapter(myAdpter);
//                        Database_Manipulation(meinv.getTngou());

                    }
                });



    }
    private void Database_Manipulation(List<meinv.TngouBean> tngou) {
        MeinvDaoOpe.deleteAllData(getActivity());
        List<ces> list=new ArrayList<>();
        for (int i=0;i<tngou.size();i++){
            list.add(new ces((long)i,tngou.get(i).getTitle(),"http://tnfs.tngou.net/image"+tngou.get(i).getImg()));
        }
        MeinvDaoOpe.insertData(getActivity(),list);
    }
    @Override
    public void onRefresh() {
        OkGo.get(URLUtisl.URL_MEINV)
                .tag(this)
                .execute(new A_type<meinv>() {
                    @Override
                    public void onSuccess(meinv meinv, Call call, Response response) {
                            if (myAdpter!=null){
                               // myAdpter.setData(0,meinv.getTngou());
                              List<TngouBean> tngou=  meinv.getTngou() ;
//                                myAdpter.setData(0,tngou);   //代表替换的意思
                                //myAdpter.setNewData(tngou);
                                myAdpter.notifyDataSetChanged();

                                mSwipeRefreshLayout.setRefreshing(false);
                            }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        Toast.makeText(getActivity(),"网络异常",Toast.LENGTH_SHORT).show();

                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
    }

    @Override
    public void onLoadMoreRequested() {
        mSwipeRefreshLayout.setEnabled(false);
        //加载新数据
        Log.d("tok","加载新数据");
        OkGo.get(URLUtisl.URL_MEINV)
                .tag(this)
                .execute(new A_type<meinv>() {
                    @Override
                    public void onSuccess(meinv ces, Call call, Response response) {
                       // myAdpter.loadMoreEnd(true);
                        //loadMoreComplete
                       // myAdpter.loadMoreFail();
                        if (ces.getTngou()==null&&ces.getTngou().size()==0){
                            myAdpter.loadMoreEnd(false);
                        }else{
                            myAdpter.addData(ces.getTngou());

                            myAdpter.loadMoreComplete();
                        }

                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        myAdpter.loadMoreFail();
                    }
                });
        mSwipeRefreshLayout.setEnabled(true);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.d("tao",hidden+"");
        if (!hidden){
            //mSwipeRefreshLayout.setEnabled(false);
            mSwipeRefreshLayout.setRefreshing(false);
            OkGo.getInstance().cancelTag(this);
        }else {
            //mSwipeRefreshLayout.setEnabled(true);
           // mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
    }




    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        int index = 0;
        ArrayList<String> info = new ArrayList<String>();
//        info.add("http://pic.huakr.com/post/20170509121154_740570.jpg?640*851");
//        info.add("http://pic.huakr.com/post/20170509121248_682390.jpg?481*640");
//        info.add("http://pic.huakr.com/post/20170509121211_588572.jpg?960*1278");
//        info.add("http://img0.imgtn.bdimg.com/it/u=1802555014,204234422&fm=23&gp=0.jpg");
//        info.add("http://img3.imgtn.bdimg.com/it/u=3348138270,554106099&fm=23&gp=0.jpg");
//        info.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2261844264,1398222573&fm=23&gp=0.jpg");
        meinv.TngouBean as = (TngouBean) adapter.getItem(position);
        info.add("http://tnfs.tngou.net/image"+as.getImg());
        Intent intent=new Intent();
        intent.putExtra(KEY_ITEM_NUM,index);
        intent.putStringArrayListExtra(KEY_IMG_PATH, info);
        intent.setClass(getActivity(),ImageDetail.class);
        startActivity(intent);

    }
}



	 

    

   

    


