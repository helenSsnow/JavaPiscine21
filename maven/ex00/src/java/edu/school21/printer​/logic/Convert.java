package edu.school21.printer​.logic;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Convert {
    BufferedImage image;
    char[][] arr;
    char white;
    char black;

    public Convert(BufferedImage image, char white, char black) {
        this.image =image;
        this.black =black;
        this.white = white;
        arr = new char[image.getHeight()][ image.getWidth()];
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
    }

    public void ConvertImage() {

        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb);

                int newRgb =(int) (color.getRed() * 0.299 + color.getGreen()  * 0.587 + color.getBlue() * 0.114);
                if(newRgb == 255) {
                    arr[y][x] = white;
                }
                else if(newRgb == 0) {
                    arr[y][x] = black;
                }
            }
        }
    }

    public void PrintImage() {
        for (int i = 0; i < arr.length; i++){

            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);
            }

            System.out.println();
        }
    }
}
