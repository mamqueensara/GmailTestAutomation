package com.selenium.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.time.Duration;

public class GmailLoginExcel {

	    public static void main(String[] args) throws Exception {

	        String filePath = "src/test/resources/testdata.xlsx";
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet("LoginData");

	        int rowCount = sheet.getPhysicalNumberOfRows();

	        for (int i = 1; i < rowCount; i++) {

	            Row row = sheet.getRow(i);

	            String email = row.getCell(0) == null ? "" : row.getCell(0).toString();
	            String password = row.getCell(1) == null ? "" : row.getCell(1).toString();

	            WebDriver driver = new ChromeDriver();
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            driver.get("https://accounts.google.com/");

	            try {

	                // TC_01 – Verify page load
	                if (driver.getTitle().contains("Google")) {
	                    System.out.println("TC_01 Passed - Page Loaded");
	                }

	                // Enter Email
	                WebElement emailField = wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
	                emailField.sendKeys(email);

	                driver.findElement(By.id("identifierNext")).click();

	                // Handle Blank Email
	                if (email.isEmpty()) {
	                    wait.until(ExpectedConditions.visibilityOfElementLocated(
	                            By.xpath("//div[@class='o6cuMc']")));
	                    System.out.println("TC_05 Executed - Blank Email");
	                }

	                // If email entered, wait for password field
	                if (!email.isEmpty()) {

	                    WebElement passwordField = wait.until(
	                            ExpectedConditions.visibilityOfElementLocated(By.name("password")));

	                    passwordField.sendKeys(password);

	                    driver.findElement(By.id("passwordNext")).click();

	                    if (password.isEmpty()) {
	                        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                                By.xpath("//div[@class='o6cuMc']")));
	                        System.out.println("TC_06 Executed - Blank Password");
	                    } else {
	                        System.out.println("TC_04 Executed - Invalid Password");
	                    }
	                }

	            } catch (Exception e) {
	                System.out.println("Test execution error for: " + email);
	            }

	            driver.quit();
	            System.out.println("----------------------------------");
	        }

	        workbook.close();
	        fis.close();
	    }
}

