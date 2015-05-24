package xiao.com.myanimation.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import xiao.com.myanimation.R;

/**
 * Created by guochang on 2015/4/12.
 */
public class TweenedAnimationActivity extends Activity implements View.OnClickListener{
    private Button mRotateBtn;
    private Button mScaleBtn;
    private Button mAlphaBtn;
    private Button mTranslateBtn;
    private Button mMixBtn;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweened_animation);

        initViews();
    }

    private void initViews(){
        mRotateBtn = (Button) findViewById(R.id.rotateBtn);
        mScaleBtn = (Button) findViewById(R.id.scaleBtn);
        mAlphaBtn = (Button) findViewById(R.id.alphaBtn);
        mTranslateBtn = (Button) findViewById(R.id.translateBtn);
        mMixBtn = (Button) findViewById(R.id.mix);
        mImage = (ImageView) findViewById(R.id.image);

        mRotateBtn.setOnClickListener(this);
        mScaleBtn.setOnClickListener(this);
        mAlphaBtn.setOnClickListener(this);
        mTranslateBtn.setOnClickListener(this);
        mMixBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rotateBtn:
                //codeRotateAnimation();
                xmlRotateAnimation();
                break;
            case R.id.scaleBtn:
                //codeScaleAnimation();
                xmlScaleAnimation();
                break;
            case R.id.alphaBtn:
                //codeAlphaAnimation();
                xmlAlphaAnimation();
                break;
            case R.id.translateBtn:
                //codeTranslateAnimation();
                xmlTranslateAnimation();
                break;
            case R.id.mix:
                //codeMixAnimation();
                xmlMixAnimation();
                break;
        }
    }

    private void codeRotateAnimation(){
        AnimationSet set = new AnimationSet(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1500);
        set.addAnimation(rotateAnimation);
        mImage.startAnimation(set);
    }

    private void codeScaleAnimation(){
        AnimationSet set = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1.0f, 0, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1500);
        set.addAnimation(scaleAnimation);
        mImage.startAnimation(set);
    }

    private void codeAlphaAnimation(){
        AnimationSet set = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1f);
        alphaAnimation.setDuration(1500);
        set.addAnimation(alphaAnimation);
        mImage.startAnimation(set);

    }

    private void codeTranslateAnimation(){
        AnimationSet set = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 400, 0, 0);
        translateAnimation.setDuration(1500);
        set.addAnimation(translateAnimation);
        mImage.startAnimation(set);
    }

    private void codeMixAnimation(){
        AnimationSet set = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 400, 0, 0);
        translateAnimation.setDuration(1500);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        set.addAnimation(translateAnimation);

        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1f);
        alphaAnimation.setDuration(1500);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        set.addAnimation(alphaAnimation);

        mImage.startAnimation(set);

    }

    private void xmlRotateAnimation(){
        mImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate));
    }

    private void xmlScaleAnimation(){
        mImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
    }

    private void xmlAlphaAnimation(){
        mImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.alpha));
    }

    private void xmlTranslateAnimation(){
        mImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
    }

    private void xmlMixAnimation(){
        mImage.startAnimation(AnimationUtils.loadAnimation(this, R.anim.mix));
    }
}
