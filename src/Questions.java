import java.util.ArrayList;

public class Questions {

    ArrayList<String> questionList = new ArrayList<>();
    ArrayList<String> answerList = new ArrayList<>();

    public Questions(){
        questionList.add("Hva er hovedstaden i Norge?");
        questionList.add("Hva er hovedstaden i Argentina?");
        questionList.add("Hva er hovedstaden i Brasil?");
        questionList.add("Hva er hovedstaden i Finland?");
        questionList.add("Hva er hovedstaden i Thailand?");
        questionList.add("Hva er hovedstaden i Tyrkia?");
        questionList.add("Hva er hovedstaden i USA?");
        answerList.add("oslo");
        answerList.add("buenos aires");
        answerList.add("brasilia");
        answerList.add("helsinki");
        answerList.add("bankok");
        answerList.add("ankara");
        answerList.add("washington dc");

    }
    //Returns question as a String
    public String returnQuestion(int questionId){
        return questionList.get(questionId);
    }
    //Returns the size of the questionlist
    public int returnQuestionListSize(){
        return questionList.size();
    }
    //Returns answer from answerlist
    public String returnAnswer(int answerId){
        return answerList.get(answerId);
    }
}
