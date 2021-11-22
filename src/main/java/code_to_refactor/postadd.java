package code_to_refactor;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class postadd {

    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Witaj w programie Spot Bot,\nPodaj zmienne dla posta ");
        //System.out.println("Podaj hasło do konta: ");

        //zmienne dla scryptu
        //login i hasło (dodać potem scanner)
        String login = "";
        String pass = "";

        //treść posta w zmiennej typu string post
        System.out.println("Podaj treść Posta: ");
        String post = in.nextLine();

        //ilość postów dla pentli for ilości w jakiej bedzie dodawany post
        System.out.println("Podaj ilość postów: ");
        int iloscPostow = in.nextInt();

        //dzień od którego ma sie zaczynać dodawanie posta
        System.out.println("Podaj dzień od którego ma się zaczać dodawanie postów: ");
        int dd = in.nextInt();

        //miesiąc od którego ma sie zaczynać dodawanie posta
        System.out.println("Podaj miesiąc od którego ma się zaczynać dodawanie posta: ");
        int mm = in.nextInt();
        int rrrr;

        //zmienne dla zdjęć
        //ilość zdjęć jaka ma być w poście
        System.out.println("Podaj ilosc zdjęć: ");
        int iloscZdjec = in.nextInt();

        String tablicaZdjec[] = new String[iloscZdjec];
        if (iloscZdjec > 0) {
            System.out.println("Podaj nazwy zdjęć z rozszerzeniem (jpg, png): ");
            tablicaZdjec[0] = in.nextLine();

            for (int i = 0; i < tablicaZdjec.length; i++) {
                tablicaZdjec[i] = in.nextLine();
            }
        }
        System.out.println("Dane wprowadone poprawnie");
        System.out.println("Uruchamiam Selenium WebDriverController");

        //Uruchamia chromium i przekierowuje na strone fb
        WebDriver driver;
//        WebDriverManager.chromedriver().setup();

        ChromeOptions ops = new ChromeOptions();//wyłąncza powiadomienia
        ops.addArguments("--disable-notifications");

        driver = new ChromeDriver(ops);
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();

        //Automatyczne logowanie
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("pass")).sendKeys(pass);
        driver.findElement(By.name("login")).click();

        //Operacje na stronie aby przejsc do creator studio
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("p361ku9c")).click();

        driver.navigate().to("https://www.facebook.com/Spottedmielecofficial");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElement(By.linkText("Creator Studio")).click();

        //Sprawdza czy pojawiło się okienko do nawigacji
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            driver.findElement(By.linkText("Rozpocznij przeglądanie")).click();
        } catch (Exception e){

        }

        //pentla for do ilośc postów
        for (int i = 0 ; i < iloscPostow; i++) {      //dać tu ilość postów
            int godz = r.nextInt(17 - 15 + 1) + 15; //przedział czasowy od 15 do 17
            int min = r.nextInt(59 - 10 + 1) + 10; //przdział czasowy od 10 do 59

            //Przechodzi do tworzenia postów
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//span[@class='l61y9joe j8otv06s a1itoznt kd9y4r7t svz86pwt cu1gti5y a53abz89']")).click();

            //tworzenie posta
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Thread.sleep(7000);
            driver.findElement(By.xpath("//br[@data-text='true']")).sendKeys(post);//dodać zmienne do tej linijki

            //dodawanie zdjęcia do posta
            if (iloscZdjec > 0) {
                WebElement dodajZdjecie = driver.findElement(By.xpath("//td[@class='fbReactComposerAttachmentSelector_PHOTO pas _1fng _51m-']//div//div//span//a//div[2]//input"));
                for (int j = 0; j < tablicaZdjec.length; j++) {
                    dodajZdjecie.sendKeys("C:\\Users\\Kornel\\Pictures\\" + tablicaZdjec[j]);
                }
            }
            Thread.sleep(5000);


            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[@class='_271k _271l _271m _1qjd _7tvm _7tv2 _7tv4 _p']")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("Zaplanuj")).click();


            //planowanie posta
            //data

            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.xpath("//div[@class='_5qcv _3-8x _t0j']//div//span//label//input")).click();
            driver.findElement(By.xpath("//div[@class='_5qcv _3-8x _t0j']//div//span//label//input")).sendKeys(Keys.CONTROL + "a");
            driver.findElement(By.xpath("//div[@class='_5qcv _3-8x _t0j']//div//span//label//input")).sendKeys(Keys.DELETE);
            driver.findElement(By.xpath("//div[@class='_5qcv _3-8x _t0j']//div//span//label//input")).sendKeys(dd + "." + mm + ".2021");
            dd++;


            //godzina
            try {
                WebElement godzinaPosta = driver.findElement(By.xpath("//div[@class='_4nx7 _4nww _5pw0']//div[1]//input"));
                godzinaPosta.sendKeys(godz + "");
                Thread.sleep(2000);
            } catch (Exception e) { }

            //minuty
            try {
                WebElement minutaPosta = driver.findElement(By.xpath("//div[@class='_4nxe _4nww _5pw0']//div[1]//input"));
                minutaPosta.sendKeys(min + "");
                Thread.sleep(2000);

            } catch (Exception e) { }

            //zatwiedzenie posta
            try {
                driver.findElement(By.xpath("//button[@action='confirm']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@class='_1mf7  _8bma _4jy0 _4jy3 _4jy1 _51sy selected _42ft']")).click();
            } catch (Exception e) { }

            //odświerza strone
            driver.navigate().to("https://www.facebook.com/Spottedmielecofficial");
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.linkText("Creator Studio")).click();
        }

        //wyłącza chromedrive
        Thread.sleep(3000);
        driver.quit();

    }

}
