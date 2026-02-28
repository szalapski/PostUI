
package com.eviware.soapui.tools;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplashScreenStomper {
    public static void main(String arg[]) throws IOException {
        String version = arg[0];
        String inputFilePath = arg[1];
        String outputFilePath = arg[2];
        String inputHighResolutionFilePath = arg[3];
        String outputHighResolutionFilePath = arg[4];

        String fullText = String.format("%s\n\nCopyright Szalapski Software\n\nwww.soapui.org\nszalapski.com", version);
        BufferedImage lowResolutionImage = ImageIO.read(new File(inputFilePath));
        BufferedImage highResolutionImage = ImageIO.read(new File(inputHighResolutionFilePath));

        Graphics2D[] imageGraphics = {lowResolutionImage.createGraphics(), highResolutionImage.createGraphics()};
        Font font = new Font("Arial", Font.PLAIN, 12);
        Font bigSizeFont = new Font("Arial", Font.PLAIN, 20);

        for (Graphics2D graphics : imageGraphics) {
            graphics.setColor(new Color(0x66, 0x66, 0x66));
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }
        imageGraphics[0].setFont(font);
        imageGraphics[1].setFont(bigSizeFont);

        int y = 181;
        for (String text : fullText.split("\n")) {
            imageGraphics[0].drawString(text, 42, y);
            y += 15;
        }

        y = 362;
        for (String text : fullText.split("\n")) {
            imageGraphics[1].drawString(text, 84, y);
            y += 30;
        }
        ImageIO.write(lowResolutionImage, "png", new File(outputFilePath));
        ImageIO.write(highResolutionImage, "png", new File(outputHighResolutionFilePath));
    }
}
