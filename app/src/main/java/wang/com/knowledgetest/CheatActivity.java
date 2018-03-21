package wang.com.knowledgetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private String mQuestion;
    private Boolean mAnswer;
    private Button mGobackBtn;
    private TextView mQuestionView;
    private TextView mCheatView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Bundle bundle = this.getIntent().getExtras();

        mQuestion = bundle.getString("question");
        mAnswer = bundle.getBoolean("answear");
        mGobackBtn = (Button) findViewById(R.id.back_to_mainActivity_btn);
        mQuestionView= (TextView) findViewById(R.id.question_view);
        mCheatView = (TextView) findViewById(R.id.cheat_view);

        mGobackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        mQuestionView.setText(mQuestion);
        mCheatView.setText(mAnswer.toString());

    }
}
