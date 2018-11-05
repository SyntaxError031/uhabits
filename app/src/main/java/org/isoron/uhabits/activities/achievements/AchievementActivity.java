package org.isoron.uhabits.activities.achievements;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import org.isoron.uhabits.R;
import org.isoron.uhabits.activities.BaseActivity;

public class AchievementActivity extends BaseActivity {

    private AchievementController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievements);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar == null) return;

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) return;

        actionBar.setDisplayHomeAsUpEnabled(true);

        controller = new AchievementController(this);

        Button details_btn = findViewById(R.id.view_details);
        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AchievementActivity.this, DetailsActivity.class);
                startActivity(i);
            }
            });

    }

}
