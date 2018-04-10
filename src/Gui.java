import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Gui extends Application {
    //Objects
    private Questions questions = new Questions();
    private Builder builder = new Builder();
    private Images images = new Images();

    //Text
    private Text scoreText = new Text();
    private Text question = new Text();
    private Text questionCounter = new Text();
    private TextField textField = new TextField();

    //Buttons
    private Button nextQuestion = new Button("Neste spørsmål");
    private Button submit = new Button("Submit");

    BorderPane borderPane = new BorderPane();

    //Scores and contentrefresher
    private int contentRefresher = 0;
    private int score = 0;

    private ImageView imageView = new ImageView();


    public void start(Stage primaryStage) {

        imageView.setImage(images.returnImage(0, 600, 400));
        imageView.setFitHeight(400);
        imageView.setFitWidth(600);

        nextQuestion.setDefaultButton(false);
        submit.setDefaultButton(true);

        //Put question-text in VBox so it's possible to align.
        VBox textBox = new VBox();
        question.setText(questions.returnQuestion(0));
        textBox.setPadding(new Insets(10,10,20,10));
        textBox.getChildren().addAll(question);
        textBox.setAlignment(Pos.CENTER);

        //Styles the questions
        question.setFont(new Font("Arial", 35));
        question.setFill(Color.BLUE);
        question.setTextAlignment(TextAlignment.CENTER);

        //Styles scoretext
        scoreText.setFont(new Font("Arial", 35));
        scoreText.setFill(Color.BLUE);
        scoreText.setTextAlignment(TextAlignment.CENTER);


        //First section under the flag with textfield and Button
        textField.setPrefWidth(525);
        HBox bottomBox = builder.returnHBox2(textField, submit, 10, Pos.CENTER);
        bottomBox.setPadding(new Insets(10,10,20,10));

        //Second section under the flag with questioncounter, score and button for next question
        questionCounter.setText(contentRefresher + 1 + "/" + questions.returnQuestionListSize());
        questionCounter.setFill(Color.BLUE);
        questionCounter.setFont(new Font("Areal", 35));
        questionCounter.setTextAlignment(TextAlignment.LEFT);
        updateScoreText();

        nextQuestion.setOpacity(0);
        HBox bottomBox2 = builder.returnHBox3(questionCounter, scoreText, nextQuestion, 140, Pos.CENTER);
        VBox mainBottomBox = builder.returnVBox2(bottomBox, bottomBox2, 10);


        BorderPane borderPane = new BorderPane();
        borderPane.setTop(textBox);
        borderPane.setCenter(imageView);
        borderPane.setBottom(mainBottomBox);

        //Actionevent for Next-Question button. Triggers returnEvent method
        nextQuestion.setOnAction(event -> {
           returnEvent();
           updateQuestionCounter();
           submit.setDisable(false);
           nextQuestion.setDefaultButton(false);
           submit.setDefaultButton(true);
        });

        //Actionevent for submit button. Checks if textfield is equals to answer
        submit.setOnAction(event -> {
            nextQuestion.setOpacity(1);
            submit.setDisable(true);
            submit.setDefaultButton(false);
            nextQuestion.setDefaultButton(true);

            if(textField.getText().toLowerCase().equals(questions.returnAnswer(contentRefresher))){
                score += 100;
                updateScoreText();
            }
        });

        primaryStage.setScene(new Scene(borderPane, 700, 600));
        primaryStage.show();

    }

    //Updates Score Text
    public void updateScoreText(){
        scoreText.setText("Score: " + score);
    }

    //Updates the Question Counter.
    public void updateQuestionCounter(){
        questionCounter.setText(contentRefresher + 1 + "/" + questions.returnQuestionListSize());
    }

    //Method when Next-Question button is pressed
    public void returnEvent(){

        contentRefresher++;

        imageView.setImage(images.returnImage(contentRefresher, 600, 400));
        question.setText(questions.returnQuestion(contentRefresher));
        nextQuestion.setOpacity(0);
        textField.clear();
    }
}
