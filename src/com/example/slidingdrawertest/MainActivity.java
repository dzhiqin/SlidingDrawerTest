package com.example.slidingdrawertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnScrollChangeListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;
import android.widget.SlidingDrawer.OnDrawerScrollListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressWarnings("deprecation")
	private SlidingDrawer mDrawer;
	private Button handle;
	private TextView mTextView;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDrawer=(SlidingDrawer)findViewById(R.id.mDrawer);
		handle=(Button)findViewById(R.id.handle);
		mTextView=(TextView)findViewById(R.id.mTextView);
		/**
		 * ҳ��������ļ�������
		 */
		mDrawer.setOnDrawerOpenListener(new OnDrawerOpenListener(){

			@Override
			public void onDrawerOpened() {
				handle.setBackground(getResources().getDrawable(R.drawable.handle_down_bg));
				mTextView.setText("ҳ��չ�����");				
			}
			
		});
		/**
		 * ҳ��������ļ�������
		 */
		mDrawer.setOnDrawerCloseListener(new OnDrawerCloseListener(){

			@Override
			public void onDrawerClosed() {
				//handle_up_bg.xml�ļ�������ť�����£����ֵ�״̬
				handle.setBackground(getResources().getDrawable(R.drawable.handle_up_bg));
				mTextView.setText("ҳ������չ��");
			}			
		});
		/**
		 * ҳ���϶�ʱ�ļ�������
		 */
		mDrawer.setOnDrawerScrollListener(new OnDrawerScrollListener(){

			@Override
			public void onScrollStarted() {
				mTextView.setText("�϶�ҳ��");				
			}

			@Override
			public void onScrollEnded() {
				mTextView.setText("����");				
			}			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
