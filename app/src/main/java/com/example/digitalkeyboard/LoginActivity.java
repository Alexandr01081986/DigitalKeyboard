package com.example.digitalkeyboard;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

@SuppressWarnings("ALL")
public class LoginActivity<TextInputEditText, MaterialRadioButton> extends AppCompatActivity {


    private static final String NameSharedPreference = "LOGIN";

    private static final String AppTheme = "APP_THEME";
    private static final int AppThemeMaterialBlack = 0;
    private static final int AppThemeMaterialRed = 1;
    private static final int AppThemeMaterialDefault = 2;
    private static final int AppThemeMaterialBlue = 3;

    private View item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyCoolStyle));
        setContentView(R.layout.activity_login);
        initThemeChooser();
    }

    @SuppressWarnings("unchecked")
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMaterialBlack), AppThemeMaterialBlack);
        initRadioButton(findViewById(R.id.radioButtonMaterialBlue), AppThemeMaterialBlue);
        initRadioButton(findViewById(R.id.radioButtonMaterialRed), AppThemeMaterialRed);
        initRadioButton(findViewById(R.id.radioButtonMaterialDefault), AppThemeMaterialDefault);
        RadioGroup rg = findViewById(R.id.radioButtons);
        int codeToSave = 0;
        ((com.google.android.material.radiobutton.MaterialRadioButton) rg.getChildAt(codeToSave)).setChecked(true);
    }
    

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }


    private int getCodeStyle(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeMaterialDefault:
                return R.style.AppTheme;
            case AppThemeMaterialRed:
                return R.style.AppThemeLight;
            case AppThemeMaterialBlue:
                return R.style.AppThemeDark;
            default:
                return R.style.MyCoolStyle;
        }
    }
}
