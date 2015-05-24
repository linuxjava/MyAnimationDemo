package xiao.com.myanimation.layout;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
public class LayoutAnimationActivity extends ListActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animation);

        mListView = getListView();

    }

    public void onTest(View v){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.list_anim);
        LayoutAnimationController controller = new LayoutAnimationController(animation);
        controller.setDelay(0.5f);
        controller.setAnimation(animation);
        mListView.setLayoutAnimation(controller);

//        AnimatorSet set = new AnimatorSet();
//        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mListView, "alpha", 0f, 1f);
////        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mListView, "alpha", 0f, 1f);
////        set.playTogether(animator1, animator2);
//        LayoutTransition layoutTransition = new LayoutTransition();
//        layoutTransition.setDuration(500);
//        layoutTransition.setAnimator(LayoutTransition.APPEARING, animator1);
//        mListView.setLayoutTransition(layoutTransition);


        mListView.setAdapter(createListAdapter());
    }

    private ListAdapter createListAdapter() {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> m1 = new HashMap<String, String>();
        m1.put("name", "bauble");
        m1.put("sex", "male");
        HashMap<String, String> m2 = new HashMap<String, String>();
        m2.put("name", "Allorry");
        m2.put("sex", "male");
        HashMap<String, String> m3 = new HashMap<String, String>();
        m3.put("name", "Allotory");
        m3.put("sex", "male");
        HashMap<String, String> m4 = new HashMap<String, String>();
        m4.put("name", "boolbe");
        m4.put("sex", "male");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this, list, R.layout.item, new String[]{"name", "sex"},
                new int[]{R.id.name, R.id.sex});

        return simpleAdapter;
    }
}
