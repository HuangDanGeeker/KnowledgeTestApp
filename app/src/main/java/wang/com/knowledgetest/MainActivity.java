package wang.com.knowledgetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//
//    private QuestionItem[] questions ={
//                                    new QuestionItem(this.getString(R.string.question1), Boolean.valueOf(this.getString(R.string.answer1))),
//                                    new QuestionItem(this.getString(R.string.question2), Boolean.valueOf(this.getString(R.string.answer2))),
//                                    new QuestionItem(this.getString(R.string.question3), Boolean.valueOf(this.getString(R.string.answer3)))
//                                    };
    private QuestionItem[] questions ={
                                    new QuestionItem("s", true),
                                    new QuestionItem("s", true),
                                    new QuestionItem("s", true),
                                    };
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mTrueBtn = (Button)findViewById(R.id.true_answerBtn);
        Button mFalseBtn = (Button)findViewById(R.id.false_answerBtn);
        Button mCheatBtn = (Button)findViewById(R.id.cheatBtn);

        Log.w("Warning", "HEre");
        final TextView mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(questions[0].getQuestion());

        mTrueBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(questions[currentIndex].getAnswer()){
                    Toast.makeText(getBaseContext(), "Right Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }
                currentIndex = (currentIndex + 1 ) % 3;
                mQuestionTextView.setText(questions[currentIndex].getQuestion());
            }
        });
        mFalseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(questions[currentIndex].getAnswer()){
                    Toast.makeText(getBaseContext(), "False Answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getBaseContext(), "Right Answer", Toast.LENGTH_SHORT).show();
                }
                currentIndex = (currentIndex + 1 ) % 3;
                mQuestionTextView.setText(questions[currentIndex].getQuestion());
            }
        });

        mCheatBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CheatActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("question", questions[currentIndex].getQuestion());
                bundle.putBoolean("answer", questions[currentIndex].getAnswer());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
