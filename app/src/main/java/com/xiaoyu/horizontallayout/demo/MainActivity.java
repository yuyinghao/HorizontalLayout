package com.xiaoyu.horizontallayout.demo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.xiaoyu.horizontallayout.R;
import com.xiaoyu.horizontallayout.library.HorizontalLayout;

public class MainActivity extends Activity {

	private HorizontalLayout horizontalLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		horizontalLayout = (HorizontalLayout)findViewById(R.id.content_layout);
		
		horizontalLayout.setOnItemClickListener(new HorizontalLayout.OnItemClickListener() {
			
			@Override
			public boolean onItemClick(View view, int position) {
				
				Toast.makeText(MainActivity.this, "click "+position, Toast.LENGTH_SHORT).show();
				
				return false;
			}
		});
		
		horizontalLayout.setOnItemFocuseChangeListener(new HorizontalLayout.OnItemFocuseChangeListener() {
			
			@Override
			public void onItemFocuseChange(View view, boolean hasFocuse) {
				if(hasFocuse){
					changeToView(view, 1.0f, 1.2f, 200);
				}else{
					changeToView(view, 1.2f, 1.0f, 200);
				}
			}
		});
		
		horizontalLayout.setContentAdapter(myAdapter);
	}
	
	@Override
	protected void onDestroy() {
		if(horizontalLayout != null){
			horizontalLayout.onViewDestroy();
		}
		super.onDestroy();
	}
	
	private BaseAdapter myAdapter = new BaseAdapter() {
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
			
			return view;
		}
		
		@Override
		public long getItemId(int position) {
			return position;
		}
		
		@Override
		public Object getItem(int position) {
			return null;
		}
		
		@Override
		public int getCount() {
			return 10;
		}
	};

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private static void changeToView(final View view, float beginS, float endS,
			long duration) {
		view.setLayerType(View.LAYER_TYPE_HARDWARE, null);// 开启物理加速
		AnimatorSet set = new AnimatorSet();
		set.playTogether(ObjectAnimator.ofFloat(view, "rotationX", 0, 0),
				ObjectAnimator.ofFloat(view, "rotationY", 0, 0),
				ObjectAnimator.ofFloat(view, "translationX", 0, 0),
				ObjectAnimator.ofFloat(view, "translationY", 0, 0),
				ObjectAnimator.ofFloat(view, "scaleX", beginS, endS),
				ObjectAnimator.ofFloat(view, "scaleY", beginS, endS),
				ObjectAnimator.ofFloat(view, "alpha", 1, 1));
		set.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animation) {
			}

			@Override
			public void onAnimationEnd(Animator animation) {
			}

			@Override
			public void onAnimationCancel(Animator animation) {
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
			}
		});
		set.setDuration(duration).start();
	}
	
}
