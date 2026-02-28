package backend;

import java.awt.Insets;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

import database.AdminCredentialChecker;
import database.DropPatientRecord;
import database.PatientSSNChecker;
import frontend.UserPanel;

public class HelperMethods {

    public static String getGender(JRadioButton rbtnMale, JRadioButton rbtnFemale) {
        return rbtnMale.isSelected() ? "Male" : "Female";
    }

    public static String getMaritalStatus(JComboBox<String> cmbPatientMaritalStatus) {
        return (String) cmbPatientMaritalStatus.getSelectedItem();
    }

    public static String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private static JTextArea createScrollableTextArea(String text, int rows, int cols) {
        JTextArea textArea = new JTextArea(text, rows, cols);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        return textArea;
    }

    public static void clearTxtFields(UserPanel objUserInput) {
        LocalDate currentDate = LocalDate.now();
        LocalDate date18YearsAgo = currentDate.minusYears(18);
        Date defaultDate = Date.from(date18YearsAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());

        objUserInput.setTxtPatientSSN("");
        objUserInput.setTxtPreviousPhysician("");
        objUserInput.setTxtPatientLastName("");
        objUserInput.setTxtPatientFirstName("");
        objUserInput.setTxtPatientMiddleName("");
        objUserInput.setDcPatientBirthdate(defaultDate);
        objUserInput.setTxtPatientAge("");
        objUserInput.setPatientGender("");
        objUserInput.setTxtPatientHonorifics("");
        objUserInput.setCbMaritalStatus("Single");
        objUserInput.setTxtPatientEthnicity("");
        objUserInput.setTxtPatientRace("");
        objUserInput.setTxtPatientCPN("");
        objUserInput.setTxtPatientHPN("");
        objUserInput.setTxtPatientWPN("");
        objUserInput.setTxtPatientPO("");
        objUserInput.setTxtPatientZipCode("");
        objUserInput.setTxtPatientStreet("");
        objUserInput.setTxtPatientCity("");
        objUserInput.setTxtPatientRegion("");
        objUserInput.setTxtPatientProvince("");
        objUserInput.setTxtPatientOccupation("");
        objUserInput.setTxtPatientEmployer("");
        objUserInput.setTxtPatientEmployerPN("");
        objUserInput.setTxtPatientECName("");
        objUserInput.setTxtPatientToEC("");
        objUserInput.setTxtPatientECPhoneNumber("");
        objUserInput.setTxtHIPAA1Name("");
        objUserInput.setTxtHIPAA1Relation("");
        objUserInput.setTxtHIPAA1PhoneNumber("");
        objUserInput.setTxtHIPAA2Name("");
        objUserInput.setTxtHIPAA2Relation("");
        objUserInput.setTxtHIPAA2PhoneNumber("");
        objUserInput.setTxtInsurance1Name("");
        objUserInput.setTxtSubscriber1Name("");
        objUserInput.setTxtSubscriber1SSN("");
        objUserInput.setDcSubscriber1Birthdate(defaultDate);
        objUserInput.setSubscriber1Gender("");
        objUserInput.setTxtSubscriber1Relation("");
        objUserInput.setTxtSubscriber1Employer("");
        objUserInput.setTxtInsurance2Name("");
        objUserInput.setTxtSubscriber2Name("");
        objUserInput.setTxtSubscriber2SSN("");
        objUserInput.setDcSubscriber2Birthdate(defaultDate);
        objUserInput.setSubscriber2Gender("");
        objUserInput.setTxtSubscriber2Relation("");
        objUserInput.setTxtSubscriber2Employer("");
        objUserInput.setTxtResponsibleName("");
        objUserInput.setDcResponsibleBirthdate(defaultDate);
        objUserInput.setTxtResponsibleAddress("");
        objUserInput.setTxtResponsiblePhoneNumber("");
        objUserInput.setTxtResponsibleOccupation("");
        objUserInput.setTxtResponsibleEmployer("");
        objUserInput.setTxtResponsibleEmployerAddress("");
        objUserInput.setTxtResponsibleEmployerPhoneNumber("");
    }

