package pages.services;

import org.openqa.selenium.WebDriver;
import pages.ProductsPage;

public class AddProductToCartService {
    private WebDriver driver;

    public AddProductToCartService(WebDriver driver) {
        this.driver = driver;
    }

    //Здесь вероятно можно придумать как рандомизировать добавление товаров в корзину
    //Ввиду того, что в будущем понадобится расширить и усложнить метод, я вынесла его в сервисы
    //Пока я использовала один товар - детский комбинезончик...
    public void addSingleProductToCart() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addToCartOnesie();
    }
}
