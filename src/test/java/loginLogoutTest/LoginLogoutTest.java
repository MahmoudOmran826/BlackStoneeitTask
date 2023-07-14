package loginLogoutTest;

import baseTest.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginLogoutTest extends BaseTests{
@Test
    public void testLoginLogoutFullScenario(){
    String actualWelcomeMessage = loginPage.enterEmail(email)
            .enterPassword(password)
            .clickLoginBtn()
            .getWelcomeHeaderText();
/*  Verify that the login is successful by checking if the user is redirected to the home page
    or if a success message is displayed.*/
    Assert.assertEquals(actualWelcomeMessage,expectedWelcomeMessage,
            String.format("Expected actual message to be %s, but found %s",
                    actualWelcomeMessage,expectedWelcomeMessage));

//  Print the title of the home page.
    String titleOfAdminPage = adminPage.getTitleOfAdminPage();
    System.out.println(titleOfAdminPage);

//    Verify that the user is successfully logged out by checking if the login page is displayed again
    String actualLoginPageTitle = adminPage.clickOnHumanImageOnTheTopRightOfTheScreen()
            .clickOnLogOutSelector()
            .getLoginPageTitle();
    Assert.assertEquals(actualLoginPageTitle,expectedLoginPageTitle,
            String.format("Expected actual message to be %s, but found %s",
                    actualLoginPageTitle,expectedLoginPageTitle));

}
}
