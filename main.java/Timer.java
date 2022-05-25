package com.example.perst;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Timer extends Fragment {
    TextView dateTv, timer, recordText, test;
    Button startBtn, resetBtn, recordBtn;
    Chronometer stopwatch;
    Boolean running = false;
    String printRecord = "";
    long pauseOffset;
    Integer count = 0;
    public static final String TAG = "MAIN";
    private TextView time_text;
    Button time_btn, alarm_cancel_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        //타이머
        dateTv = (TextView) view.findViewById(R.id.date);
        timer = (TextView) view.findViewById(R.id.timer);
        recordText = (TextView) view.findViewById(R.id.recordtxt);
        startBtn = (Button) view.findViewById(R.id.bt_start);
        resetBtn = (Button) view.findViewById(R.id.bt_stop);
        recordBtn = (Button) view.findViewById(R.id.bt_record);
        stopwatch = (Chronometer) view.findViewById(R.id.stopwatch);
        test = (TextView) view.findViewById(R.id.textView);

        recordText.setMovementMethod(new ScrollingMovementMethod());
        stopwatch.setFormat("%s");

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일", Locale.KOREAN);
        dateTv.setText(df.format(date));

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetBtn.setVisibility(View.VISIBLE);
                recordBtn.setVisibility(View.VISIBLE);

                if (running == false) {
                    startBtn.setText("pause");
                    stopwatch.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    stopwatch.start();
                    running = true;
                } else {
                    stopwatch.stop();
                    startBtn.setText("start");
                    pauseOffset = SystemClock.elapsedRealtime() - stopwatch.getBase();
                    running = false;
                }
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() { //초기화
            @Override
            public void onClick(View view) {
                view.setVisibility(View.GONE);
                startBtn.setVisibility(View.VISIBLE);
                recordBtn.setVisibility(View.GONE);
                startBtn.setText("start");
                recordText.setText("");

                stopwatch.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;
                stopwatch.stop();
                running = false;
                printRecord = "";
                count = 0;
            }
        });

        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (running) {
                    count++;
                    pauseOffset = SystemClock.elapsedRealtime() - stopwatch.getBase();
                    int recordTime = (int) (pauseOffset / 1000);

                    Integer hour = recordTime / (60 * 60);
                    Integer min = recordTime % (60 * 60) / 60;
                    Integer sec = recordTime % 60;

                    printRecord = printRecord + "[" + count.toString() + "번째] " + hour.toString() + "시간 " + min.toString() + "분 " + sec.toString() + "초\n";
                    recordText.setText(printRecord);
                }
            }
        });
        return view;
    }
}