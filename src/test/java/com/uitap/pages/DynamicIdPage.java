package com.uitap.pages;

public class DynamicIdPage extends BasePage {
    private String buttonDynamicIdXpath = "//button[@class='btn btn-primary']";


    public DynamicIdPage(){
        super();
    }

    public void navigateToDynamicIdExample(){
        navigateTo("http://www.uitestingplayground.com/dynamicid");
    }

    public String getButtonText()
    {
        return TextFromElement(buttonDynamicIdXpath);
    }
}
