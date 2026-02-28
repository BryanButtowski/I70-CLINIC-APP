package backend;

import javax.swing.*;

import frontend.UserPanel;

import java.awt.*;

public class FieldValidator {

    private static final String SSN_PATTERN = "\\d{10}";
    private static final String NAME_PATTERN = "[a-zA-Z.'\\- ]{1,45}";
    private static final String LONG_NAME_PATTERN = "[a-zA-Z.'\\- ]{1,100}";
    private static final String DETAILS_PATTERN = "[a-zA-Z0-9.'\\- ]{1,30}";
    private static final String LONG_DETAILS_PATTERN = "[a-zA-Z0-9.'\\- ]{1,50}";
    private static final String PHONE_PATTERN = "[\\d+]{8,12}";
    private static final String ZIP_PATTERN = "\\d{4}";
    private static final String ADDRESS_PATTERN = "[a-zA-Z0-9.,'\\- ]{1,100}";

    private static boolean isValid(String strValue, String strPattern) {
        if (strValue != null && strValue.isEmpty()) {
            return true;
        }
        return strValue != null && strValue.matches(strPattern);
    }

    public static boolean isValidSSN(String strSSN) { 
    	return isValid(strSSN, SSN_PATTERN); 
    }
    public static boolean isValidName(String strName) { 
    	return isValid(strName, NAME_PATTERN); 
    }
    public static boolean isValidLongName(String strLongName) { 
    	return isValid(strLongName, LONG_NAME_PATTERN); 
    }
    public static boolean isValidDetails(String strDetails) { 
    	return isValid(strDetails, DETAILS_PATTERN); 
    }
    public static boolean isValidLongDetails(String strLongDetails) { 
    	return isValid(strLongDetails, LONG_DETAILS_PATTERN); 
    }
    public static boolean isValidPhone(String strPhone) { 
    	return isValid(strPhone, PHONE_PATTERN); 
    }
    public static boolean isValidZipCode(String strZip) { 
    	return isValid(strZip, ZIP_PATTERN); 
    }
    public static boolean isValidAddress(String strAddress) { 
    	return isValid(strAddress, ADDRESS_PATTERN); 
    }

    public static boolean isValidAge(String strAge) {
        try {
            int intAge = Integer.parseInt(strAge);
            return intAge >= 18 && intAge <= 65;
        } catch (NumberFormatException objEx) {
            return false;
        }
    }

