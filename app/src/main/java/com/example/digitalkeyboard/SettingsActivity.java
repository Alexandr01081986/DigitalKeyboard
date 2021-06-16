package com.example.digitalkeyboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends AppCompatActivity {

    public static final String NAME_ACTIVITY = "SettingsActivity";


    private static final String GenericPreference = "CALC";
    private static final String SettingsPreference = "SETTINGS";

    private static final String AppTheme = "APP_THEME";
    private static final int AppThemeMaterialBlack = 0;
    private static final int AppThemeMaterialRed = 1;
    private static final int AppThemeMaterialDefault = 2;
    private static final int AppThemeMaterialBlue = 3;

    private int codeToSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        codeToSave = getCodeStyle(GenericPreference);
        if (codeToSave != getCodeStyle(SettingsPreference)) {
            codeToSave = getCodeStyle(SettingsPreference);
            setTheme(getAppTheme(SettingsPreference));
        } else {
            setTheme(getAppTheme(GenericPreference));
        }

        setContentView(R.layout.activity_settings);
        initThemeChooser();

        Button btSaveSettings = findViewById(R.id.btnSaveSettings);
        btSaveSettings.setOnClickListener((view) -> {
            saveTheme(SettingsPreference, codeToSave);
            saveTheme(GenericPreference, codeToSave);
            Intent result = new Intent();
            result.putExtra(MainActivity.U_NAME, "ok");
            setResult(RESULT_OK, result);
            finish();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(NAME_ACTIVITY, "onDestroy() ");
    }

    private int getAppTheme(String NameSharedPreference) {
        return codeStyleToStyleId(getCodeStyle(NameSharedPreference));
    }


    private int getCodeStyle(String NameSharedPreference) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        return sharedPref.getInt(AppTheme, 0);
    }


    private void setAppTheme(int codeStyle) {
        codeToSave = codeStyle;
        saveTheme(SettingsPreference, codeToSave);
        recreate();
    }

    private void saveTheme(String NameSharedPreference, int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    public static int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeMaterialDefault:
                return R.style.AppThemeOrange;
            case AppThemeMaterialRed:
                return R.style.AppThemeLight;
            case AppThemeMaterialBlue:
                return R.style.AppThemeDark;
            case AppThemeMaterialBlack:
                return R.style.MyCoolStyle;
            default:
                return 0;
        }
    }

    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonMaterialBlack), AppThemeMaterialBlack);
        initRadioButton(findViewById(R.id.radioButtonMaterialBlue), AppThemeMaterialBlue);
        initRadioButton(findViewById(R.id.radioButtonMaterialRed), AppThemeMaterialRed);
        initRadioButton(findViewById(R.id.radioButtonMaterialDefault), AppThemeMaterialDefault);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(codeToSave)).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(v -> setAppTheme(codeStyle));
    }
}
