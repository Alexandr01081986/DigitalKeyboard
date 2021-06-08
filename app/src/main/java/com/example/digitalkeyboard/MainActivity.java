package com.example.digitalkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

class Calculator extends AppCompatActivity {

    public static final String NAME = "Calculator";
    public static final String FIRST = NAME + ".mFirst";
    private static final String SECOND = NAME + ".mSecond";
    private static final String OPERATION = NAME + ".mOperation";
    private static final String RESULT = NAME + ".mResult";
    private static final String TVRESULT = NAME + ".tvResult";

    private String mFirst;
    private String mSecond;
    private String tvResultText = "0";
    private char mOperation;
    private float mResult;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonDivision = findViewById(R.id.buttonDivision);
        Button buttonMultiplication = findViewById(R.id.buttonMultiplication);
        Button buttonDelete = findViewById(R.id.buttonDelete);
        Button buttonCon = findViewById(R.id.buttonCon);
        Button buttonPros = findViewById(R.id.buttonPros);
        Button buttonEven = findViewById(R.id.buttonEven);
        Button buttonPoint = findViewById(R.id.buttonPoint);
        tvResult = findViewById(R.id.tvResult);
        setTvResult();

        button1.setOnClickListener(button1ClickListener);
        button2.setOnClickListener(button2ClickListener);
        button3.setOnClickListener(button3ClickListener);
        button4.setOnClickListener(button4ClickListener);
        button5.setOnClickListener(button5ClickListener);
        button6.setOnClickListener(button6ClickListener);
        button7.setOnClickListener(button7ClickListener);
        button8.setOnClickListener(button8ClickListener);
        button9.setOnClickListener(button9ClickListener);
        button0.setOnClickListener(button0ClickListener);
        buttonClear.setOnClickListener(buttonClearClickListener);
        buttonDivision.setOnClickListener(buttonDivisionClickListener);
        buttonMultiplication.setOnClickListener(buttonMultiplicationClickListener);
        buttonDelete.setOnClickListener(buttonDeleteClickListener);
        buttonCon.setOnClickListener(buttonConClickListener);
        buttonPros.setOnClickListener(buttonProsClickListener);
        buttonEven.setOnClickListener(buttonEvenClickListener);
        buttonPoint.setOnClickListener(buttonPointClickListener);

    }

    private void setTvResult() {
    }


    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);

        state.putString(FIRST, mFirst);
        state.putString(SECOND, mSecond);
        state.putChar(OPERATION, mOperation);
        state.putFloat(RESULT, mResult);
        state.putString(TVRESULT, String.valueOf(tvResult));
    }

    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        
        mFirst = state.getString(FIRST);
        mSecond = state.getString(SECOND);
        mOperation = state.getChar(OPERATION);
        mResult = state.getFloat(RESULT);
        setResultText(state.getString(TVRESULT));
    }



    private final View.OnClickListener buttonClearClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mFirst = "";
            mSecond = "";
            mResult = 0f;
            mOperation = ' ';
            setResultText("0");
        }
    };

    private final View.OnClickListener button0ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("0");
        }
    };

    private final View.OnClickListener button1ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("1");
        }
    };

    private final View.OnClickListener button2ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("2");
        }
    };

    private final View.OnClickListener button3ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("3");
        }
    };

    private final View.OnClickListener button4ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("4");
        }
    };

    private final View.OnClickListener button5ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("5");
        }
    };

    private final View.OnClickListener button6ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("6");
        }
    };

    private final View.OnClickListener button7ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("7");
        }
    };

    private final View.OnClickListener button8ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("8");
        }
    };

    private final View.OnClickListener button9ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam("9");
        }
    };

    private final View.OnClickListener buttonDivisionClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mOperation = '/';
            addCharToParam("/");
        }
    };

    private final View.OnClickListener buttonMultiplicationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mOperation = '*';
            addCharToParam("*");
        }
    };

    private final View.OnClickListener buttonDeleteClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = tvResult.getText().toString();

            if (text.length() == 1) {
                mFirst = "";
                setResultText("0");
            } else if (
                    text.charAt(text.length() - 1) != '+' && text.charAt(text.length() - 1) != '*' &&
                            text.charAt(text.length() - 1) != '/' && text.charAt(text.length() - 1) != '-'
            ) {
                if (mOperation == ' ') {
                    if (!mFirst.equals("")) {
                        mFirst = mFirst.substring(0, mFirst.length() - 1);
                    }
                } else {
                    if (!mSecond.equals("")) {
                        mSecond = mSecond.substring(0, mSecond.length() - 1);
                    }
                }
                setResultText(text.substring(0, text.length() - 1));
            } else {
                mOperation = ' ';
                mSecond = "";
                setResultText(text.substring(0, text.length() - 1));
            }
        }
    };

    private final View.OnClickListener buttonConClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mOperation = '-';
            addCharToParam("-");
        }
    };

    private final View.OnClickListener buttonProsClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mOperation = '+';
            addCharToParam("+");
        }
    };

    private final View.OnClickListener buttonPointClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToParam(",");
        }
    };

    private final View.OnClickListener buttonEvenClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addCharToText();
            switch (mOperation) {
                case '+':
                    mResult = Float.parseFloat(mFirst) + Float.parseFloat(mSecond);
                    break;
                case '-':
                    mResult = Float.parseFloat(mFirst) - Float.parseFloat(mSecond);
                    break;
                case '*':
                    mResult = Float.parseFloat(mFirst) * Float.parseFloat(mSecond);
                    break;
                case '/':
                    mResult = Float.parseFloat(mFirst) / Float.parseFloat(mSecond);
                    break;
                default:
                    mResult = 0;
            }

            setResultText(String.format(Locale.getDefault(), "%f", mResult));
        }
    };

    private void addCharToParam(String button) {
        if (mOperation == ' ') {
            mFirst += button;
        } else {
            mSecond += button;
        }

        addCharToText();
    }

    private void addCharToText() {
    }

    private void setResultText(String text) {
        tvResultText = text;
        tvResult.setText(text);
    }

}