    public static boolean userProcessChoice(UserPanel objUserInput) throws SQLException {
        Object[] objOptions = {"New User", "Existing User"};
        int intChoice = JOptionPane.showOptionDialog(null, "Are you a new user or an existing user?", "User Selection",
                									 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                									 objOptions, objOptions[0]);

        if (intChoice == 0) {
            objUserInput.setTxtPatientSSN("");
            return true;
        }

        if (intChoice == 1) {
            int updateChoice = JOptionPane.showConfirmDialog(null, "Would you like to update your information?",
                    										 "Update Option", JOptionPane.YES_NO_OPTION);

            if (updateChoice != JOptionPane.YES_OPTION) {
                return false;
            }

            String strSSN = JOptionPane.showInputDialog(null, "Enter your unique 10-character Social Security number",
                    									"xxxxxxxxxx");

            if (strSSN == null || !PatientSSNChecker.isPatientSSNExists(strSSN)) {
                if (strSSN != null) {
                    JOptionPane.showMessageDialog(null, "Your SSN is not listed. Please proceed to registration.",
                            					  "Patient SSN Not Found", JOptionPane.WARNING_MESSAGE);
                }
                objUserInput.setTxtPatientSSN("");
                return false;
            }

            JOptionPane.showMessageDialog(null, "Proceeding to update your information...",
                    					  "Update Information", JOptionPane.INFORMATION_MESSAGE);
            objUserInput.setTxtPatientSSN(strSSN);
            return true;
        }
        return false;
    }

