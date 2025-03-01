//package ProiectOOP.Tests;
//import ProiectOOP.HelperMethods.PopUp;
//import ProiectOOP.Pages.AddToCart;
//import ProiectOOP.Pages.FormularComanda;
//import ProiectOOP.Pages.Login;
//import ProiectOOP.ShareData.ShareData;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//public class AddToCartOOPTest extends ShareData {
//    Login login;
//    AddToCart addToCart;
//    FormularComanda formularComanda;
//
//    @Test
//    public void metodaTest(){
//        login = new Login(getDriver());
//        login.metodaLogin("georgiana.petu@gmail.com", "Test12345!");
//        addToCart = new AddToCart(getDriver());
//        addToCart.metodaAddToCart();
//        //assert
//        String addedBook1 = "Curiozitati incredibile despre gaurile negre";
//        Assert.assertTrue(addToCart.searchResult1Text.contains(addedBook1));
//        String addedBook2 = "Universul intr-o coaja de nuca";
//        Assert.assertTrue(addToCart.searchResult2Text.contains(addedBook2));
//        String quantity = "1";
//        //Assert.assertTrue(addToCart.quantityResult1Text.equals(quantity));
//        //Assert.assertTrue(addToCart.quantityResult2Text.equals(quantity));
//        //Assert.assertTrue(addToCart.priceResult1Text.contains("6290Lei"));
//        //Assert.assertTrue(addToCart.totalProduseText.contains("15199Lei"));
//        //Assert.assertTrue(addToCart.costLivareText.contains("000Lei"));
//        formularComanda = new FormularComanda(getDriver());
//        formularComanda.metodaFormularComanda("Calarasi", "Calarasi", "Strada Lalelelor nr30");
//        //assert
////        Assert.assertTrue(formularComanda.prenumeText.contains("Georgiana"));
//
//    }
//}
