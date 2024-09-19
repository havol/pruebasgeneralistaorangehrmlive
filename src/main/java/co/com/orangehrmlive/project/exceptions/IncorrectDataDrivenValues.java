package co.com.orangehrmlive.project.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class IncorrectDataDrivenValues extends SerenityManagedException {

    public static final String MESSAGE_FAILED_LIST = "No se pudo generar lista del recordSet en el archivo Excel.";

    public IncorrectDataDrivenValues(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }

}
