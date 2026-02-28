package backend;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import database.BillHandlerDAO;
import database.DatabaseConnection;
import database.HipaaDAO;
import database.InsuranceDAO;
import database.PatientDAO;
import database.SubscriberDAO;
import frontend.UserPanel;

public class ToDatabase {
	
    private final UserPanel objUserInput;

    private static final int NEW_PATIENT = 1;
    private static final int EXISTING_PATIENT = 2;

    public ToDatabase(UserPanel objUserInput) {
        this.objUserInput = objUserInput;
    }

    public boolean adminProcessChoice() {
    	
        if (!HelperMethods.isAdminPassCorrect()) return false;
        if (!HelperMethods.isSelectedViewRecord()) return false;
        return true;
    }

    public boolean userProcessChoice() {
    	
        try {
            if (!HelperMethods.userProcessChoice(objUserInput)) return false;

            if (objUserInput.getTxtPatientSSN().isEmpty()) {
                HelperMethods.setControllerState(NEW_PATIENT);
                HelperMethods.enableHIPAAFields(objUserInput);
                HelperMethods.clearTxtFields(objUserInput);
            } else {
                HelperMethods.setControllerState(EXISTING_PATIENT);
                HelperMethods.disableHIPAAFields(objUserInput);
                HelperMethods.setHIPAAFieldsDisabledValue(objUserInput);
            }

            processToDatabase1();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void saveToDatabase() {
    	
        boolean isSuccess = false;

        try {
            PatientDAO objPatientDAO = new PatientDAO(objUserInput);
            BillHandlerDAO objBillHandlerDAO = new BillHandlerDAO(objUserInput);
            HipaaDAO objHipaaDAO = new HipaaDAO(objUserInput);
            SubscriberDAO objSubscriberDAO = new SubscriberDAO(objUserInput);
            InsuranceDAO objInsuranceDAO = new InsuranceDAO(objUserInput);

            try (Connection objConn = DatabaseConnection.getConnection()) {
                objConn.setAutoCommit(false);

                try {
                    if (HelperMethods.getControllerState() == NEW_PATIENT) {
                        objPatientDAO.savePatientInfo();
                        objBillHandlerDAO.saveBillHandlerInfo();
                        objHipaaDAO.saveHipaaInfo();
                        objSubscriberDAO.saveSubscriberInfo();
                        objInsuranceDAO.saveInsuranceInfo();
                        
                    } else if (HelperMethods.getControllerState() == EXISTING_PATIENT) {
                        objPatientDAO.updatePatientInfo(objUserInput.getTxtPatientSSN());
                        objBillHandlerDAO.updateBillHandlerInfo(objUserInput.getTxtPatientSSN());
                        objSubscriberDAO.saveSubscriberInfo();
                        objInsuranceDAO.updateInsuranceInfo();
                    }

                    objConn.commit();
                    isSuccess = true;

                } catch (SQLException objSqlEx) {
                    objConn.rollback();
                    throw objSqlEx;
                } finally {
                    objConn.setAutoCommit(true);
                }
            }
        } catch (Exception objEx) {
            objEx.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error saving data: " + objEx.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }

        if (isSuccess) {
            JOptionPane.showMessageDialog(null,
                "Patient information was successfully saved to the database!",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean processToDatabase1() {
        System.out.println(HelperMethods.getControllerState());
        // HelperMethods.setTxtFields(objUserInput);
        return HelperMethods.checkMandatoryPage1(objUserInput);
    }

    public boolean processToDatabase2() {
        System.out.println(HelperMethods.getControllerState());

        if (!HelperMethods.checkMandatoryPage2(objUserInput)) return false;
        if (!FieldValidator.validateAndShowErrors(objUserInput)) return false;
        if (!HelperMethods.processToConfirmation()) return false;

        saveToDatabase();
        return true;
    }
}
