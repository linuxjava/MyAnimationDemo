package xiao.com.myanimation.property;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import xiao.com.myanimation.R;

/**
 * Created by guochang on 2015/4/12.
 */
public class PropertyAnimationActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animation);

    }

    public void onObjectAnimator(View v){
        startActivity(new Intent(this, ObjectAnimatorActivity.class));
    }

    public void onValueAnimator(View v){
        startActivity(new Intent(this, ValueAnimatorActivity.class));
    }

    public void onAnimatorSet(View v){
        startActivity(new Intent(this, AnimatorSetActivity.class));
    }
}
