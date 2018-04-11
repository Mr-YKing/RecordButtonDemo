package com.example.mr_yking.recordbuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yking.lastfairytales.view.RecordButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecordButton mRecordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecordButton = findViewById(R.id.recordBt);
        mRecordButton.setRecordButtonListener(new RecordButton.RecordButtonListener() {
            @Override
            public void onClick() {
                Log.e(TAG, "onClick: ");
                Toast.makeText(MainActivity.this,"点击了按钮",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick() {
                Log.e(TAG, "onLongClick: ");
                Toast.makeText(MainActivity.this,"长按了按钮",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickFinish(int result) {
                Log.e(TAG, "onLongClickFinish: "+result);
                switch (result) {
                    case RecordButton.NORMAL:
                        Toast.makeText(MainActivity.this,"长按结束",Toast.LENGTH_SHORT).show();
                        break;
                    case RecordButton.RECORD_SHORT:
                        Toast.makeText(MainActivity.this,"录制时间过短",Toast.LENGTH_SHORT).show();
                        break;
                        default:
                }
            }
        });

        /**
         * 这三个属性也可以在xml文件中设置
         */
        //设置触摸延迟时间，区分点击还是长按，单位是毫秒
        mRecordButton.setTouchDelay(300);
        //设置最大录制时间，单位为毫秒
        mRecordButton.setRecordTime(30000);
        //设置最小录制时间，单位为毫秒
        mRecordButton.setMinRecordTime(1000);
    }
}
