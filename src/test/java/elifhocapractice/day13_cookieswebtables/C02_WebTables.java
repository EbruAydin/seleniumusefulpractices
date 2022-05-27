package elifhocapractice.day13_cookieswebtables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseClass;

import java.util.List;

public class C02_WebTables extends TestBaseClass {
    //● login( ) metodun oluşturun ve oturum açın.
    //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //          ○ Username : manager
    //          ○ Password : Manager1!
    //● table( ) metodu oluşturun
    //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //          ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    // Tum body'i bir String olarak yazdirmak isterseniz
    // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
    //● printRows( ) metodu oluşturun //tr
    //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
    //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
    // once email basliginin kacinci sutunda oldugunu bulalim

    @Test
    public void test() {

        login();
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> head = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Tum table sutun sayisi : " + head.size());

        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        System.out.println("======Table'daki tum datalar=====");
        System.out.println("=======Table Basligi===========");

        for (WebElement each : head) {
            System.out.println(each.getText());
        }

        List<WebElement> tableBody = driver.findElements(By.xpath("//table//tbody//tr"));

        for (WebElement each : tableBody) {
            System.out.println(each.getText());
        }

        /*

        2.yol
         Tum body'i bir String olarak yazdirmak isterseniz
        body webElementini locate edip, getText() method'u ile yazdirabilirsiniz

        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
         */




        //● printRows( ) metodu oluşturun //tr
        //          ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> rowNumber = driver.findElements(By.xpath("//table//tbody//tr"));
        System.out.println("=====Toplam row sayisi====");
        System.out.println(rowNumber.size());

        //          ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("=====Tbody'deki rowlar====");
        for (WebElement each : rowNumber) {
            System.out.println(each.getText());
        }
        //          ○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dorduncuRowdakiElementler = driver.findElements(By.xpath("//table//tbody//tr[4]"));
        System.out.println("=======4.satirdaki(row) elementleri======");
        for (WebElement each : dorduncuRowdakiElementler) {
            System.out.println(each.getText());
        }

        //          Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim

        System.out.println("=======Email icerisindeki tum elementler===========");
        List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo=0;
        for (int i = 0; i < basliklarListesi.size() ; i++) {
            if (basliklarListesi.get(i).getText().equals("Email")){
                emailSutunNo=i;
            }
        }
        List<WebElement> emailSutunListesi=
                driver.findElements(By.xpath("//tbody//td["+(emailSutunNo+1)+"]"));
        for (WebElement each: emailSutunListesi) {
            System.out.println(each.getText());
        }

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("(//a[@class='nav-link'])[7]")).click();

        Actions action = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        action.
                click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }

}
