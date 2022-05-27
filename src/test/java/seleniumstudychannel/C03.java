package seleniumstudychannel;

import io.netty.handler.codec.http.cookie.Cookie;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseClass;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

public class C03 extends TestBaseClass {
    //1. https://www.n11.com/ adresine gidilerek headerdan “Mağazalar/Mağazaları Gör”
    //seçilir.
    //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
    //txt dosyasına yazdırılır.

    @Test
    public void test() throws IOException {
        driver.get("https://www.n11.com/");

        //“Mağazalar/Mağazaları Gör” seciniz.
        driver.findElement(By.xpath("(//*[text()='Daha Sonra'])[1]")).click();
        driver.findElement(By.xpath("//li[@class='hBotMenuItem hTMItem hasMenu']")).click();
        driver.findElement(By.xpath("//li[@class='hBotMenuItem hTMItem hasMenu']//div//a[1]")).click();

        //2. Tüm Mağazalar butonuna tıklanır. A harfindeki tüm mağazalar bir excel, csv veya
        //txt dosyasına yazdırılır.
        driver.findElement(By.xpath("(//h3)[7]")).click();

        String dosyaYolu = "src/resources/magazalar.txt";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        WebElement aMagazalar = driver.findElement(By.xpath("(//ul)[24]")); //magazlarin oldugu bolge secildi

        String aMagazalarListesi = aMagazalar.getText(); //secilen magazalar string'e atandi

        System.out.println(aMagazalarListesi); // yazdirdigini gormek icin denedim

        File file = new File("src/resources/magazalar2.txt"); //magazalar2 isminde bir txt dosyasi olusturur

        FileUtils.writeStringToFile(file, aMagazalarListesi, Charset.defaultCharset());
        //FileUtils.writeStringToFile(file name, yazilarin oldugu string ifade, Charset.defaultCharset());
        //defaultCharset()= which returns the charset object for the default charset.
    }




        /*
        List<WebElement> aHarfliMagazalarList = driver.findElements(By.xpath("//div[@class='tabPanel allSellers']//div[2]/ul/li"));
        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.createSheet("N11").
                createRow(0).
                createCell(0).
                setCellValue("Mağazalar");

        for (int i = 0; i < aHarfliMagazalarList.size(); i++) {

            workbook.
                    getSheet("N11").
                    createRow(i + 1).
                    createCell(0).
                    setCellValue((aHarfliMagazalarList.get(i).getText()));
        }

        FileOutputStream fos = new FileOutputStream("src/resources/ulkeler.xlsx");
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();

         */
    }


