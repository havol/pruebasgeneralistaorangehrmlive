package co.com.orangehrmlive.project.interactions.excel;

import co.com.orangehrmlive.project.enums.Constants;
import co.com.orangehrmlive.project.exceptions.IncorrectDataDrivenValues;
import co.com.orangehrmlive.project.models.ParameterOrangeHRM;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static co.com.orangehrmlive.project.utils.Constants.HEADER_TITLE_EXCEL;
import static co.com.orangehrmlive.project.utils.Constants.INFORMATION_IN_EXCEL;

public class CaptureInformationUnfiltered implements Interaction {
    private static final Logger LOGGER = LoggerFactory.getLogger(CaptureInformationUnfiltered.class);
    static final String STRBASEPATH = System.getProperty("user.dir") + "\\src\\test\\resources\\data\\";

    @Override
    public <T extends Actor> void performAs(T actor) {
        ParameterOrangeHRM parameter = new ParameterOrangeHRM();
        List<ParameterOrangeHRM> paramDataList = new ArrayList<>();
        StringBuilder msg1 = new StringBuilder();

        try{
            Fillo filloConnection = new Fillo();
            Connection connection = filloConnection.getConnection(STRBASEPATH + parameter.getStrPath());
            Recordset recordSet = connection.executeQuery(ParameterOrangeHRM.SELECT_FROM_CANDIDATE);
            ParameterOrangeHRM listDataCandidate = null;
            recordSet.moveFirst();
            listDataCandidate = new ParameterOrangeHRM();
            LOGGER.info(HEADER_TITLE_EXCEL);
            for (int i = 0; i < recordSet.getCount(); i++) {
                listDataCandidate.setStrFirstname(recordSet.getField(ParameterOrangeHRM.COLUMN_FIRTS_NAME));
                listDataCandidate.setStrMiddleName(recordSet.getField(ParameterOrangeHRM.COLUMN_MIDDLE_NAME));
                listDataCandidate.setStrLastname(recordSet.getField(ParameterOrangeHRM.COLUMN_LAST_NAME));
                listDataCandidate.setStrVacancy(recordSet.getField(ParameterOrangeHRM.COLUMN_VACANCY));
                listDataCandidate.setStrEmail(recordSet.getField(ParameterOrangeHRM.COLUMN_EMAIL));
                listDataCandidate.setStrContactNumber(recordSet.getField(ParameterOrangeHRM.COLUMN_CONTACT_NUMBER));
                listDataCandidate.setStrKeywords(recordSet.getField(ParameterOrangeHRM.COLUMN_KEYWORDS));
                listDataCandidate.setStrDateApplication(recordSet.getField(ParameterOrangeHRM.COLUMN_DATE_OF_APPLICATION));
                listDataCandidate.setStrInterViewTitle(recordSet.getField(ParameterOrangeHRM.COLUMN_INTERVIEW_TITLE));
                listDataCandidate.setStrInterviewer(recordSet.getField(ParameterOrangeHRM.COLUMN_INTERVIEWER));
                listDataCandidate.setStrDateI(recordSet.getField(ParameterOrangeHRM.COLUMN_DATE));

                paramDataList.add(listDataCandidate);

                String msg = " | " + ParameterOrangeHRM.COLUMN_FIRTS_NAME + " = " + listDataCandidate.getStrFirstname() + " | " + ParameterOrangeHRM.COLUMN_MIDDLE_NAME + " = " + listDataCandidate.getStrMiddleName() +
                        " | " + ParameterOrangeHRM.COLUMN_LAST_NAME + " = " + listDataCandidate.getStrLastname() + " | " + ParameterOrangeHRM.COLUMN_VACANCY + " = " + listDataCandidate.getStrVacancy() +
                        " | " + ParameterOrangeHRM.COLUMN_EMAIL + " = " + listDataCandidate.getStrEmail() + " | ";
                LOGGER.info(msg);
                msg1.append('\n').append(i + 1).append(") ").append(msg);
                recordSet.next();
            }
            Serenity.recordReportData().withTitle(INFORMATION_IN_EXCEL).andContents(msg1.toString());
            actor.remember(Constants.INFORMATION_EXCEL.getValue(), paramDataList);

            recordSet.close();
            connection.close();
        } catch (FilloException e) {
            throw new IncorrectDataDrivenValues(IncorrectDataDrivenValues.MESSAGE_FAILED_LIST, e);
        }
    }

    public static CaptureInformationUnfiltered inExcel( ) {
        return Tasks.instrumented(CaptureInformationUnfiltered.class);
    }

}