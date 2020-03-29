package com.cybertek.homework;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.*;

public class AmazonCheckboxes {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void afterTest() {
    //  driver.quit();
    }

    @Test
    public void days() throws InterruptedException {
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html");

        int countFridays =0;
        Thread.sleep(1000);
        Random rand = new Random();
        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[starts-with(@id,'gwt-debug-cwCheckBo')]"));
        List<WebElement> allBoxesName = driver.findElements(By.xpath("//input[starts-with(@id,'gwt-debug-cwCheckBo')]/following-sibling::label"));

       do {
           int random = rand.nextInt(allBoxes.size());
           WebElement oneBox = allBoxes.get(random);
           if (!oneBox.isEnabled()){
               continue;
           }
           WebElement oneBoxText = allBoxesName.get(random);
            oneBox.click();
           System.out.println(oneBoxText .getText());
           oneBox.click();
           if(oneBoxText.getText().equals("Friday")){
               countFridays++;
           }
       } while (countFridays!=3);
    }

    @Test
    public void TodayDay() {
        LocalDate localDate = LocalDate.now();

        String year = String.valueOf(localDate.getYear());
        String month = localDate.getMonth().name().toLowerCase();
        String day = String.valueOf(localDate.getDayOfMonth());

        driver.get("http://practice.cybertekschool.com/dropdown");
        String yearElement = new Select(driver.findElement(By.id("year"))).getFirstSelectedOption().getText();
        String monthElement = new Select(driver.findElement(By.id("month"))).getFirstSelectedOption().getText().toLowerCase();
        String dayElement = new Select(driver.findElement(By.id("day"))).getFirstSelectedOption().getText();

        Assert.assertEquals(year,yearElement);
        Assert.assertEquals(month,monthElement);
        Assert.assertEquals(day,dayElement);
    }

    @Test
    public void yearsMonthsdays () {
        Random rand = new Random();
        driver.get("http://practice.cybertekschool.com/dropdown");
        // All year elements
        Select yearElement = new Select(driver.findElement(By.id("year")));
        List<WebElement> allYears = yearElement.getOptions();
        // Random number for selecting a year
        int randomNr = rand.nextInt(allYears.size());

        allYears.get(randomNr).click(); /// click on a random year
        int year = Integer.parseInt(yearElement.getFirstSelectedOption().getText()); // make it int
        // All months elements
        Select monthElement = new Select(driver.findElement(By.id("month")));
        List<WebElement> allMonths = monthElement.getOptions();
        // All days elements
        Select dayElement = new Select(driver.findElement(By.id("day")));
        List<WebElement> allDays = dayElement.getOptions();

        // VERIFYING
        for (int i = 0; i < allMonths.size(); i++) {
            monthElement.selectByIndex(i);
            String month = monthElement.getFirstSelectedOption().getText();
            if(year % 4 == 0 && month.equals("January")) {
                System.out.println("--- LEAP YEAR ---");
                Assert.assertEquals(allDays.size(),29);
            }
        }
    }

    @Test
    public void departments_sort (){
        driver.get(" https://www.amazon.com ");


        String defaultValue = driver.findElement(By.xpath("//span[@class='nav-search-label']")).getText();
        Assert.assertEquals(defaultValue,"All");

        Select allDeparts = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> allDepartments = allDeparts.getOptions();
        List<String> stringDepartments = BrowserUtils.getElementsText(allDepartments);
        List<String> stringDepartmentsCopy = BrowserUtils.getElementsText(allDepartments);

        Collections.sort(stringDepartmentsCopy);

        Assert.assertNotEquals(stringDepartments,stringDepartmentsCopy);
    }

    @Test
    public void main_departments (){
        driver.get("https://www.amazon.com/gp/site-directory");
        Select allDeparts = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> allDepartments = allDeparts.getOptions();
        List<String> stringDeparts = BrowserUtils.getElementsText(allDepartments);

   List<WebElement> allMainDep = driver.findElements(By.cssSelector("h2.fsdDeptTitle"));
        List<String> mainDepartments = BrowserUtils.getElementsText(allDepartments);

        for (String mainDepartment : mainDepartments) {
            Assert.assertTrue(stringDeparts.contains(mainDepartment));
        }

    }

    @Test
    public void links (){
        driver.get("https://www.w3schools.com/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        for (WebElement allLink : allLinks) {
            if (allLink.isDisplayed()){
                System.out.println(allLink.getText());
                System.out.println(allLink.getAttribute("href"));
            }
        }
    }

