package com.uitap.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.uitap.pages.DynamicIdPage;

public class DynamicIdTest {
    


    @Test
    public void validateDynamicElement()
    {
        String expectedButtonText = "Button with Dynamic ID";
        DynamicIdPage dp = new DynamicIdPage();
        dp.navigateToDynamicIdExample();
        String actualButtonText = dp.getButtonText();
        Assert.assertEquals(actualButtonText, expectedButtonText);
    }
}
