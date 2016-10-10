package com.szy.update;

import com.shelwee.update.UpdateHelper;
import com.shelwee.update.listener.OnUpdateListener;
import com.shelwee.update.pojo.UpdateInfo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 *@author coolszy
 *@date 2012-4-26
 *@blog http://blog.92coding.com
 */
public class MainActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button updateBtn = (Button) findViewById(R.id.btnUpdate);
		updateBtn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
//				UpdateManager manager = new UpdateManager(MainActivity.this);
//				// 检查软件更新
//				manager.checkUpdate();
				checkUpdate();
			}
		});
 
	}
	
	void checkUpdate(){

		UpdateHelper updateHelper = new UpdateHelper.Builder(this)
                .checkUrl("http://kx520.github.io/update")
                .isAutoInstall(true) //设置为false需在下载完手动点击安装;默认值为true，下载后自动安装。
                .build();
    updateHelper.check(); 
//    或者使用下面的方式，针对复杂需求的可重写回调方法
    updateHelper.check(new OnUpdateListener() {

            @Override
            public void onStartDownload() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartCheck() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinshDownload() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinishCheck(UpdateInfo info) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDownloading(int progress) {
                // TODO Auto-generated method stub

            }
        });
	}
}