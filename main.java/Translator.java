package com.example.perst;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Translator extends Fragment {
    EditText inContent_et;
    TextView outContent_tv;
    Button setInLng_btn, setOutLng_btn;
    LinearLayout setInLngList, setOutLngList;
    Animation inputTranslateUp, inputTranslateDown, outputTranslateUp, outputTranslateDown;
    boolean inputIsShown = false, outputIsShown = false;
    String inputLng, outputLng;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_trans, container, false);

        //앱이 처음 실행될 때 requestQueue를 생성하도록 함
        if (ApiHelper.requestQueue == null) {
            ApiHelper.requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        }

        inContent_et = view.findViewById(R.id.inContent_et);
        outContent_tv = view.findViewById(R.id.outContent_tv);
        setInLngList = view.findViewById(R.id.setInLngList);
        setOutLngList = view.findViewById(R.id.setOutLngList);

        //input 상승 애니메이션 변수 할당
        inputTranslateUp = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up);
        inputTranslateUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setInLngList.setVisibility(view.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //input 하강 애니메이션 변수 할당
        inputTranslateDown = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_down);

        //output 상승 애니메이션 변수 할당
        outputTranslateUp = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_up);
        outputTranslateUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setOutLngList.setVisibility(view.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //output 하강 애니메이션 변수 할당
        outputTranslateDown = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.translate_down);

        // input 언어 선택 버튼을 터치하면 리스트가 나타나고 한번 더 터치하면 사라지도록 구현
        setInLng_btn = view.findViewById(R.id.setInLng_btn);
        setInLng_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputIsShown == true) {
                    setInLngList.startAnimation(inputTranslateUp);
                } else {
                    setInLngList.startAnimation(inputTranslateDown);
                    setInLngList.setVisibility(view.VISIBLE);
                }
                inputIsShown = !inputIsShown;
            }
        });

        //언어를 선택하면 선택버튼의 글이 변경되고 리스트가 사라지도록 구현
        //한국어
        final Button inKo_btn = view.findViewById(R.id.inkor_btn);
        inKo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inKo_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //영어
        final Button inEn_btn = view.findViewById(R.id.inEn_btn);
        inEn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inEn_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //중국어 간체
        final Button inCn_btn = view.findViewById(R.id.inCn_btn);
        inCn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inCn_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //중국어 번체
        final Button inTw_btn = view.findViewById(R.id.inTw_btn);
        inTw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inTw_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //베트남어
        final Button inVi_btn = view.findViewById(R.id.inVi_btn);
        inVi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inVi_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //프랑스어
        final Button inFr_btn = view.findViewById(R.id.inFr_btn);
        inFr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inFr_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //스페인어
        final Button inSp_btn = view.findViewById(R.id.inEn_btn);
        inSp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inSp_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //태국어
        final Button inTh_btn = view.findViewById(R.id.inTh_btn);
        inTh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inTh_btn.getText().toString());
                inputIsShown = false;
            }
        });

        //인도네시아어
        final Button inIn_btn = view.findViewById(R.id.inId_btn);
        inIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setInLngList.startAnimation(inputTranslateUp);
                setInLng_btn.setText(inIn_btn.getText().toString());
                inputIsShown = false;
            }
        });

        setOutLng_btn = view.findViewById(R.id.setOutLng_btn);
        setOutLng_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (outputIsShown == true) {
                    setOutLngList.startAnimation(outputTranslateUp);
                } else {
                    setOutLngList.startAnimation(outputTranslateDown);
                    setOutLngList.setVisibility(view.VISIBLE);
                }
                outputIsShown = !outputIsShown;
            }
        });

        //한국어
        final Button outKo_btn = view.findViewById(R.id.outkor_btn);
        outKo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outKo_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //영어
        final Button outEn_btn = view.findViewById(R.id.outEn_btn);
        outEn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outEn_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //중국어 간체
        final Button outCn_btn = view.findViewById(R.id.outCn_btn);
        outCn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outCn_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //중국어 번체
        final Button outTw_btn = view.findViewById(R.id.outTw_btn);
        outTw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outTw_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //베트남어
        final Button outVi_btn = view.findViewById(R.id.outVi_btn);
        outVi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outVi_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //프랑스어
        final Button outFr_btn = view.findViewById(R.id.outFr_btn);
        outFr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outFr_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //스페인어
        final Button outEs_btn = view.findViewById(R.id.outEs_btn);
        outEs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outEs_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //태국어
        final Button outTh_btn = view.findViewById(R.id.outTh_btn);
        outTh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outTh_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //인도네시아어
        final Button outId_btn = view.findViewById(R.id.outId_btn);
        outId_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOutLngList.startAnimation(outputTranslateUp);
                setOutLng_btn.setText(outId_btn.getText().toString());
                outputIsShown = false;
            }
        });

        //번역하기 버튼을 누르면 API 서버에 요청하도록 함
        Button translator_btn = view.findViewById(R.id.translator_btn);
        translator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });

        return view;
    }

    //API 서버로 요청하기 전, 필요한 정보를 설정하도록 함
    //필요한 정보: input언어, output언어, 번역할 단어나 문장
    //+ API 서버로 요청할 때 클라이언트 id와 비밀번호가 필요함

    //번역할 언어 선택은 if문을 사용해서 설정함
    public void sendRequest() {
        if (setInLng_btn.getText().toString().equals("한국어")) {
            inputLng = "ko";
        } else if (setInLng_btn.getText().toString().equals("영어")) {
            inputLng = "en";
        } else if (setInLng_btn.getText().toString().equals("중국어 간체")) {
            inputLng = "zh-CN";
        } else if (setInLng_btn.getText().toString().equals("중국어 번체")) {
            inputLng = "zh-TW";
        } else if (setInLng_btn.getText().toString().equals("스페인어")) {
            inputLng = "es";
        } else if (setInLng_btn.getText().toString().equals("프랑스어")) {
            inputLng = "fr";
        } else if (setInLng_btn.getText().toString().equals("베트남어")) {
            inputLng = "vi";
        } else if (setInLng_btn.getText().toString().equals("태국어")) {
            inputLng = "th";
        } else if (setInLng_btn.getText().toString().equals("인도네시아어")) {
            inputLng = "id";
        }

        if (setOutLng_btn.getText().toString().equals("한국어")) {
            outputLng = "ko";
        } else if (setOutLng_btn.getText().toString().equals("영어")) {
            outputLng = "en";
        } else if (setOutLng_btn.getText().toString().equals("중국어 간체")) {
            outputLng = "zh-CN";
        } else if (setOutLng_btn.getText().toString().equals("중국어 번체")) {
            outputLng = "zh-TW";
        } else if (setOutLng_btn.getText().toString().equals("스페인어")) {
            outputLng = "es";
        } else if (setOutLng_btn.getText().toString().equals("프랑스어")) {
            outputLng = "fr";
        } else if (setOutLng_btn.getText().toString().equals("베트남어")) {
            outputLng = "vi";
        } else if (setOutLng_btn.getText().toString().equals("태국어")) {
            outputLng = "th";
        } else if (setOutLng_btn.getText().toString().equals("인도네시아어")) {
            outputLng = "id";
        }

        //서버에 요청할 때 Volley 라이브러리를 사용함
        Request request = new StringRequest(
                Request.Method.POST,
                //서버에 필요한 정보들은 ApiHelper라는 클래스를 만들어 사용함
                ApiHelper.host,
                //서버에서는 JSON 객체로 보내주기 때문에
                //그걸 처리하는 메소드를 만들어 주는 것
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String body = null;
                        //서버로 요청 중 에러가 생기면 로그를 찍도록 함
                        try {
                            body = new String(error.networkResponse.data, StandardCharsets.UTF_8);
                            Log.d("Translator.java", body);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        ) {

            @Override
            //서버에 필요한 정보들은 ApiHelper라는 클래스를 만들어 사용함
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Naver-Client-Id", ApiHelper.clientId);
                params.put("X-Naver-Client-Secret", ApiHelper.clientSecret);

                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("source", inputLng);
                params.put("target", outputLng);
                params.put("text", inContent_et.getText().toString());

                return params;
            }
        };

        //volley를 사용할때 requestQueue에 추가해줘야 사용할 수 있게 함
        request.setShouldCache(false);
        ApiHelper.requestQueue.add(request);
    }


    //서버에서 받은 JSON 객체를 java 객체로 만들어주도록 함.
    // 그러기위해서 GSON 라이브러리를 사용해야 함
    public void processResponse(String response) {
        Gson gson = new Gson();
        TranslationMessage translationMessage = gson.fromJson(response, TranslationMessage.class);
        if (translationMessage != null) {
            outContent_tv.setText(translationMessage.message.result.translatedText);
        }
    }
}