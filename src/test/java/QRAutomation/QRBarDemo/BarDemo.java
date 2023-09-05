package QRAutomation.QRBarDemo;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarDemo 
{
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://barcode-labels.com/getting-started/barcodes/types/");
		
		String locationUrl = driver.findElement(By.xpath("//img[contains(@alt,'Code 39 Barcode')]")).getAttribute("src");
		
		URL url = new URL(locationUrl);
		
		BufferedImage imageio = ImageIO.read(url);
		
		LuminanceSource source = new BufferedImageLuminanceSource(imageio);
		
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		
		Result result = new MultiFormatReader().decode(bitmap);
		
		System.out.println(" Bar code reader info is :" + result.getText());
		
		driver.close();
	}
	
}
