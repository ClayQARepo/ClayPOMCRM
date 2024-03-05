package com.crm.clay.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
    public static LocalDateTime currentDate = LocalDateTime.now();
	

	//public static String browserName;
	
	public TestBase() {
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\src\\main\\java"
					+ "\\com\\crm\\clay\\config\\config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

    public static void initialization() {
    	 String browserName=prop.getProperty("browser");
    	// Generate current date
     
		
    	if(browserName.equals("chrome")) {
    		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\Drivers\\chrome.exe");
    		//WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
    		System.out.println("Chrome is launched");
    		
    	}else if(browserName.equals("firefox")) {
    		System.setProperty("webdriver.gecko.driver", "C:\\Users\\maira\\eclipse-workspace\\CRM_CLAY_POM\\Drivers\\geckodriver.exe");
    		//WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    		System.out.println("firefox is launched");
    	}else if(browserName.equals("edge")) {
    		//WebDriverManager.edgedriver().setup();
    		driver=new EdgeDriver();
    		System.out.println("Edge is launched");
    	}
    
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	}
	}
	
	