    public static boolean processToConfirmation() {
        String strCurrentDate = getCurrentDate();
        String strConsentText = "The above information is true to the best of my knowledge. I authorize my insurance " +
                "benefits be paid directly to the clinic. I understand that I am financially " +
                "responsible for any balance due.\n\n" +
                "Current Date: " + strCurrentDate + "\n\n" +
                "Do you agree to these terms?";

        JTextArea txtConsent = createScrollableTextArea(strConsentText, 10, 30);
        int intResponse = JOptionPane.showOptionDialog(null, new JScrollPane(txtConsent),"Consent Form", 
        										 	   JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        										 	   null, new Object[]{"I Agree", "I Disagree"}, "I Agree");

        if (intResponse == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for agreeing to the terms.",
                    					  "Consent Confirmed", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        JOptionPane.showMessageDialog(null, "You must agree to the terms to proceed.",
                					  "Consent Required", JOptionPane.WARNING_MESSAGE);
        return false;
    }

    public static void disableHIPAAFields(UserPanel objUserInput) {
        objUserInput.setHIPAAFieldsState(false);
    }

    public static void enableHIPAAFields(UserPanel objUserInput) {
        objUserInput.setHIPAAFieldsState(true);
    }

    public static void setHIPAAFieldsDisabledValue(UserPanel objUserInput) {
        objUserInput.setTxtHIPAA1Name("Cannot be changed");
        objUserInput.setTxtHIPAA1Relation("Cannot be changed");
        objUserInput.setTxtHIPAA1PhoneNumber("Cannot be changed");
        objUserInput.setTxtHIPAA2Name("Cannot be changed");
        objUserInput.setTxtHIPAA2Relation("Cannot be changed");
        objUserInput.setTxtHIPAA2PhoneNumber("Cannot be changed");
    }

    private static int intController = 0;

    public static void setControllerState(int intState) {
        intController = intState;
    }

    public static int getControllerState() {
        return intController;
    }

    public static boolean checkMandatoryPage1(UserPanel objUserInput) {
        if (objUserInput == null) return false;

        ArrayList<String> arrMandatory = new ArrayList<>();
        arrMandatory.add(objUserInput.getTxtPatientSSN());
        arrMandatory.add(objUserInput.getTxtPatientLastName());
        arrMandatory.add(objUserInput.getTxtPatientFirstName());
        arrMandatory.add(objUserInput.getTxtPatientBirthdate());
        arrMandatory.add(objUserInput.getTxtPatientAge());
        arrMandatory.add(objUserInput.getTxtPatientGender());
        arrMandatory.add(objUserInput.getTxtPatientHonorifics());
        arrMandatory.add(objUserInput.getPatientMaritalStatus());
        arrMandatory.add(objUserInput.getTxtPatientRace());
        arrMandatory.add(objUserInput.getTxtPatientCPN());
        arrMandatory.add(objUserInput.getTxtPatientZipCode());
        arrMandatory.add(objUserInput.getTxtPatientStreet());
        arrMandatory.add(objUserInput.getTxtPatientCity());
        arrMandatory.add(objUserInput.getTxtPatientRegion());
        arrMandatory.add(objUserInput.getTxtPatientProvince());
        arrMandatory.add(objUserInput.getTxtPatientOccupation());
        arrMandatory.add(objUserInput.getTxtPatientEmployer());
        arrMandatory.add(objUserInput.getTxtPatientEmployerPN());
        arrMandatory.add(objUserInput.getTxtPatientECName());
        arrMandatory.add(objUserInput.getTxtPatientToEC());
        arrMandatory.add(objUserInput.getTxtPatientECPhoneNumber());
        arrMandatory.add(objUserInput.getTxtHIPAA1Name());
        arrMandatory.add(objUserInput.getTxtHIPAA1Relation());
        arrMandatory.add(objUserInput.getTxtHIPAA1PhoneNumber());
        arrMandatory.add(objUserInput.getTxtHIPAA2Name());
        arrMandatory.add(objUserInput.getTxtHIPAA2Relation());
        arrMandatory.add(objUserInput.getTxtHIPAA2PhoneNumber());

        return validateMandatoryFields(arrMandatory, "Please complete all required fields (*) to continue");
    }

    public static boolean checkMandatoryPage2(UserPanel objUserInput) {
        if (objUserInput == null) {
        	return false;
        }

        ArrayList<String> arrMandatory = new ArrayList<>();
        arrMandatory.add(objUserInput.getTxtInsurance1Name());
        arrMandatory.add(objUserInput.getTxtSubscriber1Name());
        arrMandatory.add(objUserInput.getTxtSubscriber1SSN());
        arrMandatory.add(objUserInput.getDcSubscriber1Birthdate());
        arrMandatory.add(objUserInput.getSubscriber1Gender());
        arrMandatory.add(objUserInput.getTxtSubscriber1Relation());
        arrMandatory.add(objUserInput.getTxtInsurance2Name());
        arrMandatory.add(objUserInput.getTxtSubscriber2Name());
        arrMandatory.add(objUserInput.getTxtSubscriber2SSN());
        arrMandatory.add(objUserInput.getDcSubscriber2Birthdate());
        arrMandatory.add(objUserInput.getSubscriber2Gender());
        arrMandatory.add(objUserInput.getTxtSubscriber2Relation());
        arrMandatory.add(objUserInput.getTxtResponsibleName());
        arrMandatory.add(objUserInput.getDcResponsibleBirthdate());
        arrMandatory.add(objUserInput.getTxtResponsibleAddress());
        arrMandatory.add(objUserInput.getTxtResponsiblePhoneNumber());
        arrMandatory.add(objUserInput.getTxtResponsibleOccupation());

        return validateMandatoryFields(arrMandatory, "Please complete all required fields (*) to submit");
    }

    private static boolean validateMandatoryFields(ArrayList<String> fields, String errorMessage) {
        for (String strField : fields) {
            if (strField == null || strField.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMessage, "Note for Incomplete Information", 
                							  JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public static boolean isAdminPassCorrect() {
        JPasswordField passwordField = new JPasswordField();
        int intOption = JOptionPane.showConfirmDialog(null, passwordField, "Enter admin password",
                									  JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (intOption != JOptionPane.OK_OPTION) {
            return false;
        }

        String strPassword = new String(passwordField.getPassword());

        try {
            if (!AdminCredentialChecker.isAdminPasswordExists(strPassword)) {
                JOptionPane.showMessageDialog(null, "Your admin password is wrong!",
                        					  "Please try again", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException objSqlEx) {
            objSqlEx.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isSelectedViewRecord() {
        while (true) {
            Object[] objOptions = {"View Patient Record", "Delete Patient Record"};
            int intChoice = JOptionPane.showOptionDialog(null, "Please select activity", "Admin Selection",
                    									 JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    									 null, objOptions, objOptions[0]);

            if (intChoice != 1 && intChoice != 0) {
                break;
            }

            if (intChoice == 0) {
                return true;
            }

            if (intChoice == 1) {
                deletePatientRecord();
            }
        }
        return false;
    }

    public static void deletePatientRecord() {
        String strSSN = JOptionPane.showInputDialog(null, "Enter unique 10-character Social Security number to delete",
                									"xxxxxxxxxx");
        if (strSSN == null || strSSN.trim().isEmpty()) {
            return;
        }

        try {
            boolean boolIsDeleted = DropPatientRecord.deletePatientRecord(strSSN.trim());
            if (boolIsDeleted) {
                JOptionPane.showMessageDialog(null, "Patient record successfully deleted from the database!",
                        					  "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Patient SSN not found!",
                        					  "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException objSqlEx) {
            objSqlEx.printStackTrace();
        }
    }
    
    /*
    public static void setTxtFields(UserPanel userInput) {
        // Personal Information
        userInput.setTxtPatientSSN("0234567891");
        userInput.setTxtPreviousPhysician("Dr. Juan Dela Cruz");
        userInput.setTxtPatientLastName("Santos");
        userInput.setTxtPatientFirstName("Maria");
        userInput.setTxtPatientMiddleName("Reyes");
        userInput.setTxtPatientAge("33");
        userInput.setPatientGender("Female");
        userInput.setTxtPatientHonorifics("Ms");
        userInput.setCbMaritalStatus("Single");
        userInput.setTxtPatientEthnicity("Tagalog");
        userInput.setTxtPatientRace("Filipino");
        
        // Contact Information
        userInput.setTxtPatientCPN("09171234567");
        userInput.setTxtPatientHPN("0281234567");
        userInput.setTxtPatientWPN("");
        userInput.setTxtPatientPO("");
        
        // Address Information
        userInput.setTxtPatientZipCode("1600");
        userInput.setTxtPatientStreet("123 Banawe Street");
        userInput.setTxtPatientCity("Quezon City");
        userInput.setTxtPatientRegion("NCR");
        userInput.setTxtPatientProvince("Metro Manila");
        
        // Employment Information
        userInput.setTxtPatientOccupation("Software Developer");
        userInput.setTxtPatientEmployer("ABC Technologies Inc");
        userInput.setTxtPatientEmployerPN("0287654321");
        
        // Emergency Contacts (now including aunts)
        userInput.setTxtPatientECName("Roberto Santos");
        userInput.setTxtPatientToEC("Father");
        userInput.setTxtPatientECPhoneNumber("09178889999");
        
        // Insurance Information
        userInput.setTxtInsurance1Name("PhilHealth");
        userInput.setTxtSubscriber1Name("Maria Reyes Santos");
        userInput.setTxtSubscriber1SSN("0234567891");
        userInput.setSubscriber1Gender("Female");
        userInput.setTxtSubscriber1Relation("Self");
        userInput.setTxtSubscriber1Employer("ABC Technologies Inc");
        
        userInput.setTxtInsurance2Name("Maxicare");
        userInput.setTxtSubscriber2Name("Carmen Reyes");
        userInput.setTxtSubscriber2SSN("9876543210");
        userInput.setSubscriber2Gender("Female");
        userInput.setTxtSubscriber2Relation("Mother");
        userInput.setTxtSubscriber2Employer("DEF Corporation");
        
        // Responsible Party Information
        userInput.setTxtResponsibleName("Dong Reyes");
        userInput.setTxtResponsibleAddress("423 Anonas, Quezon City");
        userInput.setTxtResponsiblePhoneNumber("09175556666");
        userInput.setTxtResponsibleOccupation("Doctor");
        userInput.setTxtResponsibleEmployer("Manila General Hospital");
        userInput.setTxtResponsibleEmployerAddress("Ermita, Manila");
        userInput.setTxtResponsibleEmployerPhoneNumber("0252367890");
    } */
}