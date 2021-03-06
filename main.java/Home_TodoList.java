package com.example.perst;

import static android.content.Context.MODE_NO_LOCALIZED_COLLATORS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Home_TodoList extends Fragment {
    public String fname = null;
    public String str = null;
    public CalendarView calendarView;
    public Button cha_Btn, del_Btn, save_Btn;
    public TextView diaryTextView, textView2;
    public EditText contextEditText;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_todo, container, false);

        calendarView = view.findViewById(R.id.calendarView);
        diaryTextView = view.findViewById(R.id.diaryTextView);
        save_Btn = view.findViewById(R.id.save_Btn);
        del_Btn = view.findViewById(R.id.del_Btn);
        cha_Btn = view.findViewById(R.id.cha_Btn);
        textView2 = view.findViewById(R.id.textView2);
        contextEditText = view.findViewById(R.id.contextEditText);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                contextEditText.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.GONE);
                cha_Btn.setVisibility(View.GONE);
                del_Btn.setVisibility(View.GONE);
                diaryTextView.setText(String.format("%d / %d / %d", year, month + 1, dayOfMonth));
                diaryTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                diaryTextView.setTextSize(25);
                contextEditText.setText("");
                checkDay(year, month, dayOfMonth);

                save_Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        saveDiary(fname);
                        str = contextEditText.getText().toString();
                        if(str.isEmpty()){
                            Toast.makeText(view.getContext(), "????????? ???????????? ???????????????.", Toast.LENGTH_LONG).show();
                        }
                        else{
                            textView2.setText(str);
                            save_Btn.setVisibility(View.GONE);
                            cha_Btn.setVisibility(View.VISIBLE);
                            del_Btn.setVisibility(View.VISIBLE);
                            contextEditText.setVisibility(View.GONE);
                            textView2.setVisibility(View.VISIBLE);
                        }
                    }
                });

                cha_Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        contextEditText.setVisibility(View.VISIBLE);
                        textView2.setVisibility(View.GONE);
                        contextEditText.setText(str);

                        save_Btn.setVisibility(View.VISIBLE);
                        cha_Btn.setVisibility(View.GONE);
                        del_Btn.setVisibility(View.GONE);
                        textView2.setText(contextEditText.getText());
                    }
                });

                del_Btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        textView2.setVisibility(View.GONE);
                        contextEditText.setText("");
                        contextEditText.setVisibility(View.VISIBLE);
                        save_Btn.setVisibility(View.VISIBLE);
                        cha_Btn.setVisibility(View.GONE);
                        del_Btn.setVisibility(View.GONE);
                        removeDiary(fname);
                    }
                });
            }
        });



        return view;
    }

    public void checkDay(int cYear, int cMonth, int cDay) {
        fname = "" + cYear + "-" + (cMonth + 1) + "" + "-" + cDay + ".txt"; //????????? ?????? ?????? ??????
        FileInputStream fis = null; //FileStream fis ??????

        try {
            fis = getActivity().openFileInput(fname);

            byte[] fileData = new byte[fis.available()];
            fis.read(fileData);
            fis.close();

            str = new String(fileData);

            contextEditText.setVisibility(View.GONE);
            textView2.setVisibility(View.VISIBLE);
            textView2.setText(str);

            save_Btn.setVisibility(View.GONE);
            cha_Btn.setVisibility(View.VISIBLE);
            del_Btn.setVisibility(View.VISIBLE);

            if (textView2.getText() == null) {
                textView2.setVisibility(View.GONE);
                diaryTextView.setVisibility(View.VISIBLE);
                save_Btn.setVisibility(View.VISIBLE);
                cha_Btn.setVisibility(View.GONE);
                del_Btn.setVisibility(View.GONE);
                contextEditText.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void removeDiary(String readDay) {
        FileOutputStream fos = null;

        try {
            fos = getActivity().openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = "";
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    public void saveDiary(String readDay) {
        FileOutputStream fos = null;

        try {
            fos = getActivity().openFileOutput(readDay, MODE_NO_LOCALIZED_COLLATORS);
            String content = contextEditText.getText().toString();
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}