package xiao.com.myanimation.property;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
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
public class ValueAnimatorActivity extends Activity{
    private ImageView mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.value_animator);

        mImage = (ImageView) findViewById(R.id.image);
    }

    public void test1(View v){
        ValueAnimator animator = ValueAnimator.ofFloat(0, 500-mImage.getHeight(), 0);
        animator.setDuration(1000).setTarget(mImage);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mImage.setTranslationY((Float) animation.getAnimatedValue());
            }
        });
        animator.start();

    }

    public void test2(View v){
        ValueAnimator animator = new ValueAnimator();
        animator.setDuration(1000);
        animator.setObjectValues(new PointF(0.0f, 0.0f));
        animator.setInterpolator(new LinearInterpolator());
        animator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                Log.e("xiao1", fraction + ":" + startValue + ":" + endValue);
                PointF point = new PointF();
                point.x = 200 * (fraction * 3);
                point.y = 0.5f * 200 * (fraction * 3) * (fraction * 3);
                return point;
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF pointF = (PointF)animation.getAnimatedValue();
                mImage.setTranslationX(pointF.x);
                mImage.setTranslationY(pointF.y);
            }
        });
        animator.start();
    }

}
