package ch.ant_one.jequizz;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static java.lang.System.currentTimeMillis;

public class MainActivity extends AppCompatActivity {

    private Button playBtn;
    private TextView textGreet;
    private TextView textPrizes;
    private boolean firstPressed = true;
    private long time = currentTimeMillis();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        playBtn = (Button) findViewById(R.id.playButton);
        textGreet = (TextView) findViewById(R.id.greetingText);
        textPrizes = (TextView) findViewById(R.id.prizesText);

        CharSequence t1 = getText(R.string.bullet1);
        SpannableString s1 = new SpannableString(t1);
        s1.setSpan(new BulletSpan(15), 0, t1.length(), 0);

        CharSequence t2 = getText(R.string.bullet2);
        SpannableString s2 = new SpannableString(t2);
        s2.setSpan(new BulletSpan(15), 0, t2.length(), 0)
        ;
        CharSequence t3 = getText(R.string.bullet3);
        SpannableString s3 = new SpannableString(t3);
        s3.setSpan(new BulletSpan(15), 0, t3.length(), 0);

        textPrizes.setText(TextUtils.concat("\n\n", s1, "\n", s2, "\n", s3));


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent questionActivity = new Intent(MainActivity.this, QuestionActivity.class);
                startActivity(questionActivity);
            }
        });

    }

    @Override
    public void onBackPressed() {

        if(currentTimeMillis() - time > 2000)
            firstPressed = true;

        if(firstPressed){
            Toast.makeText(MainActivity.this, "Appuyez encore une fois pour quitter l'application",
                    Toast.LENGTH_LONG).show();
            firstPressed = false;
            time = currentTimeMillis();
        }
        else
            finish();

    }

    @Override
    protected void onResume() {
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        super.onResume();
    }
}