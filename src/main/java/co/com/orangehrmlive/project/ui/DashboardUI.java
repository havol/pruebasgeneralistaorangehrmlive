package co.com.orangehrmlive.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardUI extends PageObject {

        public static final Target TXT_DASHBOARD = Target.the("texto random, del nombre logout")
                .located(By.xpath("//h6[normalize-space()='Dashboard']"));

}