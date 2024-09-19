package co.com.orangehrmlive.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI extends PageObject {

        public static final Target INPUT_USERNAME = Target.the("Campo Username")
                .locatedBy("//input[@name='username']");

        public static final Target INPUT_PASSWORD = Target.the("Campo Password")
                .locatedBy("//input[@name='password']");

        public static final Target BTN_LOGIN = Target.the("Boton Login")
                .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

        public static final Target TXT_RANDOM_LOGOUT= Target.the("texto random, del nombre logout")
                .located(By.xpath("Logout"));

}