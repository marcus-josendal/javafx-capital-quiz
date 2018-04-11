import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Builder {

    //Returns a borderpane. Put in four different nodes in the different positions.
    public BorderPane returnBorderPane(Node node1, Node node2, Node node3){
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(node1);
        borderPane.setCenter(node2);
        borderPane.setBottom(node3);

        return borderPane;
    }

    //Returns a Hbox with two nodes. Put in two nodes, spacing and position.
    public HBox returnHBox2(Node node1, Node node2, double spacing, Pos position){
        HBox hbox = new HBox();
        hbox.getChildren().add(node1);
        hbox.getChildren().add(node2);
        hbox.setSpacing(spacing);
        hbox.setAlignment(position);

        return hbox;
    }

    //Returns a Hbox with three nodes. Put in three nodes, spacing and position.
    public HBox returnHBox3(Node node1, Node node2, Node node3, double spacing, Pos position){
        HBox hbox = new HBox();
        hbox.getChildren().add(node1);
        hbox.getChildren().add(node2);
        hbox.getChildren().add(node3);
        hbox.setSpacing(spacing);
        hbox.setAlignment(position);

        return hbox;
    }

    //Returns a VBox with two nodes. Put in two nodes and specify the spacing between the nodes.
    public VBox returnVBox2(Node node1, Node node2, double spacing){
        VBox vbox = new VBox();
        vbox.getChildren().add(node1);
        vbox.getChildren().add(node2);
        vbox.setSpacing(spacing);

        return vbox;
    }
    //Returns a VBox with three nodes. Put in three nodes and specify the spacing between the nodes.
    public VBox returnVBox3(Node node1, Node node2, Node node3, double spacing){
        VBox vbox = new VBox();
        vbox.getChildren().add(node1);
        vbox.getChildren().add(node2);
        vbox.getChildren().add(node3);
        vbox.setSpacing(spacing);

        return vbox;
    }

    //Returns Text. Specify String, font, fonsize, color and text-alignment
    public Text returnStaticText(String content, String font, int fontsize, Color color, TextAlignment textposition){
        Text text = new Text(content);
        text.setFont(new Font(font, fontsize));
        text.setFill(color);
        text.setTextAlignment(textposition);

        return text;
    }
}
