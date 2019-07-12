package za.co.shoprite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddUsers extends BaseClass
{

    @Test (priority = 0)
    public void navigate()
    {
        try
        {
            System.out.println("Navigation to WebTables");
            driver.navigate().to(APP_URL);
            String title = driver.getTitle();
            System.out.println("Page title: - " + title);

            //Asserting if the navigation was successful
            Assert.assertEquals(title, "Protractor practice website - WebTables");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    @Test  (priority = 1)
    public void addUsers()
    {
        try
        {

            while (usersToAdd.hasNext())
            {

                User userToBeAdded = (User) usersToAdd.next();

                //Clicking the button to Add User
                addUserButton(driver).click();

                //Entering First Name
                firstName(driver).clear();
                firstName(driver).sendKeys(userToBeAdded.getFirstName());

                //Entering Last Name
                lastName(driver).clear();
                lastName(driver).sendKeys(userToBeAdded.getLastName());


                //Entering UserName
                String username = userToBeAdded.getUsername() +""+ getUniqueNumber();
                userName(driver).clear();
                userName(driver).sendKeys(username);

                //Entering password
                password(driver).clear();
                password(driver).sendKeys(userToBeAdded.getPassword());

                //Selecting Customer Type

                if (userToBeAdded.getCustomerType().equals("Company AAA"))
                {
                    customerSelectionCompanyAAA(driver).click();
                }
                else
                {
                    customerSelectionCompanyBBB(driver).click();

                }

                //Selecting a Role
                roleId(driver).sendKeys(userToBeAdded.getRole());

                //Entering an email address
                email(driver).clear();
                email(driver).sendKeys(userToBeAdded.getEmail());

                //Entering a Cell Phone Number
                mobilePhone(driver).clear();
                mobilePhone(driver).sendKeys(userToBeAdded.getCellphone());


                Thread.sleep(2000);

                //Submitting Customer information
                saveButton(driver).click();
                Thread.sleep(2000);

                //Asserting if the User is added by checking the first entry on the table
                Assert.assertEquals(username, driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[3]")).getText());


                //Logger for Customer Details that were added
                System.out.println("This user "+userToBeAdded.getFirstName()+" has been added");

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

    }

}
