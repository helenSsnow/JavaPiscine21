package edu.school21.printer.app;


import edu.school21.printer.logic.Convert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import com.beust.jcommander.*;
import com.beust.jcommander.Parameter;
import java.io.File;
import java.io.IOException;

public class Program {


    @Parameters(separators = "=")
	public static class Arguments {
		@Parameter(names = "--white", required = true)
		public static String white;

		@Parameter(names = "--black", required = true)
		public static String black;
	  }

    public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.err.println("Two arguments required, e.g. --white=GREEN --black=BLUE");
			return;
		}

		Arguments params = new Arguments();
		JCommander.newBuilder().addObject(params).build().parse(args);	
       BufferedImage image = ImageIO.read(new File("./src/resources/image.bmp"));
        if(image == null){
             System.err.println("File can not be read");
            return;
        }
        Convert convert = new Convert(image, params.white, params.black);
        convert.ConvertImage();
    }
}