    public static String validateAllFields(UserPanel userInput) {
        StringBuilder strbErrorFields = new StringBuilder();

        if (!isValidSSN(userInput.getTxtPatientSSN())) strbErrorFields.append("* Patient SSN (10 digits required)\n");
        if (!isValidName(userInput.getTxtPatientFirstName())) strbErrorFields.append("* Patient First Name (1-45 characters)\n");
        if (!isValidName(userInput.getTxtPatientLastName())) strbErrorFields.append("* Patient Last Name (1-45 characters)\n");
        if (!isValidName(userInput.getTxtPatientMiddleName())) strbErrorFields.append("* Patient Middle Name (1-45 characters)\n");
        if (!isValidDetails(userInput.getTxtPatientHonorifics())) strbErrorFields.append("* Patient Honorifics (1-30 characters)\n");
        if (!isValidAge(userInput.getTxtPatientAge())) strbErrorFields.append("* Patient Age (18-65)\n");

        if (!isValidPhone(userInput.getTxtPatientCPN())) strbErrorFields.append("* Cell Phone Number (8-12 digits)\n");
        if (!isValidPhone(userInput.getTxtPatientHPN())) strbErrorFields.append("* Home Phone Number (8-12 digits)\n");
        if (!isValidPhone(userInput.getTxtPatientWPN())) strbErrorFields.append("* Work Phone Number (8-12 digits)\n");

        if (!isValidAddress(userInput.getTxtPatientStreet())) strbErrorFields.append("* Street Address (1-100 characters)\n");
        if (!isValidAddress(userInput.getTxtPatientCity())) strbErrorFields.append("* City (1-100 characters)\n");
        if (!isValidAddress(userInput.getTxtPatientRegion())) strbErrorFields.append("* Region (1-100 characters)\n");
        if (!isValidAddress(userInput.getTxtPatientProvince())) strbErrorFields.append("* Province (1-100 characters)\n");
        if (!isValidZipCode(userInput.getTxtPatientZipCode())) strbErrorFields.append("* ZIP Code (4 digits)\n");

        if (!isValidDetails(userInput.getTxtPatientEthnicity())) strbErrorFields.append("* Ethnicity (1-30 characters)\n");
        if (!isValidDetails(userInput.getTxtPatientRace())) strbErrorFields.append("* Race (1-30 characters)\n");
        if (!isValidLongDetails(userInput.getTxtPatientOccupation())) strbErrorFields.append("* Occupation (1-50 characters)\n");
        if (!isValidLongDetails(userInput.getTxtPatientEmployer())) strbErrorFields.append("* Employer (1-50 characters)\n");
        if (!isValidPhone(userInput.getTxtPatientEmployerPN())) strbErrorFields.append("* Employer Phone Number (8-12 digits)\n");

        if (!isValidLongName(userInput.getTxtPatientECName())) strbErrorFields.append("* Emergency Contact Name (1-100 characters)\n");
        if (!isValidDetails(userInput.getTxtPatientToEC())) strbErrorFields.append("* Emergency Contact Relation (1-30 characters)\n");
        if (!isValidPhone(userInput.getTxtPatientECPhoneNumber())) strbErrorFields.append("* Emergency Contact Phone (8-12 digits)\n");

        if (!isValidLongName(userInput.getTxtResponsibleName())) strbErrorFields.append("* Responsible Party Name (1-100 characters)\n");
        if (!isValidAddress(userInput.getTxtResponsibleAddress())) strbErrorFields.append("* Responsible Party Address (1-100 characters)\n");
        if (!isValidPhone(userInput.getTxtResponsiblePhoneNumber())) strbErrorFields.append("* Responsible Party Phone (8-12 digits)\n");
        if (!isValidLongDetails(userInput.getTxtResponsibleOccupation())) strbErrorFields.append("* Responsible Party Occupation (1-50 characters)\n");
        if (!isValidLongDetails(userInput.getTxtResponsibleEmployer())) strbErrorFields.append("* Responsible Party Employer (1-50 characters)\n");
        if (!isValidAddress(userInput.getTxtResponsibleEmployerAddress())) strbErrorFields.append("* Responsible Party Employer Address (1-100 characters)\n");
        if (!isValidPhone(userInput.getTxtResponsibleEmployerPhoneNumber())) strbErrorFields.append("* Responsible Party Employer Phone (8-12 digits)\n");

        if (!isValidDetails(userInput.getTxtInsurance1Name())) strbErrorFields.append("* Primary Insurance Name (1-30 characters)\n");
        if (!isValidDetails(userInput.getTxtInsurance2Name())) strbErrorFields.append("* Secondary Insurance Name (1-30 characters)\n");
        if (!isValidSSN(userInput.getTxtSubscriber1SSN())) strbErrorFields.append("* Primary Subscriber SSN (10 digits)\n");
        if (!isValidSSN(userInput.getTxtSubscriber2SSN())) strbErrorFields.append("* Secondary Subscriber SSN (10 digits)\n");
        if (!isValidLongName(userInput.getTxtSubscriber1Name())) strbErrorFields.append("* Primary Subscriber Name (1-100 characters)\n");
        if (!isValidLongName(userInput.getTxtSubscriber2Name())) strbErrorFields.append("* Secondary Subscriber Name (1-100 characters)\n");
        if (!isValidLongDetails(userInput.getTxtSubscriber1Employer())) strbErrorFields.append("* Primary Subscriber Employer (1-50 characters)\n");
        if (!isValidLongDetails(userInput.getTxtSubscriber2Employer())) strbErrorFields.append("* Secondary Subscriber Employer (1-50 characters)\n");

        if (!isValidLongName(userInput.getTxtHIPAA1Name()) && !userInput.getTxtHIPAA1Name().equals("Cannot be changed")) strbErrorFields.append("* Primary HIPAA Contact Name (1-100 characters)\n");
        if (!isValidLongName(userInput.getTxtHIPAA2Name()) && !userInput.getTxtHIPAA2Name().equals("Cannot be changed")) strbErrorFields.append("* Secondary HIPAA Contact Name (1-100 characters)\n");
        if (!isValidDetails(userInput.getTxtHIPAA1Relation()) && !userInput.getTxtHIPAA1Relation().equals("Cannot be changed")) strbErrorFields.append("* Primary HIPAA Relation (1-30 characters)\n");
        if (!isValidDetails(userInput.getTxtHIPAA2Relation()) && !userInput.getTxtHIPAA2Relation().equals("Cannot be changed")) strbErrorFields.append("* Secondary HIPAA Relation (1-30 characters)\n");
        if (!isValidPhone(userInput.getTxtHIPAA1PhoneNumber()) && !userInput.getTxtHIPAA1PhoneNumber().equals("Cannot be changed")) strbErrorFields.append("* Primary HIPAA Phone Number (8-12 digits)\n");
        if (!isValidPhone(userInput.getTxtHIPAA2PhoneNumber()) && !userInput.getTxtHIPAA2PhoneNumber().equals("Cannot be changed")) strbErrorFields.append("* Secondary HIPAA Phone Number (8-12 digits)\n");

        return strbErrorFields.toString();
    }

    public static boolean validateAndShowErrors(UserPanel userInput) {
        String strErrors = validateAllFields(userInput);

        if (!strErrors.isEmpty()) {
            JTextArea textArea = new JTextArea(20, 30);
            textArea.setText("Validation errors in these fields:\n\n" + strErrors);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setCaretPosition(0);

            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(300, 100));

            JOptionPane.showMessageDialog(null, scrollPane, "Field Validation Results", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}