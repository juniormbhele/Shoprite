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
            System.out.println("Signing In to WebTables");
            driver.navigate().to(APP_URL);
            String title = driver.getTitle();
            System.out.println("Page title: - " + title);

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

                User obj = (User) usersToAdd.next();

                //Clicking the button to Add User
                addUserButton(driver).click();

                //Entering First Name
                firstName(driver).sendKeys(obj.getFirstName());

                //Entering Last Name
                lastName(driver).sendKeys(obj.getLastName());


                //Entering UserName
                String username = obj.getUsername() +""+ getUniqueNumber();
                userName(driver).sendKeys(username);

                //Entering password
                password(driver).sendKeys(obj.getPassword());

                customerSelectionCompanyAAA(driver).click();

                roleId(driver).sendKeys(obj.getRole());

                email(driver).sendKeys(obj.getEmail());

                mobilePhone(driver).sendKeys(obj.getCellphone());
                Thread.sleep(2000);
                saveButton(driver).click();
                Thread.sleep(2000);
                Assert.assertEquals(username, driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[3]")).getText());

                System.out.println("This user "+obj.getFirstName()+" has been added");

            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }

}
