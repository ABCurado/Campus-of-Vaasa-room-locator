package fi.vaasacampus.roomlocator.test.tests;

import fi.vaasacampus.roomlocator.test.util.XMLUtil;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by niko on 17.12.2016.
 */
@Config(
        browser = Browser.CHROME,
        url = "http://localhost/search.html"
)
public class SearchIT extends Locomotive {
    @Test
    public void validateSearchPageComponents() {
        By dropDownButton = By.id("dropdownMenu1");
        validatePresent(dropDownButton);
        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        validatePresent(By.cssSelector(".dropdown-menu > #homeListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #manualListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #aboutListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #helpListElement > a"));
        validatePresent(By.id("nav-search"));
        validatePresent(By.cssSelector("#nav-search > .form-group > input"));
        validatePresent(By.cssSelector("#nav-search > .btn.btn-default"));
        validatePresent(By.id("side-options"));
        validatePresent(By.id("title"));
        validatePresent(By.id("img-logo"));
        validatePresent(By.id("dropdown-uni"));
        validatePresent(By.cssSelector("#room-search-form > #room-search-input"));
    }

    @Test
    public void navigateToManualPageAndBack() {
        By dropDownButton = By.id("dropdownMenu1");
        validatePresent(dropDownButton);
        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        click(By.cssSelector(".dropdown-menu > #manualListElement > a"));
        final String previousURL = driver.getCurrentUrl();
        ExpectedCondition hasNavigatedToManualPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };

        //Waiting that user has navigated to manual page
        waitForCondition(hasNavigatedToManualPage);

        //Asserting that url is changed to correct one
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/manual.html");

        validatePresent(dropDownButton);
        validatePresent(By.id("nav-search"));
        validatePresent(By.cssSelector("#nav-search > .form-group > input"));
        validatePresent(By.cssSelector("#nav-search > .btn.btn-default"));
        validatePresent(By.id("side-options"));
        validatePresent(By.cssSelector("#content-wrapper > h1"));
        validatePresent(By.cssSelector("#content-wrapper > p"));

        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        validatePresent(By.cssSelector(".dropdown-menu > #homeListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #manualListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #aboutListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #helpListElement > a"));
        click(By.cssSelector(".dropdown-menu > #homeListElement > a"));

