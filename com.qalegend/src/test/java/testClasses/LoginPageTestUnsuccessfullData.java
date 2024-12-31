package testClasses;

import org.testng.annotations.Test;

import utilityClasses.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class LoginPageTestUnsuccessfullData {
  

  @DataProvider(name = "UnsuccessfullLogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] {ExcelReadClass.getStringdata(1, 0),ExcelReadClass.getStringdata(1, 1)},
      new Object[] {ExcelReadClass.getStringdata(2, 0),ExcelReadClass.getIntegerdata(2, 1)},
      new Object[] {ExcelReadClass.getStringdata(3, 0),ExcelReadClass.getStringdata(3, 1)}
    };
  }
}
