package wang.com.knowledgetest;

/**
 * Created by 1 on 2018/3/20.
 */

public class QuestionItem {
    public QuestionItem(String question, Boolean answer){
        this.question = question;
        this.answer = answer;
    }
    public String question;
    public boolean answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
