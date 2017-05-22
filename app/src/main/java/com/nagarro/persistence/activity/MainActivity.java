package com.nagarro.persistence.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nagarro.persistence.R;
import com.nagarro.persistence.database.AppDatabase;
import com.nagarro.persistence.databinding.ActivityMainBinding;
import com.nagarro.persistence.utils.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.clickHereBtn.setOnClickListener(view ->
                DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this))
        );
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