        ExpectedCondition hasNavigatedBackToSearchPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };
        waitForCondition(hasNavigatedBackToSearchPage);

        Assert.assertEquals(driver.getCurrentUrl(), previousURL);
    }

    @Test
    public void navigateToAboutPageAndBack() {
        By dropDownButton = By.id("dropdownMenu1");
        validatePresent(dropDownButton);
        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        click(By.cssSelector(".dropdown-menu > #helpListElement > a"));
        final String previousURL = driver.getCurrentUrl();
        ExpectedCondition hasNavigatedToManualPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };

        //Waiting that user has navigated to help page
        waitForCondition(hasNavigatedToManualPage);

        //Asserting that url is changed to correct one
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/help.html");

        validatePresent(dropDownButton);
        validatePresent(By.id("nav-search"));
        validatePresent(By.cssSelector("#nav-search > .form-group > input"));
        validatePresent(By.cssSelector("#nav-search > .btn.btn-default"));
        validatePresent(By.id("side-options"));
        validatePresent(By.cssSelector("#content-wrapper > h1"));
        validatePresent(By.cssSelector("#content-wrapper > p"));

        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        validatePresent(By.cssSelector(".dropdown-menu > #homeListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #manualListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #aboutListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #helpListElement > a"));
        click(By.cssSelector(".dropdown-menu > #homeListElement > a"));

        ExpectedCondition hasNavigatedBackToSearchPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };
        waitForCondition(hasNavigatedBackToSearchPage);

        Assert.assertEquals(driver.getCurrentUrl(), previousURL);
    }

    @Test
    public void navigateToHelpPageAndBack() {
        By dropDownButton = By.id("dropdownMenu1");
        validatePresent(dropDownButton);
        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        click(By.cssSelector(".dropdown-menu > #helpListElement > a"));
        final String previousURL = driver.getCurrentUrl();
        ExpectedCondition hasNavigatedToManualPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };

        //Waiting that user has navigated to about page
        waitForCondition(hasNavigatedToManualPage);

        //Asserting that url is changed to correct one
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/help.html");

        validatePresent(dropDownButton);
        validatePresent(By.id("nav-search"));
        validatePresent(By.cssSelector("#nav-search > .form-group > input"));
        validatePresent(By.cssSelector("#nav-search > .btn.btn-default"));
        validatePresent(By.id("side-options"));
        validatePresent(By.cssSelector("#content-wrapper > h1"));
        validatePresent(By.cssSelector("#content-wrapper > p"));
        validatePresent(By.cssSelector("#content-wrapper > #contact-form"));

        click(dropDownButton);
        waitForElement(By.id("dropdown-btn-header"));
        validatePresent(By.cssSelector(".dropdown-menu > #homeListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #manualListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #aboutListElement > a"));
        validatePresent(By.cssSelector(".dropdown-menu > #helpListElement > a"));
        click(By.cssSelector(".dropdown-menu > #homeListElement > a"));

        ExpectedCondition hasNavigatedBackToSearchPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };
        waitForCondition(hasNavigatedBackToSearchPage);

        Assert.assertEquals(driver.getCurrentUrl(), previousURL);
    }

    @Test
    public void fillRoomSearchInput() {
        By roomSearchInput = By.cssSelector("#room-search-form > #room-search-input");
        validatePresent(roomSearchInput);
        driver.findElement(roomSearchInput).sendKeys("INVALID");

        validatePresent(By.id("search"));

        //Assert that user gets the not found message
        Assert.assertEquals(driver.findElement(By.id("search")).getText(), "No room found. Please check your room ID!");
        driver.findElement(roomSearchInput).clear();
        driver.findElement(roomSearchInput).sendKeys("R");

        validatePresent(By.id("search"));
        List<WebElement> results = driver.findElements(By.cssSelector("#search > a"));

        for (WebElement e : results) {
            Assert.assertTrue(e.getText().contains("R"));
        }

        driver.findElement(roomSearchInput).sendKeys("0");

        validatePresent(By.id("search"));
        for (WebElement e : driver.findElements(By.cssSelector("#search > a"))) {
            Assert.assertTrue(e.getText().contains("R0"));
        }

        driver.findElement(roomSearchInput).sendKeys("0");
        validatePresent(By.id("search"));

        results = driver.findElements(By.cssSelector("#search > a"));

        Assert.assertTrue(results.size() == 1);
        Assert.assertTrue(results.get(0).getText().equals("R000"));
    }

    @Test
    public void searchForRoomAndNavigateToMapPageAndBack() throws XPathExpressionException {
        By roomSearchInput = By.cssSelector("#room-search-form > #room-search-input");
        validatePresent(roomSearchInput);

        driver.findElement(roomSearchInput).sendKeys("R208");

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        validatePresent(By.id("search"));
        List<WebElement> results = driver.findElements(By.cssSelector("#search > a"));

        Assert.assertTrue(results.size() == 1);

        String resultLinkText = results.get(0).getText();
        Assert.assertEquals(resultLinkText, "R208");

        final String previousURL = driver.getCurrentUrl();
        click(By.cssSelector("#search > a"));

        ExpectedCondition hasNavigatedToMapPage = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.getCurrentUrl().equals(previousURL));
            }
        };

        waitForCondition(hasNavigatedToMapPage);
        By heading = By.cssSelector(".navbar.navbar-default > #roomid");
        waitForElement(heading);
        validatePresent(heading);
        //Asserting that url parameter is correct
        assertEquals(driver.getCurrentUrl(), "http://localhost/map.html?roomid=" + resultLinkText);

        //Asserting that page title is correct
        assertEquals(driver.findElement(heading).getText(), resultLinkText);

        //Validating that pin pointer is present
        validatePresent(By.id("mark"));

        Document doc = XMLUtil.getDoc();

        Node root = doc.getDocumentElement();
        String xpathString = "//room/roomid[text()='" + resultLinkText +"']/parent::room";

        javax.xml.xpath.XPath xPath = javax.xml.xpath.XPathFactory.newInstance().newXPath();
        javax.xml.xpath.XPathExpression xPathExpression = xPath.compile(xpathString);

        NodeList nl = (NodeList)xPathExpression.evaluate(root, XPathConstants.NODESET);

        //Asserting that only one result was found
        Assert.assertTrue(nl.getLength() == 1);

        Node roomNode = nl.item(0);

        Assert.assertEquals(roomNode.getNodeName(), "room");

        String xcord = "";
        String ycord = "";
        for (int i = 0; i < roomNode.getChildNodes().getLength(); i++) {
            if (roomNode.getChildNodes().item(i).getNodeName().equals("xcord")) {
                xcord = roomNode.getChildNodes().item(i).getTextContent();
            }
            if (roomNode.getChildNodes().item(i).getNodeName().equals("ycord")) {
                ycord = roomNode.getChildNodes().item(i).getTextContent();
            }
        }

        String positionStyle = driver.findElement(By.id("mark")).getAttribute("style");

        //Asserting that style property has left and top properties
        Assert.assertTrue(positionStyle.contains("left") && positionStyle.contains("top"));

        String[] splitted = positionStyle.split(" ");

        String cssLeft = splitted[1].replace("%", "").replace(" ", "").replace(";", "");
        String cssTop = splitted[3].replace("%", "").replace(" ", "").replace(";", "");

        //Asserting that css properties equals the actual coordinates from xml
        Assert.assertEquals(cssLeft, xcord);
        Assert.assertEquals(cssTop, ycord);
    }
}
