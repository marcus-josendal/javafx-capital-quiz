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
        questionList.add("Hva er hovedstaden i Sverige?");
        questionList.add("Hva er hovedstaden i Japan?");
        questionList.add("Hva er hovedstaden i Canada?");
        answerList.add("oslo");
        answerList.add("buenos aires");
        answerList.add("brasilia");
        answerList.add("helsinki");
        answerList.add("bankok");
        answerList.add("ankara");
        answerList.add("washington dc");
        answerList.add("stockholm");
        answerList.add("tokyo");
        answerList.add("ottawa");



    }

    /**
     * Returns a question
     * @param questionId Specify what question you want from the ArrayList
     * @return The question in form of a string
     */
    public String returnQuestion(int questionId){
        return questionList.get(questionId);
    }

    /**
     * Returns size of questionList-array
     * @return Size of array in form of int
     */
    public int returnQuestionListSize(){
        return questionList.size();
    }

    /**
     * Returns an answer
     * @param answerId Specify what answer you want from ArrayList
     * @return The answer in form of a String
     */
    public String returnAnswer(int answerId){
        return answerList.get(answerId);
    }
}
