package fes.aragon.modelo;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class SerializableImage {
    private int width, height;
    private int[][] pixels;

    public SerializableImage(){}

    public void setImage(Image image){
        width = ((int) image.getWidth());
        height = ((int) image.getHeight());
        pixels = new int[width][height];
        PixelReader r = image.getPixelReader();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                pixels[i][j] = r.getArgb(i,j);
    }
    public Image getImage() {
        WritableImage image = new WritableImage(width, height);

        PixelWriter w = image.getPixelWriter();
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                w.setArgb(i, j, pixels[i][j]);

        return image;
    }
}
