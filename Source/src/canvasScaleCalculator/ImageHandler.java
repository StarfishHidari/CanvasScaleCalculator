package canvasScaleCalculator;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageHandler {
	
	private final String[] okFileExtensions = new String[] {"jpg", "png", "gif"};
	URL imageURL = null;
	
	private void getURL (String str) {
		
		try {
			
			for (int i = 0; i < okFileExtensions.length; i++) {
				if (str.endsWith(okFileExtensions[i])) {
				imageURL = new URL(str);
				}
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
		
		
	public BufferedImage openImage (String str) throws IOException {
		
		getURL(str);
		if (imageURL != null) {
			BufferedImage image = ImageIO.read(imageURL);
			return image;
		} else {
			return null;
		}
		
	}	
}
