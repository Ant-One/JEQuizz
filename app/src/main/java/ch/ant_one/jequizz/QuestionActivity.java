package ch.ant_one.jequizz;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.view.View.GONE;

public class QuestionActivity extends AppCompatActivity {

    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private TextView questionText;
    private TextView answerText;
    private Button nextBtn;

    private int score = 0;

    private int questionNumber;
    private static final int QUESTION_ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionText = (TextView) findViewById(R.id.questionText);
        answerText = (TextView) findViewById(R.id.answerText);
        answerBtn1 = (Button) findViewById(R.id.answer1);
        answerBtn2 = (Button) findViewById(R.id.answer2);
        answerBtn3 = (Button) findViewById(R.id.answer3);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        answerText.setVisibility(View.GONE);
        nextBtn.setVisibility(View.GONE);
        questionText.setVisibility(View.VISIBLE);
        answerBtn1.setVisibility(View.VISIBLE);
        answerBtn2.setVisibility(View.VISIBLE);
        answerBtn3.setVisibility(View.VISIBLE);

        questionNumber = getIntent().getIntExtra("questionNumber", 1);
        
        showQuestion(questionNumber);

        answerBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(questionNumber, 1);
            }
        });
        answerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(questionNumber, 2);
            }
        });
        answerBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(questionNumber, 3);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("SCORE", "Score : " + score);

                if(questionNumber < 10){
                    questionNumber += 1;
                    showQuestion(questionNumber);
                }else{
                    Intent FormActivity = new Intent(QuestionActivity.this, FormActivity.class);
                    FormActivity.putExtra("score", score);
                    startActivityForResult(FormActivity, QUESTION_ACTIVITY_CODE);
                    setResult(RESULT_OK);
                    finish();
                }

            }
        });
    }

    private void checkAnswer(int questionNumber, int btnNumber) {
        switch (questionNumber){
            case 1:
                if(btnNumber == 1){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 2:
                if(btnNumber == 3){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 3:
                if(btnNumber == 3){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 4:
                if(btnNumber == 1){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 5:
                if(btnNumber == 1){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 6:
                if(btnNumber == 2){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 7:
                if(btnNumber == 3){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 8:
                if(btnNumber == 2){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 9:
                if(btnNumber == 3){
                    score += 1;
                }
                showAns(questionNumber);
                break;

            case 10:
                if(btnNumber == 2){
                    score += 1;
                }
                showAns(questionNumber);
                break;
        }
    }

    private void showAns(int questionNumber) {
        questionText.setVisibility(View.GONE);
        answerBtn1.setVisibility(View.GONE);
        answerBtn2.setVisibility(View.GONE);
        answerBtn3.setVisibility(View.GONE);
        answerText.setVisibility(View.VISIBLE);
        if(questionNumber == 10){
            nextBtn.setText(getString(R.string.btnEnd));
        }
        nextBtn.setVisibility(View.VISIBLE);

    }

    private void showQuestion(int questionNumber) {
        answerText.setVisibility(View.GONE);
        nextBtn.setVisibility(View.GONE);
        questionText.setVisibility(View.VISIBLE);
        answerBtn1.setVisibility(View.VISIBLE);
        answerBtn2.setVisibility(View.VISIBLE);
        answerBtn3.setVisibility(View.VISIBLE);

        switch (questionNumber){
            case 1:
                questionText.setText(R.string.question1Text);
                answerText.setText(R.string.ansTxtq1);
                answerBtn1.setText(R.string.ans1q1);
                answerBtn2.setText(R.string.ans2q1);
                answerBtn3.setVisibility(GONE);
                break;

            case 2:
                questionText.setText(R.string.question2Text);
                answerText.setText(R.string.ansTxtq2);
                answerBtn1.setText(R.string.ans1q2);
                answerBtn2.setText(R.string.ans2q2);
                answerBtn3.setText(R.string.ans3q2);
                break;

            case 3:
                questionText.setText(R.string.question3Text);
                answerText.setText(R.string.ansTxtq3);
                answerBtn1.setText(R.string.ans1q3);
                answerBtn2.setText(R.string.ans2q3);
                answerBtn3.setText(R.string.ans3q3);
                break;

            case 4:
                questionText.setText(R.string.question4Text);
                answerText.setText(R.string.ansTxtq4);
                answerBtn1.setText(R.string.ans1q4);
                answerBtn2.setText(R.string.ans2q4);
                answerBtn3.setText(R.string.ans3q4);
                break;

            case 5:
                questionText.setText(R.string.question5Text);
                answerText.setText(R.string.ansTxtq5);
                answerBtn1.setText(R.string.ans1q5);
                answerBtn2.setText(R.string.ans2q5);
                answerBtn3.setVisibility(View.GONE);
                break;

            case 6:
                questionText.setText(R.string.question6Text);
                answerText.setText(R.string.ansTxtq6);
                answerBtn1.setText(R.string.ans1q6);
                answerBtn2.setText(R.string.ans2q6);
                answerBtn3.setText(R.string.ans3q6);
                break;

            case 7:
                questionText.setText(R.string.question7Text);
                answerText.setText(R.string.ansTxtq7);
                answerBtn1.setText(R.string.ans1q7);
                answerBtn2.setText(R.string.ans2q7);
                answerBtn3.setText(R.string.ans3q7);
                break;

            case 8:
                questionText.setText(R.string.question8Text);
                answerText.setText(R.string.ansTxtq8);
                answerBtn1.setText(R.string.ans1q8);
                answerBtn2.setText(R.string.ans2q8);
                answerBtn3.setVisibility(View.GONE);
                break;

            case 9:
                questionText.setText(R.string.question9Text);
                answerText.setText(R.string.ansTxtq9);
                answerBtn1.setText(R.string.ans1q9);
                answerBtn2.setText(R.string.ans2q9);
                answerBtn3.setText(R.string.ans3q9);
                break;

            case 10:
                questionText.setText(R.string.question10Text);
                answerText.setText(R.string.ansTxtq10);
                answerBtn1.setText(R.string.ans1q10);
                answerBtn2.setText(R.string.ans2q10);
                answerBtn3.setText(R.string.ans3q10);
                break;
        }
    }
}
