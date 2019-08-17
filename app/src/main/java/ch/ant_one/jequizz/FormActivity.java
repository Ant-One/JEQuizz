package ch.ant_one.jequizz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

import com.opencsv.CSVWriter;

import org.w3c.dom.Text;

import static java.lang.System.currentTimeMillis;

public class FormActivity extends AppCompatActivity {

    private TextView textEndQuizz;
    private EditText editName;
    private EditText editSurname;
    private EditText editPhone;
    private EditText editPlace;
    private EditText editEmail;
    private CheckBox checkEULA;
    private TextView textEULA;
    private Button btnConfirm;
    private TextView scoreText;

    private  int score;
    private boolean firstPressed = true;
    private long time = currentTimeMillis();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        getSupportActionBar().hide();

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);

        Intent intent = new Intent();
        intent = getIntent();
        score = intent.getIntExtra("score", 0);

        textEndQuizz = (TextView) findViewById(R.id.textEndQuizz);
        editName = (EditText) findViewById(R.id.editName);
        editSurname = (EditText) findViewById(R.id.editSurname);
        editPhone = (EditText) findViewById(R.id.editPhone);
        editPlace = (EditText) findViewById(R.id.editPlace);
        editEmail = (EditText) findViewById(R.id.editEmail);
        checkEULA = (CheckBox) findViewById(R.id.checkEULA);
        textEULA = (TextView) findViewById(R.id.textEULA);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        scoreText = (TextView) findViewById(R.id.scoreText);

        scoreText.setText(getText(R.string.scoreText) + " " + String.valueOf(score) + "/10");

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editName.getText().toString().equals("")) {
                    editName.setError("Veuillez entrer votre nom");
                }
                else if (editSurname.getText().toString().equals("")) {
                    editSurname.setError("Veuillez entrer votre prénom");
                }
                else if (editPhone.getText().toString().equals("")) {
                    editPhone.setError("Veuillez entrer un numéro de téléphone valide");
                }
                else if (editPlace.getText().toString().equals("")) {
                    editPlace.setError("Veuillez entrer une localité valide");
                }
                else if (editEmail.getText().toString().equals("")) {
                    editEmail.setError("Veuillez entrer une adresse email valide");
                }
                else if (checkEULA.isChecked() == false) {
                    checkEULA.setError("Vous devez accepter les conditions de participation pour continuer");
                }
                else {
                    Toast.makeText(FormActivity.this, "Merci de votre participation",
                            Toast.LENGTH_LONG).show();

                    String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
                    String fileName = "Scores_JE_Quizz.csv";
                    String filePath = baseDir + File.separator + fileName;
                    FileWriter fileWriter;
                    File f = new File(filePath);
                    CSVWriter writer;

                    try{
                        // File exist
                        if(f.exists()&&!f.isDirectory())
                        {
                            fileWriter = new FileWriter(filePath, true);
                            writer = new CSVWriter(fileWriter);
                        }
                        else
                        {
                            writer = new CSVWriter(new FileWriter(filePath));
                        }

                    String[] data = {editName.getText().toString(), editSurname.getText().toString(), editEmail.getText().toString(), editPlace.getText().toString(), editPlace.getText().toString(), String.valueOf(score), Boolean.valueOf(checkEULA.isChecked()).toString()};

                    writer.writeNext(data);

                    writer.close();}
                    catch (Exception e){
                        Toast.makeText(FormActivity.this, ""+e.toString(),
                                Toast.LENGTH_LONG).show();
                    }

                    finish();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {

        if(currentTimeMillis() - time > 2000)
            firstPressed = true;

        if(firstPressed){
            Toast.makeText(FormActivity.this, "Appuyez encore une fois pour quitter l'application",
                    Toast.LENGTH_LONG).show();
            firstPressed = false;
            time = currentTimeMillis();
        }
        else
            finish();

    }
}