    @Test
    public void validLinks (){
        driver.get("https://www.w3schools.com/");
List<WebElement> allLinks = driver.findElements(By.tagName("a"));
            Assert.assertTrue(allLinks.contains("http"));
}

    @Test
    public void cart () throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("wooden spoon"+ Keys.ENTER);
        Random rand = new Random();
        // get all result
        Thread.sleep(1000);
        List<WebElement> allReusltsName = driver.findElements(By.cssSelector("span[class='a-size-base-plus a-color-base a-text-normal']"));
        List<WebElement> wholePrice = driver.findElements(By.cssSelector("span[class='a-price-whole']"));
        List<WebElement> centsPrice = driver.findElements(By.cssSelector("span[class='a-price-fraction']"));
        List<String> wholePriceStr = BrowserUtils.getElementsText(wholePrice);
        List<String> centsPriceStr = BrowserUtils.getElementsText(centsPrice);
        List<String> fullPrice = new ArrayList<>();

        for (int i = 0; i < wholePrice.size(); i++) {
            fullPrice.add("$"+wholePrice.get(i).getText()+"."+centsPrice.get(i).getText());
        }

        int randomNr = rand.nextInt(allReusltsName.size());
        String name = allReusltsName.get(randomNr).getText();
        String price = fullPrice.get(randomNr);

        allReusltsName.get(randomNr).click();

        Select quantity = new Select(driver.findElement(By.id("quantity")));
            String actualQuantity = quantity.getFirstSelectedOption().getAttribute("innerHTML").replaceAll("\\s", "");

            Assert.assertEquals(actualQuantity,"1");
        Thread.sleep(1000);
            String nameOnPage = driver.findElement(By.id("productTitle")).getText();
            String priceOnPage = driver.findElement(By.id("price_inside_buybox")).getText();

        Assert.assertEquals(nameOnPage,name);
        Assert.assertEquals(priceOnPage,price);

    }

    @Test
    public void prime() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);


        WebElement prime = driver.findElement(By.cssSelector("div[class='s-expand-height s-include-content-margin s-border-bottom s-latency-cf-section']  > div >div>div>div>span>span> i"));

        System.out.println(prime.getAttribute("aria-label"));

        //WebElement pCheckBox =  driver.findElement(By.xpath("//label/i"));
        //pCheckBox.click();
    }

    @Test
    public void more_spoons() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        List<WebElement> brands = driver.findElements(By.xpath("//li[starts-with(@id, 'p_89')]"));
        List<String> brandsBefore = BrowserUtils.getElementsText(brands);
        WebElement pCheckBox =  driver.findElement(By.xpath("//label/i"));
        pCheckBox.click();
        Thread.sleep(3000);
        List<WebElement> brandsPrime = driver.findElements(By.xpath("//li[starts-with(@id, 'p_89')]"));
        List<String> brandsPrimeBefore = BrowserUtils.getElementsText(brandsPrime);

        Assert.assertEquals(brandsBefore,brandsPrimeBefore);
    }

    @Test
    public void cheap_spoons() throws InterruptedException {
        driver.get("https://www.amazon.com/s?k=wooden+spoon&rh=n%3A1063498%2Cp_36%3A1253523011&dc&qid=1585344492&rnid=386465011&ref=sr_nr_p_36_1");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

      WebElement under25 = driver.findElement(By.xpath("//span[.='Under $25']"));
 under25.click();
Thread.sleep(3000);
        List<WebElement> wholePrice = driver.findElements(By.cssSelector("span[class='a-price-whole']"));
        List<WebElement> centsPrice = driver.findElements(By.cssSelector("span[class='a-price-fraction']"));
        List<String> wholePriceStr = BrowserUtils.getElementsText(wholePrice);
        List<String> centsPriceStr = BrowserUtils.getElementsText(centsPrice);
        List<String> fullPrice = new ArrayList<>();

        for (int i = 0; i < wholePrice.size(); i++) {
            fullPrice.add(wholePrice.get(i).getText()+"."+centsPrice.get(i).getText());
        }
        List<Double> fullDoublePrice = new ArrayList<>();
        for (String s : fullPrice) {
            fullDoublePrice.add(Double.parseDouble(s));
        }

        for (Double aDouble : fullDoublePrice) {
            System.out.println(aDouble);
            Assert.assertTrue(aDouble<25);
        }




    }

}