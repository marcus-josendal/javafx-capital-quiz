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


    /**
     * Creates a borderpane with three nodes
     * @param node1 Will be set top
     * @param node2 Will be set center
     * @param node3 Will be set bottom
     * @return a borderpane with three nodes
     */
    public BorderPane returnBorderPane(Node node1, Node node2, Node node3){
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(node1);
        borderPane.setCenter(node2);
        borderPane.setBottom(node3);

        return borderPane;
    }

    /**
     * Creates an HBox with two nodes
     * @param node1 Will be set left in the HBox
     * @param node2 Will be set right in HBox
     * @param spacing Sets space between the nodes within the HBox
     * @param position Sets the position of the HBox
     * @return an HBox (Horizontal-Box)
     */
    public HBox returnHBox2(Node node1, Node node2, double spacing, Pos position){
        HBox hbox = new HBox();
        hbox.getChildren().add(node1);
        hbox.getChildren().add(node2);
        hbox.setSpacing(spacing);
        hbox.setAlignment(position);

        return hbox;
    }

    /**
     * Creates an HBox with three nodes
     * @param node1 Will be set left in the HBox
     * @param node2 Will be set center in the HBox
     * @param node3 Will be set right in the HBox
     * @param spacing Sets space between the nodes within the HBox
     * @param position Sets the position of the HBox
     * @return an HBox (Horizontal Box)
     */
    public HBox returnHBox3(Node node1, Node node2, Node node3, double spacing, Pos position){
        HBox hbox = new HBox();
        hbox.getChildren().add(node1);
        hbox.getChildren().add(node2);
        hbox.getChildren().add(node3);
        hbox.setSpacing(spacing);
        hbox.setAlignment(position);

        return hbox;
    }

    /**
     * Creates a VBox with two nodes
     * @param node1 Will be set top in the VBox
     * @param node2 Will be set under node1 in the VBox
     * @param spacing Sets space between the nodes within the VBox
     * @return a VBox (Vertical-Box)
     */
    public VBox returnVBox2(Node node1, Node node2, double spacing){
        VBox vbox = new VBox();
        vbox.getChildren().add(node1);
        vbox.getChildren().add(node2);
        vbox.setSpacing(spacing);

        return vbox;
    }

    /**
     * Creates a VBox with two nodes
     * @param node1 Will be set top in the VBox
     * @param node2 Will be set middle in the VBox
     * @param node3 Will be set under middle node in the VBox
     * @param spacing Sets space between the nodes within the VBox
     * @return a VBox (Vertical-Box)
     */
    public VBox returnVBox3(Node node1, Node node2, Node node3, double spacing){
        VBox vbox = new VBox();
        vbox.getChildren().add(node1);
        vbox.getChildren().add(node2);
        vbox.getChildren().add(node3);
        vbox.setSpacing(spacing);

        return vbox;
    }

    /**
     * Returns custom text
     * @param content What the text will show
     * @param font What font the text will have
     * @param fontsize The size of the text
     * @param color The color of the text
     * @param textposition Position of the text
     * @return returns a Text-Object
     */
    public Text returnStaticText(String content, String font, int fontsize, Color color, TextAlignment textposition){
        Text text = new Text(content);
        text.setFont(new Font(font, fontsize));
        text.setFill(color);
        text.setTextAlignment(textposition);

        return text;
    }
}
