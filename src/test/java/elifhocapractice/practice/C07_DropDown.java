package elifhocapractice.practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

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

        List<WebElement> dropDownElements = driver.findElements(By.xpath("//h3"));//dropdown baslik listesi
        //-->Task1 Find Dropdown on Multi Selection
        System.out.println("==========TASK1==========");
        System.out.println(dropDownElements.get(0).getText());
        //-->Task2 Find  all Dropdown Elements on page

        System.out.println("==========TASK2==========");
        //1.lambda ile
        dropDownElements.stream().forEach(t -> System.out.println("all dropdown elements : " + t.getText()));
        //2.yontem
        for (WebElement each : dropDownElements) {
            System.out.println("all dropdown elements : " + each.getText());
        }

        //-->Task3 printout DropDown Elements' number
        System.out.println("============TASK3=========");
        System.out.println("number all dropdown elements : " + dropDownElements.size());

        //-->Task4 choose dropdown elements and printout dropdown elements' name  until choise 6
        System.out.println("=============TASK4=========");
        List<WebElement> dropDownElementsButton = driver.findElements(By.xpath("//div[@class='comboTreeWrapper']"));
        List<WebElement> dropdownSection = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));

        dropDownElementsButton.get(0).click();
        System.out.println(dropDownElements.get(0).getText());
        for (int i = 0; i < 8; i++) {
            checkbox.get(i).click();
            System.out.println(dropdownSection.get(i).getText());
        }


        System.out.println("=============================");

        dropDownElementsButton.get(1).click();
        System.out.println(dropDownElements.get(1).getText());
        for (int i = 15; i < 23; i++) {
            checkbox.get(i).click();
            System.out.println(dropdownSection.get(i).getText());
        }

        System.out.println("=============================");

        dropDownElementsButton.get(2).click();
        System.out.println(dropDownElements.get(2).getText());
        List<WebElement> liste2 = driver.findElements(By.xpath("((//div[@class='comboTreeDropDownContainer'])[3]//ul)[1]//li"));

        for (int i = 0; i < 8; i++) {
            jse.executeScript("arguments[0].scrollIntoView(true);", liste2.get(i));
            jse.executeScript("arguments[0].click();", liste2.get(i));
            System.out.println(liste2.get(i).getText());
        }
    }
}

//diger cozum yolu
/*List<WebElement> liste = driver.findElements(By.xpath("((//div[@class='comboTreeDropDownContainer'])[1]//ul)[1]//li"));

        for (int i = 0; i < 8; i++) {
            liste.get(i).click();
            System.out.println(liste.get(i).getText());
        }


        /*
        for (WebElement each:liste) {
                each.click();
                System.out.println(each.getText());
        }



        System.out.println("=============================");
                dropDownElementsButton.get(1).click();
                System.out.println(dropDownElements.get(1).getText());
                List<WebElement> liste1 = driver.findElements(By.xpath("((//div[@class='comboTreeDropDownContainer'])[2]//ul)[1]//li"));

        for (int i = 0; i < 8; i++) {
        jse.executeScript("arguments[0].click();", liste1.get(i));
        System.out.println(liste1.get(i).getText());
        }

        System.out.println("=============================");
        dropDownElementsButton.get(2).click();
        System.out.println(dropDownElements.get(2).getText());
        List<WebElement> liste2 = driver.findElements(By.xpath("((//div[@class='comboTreeDropDownContainer'])[3]//ul)[1]//li"));

        for (int i = 0; i < 8; i++) {
        jse.executeScript("arguments[0].scrollIntoView(true);", liste2.get(i));
        jse.executeScript("arguments[0].click();", liste2.get(i));
        System.out.println(liste2.get(i).getText());
        }

 */





