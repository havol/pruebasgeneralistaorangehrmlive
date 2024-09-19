package co.com.orangehrmlive.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MenuUI extends PageObject {

    public static final Target LINK_RECRUITMENT = Target.the("Recruitment Enlace")
            .locatedBy("//a[contains(@class, 'oxd-main-menu-item') and .//span[text()='Recruitment']]");

}