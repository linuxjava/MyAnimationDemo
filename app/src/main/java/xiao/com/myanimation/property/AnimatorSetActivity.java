package xiao.com.myanimation.property;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import xiao.com.myanimation.R;

/**
 * Created by guochang on 2015/4/18.
 */
public class AnimatorSetActivity extends Activity{
    private ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_set);

        mImage = (ImageView) findViewById(R.id.image);
    }

    public void test1(View v){
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImage, "scaleX", 1.0f, 2.0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImage, "scaleY", 1.0f, 2.0f);
        set.setDuration(1000);
        set.setInterpolator(new LinearInterpolator());
        set.playTogether(animator1, animator2);
        set.start();
    }

    public void test2(View v){
        float cx = mImage.getX();

        ObjectAnimator anim1 = ObjectAnimator.ofFloat(mImage, "scaleX", 1.0f, 2f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(mImage, "scaleY", 1.0f, 2f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(mImage, "x",  cx ,  0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(mImage, "x", cx);
        /**
         * anim1，anim2,anim3同时执行
         * anim4接着执行
         */
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.play(anim2).with(anim3);
        animSet.play(anim4).after(anim3);
        animSet.setDuration(1000);
        animSet.start();
    }

}
