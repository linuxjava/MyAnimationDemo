package xiao.com.myanimation.property;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xiao.com.myanimation.R;

/**
 * Created by guochang on 2015/4/12.
 */
public class LayoutAnimatorActivity extends Activity implements CompoundButton.OnCheckedChangeListener{
    private GridLayout mGridLayout;
    private int mVal;
    private LayoutTransition mTransition;
    private CheckBox mAppear, mChangeAppear, mDisAppear, mChangeDisAppear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);

        mGridLayout = (GridLayout) findViewById(R.id.grid);
        mAppear = (CheckBox) findViewById(R.id.id_appear);
        mChangeAppear = (CheckBox) findViewById(R.id.id_change_appear);
        mDisAppear = (CheckBox) findViewById(R.id.id_disappear);
        mChangeDisAppear = (CheckBox) findViewById(R.id.id_change_disappear);

        mAppear.setOnCheckedChangeListener(this);
        mChangeAppear.setOnCheckedChangeListener(this);
        mDisAppear.setOnCheckedChangeListener(this);
        mChangeDisAppear.setOnCheckedChangeListener(this);

        //默认关闭所有动画
        closeAllAnimation();
    }

    private void closeAllAnimation(){
        mTransition = new LayoutTransition();
        mTransition.setAnimator(LayoutTransition.APPEARING, null);
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, null);
        mTransition.setAnimator(LayoutTransition.DISAPPEARING, null);
        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, null);

        mGridLayout.setLayoutTransition(mTransition);

    }

    public void addBtn(View v){
        final Button button = new Button(this);
        button.setText((++mVal) + "");
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(120, 90);
        button.setLayoutParams(layoutParams);
        mGridLayout.addView(button, Math.min(1, mGridLayout.getChildCount()));
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mGridLayout.removeView(button);
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mTransition = new LayoutTransition();
        mTransition.setAnimator(LayoutTransition.APPEARING,
                (mAppear.isChecked()?ObjectAnimator.ofFloat(mGridLayout, "scaleX", 0f, 1f):null));
        mTransition.setAnimator(LayoutTransition.CHANGE_APPEARING,
                (mChangeAppear.isChecked()?mTransition.getAnimator(LayoutTransition.CHANGE_APPEARING):null));
        mTransition.setAnimator(LayoutTransition.DISAPPEARING,
                (mDisAppear.isChecked()?mTransition.getAnimator(LayoutTransition.DISAPPEARING):null));
        mTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,
                (mChangeDisAppear.isChecked()?mTransition.getAnimator(LayoutTransition.CHANGE_DISAPPEARING):null));

        mGridLayout.setLayoutTransition(mTransition);

    }
}
