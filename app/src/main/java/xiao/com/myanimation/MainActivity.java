package xiao.com.myanimation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import xiao.com.myanimation.drawable.FrameAnimationActivity;
import xiao.com.myanimation.layout.LayoutAnimationActivity;
import xiao.com.myanimation.property.LayoutAnimatorActivity;
import xiao.com.myanimation.property.PropertyAnimationActivity;
import xiao.com.myanimation.view.TweenedAnimationActivity;

/**
 * Created by guochang on 2015/4/12.
 */
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void onViewAnmation(View v){
        startActivity(new Intent(this, TweenedAnimationActivity.class));
    }

    public void  onDrawableAnmation(View v){
        startActivity(new Intent(this, FrameAnimationActivity.class));
    }

    public void onLayoutAnmation(View v){
        startActivity(new Intent(this, LayoutAnimationActivity.class));
    }

    public void onPropertyAnmation(View v){
        startActivity(new Intent(this, PropertyAnimationActivity.class));
    }

    public void onLayoutAnimator(View v){
        startActivity(new Intent(this, LayoutAnimatorActivity.class));
    }


}
