package com.zeros.mybottomred;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.zeros.mybottomred.view.BadgeView;


public class MainActivity extends AppCompatActivity {

//    private DragPointView textView;//仿QQ可以拖拽
    private RadioGroup group;
    private BadgeView bgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
//        textView = (DragPointView) findViewById(R.id.dpv_message);
        bgView = (BadgeView) findViewById(R.id.bgView);
        group = (RadioGroup) findViewById(R.id.group);

        //放置拖拽的TexView
//        setTextView();

        //放置固定的TextView
        setText();

        group.setOnCheckedChangeListener(listener);
    }

    private RadioGroup.OnCheckedChangeListener listener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.tab_rb_news) {

            } else if (checkedId == R.id.tab_rb_contacts) {

            } else if (checkedId == R.id.up) {

            } else if (checkedId == R.id.tab_rb_service) {

            } else if (checkedId == R.id.tab_rb_myself) {

            }
        }
    };

    /**
     * 拖拽的textView
     */
//    private void setTextView() {
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int screenWidth = displayMetrics.widthPixels;
//        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) textView.getLayoutParams();
//        layoutParams.leftMargin = screenWidth * 8 / 25;
//        textView.setLayoutParams(layoutParams);
//        textView.setText("10");
//        textView.setBackgroundColor(Color.RED);
//    }

    /*固定*/
    private void setText() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bgView.getLayoutParams();
        layoutParams.leftMargin = screenWidth * 8 / 25;
        bgView.setLayoutParams(layoutParams);
        bgView.setText("99");
    }

}
