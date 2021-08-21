package edu.school21.printer.app;

import edu.school21.printer​.logic.Convert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        char black;
        char white;
        String path;

        black = args[0].toCharArray()[0];
        white = args[1].toCharArray()[1];
        path = args[2];
        path = path.replace('\\', '/');
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        if(image == null)
            throw new IOException("image was not be creat");
        Convert convert = new Convert(image, white, black);
        convert.ConvertImage();
        convert.PrintImage();
    }
}



