package utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class Utilitis {
	
	public static String getNewMailID() {
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@Email.com";

	}
	
	public static boolean compareTwoScreenshot(String actualimagePath, String expectedImagepath) throws IOException {
		BufferedImage actualImage = ImageIO.read(new File(actualimagePath));
		BufferedImage expectedImage = ImageIO.read(new File(expectedImagepath));
		
		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		return diff.hasDiff();
		
	}

}
