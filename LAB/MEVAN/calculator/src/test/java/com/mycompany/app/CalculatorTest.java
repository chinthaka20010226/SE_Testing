package com.mycompany.app;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;

public class CalculatorTest {
    Calculator c1=new Calculator();

    @BeforeClass
    public void beforeClass(){
        System.out.println("CalculatorTest class is about to test...");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("CalculatorTest class executed...");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Test is about to test....");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Test is executed...");
    }

    @Test(groups = "BasicOperations",priority = 2)  //annotation
    public void testAddition(){
        Assert.assertEquals(c1.calAddition(3, 2), 5);
    }

    @Test(groups = "BasicOperations", priority = 1, dependsOnMethods = {"testAddition"})
    public void testSubtraction(){
        Assert.assertEquals(c1.calSubtraction(11, 3), 8);
    }

    @Test(groups = "AdvanceOperations", dependsOnGroups = {"BasicOperations"})
    public void testMultiplication(){
        Assert.assertEquals(c1.calMultiplication(2, 3), 6);
    }

    @Test(groups = "AdvanceOperations")
    public void testDivision(){
        Assert.assertEquals(c1.calDivision(55, 5), 11.0);
    }

    @Test(groups = "AdvanceOperations")
    public void testModulus(){
        Assert.assertEquals(c1.calModulus(9, 2), 1);
    }

    @DataProvider(name = "dataForAddition")
    public Object[][] dataForAddition(){
        return new Object[][]{
            {1,2,3},
            {5,5,10},
            {0,11,11}
        };
    }

    @Test(dataProvider = "dataForAddition")
    public void testAdditionWithDataProvider(int a, int b, int expectedResult){
        Assert.assertEquals(c1.calAddition(a, b), expectedResult);
    }
}
