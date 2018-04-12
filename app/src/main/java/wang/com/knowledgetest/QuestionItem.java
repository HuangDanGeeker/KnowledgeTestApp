package wang.com.knowledgetest;

/**
 * Created by 1 on 2018/3/20.
 */

public class QuestionItem {
    public QuestionItem(int question, Boolean answer){
        this.question = question;
        this.answer = answer;
    }
    public int question;
    public boolean answer;

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
