package com.Launch;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.testng.annotations.Test;

public class NewTestM extends day7testngproject{
	
	public static String screenshotPath() throws IOException 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		String timeStamp = sdf.format(new Date());
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\screenShot\\ss"+timeStamp+".png");
		FileUtils.copyFile(src,dest);
		String path = dest.getAbsolutePath();
		return path;
	}

}
