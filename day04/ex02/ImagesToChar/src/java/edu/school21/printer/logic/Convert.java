package edu.school21.printer.logic;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Convert {
    BufferedImage image;
    char[][] arr;
    String white;
    String black;

    public Convert(BufferedImage image, String white, String black) {
        this.image =image;
        this.black =black;
        this.white = white;
        arr = new char[image.getHeight()][ image.getWidth()];
    }
    

    public void ConvertImage() {
        HashMap<String, Integer> colors = new HashMap<>();
		colors.put("BLACK", 0);
		colors.put("RED", 1);
		colors.put("GREEN", 2);
		colors.put("YELLOW", 3);
		colors.put("BLUE", 4);
		colors.put("MAGENTA", 5);
		colors.put("CYAN", 6);
		colors.put("WHITE", 7);

        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb);

                int newRgb =(int) (color.getRed() * 0.299 + color.getGreen()  * 0.587 + color.getBlue() * 0.114);
                if(newRgb == 255) {
                    System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(colors.get(black))));
                }
                else if(newRgb == 0) {
                    System.out.print(Ansi.colorize(" ", Attribute.BACK_COLOR(colors.get(white))));
                }

            }
            System.out.println();
        }
    }
}