package com.rq.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE = "com.rq.sharedpreferencesapp.preferences";
    private static final String KEY_EDITTEXT = "KEY_EDITTEXT";
    @BindView(R.id.editText) EditText editText;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        String text = sharedPreferences.getString(KEY_EDITTEXT, "");
        editText.setText(text);
    }

    @Override
    protected void onPause() {
        super.onPause();
        editor = sharedPreferences.edit();
        editor.putString(KEY_EDITTEXT, editText.getText().toString());
        editor.apply();
    }
}
