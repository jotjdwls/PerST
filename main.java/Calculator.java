package com.example.perst;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import org.mariuszgromada.math.mxparser.Expression;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends Fragment {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnSquare/*제곱*/, btnFactorial, btnPi, btnClear, btnBack, btnEqual,
            btnDiv, btnMult, btnMinus, btnAdd, btnDecimal, btnLeftParentheses, btnRightParentheses;

    TextView outputTv;
    String str = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_calc, container, false);

        btn0 = (Button) view.findViewById(R.id.zero);
        btn1 = (Button) view.findViewById(R.id.one);
        btn2 = (Button) view.findViewById(R.id.two);
        btn3 = (Button) view.findViewById(R.id.three);
        btn4 = (Button) view.findViewById(R.id.four);
        btn5 = (Button) view.findViewById(R.id.five);
        btn6 = (Button) view.findViewById(R.id.six);
        btn7 = (Button) view.findViewById(R.id.seven);
        btn8 = (Button) view.findViewById(R.id.eight);
        btn9 = (Button) view.findViewById(R.id.nine);

        btnFactorial = (Button) view.findViewById(R.id.factorial);
        btnSquare = (Button) view.findViewById(R.id.square);
        btnPi = (Button) view.findViewById(R.id.pi);
        btnDiv = (Button) view.findViewById(R.id.div);
        btnMult = (Button) view.findViewById(R.id.mult);
        btnAdd = (Button) view.findViewById(R.id.plus);
        btnMinus = (Button) view.findViewById(R.id.minus);
        btnDecimal = (Button) view.findViewById(R.id.dot);
        btnRightParentheses = (Button) view.findViewById(R.id.rpth);
        btnLeftParentheses = (Button) view.findViewById(R.id.lpth);

        btnClear = (Button) view.findViewById(R.id.ac);
        btnEqual = (Button) view.findViewById(R.id.fin);
        btnBack = (Button) view.findViewById(R.id.del);

        outputTv = (TextView) view.findViewById(R.id.textView);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn0.getText();
                outputTv.setText(str);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn1.getText();
                outputTv.setText(str);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn2.getText();
                outputTv.setText(str);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn3.getText();
                outputTv.setText(str);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn4.getText();
                outputTv.setText(str);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn5.getText();
                outputTv.setText(str);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn6.getText();
                outputTv.setText(str);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn7.getText();
                outputTv.setText(str);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn8.getText();
                outputTv.setText(str);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btn9.getText();
                outputTv.setText(str);
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnFactorial.getText();
                outputTv.setText(str);
            }
        });

        btnSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += "^";
                outputTv.setText(str);
            }
        });

        btnPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnPi.getText();
                outputTv.setText(str);
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnDecimal.getText();
                outputTv.setText(str);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnAdd.getText();
                outputTv.setText(str);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnMinus.getText();
                outputTv.setText(str);
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += "*";
                outputTv.setText(str);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += "/";
                outputTv.setText(str);
            }
        });

        btnRightParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnRightParentheses.getText();
                outputTv.setText(str);
            }
        });

        btnLeftParentheses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str += btnLeftParentheses.getText();
                outputTv.setText(str);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Expression e = new Expression(str);

                if (String.valueOf(e.calculate()) == "NaN") {
                    str = "";
                    outputTv.setText("ERROR");

                } else {
                    outputTv.setText(e.getExpressionString() + " = " + e.calculate());
                    str = String.valueOf(Double.valueOf(e.calculate()));
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (str.length() <= 1) {
                    str = "";
                    outputTv.setText("0");
                } else {
                    String tmp = "";
                    for (int i = 0; i < str.length() - 1; i++) {
                        tmp += str.charAt(i);
                    }
                    str = tmp;
                    outputTv.setText(str);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str = "";
                outputTv.setText("0");
            }
        });

        return view;
    }
}