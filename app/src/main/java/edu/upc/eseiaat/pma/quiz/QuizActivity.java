package edu.upc.eseiaat.pma.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private int ids_answers []={
        R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text_question = (TextView) findViewById(R.id.text_question);
        text_question.setText(R.string.question_content);

        String[] answers= getResources().getStringArray(R.array.answers);


        for (int i=0; i< ids_answers.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_answers[i]);
            rb.setText(answers[i]);
        }

        //Aquí es on li dic que la resposta correcta es la segona (0,1,2...).//

        final int correct_answer = getResources().getInteger(R.integer.correct_answer);
        final RadioGroup grup= (RadioGroup) findViewById(R.id.answer_group);

        Button btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id= grup.getCheckedRadioButtonId();
                int answer=-1;
                for (int i=0; i< ids_answers.length; i++){
                    if (ids_answers[1] == id){
                            answer=1;

                    }
                }
                if (answer==correct_answer){
                    Toast.makeText(QuizActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(QuizActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
