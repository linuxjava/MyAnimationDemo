package xiao.com.myanimation.property;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import xiao.com.myanimation.R;

/**
 * Created by guochang on 2015/4/18.
 */
public class ObjectAnimatorActivity extends Activity{
    private ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.object_animator);

        mImage = (ImageView) findViewById(R.id.image);
    }

    public void test1(View v){
        ObjectAnimator.ofFloat(mImage, "rotationY", 0.0f, 180.0f, 120f)
        .setDuration(5000).start();
    }

    public void test2(View v){
        ObjectAnimator animator = ObjectAnimator.ofFloat(v, "xyz", 1.0f, 0.0f, 0.5f).setDuration(5000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();
                mImage.setAlpha(val);
                mImage.setScaleX(val);
                mImage.setScaleY(val);
            }
        });

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });

        animator.start();
    }

    public void test3(View v){
        Keyframe keyframe1 = Keyframe.ofFloat(0);
        keyframe1.setInterpolator(new AccelerateInterpolator());
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f);
        keyframe2.setInterpolator(new DecelerateInterpolator());

        PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1f, 0f, 1f);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1f);
        holder2.setKeyframes(keyframe1, keyframe2);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("ScaleY", 1f, 0f, 1f);
        holder3.setKeyframes(keyframe1, keyframe2);
        ObjectAnimator.ofPropertyValuesHolder(mImage, holder1, holder2, holder3).setDuration(5000).start();

    }

    public void test4(){
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mImage, "alpha", 1f, 0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(mImage, "scaleX", 1f, 0f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(mImage, "ScaleY", 1f, 0f);

        AnimatorSet set = new AnimatorSet();
        set.play(objectAnimator1);
        set.play(objectAnimator2);
        set.play(objectAnimator3);
        set.start();
    }

}
