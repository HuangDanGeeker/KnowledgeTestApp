package wang.com.knowledgetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//
    private QuestionItem[] questions ={
                                    new QuestionItem(R.string.question1, true),
                                    new QuestionItem(R.string.question2, true),
                                    new QuestionItem(R.string.question3, false)
                                    };
    // REUQEST CODE
    private static final int CHECK_FOR_ANSWER = 1;
    private int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mTrueBtn = (Button)findViewById(R.id.true_answerBtn);
        Button mFalseBtn = (Button)findViewById(R.id.false_answerBtn);
        Button mCheatBtn = (Button)findViewById(R.id.cheatBtn);

        final TextView mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setText(questions[0].getQuestion());

        mTrueBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(questions[currentIndex].getAnswer()){
                    Toast.makeText(getBaseContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getBaseContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
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
                bundle.putInt("question", questions[currentIndex].getQuestion());
                bundle.putBoolean("answer", questions[currentIndex].getAnswer());
                intent.putExtras(bundle);
                startActivityForResult(intent, CHECK_FOR_ANSWER);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case CHECK_FOR_ANSWER:
                if(resultCode == RESULT_OK && data.getBooleanExtra("isCheat", false)){
                    Toast.makeText(getBaseContext(), "The answer is " + data.getStringExtra("answer"), Toast.LENGTH_SHORT).show();
                }
                break;
            default: break;
        }
    }
}
