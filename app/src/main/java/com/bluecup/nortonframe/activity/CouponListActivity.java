package com.bluecup.nortonframe.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.bluecup.core.ActionCallbackListener;
import com.bluecup.model.CouponBO;
import com.bluecup.nortonframe.R;
import com.bluecup.nortonframe.adapter.CouponListAdapter;

import java.util.List;

/**
 * 券列表
 * Created by YUHONG on 2015/12/9.
 * Email: hongyuahu@gmail.com
 */
public class CouponListActivity extends NBaseActivity  implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private CouponListAdapter listAdapter;
    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list);
        initViews();
        getData();
        // TODO 添加上拉加载更多的功能
    }

    @Override
    protected void initViews() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        listView = (ListView) findViewById(R.id.list_view);
        listAdapter = new CouponListAdapter(this);
        listView.setAdapter(listAdapter);
    }

    private void getData() {
        this.appAction.listCoupon(currentPage, new ActionCallbackListener<List<CouponBO>>() {
            @Override
            public void onSuccess(List<CouponBO> data) {
                if (!data.isEmpty()) {
                    if (currentPage == 1) { // 第一页
                        listAdapter.setItems(data);
                    } else { // 分页数据
                        listAdapter.addItems(data);
                    }
                }
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(String errorEvent, String message) {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    @Override
    public void onRefresh() {
        currentPage = 1;
        listAdapter.clearItems();
        getData();
    }
}
