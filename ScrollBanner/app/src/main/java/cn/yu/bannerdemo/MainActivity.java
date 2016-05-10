package cn.yu.bannerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.yuan.banner.BannerViewPager;
import cn.yuan.banner.ViewFactory;

public class MainActivity extends AppCompatActivity {

    private BannerViewPager cycleViewPager;
    private String[] imageUrls = {"http://pic7.nipic.com/20100525/4796759_105030008376_2.jpg",
            "http://img2.imgtn.bdimg.com/it/u=3970522361,3400221709&fm=21&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=2068775265,2208926539&fm=21&gp=0.jpg",
            "http://pic.58pic.com/58pic/13/07/98/58PIC8r58PICy3w_1024.jpg",
            "http://img1.imgtn.bdimg.com/it/u=1459694053,2159023530&fm=21&gp=0.jpg"};
    private List<ImageView> views = new ArrayList<ImageView>();
    private List<String> infos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cycleViewPager = (BannerViewPager) getSupportFragmentManager()
                .findFragmentById(R.id.fl_banner);
        for (int i = 0; i < imageUrls.length; i++) {
            infos.add(imageUrls[i]);
        }
        // 将最后一个ImageView添加进来
        views.add(ViewFactory.getImageView(this, infos.get(infos.size() - 1)));
        for (int i = 0; i < infos.size(); i++) {
            views.add(ViewFactory.getImageView(this, infos.get(i)));
        }
        // 将第一个ImageView添加进来
        views.add(ViewFactory.getImageView(this, infos.get(0)));
        // 在加载数据前设置是否循环
        cycleViewPager.setData(views, infos, new BannerViewPager.OnItemClickListener() {
            @Override
            public void onItemClick(int postion) {
                Toast.makeText(MainActivity.this, postion + "", Toast.LENGTH_SHORT).show();
            }
        });
        //开始轮播
        cycleViewPager.setWheel(true);
        // 设置轮播时间，默认3000ms
        cycleViewPager.setScrollTime(2000);
        //设置圆点指示图标组居中显示，默认靠右
        cycleViewPager.setIndicatorCenter();
    }
}
