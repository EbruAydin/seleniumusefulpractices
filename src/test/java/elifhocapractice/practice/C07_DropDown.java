package elifhocapractice.practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseClass;
import utilities.TestCase;

import java.time.Duration;
import java.util.List;

public class C07_DropDown extends TestBaseClass {

    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find  all Dropdown Elements on page
    //-->Task3 printout DropDown Elements' number
    //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        //-->Task1 Find Dropdown on Multi Selection
        //-->Task2 Find  all Dropdown Elements on page

        List<WebElement> dropDownElements = driver.findElements(By.xpath("//h3"));
        //1.lambda ile
        dropDownElements.stream().forEach(t -> System.out.println("all dropdown elements : " + t.getText()));
        //2.yontem
        for (WebElement each : dropDownElements) {
            System.out.println("all dropdown elements : " + each.getText());
        }

        //-->Task3 printout DropDown Elements' number

        System.out.println("number all dropdown elements : " + dropDownElements.size());


        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
        Actions action = new Actions(driver);
        List<WebElement> dropDownElementsButton = driver.findElements(By.xpath("//div[@class='comboTreeWrapper']"));
        //List<WebElement> dropdownSection = driver.findElements(By.xpath("//*[@class='comboTreeItemTitle']"));
        List<WebElement> dropdownSection = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
        //List<WebElement> dropdownSection = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(dropdownSection.size());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        for (int i = 0; i < dropdownSection.size(); i++) {

            //if (dropDownElements.get(0).isDisplayed()) {
            action.click(dropDownElementsButton.get(0)).perform();
            System.out.println(dropDownElements.get(0).getText());
            do {
                dropdownSection.get(i).click();
                System.out.println(dropdownSection.get(i).getText());
                i++;
            } while (!dropdownSection.get(i).getText().equals("choice 6"));
            System.out.println(i);//8'e denk geliyor
            //}


            // if (dropDownElements.get(1).isDisplayed()) {
            action.click(dropDownElementsButton.get(1)).perform();
            System.out.println(dropDownElements.get(1).getText());

            do {
                //WebElement tr1= wait.until(ExpectedConditions.elementToBeClickable(dropdownSection.get(i+7)));
                //tr1.click();
                //dropdownSection.get(i+7).click();
                jse.executeScript("arguments[0].scrollIntoView(true);", dropdownSection.get(i));
                jse.executeScript("arguments[0].click();", dropdownSection.get(i));
                System.out.println(dropdownSection.get(i).getText());
                i++;
            } while (!dropdownSection.get(i).getText().equals("choice 6"));
            // }

            action.click(dropDownElementsButton.get(2)).perform();
            System.out.println(dropDownElements.get(2).getText());

            do {
                dropdownSection.get(i).click();
                jse.executeScript("arguments[0].scrollIntoView(true);", dropdownSection.get(i));
                jse.executeScript("arguments[0].click();", dropdownSection.get(i));
                System.out.println(dropdownSection.get(i).getText());
                i++;
            } while (!dropdownSection.get(i).getText().equals("choice 6"));
        }
    }
}



