package com.epam.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.pages.HomePage;
import com.epam.pages.LoginPage;
import com.epam.pages.NewCustomerPage;
import com.epam.utilities.CommonUtil;
import com.epam.utilities.XLUtils;

public class CreateNewCustomer_002 extends BaseClass {
	
	NewCustomerPage customerPage;
	HomePage homePage;
	boolean isLogin =  false;
	
	String userName = configReader.getProperty("userName");
	String password = configReader.getProperty("password");
	String baseUrl = configReader.getProperty("baseUrl");
	
	@Test(dataProvider = "CustomerData")
	//public void registerNewCustomer(String cusromerName,String gender,String month,String date,String year,String address,String city,String state,String pin,String mobile,String email,String customerPassword ) throws InterruptedException{
	//public void registerNewCustomer(String[] row) throws InterruptedException{
	public void registerNewCustomer(Map<String,String> row) throws InterruptedException{
		
		log.info("CreateNewCustomer_002 - Started");
		if (isLogin == false){
			driver.get(baseUrl);
			LoginPage loginPage = new LoginPage(driver);
			homePage = loginPage.enterLoginCredentials(userName, password);
			customerPage = homePage.getNewCustomerPage();
			isLogin = true;
		}
		/*customerPage.enterCustomerName(cusromerName);
		customerPage.selectGender(gender);
		customerPage.enterdateOfBirth(month,date,year);
		customerPage.enterAddress(address);
		customerPage.enterCity(city);
		customerPage.enterState(state);
		customerPage.enterPin(pin);
		customerPage.enterMobile(mobile);
		customerPage.enterEmail(email);
		customerPage.enterPassword(customerPassword);
		customerPage.clickOnSubmitButton();*/
		
		/*customerPage.enterCustomerName(row[1]);
		customerPage.selectGender(row[2]);
		customerPage.enterdateOfBirth(row[3],row[5],row[5]);
		customerPage.enterAddress(row[6]);
		customerPage.enterCity(row[7]);
		customerPage.enterState(row[8]);
		customerPage.enterPin(row[9]);
		customerPage.enterMobile(row[10]);
		customerPage.enterEmail(row[11]);
		customerPage.enterPassword(row[12]);
		customerPage.clickOnSubmitButton();*/
		
		customerPage.enterCustomerName(row.get("cusromerName"));
		customerPage.selectGender(row.get("gender"));
		customerPage.enterdateOfBirth(row.get("month"),row.get("date"),row.get("year"));
		customerPage.enterAddress(row.get("address"));
		customerPage.enterCity(row.get("city"));
		customerPage.enterState(row.get("state"));
		customerPage.enterPin(row.get("pin"));
		customerPage.enterMobile(row.get("mobile"));
		customerPage.enterEmail(row.get("email"));
		customerPage.enterPassword(row.get("customerPassword"));
		customerPage.clickOnSubmitButton();
		
		
		if (customerPage.isNewCustomerRegisted()){
			Assert.assertTrue(true);
			//log.info("User Registration is successful with "+ cusromerName);
			//log.info("User Registration is successful with "+ row[1]);
			log.info("User Registration is successful with "+ row.get("cusromerName"));
			//customerPage = homePage.getNewCustomerPage();			
			
		}else{
			//takeScreenshot("registerNewCustomer");
			CommonUtil.takeScreenshot(driver, "registerNewCustomer");
			//log.info("User Registration is failed for "+ cusromerName);
			//log.info("User Registration is failed for "+ row[1]);
			log.info("User Registration is failed for "+ row.get("cusromerName"));
			System.out.println("fail");
			Assert.assertTrue(false);
			customerPage = homePage.getNewCustomerPage();			
			
		}
		
		log.info("CreateNewCustomer_002 - Ended");
		
		
	}
	
	@DataProvider(name="CustomerData")
	public Object[][] getCustomerData() throws IOException{
			
		String filePath= "./src/test/resources/CustomerData.xlsx";
		String sheetName = "Sheet1";

		int rowCount = XLUtils.getRowCount(filePath, sheetName);
		int CellCount = XLUtils.getCellCount(filePath, sheetName, 1);
		System.out.println("rowCount: " + rowCount);
		System.out.println("CellCount: " + CellCount);
		
		//Object[][] rowData =  new Object[rowCount-1][CellCount];
		Object[][] rowData =  new Object[rowCount-1][1];
		String[] columns = new String[]{"cusromerName","gender","month","date","year","address","city","state","pin","mobile","email","customerPassword"};
		for (int i=0;i<rowCount-1;i++){
			List<String> row = new ArrayList<String>();
			Map<String,String> map = new HashMap<String,String>();
			
			for (int j=0;j<CellCount;j++){				
				//data[i][j] = XLUtils.getCellData(filePath, sheetName, i+1, j);
				//row.add(XLUtils.getCellData(filePath, sheetName, i+1, j));
				map.put(columns[j], XLUtils.getCellData(filePath, sheetName, i+1, j));							
			}
			//rowData[i]=row.toArray();
			rowData[i][0]=map;
			
		}
		return rowData;
	}

}
