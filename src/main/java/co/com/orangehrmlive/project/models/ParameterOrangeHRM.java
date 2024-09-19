package co.com.orangehrmlive.project.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ParameterOrangeHRM {

    private String strPath = "DataDriven.xlsx";
    private String strTable = "CANDIDATE";

    public static final String COLUMN_FIRTS_NAME = "FIRTS_NAME";
    public static final String COLUMN_MIDDLE_NAME = "MIDDLE_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_VACANCY = "VACANCY";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_CONTACT_NUMBER = "CONTACT_NUMBER";
    public static final String COLUMN_KEYWORDS = "KEYWORDS";
    public static final String COLUMN_DATE_OF_APPLICATION = "DATE_OF_APPLICATION";
    public static final String COLUMN_CONSENT_TO_KEEP_DATA = "CONSENT_TO_KEEP_DATA";
    public static final String COLUMN_INTERVIEW_TITLE = "INTERVIEW_TITLE";
    public static final String COLUMN_INTERVIEWER = "INTERVIEWER";
    public static final String COLUMN_DATE = "DATE";
    public static final String SELECT_FROM_CANDIDATE = "SELECT * FROM CANDIDATE";

    private String strFirstname;
    private String strMiddleName;
    private String strLastname;
    private String strVacancy;
    private String strEmail;
    private String strContactNumber;
    private String strKeywords;
    private String strDateApplication;
    private String strInterViewTitle;
    private String strInterviewer;
    private String strDateI;


    static List<ParameterOrangeHRM> paramDataList;

    public ParameterOrangeHRM(String strFirstname, String strMiddleName, String strLastname, String strVacancy, String strEmail) {
        this.strFirstname = strFirstname;
        this.strMiddleName = strMiddleName;
        this.strLastname = strLastname;
        this.strVacancy = strVacancy;
        this.strEmail = strEmail;
    }

    public ParameterOrangeHRM() {
        super();
    }

    public static List<ParameterOrangeHRM> getParamList() {
        return paramDataList;
    }

    public static void setParameterList(List<ParameterOrangeHRM> paramDataList) {
        ParameterOrangeHRM.paramDataList = paramDataList;
    }

}
