package com.example.digitalkeyboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

class Calculator<param> extends AppCompatActivity {

    public static final String NAME = "Calculator";
    public static final String FIRST = NAME + ".mFirst";
    private static final String SECOND = NAME + ".mSecond";
    private static final String OPERATION = NAME + ".mOperation";
    private static final String RESULT = NAME + ".mResult";
    private static final String TVRESULT = NAME + ".tvResult";

    public static final String U_NAME = "our.prefix.user.name";

    private String mFirst;
    private String mSecond;
    private String tvResultText = "0";
    private char mOperation;
    private float mResult;
    TextView tvResult;
    Intent mItMoveToTest;

    private static final String NameSharedPreference = "CALC";
    private static final String appTheme = "APP_THEME";
    private Object SettingsActivity;
    private String text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(-1));
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

        mItMoveToTest = new Intent(this, SettingsActivity.class);

        Button btnMoveToTest = findViewById(R.id.btnMoveToTest);
        btnMoveToTest.setOnClickListener(moveToTestClickListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(NAME, "onActivityResult() ");
        if (data != null && resultCode == RESULT_OK) {
            recreate();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(NAME, "onStart() ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(NAME, "onRestart() ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(NAME, "onResume() ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(NAME, "onPause() ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(NAME, "onStop() ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(NAME, "onDestroy() ");
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
        setTvResult(state.getString(TVRESULT));
    }

    private final View.OnClickListener moveToTestClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            startActivityForResult(mItMoveToTest, 1);
        }
    };

    private final View.OnClickListener buttonClearClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mFirst = "";
            mSecond = "";
            mResult = 0f;
            mOperation = ' ';
            setTvResult("0");
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
                setTvResult("0");
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
                setTvResult(text.substring(0, text.length() - 1));
            } else {
                mOperation = ' ';
                mSecond = "";
                setTvResult(text.substring(0, text.length() - 1));
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
            if (mOperation == '!') return;
            String resultText = "";
            try {
                if (!mFirst.equals("") && !mSecond.equals("")) {
                    float first = Float.parseFloat(mFirst);
                    float second = Float.parseFloat(mSecond);
                    if (mOperation != ' ' && tvResultText.contains("=")) {
                        first = mResult;
                        mFirst = "" + mResult;
                        setTvResult("" + mResult + mOperation + mSecond);
                    }
                    addCharToText(" = ");
                    switch (mOperation) {
                        case '+':
                            mResult = first + second;
                            break;
                        case '-':
                            mResult = first - second;
                            break;
                        case '*':
                            mResult = first * second;
                            break;
                        case '/':
                            if (mSecond.equals("0")) {
                                throw new ArithmeticException("Деление на 0");
                            }
                            mResult = first / second;
                            break;
                        default:
                            mResult = 0;
                    }
                    resultText = "" + mResult;
                    if (resultText.equals("Infinity")) {
                        throw new ArithmeticException("Превышение");
                    }
                    resultText = splitZero(resultText);
                }
                addCharToText(resultText);
            } catch (Exception ex) {
                addCharToText(" : " + ex.getMessage());
                mOperation = '!';
            }
        }
    };

    private void setTvResult(String s) {
    }

    private void addCharToText(String s) {
    }

    private String splitZero(String resultText) {
        boolean exist0 = false;
        if (resultText.contains(".") || resultText.contains(",")) {
            exist0 = true;
        }
        while (exist0) {
            if (resultText.charAt(resultText.length() - 1) == '0' && resultText.length() != 1) {
                resultText = resultText.substring(0, resultText.length() - 1);
            } else if (resultText.charAt(resultText.length() - 1) == ',' || resultText.charAt(resultText.length() - 1) == '.') {
                resultText = resultText.substring(0, resultText.length() - 1);
                exist0 = false;
            } else {
                exist0 = false;
            }
        }
        return resultText;
    }

    private void addCharToParam(String button) {
        if (tvResultText.contains("=")) {
            initCalc();
        }
        if (mOperation == '!') {
            return;
        } else if (mOperation == ' ') {
            if ((!button.equals(".") || !mFirst.contains(".")) && mFirst.length() < 15) {
                if (mFirst.length() == 0 && button.equals(".")) button = "0" + button;
                mFirst += button;
                addCharToText(button);
            }
        } else {
            if ((!button.equals(".") || !mSecond.contains(".")) && mSecond.length() < 15) {
                if (mSecond.length() == 0 && button.equals(".")) button = "0" + button;
                mSecond += button;
                addCharToText(button);
            }
        }

        private void addCharToText (String button){
            if (tvResult.getText() == "0") {
                setTvResult(button);
            } else {
                setTvResult(tvResult.getText() + button);
            }
        }

        private void setTvResult (String text){
            tvResultText = text;
            tvResult.setText(text);
        }

    }

    private void initCalc() {
        mFirst = "";
        mSecond = "";
        mResult = 0f;
        mOperation = ' ';
        setTvResult("0");
    }

    private int getAppTheme(int codeStyle) {
        return SettingsActivity.codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(appTheme, codeStyle);
    }
}
