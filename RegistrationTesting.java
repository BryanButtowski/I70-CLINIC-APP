import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegistrationTesting {
    private Map<String, JTextField> dataMap = new LinkedHashMap<>();
    private JFrame frame;
    private boolean fieldsModified = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationTesting().initialize());
    }

    private void initialize() {
        frame = new JFrame("Patient Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        
        addPatientInformationFields(formPanel);
        addInsuranceInformationFields(formPanel);
        addBillHandlerFields(formPanel);
        
        JScrollPane scrollPane = new JScrollPane(formPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitAction());
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(submitButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addSectionLabel(JPanel panel, String sectionName) {
        JLabel sectionLabel = new JLabel(sectionName);
        sectionLabel.setFont(new Font("Arial", Font.BOLD, 14));
        sectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(sectionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    private void addFieldToPanel(JPanel panel, String labelText, JComponent field) {
        JPanel fieldPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fieldPanel.add(new JLabel(labelText));
        fieldPanel.add(field);
        fieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(fieldPanel);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
    }

    private void addPatientInformationFields(JPanel panel) {
        addSectionLabel(panel, "PATIENT INFORMATION");
        createAndMapField(panel, "patient_ssn", "Patient SSN:");
        createAndMapField(panel, "prev_physician", "Previous Physician:");
        createAndMapField(panel, "p_lastname", "Last Name:");
        createAndMapField(panel, "p_firstname", "First Name:");
        createAndMapField(panel, "p_middlename", "Middle Name:");
        createAndMapField(panel, "p_honorific", "Patient Honorifics:");
        createAndMapField(panel, "p_age", "Patient Age:");
        createAndMapField(panel, "p_gender", "Patient Gender:");
        createAndMapField(panel, "p_maritalstatus", "Patient Marital Status:");
        createAndMapField(panel, "p_homePN", "Home Phone Number:");
        createAndMapField(panel, "p_workPN", "Work Phone Number:");
        createAndMapField(panel, "p_cellPN", "Cell Phone Number:");
        createAndMapField(panel, "p_street_brgy", "Street and Barangay:");
        createAndMapField(panel, "p_city", "City:");
        createAndMapField(panel, "p_region", "Region:");
        createAndMapField(panel, "p_zipcode", "Zip Code:");
        createAndMapField(panel, "p_POBox", "P.O Box:");
        createAndMapField(panel, "p_province", "Province:");
        createAndMapField(panel, "p_ethnicity", "Ethnicity:");
        createAndMapField(panel, "p_race", "Race:");
        createAndMapField(panel, "p_occupation", "Occupation:");
        createAndMapField(panel, "p_employer", "Patient Employer:");
        createAndMapField(panel, "p_employer_PN", "Employer Phone Number:");
        createAndMapField(panel, "EC2P_relation", "Emergency Contact Relation:");
        createAndMapField(panel, "EC_name", "Emergency Contact Name:");
        createAndMapField(panel, "EC_PN", "Emergency Contact Phone Number:");
    }

    private void addInsuranceInformationFields(JPanel panel) {
        addSectionLabel(panel, "INSURANCE INFORMATION");
        createAndMapField(panel, "insurance_code", "Insurance Code:");
        createAndMapField(panel, "insurance_name", "Insurance Name:");
        createAndMapField(panel, "subscriber_ssn", "Subscriber SSN:");
        createAndMapField(panel, "S2P_relation", "Subscriber-Patient Relation:");
        createAndMapField(panel, "subscriber_name", "Subscriber Name:");
        createAndMapField(panel, "subscriber_birthdate", "Subscriber Birthdate (YYYY-MM-DD):");
        createAndMapField(panel, "subscriber_gender", "Subscriber Gender:");
        createAndMapField(panel, "subscriber_employer", "Subscriber Employer:");
        createAndMapField(panel, "HIPAA_name", "HIPAA Contact Name:");
        createAndMapField(panel, "HIPAA_PN", "HIPAA Contact Phone Number:");
        createAndMapField(panel, "HIPAA2P_relation", "HIPAA-Patient Relation:");
    }

    private void addBillHandlerFields(JPanel panel) {
        addSectionLabel(panel, "BILL HANDLER INFORMATION");
        createAndMapField(panel, "BH_name", "Bill Handler Name:");
        createAndMapField(panel, "BH_address", "Bill Handler Address:");
        createAndMapField(panel, "BH_PN", "Bill Handler Phone Number:");
        createAndMapField(panel, "BH_occupation", "Bill Handler Occupation:");
        createAndMapField(panel, "BH_employer", "Bill Handler Employer:");
        createAndMapField(panel, "BH_employerAddress", "Bill Handler Employer Address:");
        createAndMapField(panel, "BH_employerPN", "Bill Handler Employer Phone Number:");
    }

    private JTextField createAndMapField(JPanel panel, String fieldName, String labelText) {
        JTextField textField = new JTextField(20);
        addFieldToPanel(panel, labelText, textField);
        
        textField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { fieldModified(); }
            public void removeUpdate(DocumentEvent e) { fieldModified(); }
            public void changedUpdate(DocumentEvent e) { fieldModified(); }
            
            private void fieldModified() {
                fieldsModified = true;
                if (fieldName.equals("p_age")) {
                    validateAgeField(textField.getText());
                } else if (fieldName.equals("subscriber_birthdate")) {
                    validateDateField(textField.getText());
                }
            }
        });

        dataMap.put(fieldName, textField);
        return textField;
    }

    private void validateAgeField(String ageText) {
        try {
            if (!ageText.isEmpty()) {
                int age = Integer.parseInt(ageText);
                if (age < 0 || age > 120) {
                    showWarning("Please enter a valid age (0-120)", "Invalid Age");
                }
            }
        } catch (NumberFormatException e) {
            showWarning("Age must be a number", "Invalid Age");
        }
    }

    private void validateDateField(String dateText) {
        if (!dateText.isEmpty() && !dateText.matches("\\d{4}-\\d{2}-\\d{2}")) {
            showWarning("Date must be in YYYY-MM-DD format", "Invalid Date Format");
        }
    }

    private void showWarning(String message, String title) {
        JOptionPane.showMessageDialog(frame, message, title, JOptionPane.WARNING_MESSAGE);
    }

    private class SubmitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (!fieldsModified) {
                    JOptionPane.showMessageDialog(frame, 
                        "No changes detected to submit.",
                        "No Changes",
                        JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                int confirmation = JOptionPane.showConfirmDialog(
                    frame, 
                    "Are you sure you want to submit?", 
                    "Confirmation", 
                    JOptionPane.YES_NO_OPTION
                );

                if (confirmation == JOptionPane.YES_OPTION) {
                    saveToDB();
                    fieldsModified = false;
                    JOptionPane.showMessageDialog(
                        frame, 
                        "Patient data was successfully saved",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                    clearForm();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                    frame, 
                    "Error: " + ex.getMessage(),
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
                );
                ex.printStackTrace();
            }
        }
    }

    private void clearForm() {
        for (JTextField field : dataMap.values()) {
            field.setText("");
        }
    }

    private void saveToDB() throws SQLException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String connectionUrl = "jdbc:mysql://localhost:3306/MyDb";
        String username = "your_username";
        String password = "your_password";

        try { 
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(connectionUrl, username, password)) {
                StringBuilder sql = new StringBuilder("INSERT INTO patient_info (");
                StringBuilder values = new StringBuilder("VALUES (");
                
                boolean first = true;
                for (String fieldName : dataMap.keySet()) {
                    if (!first) {
                        sql.append(", ");
                        values.append(", ");
                    } 
                    sql.append(fieldName);
                    values.append("?");
                    first = false;
                }

                sql.append(") ").append(values).append(")");
            
                try (PreparedStatement stmt = conn.prepareStatement(sql.toString())) {
                    int i = 1;
                    for (JTextField field : dataMap.values()) {
                        String value = field.getText().trim();
                        stmt.setString(i++, value.isEmpty() ? null : value);
                    }
                    
                    int rowsAffected = stmt.executeUpdate();
                    if (rowsAffected == 0) {
                        throw new SQLException("No rows were inserted");
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            throw new SQLException("JDBC driver not found: " + driver, ex);
        }
    }
}