package wang.com.knowledgetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CheatActivity extends AppCompatActivity {

    public Boolean mAnswer;
    private Button mGobackBtn;
    private Button mShowAnsearBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Bundle bundle = this.getIntent().getExtras();

        mAnswer = bundle.getBoolean("answer");
        mGobackBtn = (Button) findViewById(R.id.back_to_mainActivity_btn);
        mShowAnsearBtn = (Button) findViewById(R.id.show_answer_btn);

        mGobackBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("isCheat", false);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        mShowAnsearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("isCheat", true);
                intent.putExtra("answer", mAnswer.toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}
