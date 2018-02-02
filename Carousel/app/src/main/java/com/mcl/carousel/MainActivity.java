package com.mcl.carousel;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;
import cn.bingoogolapple.bgabanner.BGALocalImageSize;

public class MainActivity extends Activity {

    private BGABanner mBanner = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBanner = (BGABanner) findViewById(R.id.banner_guide_content);
        mBanner.setAdapter(new BGABanner.Adapter<View, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, View itemView, String model, int position) {

            }
        });
        List<View> viewList = new ArrayList<>();
        viewList.add(BGABannerUtil.getItemImageView(this, R.drawable.bga_banner_selector_point_hollow,
                new BGALocalImageSize(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(),
                        getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight()), ImageView.ScaleType.CENTER));
        viewList.add(BGABannerUtil.getItemImageView(this, R.drawable.bga_banner_point_enabled,
                new BGALocalImageSize(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(),
                        getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight()), ImageView.ScaleType.CENTER));
        viewList.add(BGABannerUtil.getItemImageView(this, R.drawable.bga_banner_selector_point_solid,
                new BGALocalImageSize(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(),
                        getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight()), ImageView.ScaleType.CENTER));
        viewList.add(BGABannerUtil.getItemImageView(this, R.drawable.bga_banner_point_disabled,
                new BGALocalImageSize(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight(),
                        getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight()), ImageView.ScaleType.CENTER));
        mBanner.setData(viewList);
        mBanner.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, Object model, int position) {
                Toast.makeText(banner.getContext(), "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
