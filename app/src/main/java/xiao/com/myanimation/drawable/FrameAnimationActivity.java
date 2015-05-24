package xiao.com.myanimation.drawable;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import xiao.com.myanimation.R;

/**
 * Created by guochang on 2015/4/12.
 */
public class FrameAnimationActivity extends Activity{
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_animation);

        mImage = (ImageView) findViewById(R.id.image);
    }

    public void onFrameAnimation(View v){
        mImage.setBackgroundResource(R.drawable.frame);
        AnimationDrawable animationDrawable = (AnimationDrawable) mImage.getBackground();
        animationDrawable.start();
    }
}
