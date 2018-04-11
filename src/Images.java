import javafx.scene.image.Image;

import java.util.ArrayList;

public class Images {
    /**
     * Returns an image from an ArrayList
     * @param imageId Specifies what piture ID you want
     * @param width Sets width of the Image
     * @param height Sets height of the Image
     * @return Image
     */
    public Image returnImage(int imageId, int width, int height){
        ArrayList<Image> imageList = new ArrayList<>();
        imageList.add(new Image("images/no.png"));
        imageList.add(new Image("images/ar.png"));
        imageList.add(new Image("images/br.png"));
        imageList.add(new Image("images/fi.png"));
        imageList.add(new Image("images/th.png"));
        imageList.add(new Image("images/tr.png"));
        imageList.add(new Image("images/us.png"));
        imageList.add(new Image("images/se.png"));
        imageList.add(new Image("images/jp.png"));
        imageList.add(new Image("images/ca.png"));

        return imageList.get(imageId);
    }
}
