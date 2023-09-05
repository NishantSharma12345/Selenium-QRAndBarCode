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

public class QRDemo 
{
	public static void main(String args[]) throws Exception
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://qrcode.meetheed.com/qrcode_examples.php");
		
		String locationUrl = driver.findElement(By.xpath("//img[@alt='QR Contact Example']")).getAttribute("src");
		
		URL url = new URL(locationUrl);
		
		BufferedImage imageio = ImageIO.read(url);
		
		LuminanceSource source = new BufferedImageLuminanceSource(imageio);
		
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		
		Result result = new MultiFormatReader().decode(bitmap);
		
		System.out.println(" QR code reader info is :" + result.getText());
		
		driver.close();
	}
	
}
