package t;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class T {

    @Test

    public void t1(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement((By.id("password"))).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        String actualResult = driver.findElement(By.id("flash")).getText();
        String expectedResult = "You logged into a secure area!";
        Assert.assertTrue(actualResult.contains(expectedResult));
        driver.close();
    }

    @Test

    public void t2(){        // invalid password

        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("[id=password")).sendKeys("SuperSecret");
        driver.findElement(By.cssSelector("button.radius")).click();
        String actualResult = driver.findElement(By.cssSelector("#flash")).getText();
        String expectedResult = "Your password is invalid!";
        Assert.assertTrue(actualResult.contains(expectedResult));
        driver.close();

    }

    @Test

    public void t3 (){       // invalid userName

        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.cssSelector("input#username")).sendKeys("eslam");
        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        String actualResult = driver.findElement(By.cssSelector("div#flash")).getText();
        String expectedResult = "Your username is invalid!";
        Assert.assertTrue(actualResult.contains(expectedResult));
        driver.close();


    }


}