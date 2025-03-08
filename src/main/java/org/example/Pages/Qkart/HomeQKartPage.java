package org.example.Pages.Qkart;

import org.example.Base.BasePage;
import org.example.Enums.WaitTypes;
import org.openqa.selenium.By;

public class HomeQKartPage extends BasePage {

    private static final By PRIVACY_POLICY = By.xpath("//p[@class='footer-text']//a[text()='Privacy policy']");
    private static final By ABOUT_US = By.xpath("//p[@class='footer-text']//a[text()='About us']");
    private static final By TERMS_OF_SERVICE = By.xpath("//p[@class='footer-text']//a[text()='Terms of Service']");
    private static final By LIST_OF_ITEMS = By.xpath("//div[@class='MuiCardContent-root css-1qw96cp']/p");
    private static final By SECOND_CARAOSEL = By.xpath("//button[@aria-label='Go to page 2']");
    private static final By FIRST_ITEM_ADD_TO_CART = By.xpath("//p[text()='Stylecon 9 Seater RHS Sofa Set ']/parent::div/following-sibling::div/button");
    private static final By SHOE_ADD_TO_CART = By.xpath("//p[text()='Roadster Mens Running Shoes']/parent::div/following-sibling::div/button");
    private static final By CHECKOUT_BUTTON = By.xpath("//div[text()='Order total']/parent::div/following-sibling::div/button");
    private static final By LOGOUT_LINK = By.xpath("//button[@type='primary' and contains(text(),'Logout')]");
    private static final By SIZE_DROPDOWN = By.xpath("//select[@id='uncontrolled-native']");
    private static final By PLUS_ICON = By.xpath("//div[@class='MuiBox-root css-69i1ev']//button[2]");
    private static final By USERNAME_TEXT = By.xpath("//p[@class='username-text']");
    private static final By SUCCESS_MESSAGE=By.xpath("//div[@id='notistack-snackbar']");


    public String getText()
    {
        return getText(SUCCESS_MESSAGE, WaitTypes.VISIBLE);
    }

    public HomeQKartPage clickPrivacyPolicy()  {
        waitVisible(LOGOUT_LINK);
        ScrollToBottom();
        waitPresent(PRIVACY_POLICY);
        ClickElementByJS(PRIVACY_POLICY, WaitTypes.PRESENT);
        return this;
    }


    public HomeQKartPage clickAboutUs()
    {
        waitVisible(LOGOUT_LINK);
        ScrollToBottom();
        waitPresent(ABOUT_US);
        ClickElementByJS(ABOUT_US, WaitTypes.PRESENT);
        return this;
    }


    public HomeQKartPage ClickTermOdService()
    {
        waitVisible(LOGOUT_LINK);
        ScrollToBottom();
        waitPresent(TERMS_OF_SERVICE);
        ClickElementByJS(TERMS_OF_SERVICE, WaitTypes.PRESENT);
        return this;
    }


    public String ListofItems() {
        waitPresent(LIST_OF_ITEMS);
        StringBuilder allItems = new StringBuilder();

        while (true) {
            allItems.append(getAllItems(LIST_OF_ITEMS));
            // Check if the next page button is present and clickable
            if (isElementPresent(SECOND_CARAOSEL)) {
                ClickElementByJS(SECOND_CARAOSEL, WaitTypes.VISIBLE);
                waitPresent(LIST_OF_ITEMS);
            } else {
                break; // Exit loop when no more pages exist
            }
        }
        return allItems.toString().trim();
    }


    public HomeQKartPage placeOrder() throws InterruptedException {
         waitPresent(FIRST_ITEM_ADD_TO_CART);
         ScrollToElement(FIRST_ITEM_ADD_TO_CART, WaitTypes.PRESENT);
         ClickElement(FIRST_ITEM_ADD_TO_CART, WaitTypes.CLICKABLE);
         waitPresent(CHECKOUT_BUTTON);
         MoveToElementByAction(CHECKOUT_BUTTON, WaitTypes.PRESENT);
         ClickElement(CHECKOUT_BUTTON, WaitTypes.CLICKABLE);
         Thread.sleep(5000);
         return this;
    }


    public HomeQKartPage selectProductSizeAndIncreaseCountandPlaceOrder() throws InterruptedException {
        waitVisible(SIZE_DROPDOWN);
        ScrollToElement(SIZE_DROPDOWN, WaitTypes.VISIBLE);
        waitVisible(SIZE_DROPDOWN);
        ClickElementByJS(SIZE_DROPDOWN, WaitTypes.VISIBLE);
        SelectbyVisibleText(SIZE_DROPDOWN, "7", WaitTypes.VISIBLE);
        Thread.sleep(5000);
        ClickElement(SHOE_ADD_TO_CART, WaitTypes.CLICKABLE);
        waitPresent(PLUS_ICON);
        MoveToElementByAction(PLUS_ICON, WaitTypes.PRESENT);
        ClickElement(PLUS_ICON, WaitTypes.CLICKABLE);
        Thread.sleep(2000);
        ClickElement(PLUS_ICON, WaitTypes.CLICKABLE);
        Thread.sleep(2000);
        waitVisible(CHECKOUT_BUTTON);
        ClickElement(CHECKOUT_BUTTON, WaitTypes.CLICKABLE);
        return this;
    }


}
