import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Gui extends Application {

    //Instances
    private Questions questions = new Questions();
    private Builder builder = new Builder();
    private Images images = new Images();
    private OtherStages otherStages = new OtherStages();

    //Text and textfield
    private Text scoreText = new Text();
    private Text question = new Text();
    private Text questionCounter = new Text();
    private String name;
    private TextField textField = new TextField();
    private TextField nameField = new TextField();


    //Buttons
    private Button nextQuestion = new Button("Neste spørsmål");
    private Button submit = new Button("Submit");
    private Button submitName = new Button("Submit");

    //Score and contentrefresher
    private int contentRefresher = 0;
    private int score = 0;

    //Flag-image
    private ImageView imageView = new ImageView();


    public void start(Stage primaryStage) {


        //Put question-text in VBox so it's possible to align.
        VBox textBox = new VBox();
        question.setText(questions.returnQuestion(0));
        textBox.setPadding(new Insets(10,10,20,10));
        textBox.getChildren().addAll(question);
        textBox.setAlignment(Pos.CENTER);

        //Sets image
        imageView.setImage(images.returnImage(0, 600, 400));
        imageView.setFitHeight(400);
        imageView.setFitWidth(600);

        //Sets button to default so you can click enter.
        nextQuestion.setDefaultButton(false);
        submit.setDefaultButton(false);
        submitName.setDefaultButton(true);

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

        //HBox for questioncounter, scoretext and Next Question text
        HBox bottomBox2 = builder.returnHBox3(questionCounter, scoreText, nextQuestion, 140, Pos.CENTER);

        //VBox for the two HBoxes that will be set under the flag
        VBox mainBottomBox = builder.returnVBox2(bottomBox, bottomBox2, 10);

        //Setting the different nodes to the borderpane.
        BorderPane borderPane = builder.returnBorderPane(textBox, imageView, mainBottomBox);

        //Actionevent for Next-Question button. Triggers returnEvent and updateQuestionCounter methods. Enables/Disables buttons
        nextQuestion.setOnAction(event -> {

            if(contentRefresher == questions.returnQuestionListSize()-1) {
                primaryStage.setScene(otherStages.returnFinishStage());
                return;
            }

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

            if(textField.getText().toLowerCase().equals(questions.returnAnswer(contentRefresher))) {
                score += 100;
                updateScoreText();
            }
        });

        submitName.setOnAction(event -> {
            submitName.setDefaultButton(false);
            submit.setDefaultButton(true);
            name = nameField.getText();
            System.out.println(name);
            primaryStage.setScene(new Scene(borderPane, 700, 600));
        });

        primaryStage.setScene(otherStages.returnStartScene());
        primaryStage.show();
    }

    //Updates Score Text
    private void updateScoreText(){
        scoreText.setText("Score: " + score);
    }

    //Updates the Question Counter.
    private void updateQuestionCounter(){
        questionCounter.setText(contentRefresher + 1 + "/" + questions.returnQuestionListSize());
    }

    //Method when Next-Question button is pressed. Gets next image, question and clears textfield.
    private void returnEvent(){

        contentRefresher++;

        imageView.setImage(images.returnImage(contentRefresher, 600, 400));
        question.setText(questions.returnQuestion(contentRefresher));
        nextQuestion.setOpacity(0);
        textField.clear();
    }

    //Inner class for start-scene
    class OtherStages {

        public Scene returnStartScene(){

            //Content for start scene
            HBox nameBox = builder.returnHBox2(nameField, submitName, 10, Pos.CENTER);

            //Text
            Text firstLine = builder.returnStaticText("Velkommen til denne hovedstad-quizen. Bruk norske navn for hovedstedene.",
                    "Arial", 20, Color.BLUE, TextAlignment.CENTER);
            Text secondLine = builder.returnStaticText("Skriv inn navnet ditt under:",
                    "Arial", 25, Color.BLUE, TextAlignment.CENTER);

            //Creates VBox for HBox with Textfield and button and aligns it center
            VBox topBox = builder.returnVBox3(firstLine, secondLine, nameBox, 30);
            topBox.setAlignment(Pos.CENTER);

            //Creates Borderpane and sets content
            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(topBox);

            //Sets scene and returns the scene
            Scene scene = new Scene(borderPane, 800, 600);
            return scene;
        }


        public Scene returnFinishStage(){

            //Content for the finish scene
            Text firstLine = builder.returnStaticText("Takk for at du spilte" + name + "!",
                    "Arial", 40, Color.BLUE, TextAlignment.CENTER);
            Text secondLine = builder.returnStaticText("Din score ble: " + score + ".",
                    "Arial", 40, Color.BLUE, TextAlignment.CENTER);
            VBox finishMessageBox = builder.returnVBox2(firstLine, secondLine, 10);
            finishMessageBox.setAlignment(Pos.CENTER);

            //Creates Borderpane and sets content
            BorderPane borderpane = new BorderPane();
            borderpane.setCenter(finishMessageBox);

            //Sets the scene and returns it
            Scene scene = new Scene(borderpane, 800, 600);
            return scene;
        }

    }
}
