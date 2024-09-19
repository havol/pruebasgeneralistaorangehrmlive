package co.com.orangehrmlive.project.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class RecruitmentUI extends PageObject {

    public static final Target RECRUITMENT_HEADING = Target.the("Recruitment heading")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public static final Target ADD_BUTTON = Target.the("Boton de Add+")
            .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");

    public static final Target ADD_CANDIDATE_HEADING = Target.the("Add Candidate heading")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");

    public static final Target FIRST_NAME_FIELD = Target.the("First Name field")
            .locatedBy("//input[@class='oxd-input oxd-input--active orangehrm-firstname']");

    public static final Target MIDDLE_NAME_FIELD = Target.the("Middle Name field")
            .locatedBy("//input[@class='oxd-input oxd-input--active orangehrm-middlename']");

    public static final Target LAST_NAME_FIELD = Target.the("Last Name field")
            .locatedBy("//input[@class='oxd-input oxd-input--active orangehrm-lastname']");

    public static final Target DROPDOWN_VACANCY = Target.the("Dropdown Vacancy")
            .locatedBy("//div[@class='oxd-select-text oxd-select-text--active']");

    public static final Target DYNAMIC_TEXT_DROPDOWN_VACANCY = Target.the("Dropdown with dynamic text Vacancy")
            .locatedBy("//div[@class='oxd-select-text oxd-select-text--active' and text()='{0}']");

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

    public static final Target APPLICATION_STAGE_HEADING = Target.the("Application Stage heading")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Application Stage']");

    public static final Target SHORTLIST_BUTTON = Target.the("Shortlist button")
            .locatedBy("(//button[normalize-space()='Shortlist'])[1]");

    public static final Target SHORTLIST_CANDIDATE_HEADING = Target.the("Shortlist Candidate heading")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Shortlist Candidate']");

    public static final Target SCHEDULE_INTERVIEW_BUTTON = Target.the("Schedule Interview button")
            .locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success']");

    public static final Target SCHEDULE_INTERVIEW_HEADING = Target.the("Schedule Interview heading")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Schedule Interview']");

    public static final Target INTERVIEW_TITLE_INPUT_FIELD = Target.the("Primer input dentro del primer div")
            .locatedBy("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");

    public static final Target INTERVIEWER_INPUT_FIELD = Target.the("Campo de entrada para el entrevistador")
            .locatedBy("//input[@data-v-75e744cd='' and @include-employees='onlyCurrent' and @placeholder='Type for hints...']");

    public static final Target DATE_INPUT_FIELD = Target.the("Date input field")
            .locatedBy("//input[@class='oxd-input oxd-input--active' and @data-v-1f99f73c='' and @data-v-4a95a2e0='']");

    public static final Target MARK_INTERVIEW_PASSED_BUTTON = Target.the("Mark Interview Passed button")
        .locatedBy("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[2]/button[3]");

    public static final Target CANDIDATE_LABEL = Target.the("Candidate label")
            .locatedBy("//label[@class='oxd-label' and text()='Candidate']");

    public static final Target CANDIDATE_NAME = Target.the("Candidate Name")
            .locatedBy("//div[@class='oxd-input-group']//label[@class='oxd-label' and text()='Name']//following-sibling::div[@class='oxd-text oxd-text--p']");

    public static final Target OFFER_JOB_BUTTON = Target.the("Offer Job button")
            .locatedBy("(//button[normalize-space()='Offer Job'])[1]");

    public static final Target HIRE_BUTTON = Target.the("Hire button")
            .locatedBy("(//button[normalize-space()='Hire'])[1]");

    public static final Target HIRE_CANDIDATE_HEADING = Target.the("Hire Candidate heading")
            .locatedBy("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title' and text()='Hire Candidate']");

    public static final Target HIRED_STATUS_PARAGRAPH = Target.the("Hired status paragraph")
            .locatedBy("//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2' and text()='Status: Hired']");

    public static boolean isCandidateWithStatusPresent(String candidateName, String status) {
        String xpath = String.format("//div[@class='oxd-table']//div[@role='row']//div[@role='cell'][3]//div[contains(text(), '%s')] | //div[@class='oxd-table']//div[@role='row']//div[@role='cell'][6]//div[contains(text(), '%s')]", candidateName, status);
        return !BrowseTheWeb.as(OnStage.theActorInTheSpotlight()).getDriver().findElements(By.xpath(xpath)).isEmpty();
    }

}