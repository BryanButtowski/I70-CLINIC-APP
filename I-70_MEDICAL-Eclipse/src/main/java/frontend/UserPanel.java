package frontend;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import backend.HelperMethods;
import backend.ToDatabase;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	public UserPanel(CardLayout cardLayout, JPanel pnlPageSwitch) {
		UserPagesPanel(cardLayout, pnlPageSwitch);
	}
	
		private JTextField txtPatientSSN;
	    private JTextField txtPreviousPhysician;
	    private JTextField txtPatientLastName;
	    private JTextField txtPatientFirstName;
	    private JTextField txtPatientMiddleName;
	    private com.toedter.calendar.JDateChooser txtPatientBirthdate;
	    private JTextField txtPatientAge;
	    private ButtonGroup rbtnPatientGender;
	    private JRadioButton rbtnPatientMale;
	    private JRadioButton rbtnPatientFemale;
	    private JTextField txtPatientHonorifics;
	    private JComboBox<String> cmbPatientMaritalStatus;
	    private JTextField txtEthnicity;
	    private JTextField txtPatientRace;
	    private JTextField txtPatientCPN;
	    private JTextField txtPatientHPN;
	    private JTextField txtPatientWPN;
	    private JTextField txtPatientPO;
	    private JTextField txtPatientZipCode;
	    private JTextField txtPatientStreet;
	    private JTextField txtPatientCity;
	    private JTextField txtPatientRegion;
	    private JTextField txtPatientProvince;
	    private JTextField txtPatientOccupation;
	    private JTextField txtPatientEmployer;
	    private JTextField txtPatientEmployerPN;
	    private JTextField txtPatientECName;
	    private JTextField txtPatientToEC;
	    private JTextField txtPatientECPhoneNumber;
	    private JTextField txtHIPAA1Name;
	    private JTextField txtHIPAA1Relation;
	    private JTextField txtHIPAA1PhoneNumber;
	    private JTextField txtHIPAA2Name;
	    private JTextField txtHIPAA2Relation;
	    private JTextField txtHIPAA2PhoneNumber;
	   
	    private JTextField txtInsurance1Name;
	    private JTextField txtSubscriber1Name;
	    private JTextField txtSubscriber1SSN;
	    private com.toedter.calendar.JDateChooser dcSubscriber1Birthdate;
	    private JRadioButton rbtnSubscriber1Male;
	    private JRadioButton rbtnSubscriber1Female;
	    private JTextField txtSubscriber1Relation;
	    private JTextField txtSubscriber1Employer;
	    private JTextField txtInsurance2Name;
	    private JTextField txtSubscriber2Name;
	    private JTextField txtSubscriber2SSN;
	    private com.toedter.calendar.JDateChooser dcSubscriber2Birthdate;
	    private JRadioButton rbtnSubscriber2Male;
	    private JRadioButton rbtnSubscriber2Female;
	    private JTextField txtSubscriber2Relation;
	    private JTextField txtSubscriber2Employer;
	    
	    private JTextField txtResponsibleName;
	    private com.toedter.calendar.JDateChooser dcResponsibleBirthdate;
	    private JTextField txtResponsibleAddress;
	    private JTextField txtResponsiblePhoneNumber;
	    private JTextField txtResponsibleOccupation;
	    private JTextField txtResponsibleEmployer;
	    private JTextField txtResponsibleEmployerAddress;
	    private JTextField txtResponsibleEmployerPhoneNumber;
	    
        public JPanel pnlUserPage1 = new JPanel();
        public JPanel pnlUserPage2 = new JPanel();

	
	public void UserPagesPanel(CardLayout cardLayout, JPanel pnlPageSwitch) {
		pnlUserPage1.setLayout(new java.awt.BorderLayout());
    	GridBagConstraints gridBagConstraints = new GridBagConstraints();
    	
    	UIHelperMethods.addHeader(pnlUserPage1, "Registration", 1);
        
        JPanel pnlContentUserPage1 = new JPanel();
        pnlContentUserPage1.setLayout(new java.awt.GridBagLayout());
        
        JPanel pnlPatientInfo = new JPanel();
        pnlPatientInfo.setBackground(new java.awt.Color(216, 220, 235));
        pnlPatientInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 0, 0, 0, new java.awt.Color(104, 120, 208)));
        pnlPatientInfo.setForeground(new java.awt.Color(0, 0, 255));
        
        JLabel lblPatientInfo = new JLabel("PATIENT INFORMATION");
        lblPatientInfo.setFont(new java.awt.Font("Arial", 1, 36));  
        
        JLabel lblPatientSSN = new JLabel("Patient's SSN *");
        lblPatientSSN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientSSN.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientSSN = new JTextField();
        
        JLabel lblPreviousPhysician1 = new JLabel("Previous Physician");
        lblPreviousPhysician1.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPreviousPhysician1.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPreviousPhysician = new JTextField();
        
        JLabel lblPatientLastName = new JLabel("Last Name *");
        lblPatientLastName.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientLastName.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientLastName = new JTextField();
        
        JLabel lblPatientFirstName = new JLabel("First Name *");
        lblPatientFirstName.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientFirstName.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientFirstName = new JTextField();
        
        JLabel lblPatientMiddleName = new JLabel("Middle Name");
        lblPatientMiddleName.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientMiddleName.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientMiddleName = new JTextField();
     
        JLabel lblPatientBirthdate = new JLabel("Birthdate *");
        lblPatientBirthdate.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientBirthdate.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientBirthdate = new com.toedter.calendar.JDateChooser();
        
        JLabel lblPatientAge = new JLabel("Age *");
        lblPatientAge.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientAge.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientAge = new JTextField();
        
        JLabel lblPatientGender = new JLabel("Gender *");
        lblPatientGender.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientGender.setForeground(new java.awt.Color(123, 130, 145));
        
        rbtnPatientGender = new javax.swing.ButtonGroup();
        
        rbtnPatientMale = new JRadioButton();
        rbtnPatientGender.add(rbtnPatientMale);
        rbtnPatientMale.setFont(new java.awt.Font("Arial", 1, 14));  
        rbtnPatientMale.setForeground(new java.awt.Color(123, 130, 145));
        rbtnPatientMale.setText("Male");
        
        rbtnPatientFemale = new JRadioButton();
        rbtnPatientGender.add(rbtnPatientFemale);
        rbtnPatientFemale.setFont(new java.awt.Font("Arial", 1, 14));  
        rbtnPatientFemale.setForeground(new java.awt.Color(123, 130, 145));
        rbtnPatientFemale.setText("Female");
        
        JLabel lblPatientHonorifics = new JLabel("Honorifics *");
        lblPatientHonorifics.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientHonorifics.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientHonorifics = new JTextField();
        
        JLabel lblPatientMaritalStatus = new JLabel("Marital Status *");
        lblPatientMaritalStatus.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientMaritalStatus.setForeground(new java.awt.Color(123, 130, 145));
        
        cmbPatientMaritalStatus = new JComboBox<>();
        cmbPatientMaritalStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Divorced", "Widowed", "Separated", "Annulled" }));
        cmbPatientMaritalStatus.setPreferredSize(new java.awt.Dimension(88, 15));
 
        JLabel lblPatientEthnicity = new JLabel("Ethnicity");
        lblPatientEthnicity.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientEthnicity.setForeground(new java.awt.Color(123, 130, 145));
        
        txtEthnicity = new JTextField();
        
        JLabel lblPatientRace = new JLabel();
        lblPatientRace.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientRace.setForeground(new java.awt.Color(123, 130, 145));
        lblPatientRace.setText("Race *");
        
        txtPatientRace = new JTextField();
        
        JLabel lblPatientCPN = new JLabel("Cell Phone Number *");
        lblPatientCPN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientCPN.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientCPN = new JTextField();
        
        JLabel lblPatientHPN = new JLabel("Home Phone Number");
        lblPatientHPN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientHPN.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientHPN = new JTextField();
        
        JLabel lblPatientWPN = new JLabel("Work Phone Number");
        lblPatientWPN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientWPN.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientWPN = new JTextField();
        
        JLabel lblPatientPO = new JLabel("Post Office Box");
        lblPatientPO.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientPO.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientPO = new JTextField();
        
        JLabel lblPatientZipCode = new JLabel("Zip Code *");
        lblPatientZipCode.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientZipCode.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientZipCode = new JTextField();
        
        JLabel lblPatientStreet = new JLabel("Street/Barangay *");
        lblPatientStreet.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientStreet.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientStreet = new JTextField();
        
        JLabel lblPatientCity = new JLabel("City *");
        lblPatientCity.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientCity.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientCity = new JTextField();

        JLabel lblPatientRegion = new JLabel("Region *");
        lblPatientRegion.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientRegion.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientRegion = new JTextField();
        
        JLabel lblPatientProvince = new JLabel("Province *");
        lblPatientProvince.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientProvince.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientProvince = new JTextField();
        
        JLabel lblPatientOccupation = new JLabel("Occupation *");
        lblPatientOccupation.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientOccupation.setForeground(new java.awt.Color(123, 130, 145));

        txtPatientOccupation = new JTextField();

        JLabel lblPatientEmployer = new JLabel("Employer *");
        lblPatientEmployer.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientEmployer.setForeground(new java.awt.Color(123, 130, 145));

        txtPatientEmployer = new JTextField();

        JLabel lblPatientEmployerPN = new JLabel("Employer Phone Number *");
        lblPatientEmployerPN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientEmployerPN.setForeground(new java.awt.Color(123, 130, 145));

        txtPatientEmployerPN = new JTextField();

        JLabel lblPatientECName = new JLabel("Emergency Contact Name *");
        lblPatientECName.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientECName.setForeground(new java.awt.Color(123, 130, 145));

        txtPatientECName = new JTextField();

        JLabel lblPatientToEC = new JLabel("Relationship to E.C *");
        lblPatientToEC.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientToEC.setForeground(new java.awt.Color(123, 130, 145));

        txtPatientToEC = new JTextField();

        JLabel lblPatientECPhoneNumber = new JLabel("E.C Phone Number *");
        lblPatientECPhoneNumber.setFont(new java.awt.Font("Arial", 0, 20));  
        lblPatientECPhoneNumber.setForeground(new java.awt.Color(123, 130, 145));
        
        txtPatientECPhoneNumber = new JTextField();
        
        /** NOTE: The following layout code was auto-generated by NetBeans GUI Builder (drag-and-drop interface).
            As a result, it may appear verbose or complex. Manual edits should be made with caution.
            The use of drag-and-drop tools was consented by Prof. Alexis Libunao and Prof. Monina Barretto **/

        javax.swing.GroupLayout pnlPatientInfoLayout = new javax.swing.GroupLayout(pnlPatientInfo);
        pnlPatientInfo.setLayout(pnlPatientInfoLayout);
        pnlPatientInfoLayout.setHorizontalGroup(
            pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatientPO, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtPatientWPN, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtPatientCPN, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtPatientHPN, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(lblPatientCPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPatientRace)
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPatientHPN, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPatientWPN)
                                    .addComponent(lblPatientPO)
                                    .addComponent(lblPatientHonorifics))
                                .addGap(0, 24, Short.MAX_VALUE))
                            .addComponent(txtPatientHonorifics)))
                    .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                        .addComponent(lblPatientInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPatientSSN)
                            .addComponent(lblPatientGender)
                            .addComponent(lblPatientAge)
                            .addComponent(lblPreviousPhysician1)
                            .addComponent(lblPatientLastName)
                            .addComponent(lblPatientFirstName)
                            .addComponent(lblPatientMiddleName)
                            .addComponent(lblPatientBirthdate)
                            .addComponent(txtPatientAge, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(txtPatientMiddleName)
                            .addComponent(txtPatientFirstName)
                            .addComponent(txtPatientLastName)
                            .addComponent(txtPreviousPhysician)
                            .addComponent(txtPatientSSN)
                            .addComponent(txtPatientBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rbtnPatientMale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(rbtnPatientFemale)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbPatientMaritalStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEthnicity)
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPatientEthnicity)
                                    .addComponent(lblPatientMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPatientRace, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPatientCity, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientEmployerPN, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPatientEmployerPN, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPatientRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPatientRegion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(lblPatientZipCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientEmployer, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatientOccupation, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatientProvince, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatientStreet, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatientZipCode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatientStreet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientCity, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPatientToEC, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPatientECName)
                                    .addComponent(txtPatientECName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPatientECPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPatientToEC, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPatientECPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(12, 12, 12))
        );
        pnlPatientInfoLayout.setVerticalGroup(
            pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientInfoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblPatientInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblPatientSSN)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblPatientECName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientHonorifics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPreviousPhysician1)
                            .addComponent(lblPatientMaritalStatus))
                        .addGap(6, 6, 6)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPreviousPhysician, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPatientMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientLastName)
                            .addComponent(lblPatientEthnicity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEthnicity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientFirstName)
                            .addComponent(lblPatientRace)
                            .addComponent(lblPatientRegion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientRace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientMiddleName)
                            .addComponent(lblPatientCPN)
                            .addComponent(lblPatientProvince))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientCPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientBirthdate)
                            .addComponent(lblPatientHPN)
                            .addComponent(lblPatientOccupation))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPatientHPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPatientOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPatientBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientAge)
                            .addComponent(lblPatientWPN)
                            .addComponent(lblPatientEmployer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientWPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPatientGender)
                            .addComponent(lblPatientPO)
                            .addComponent(lblPatientEmployerPN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPatientPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPatientEmployerPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbtnPatientMale)
                            .addComponent(rbtnPatientFemale))
                        .addGap(15, 15, 15))
                    .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                        .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblPatientZipCode)
                                .addGap(6, 6, 6)
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPatientZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPatientECName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPatientStreet)
                                    .addComponent(lblPatientToEC))
                                .addGap(6, 6, 6)
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPatientStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPatientToEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPatientCity)
                                    .addComponent(lblPatientECPhoneNumber))
                                .addGap(29, 29, 29))
                            .addGroup(pnlPatientInfoLayout.createSequentialGroup()
                                .addComponent(lblPatientHonorifics)
                                .addGap(125, 125, 125)
                                .addComponent(txtPatientECPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnlPatientInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbPatientMaritalStatus, lblPatientLastName});

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        pnlContentUserPage1.add(pnlPatientInfo, gridBagConstraints);
        
        JPanel pnlUserPage1Spacer = new JPanel();
        pnlUserPage1Spacer.setOpaque(false);
        pnlUserPage1Spacer.setPreferredSize(new java.awt.Dimension(50, 100));

        javax.swing.GroupLayout pnlUserPage1SpacerLayout = new javax.swing.GroupLayout(pnlUserPage1Spacer);
        pnlUserPage1Spacer.setLayout(pnlUserPage1SpacerLayout);
        pnlUserPage1SpacerLayout.setHorizontalGroup(
            pnlUserPage1SpacerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlUserPage1SpacerLayout.setVerticalGroup(
            pnlUserPage1SpacerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        pnlContentUserPage1.add(pnlUserPage1Spacer, gridBagConstraints);
        
        JPanel pnlHIPAA = new JPanel();
        pnlHIPAA.setBackground(new java.awt.Color(216, 220, 235));
        pnlHIPAA.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 0, 0, 0, new java.awt.Color(104, 120, 208)));
        
        JLabel lblHIPAA = new JLabel("HIPAA");
        lblHIPAA.setFont(new java.awt.Font("Arial", 1, 36));  
        
        JLabel lblInformation = new JLabel("INFORMATION");
        lblInformation.setFont(new java.awt.Font("Arial", 1, 36));  
        
        JLabel lblHIPAA1Name = new JLabel("HIPAA #1 Name *");
        lblHIPAA1Name.setFont(new java.awt.Font("Arial", 0, 20));  
        lblHIPAA1Name.setForeground(new java.awt.Color(123, 130, 145));
        
        txtHIPAA1Name = new JTextField();
        
        JLabel lblHIPAA1Relation = new JLabel("Relationship to Patient *");
        lblHIPAA1Relation.setFont(new java.awt.Font("Arial", 0, 20));  
        lblHIPAA1Relation.setForeground(new java.awt.Color(123, 130, 145));
        
        txtHIPAA1Relation = new JTextField();
        
        JLabel lblHIPAA1PhoneNumber = new JLabel("HIPAA Phone Number *");
        lblHIPAA1PhoneNumber.setFont(new java.awt.Font("Arial", 0, 20));  
        lblHIPAA1PhoneNumber.setForeground(new java.awt.Color(123, 130, 145));
        
        txtHIPAA1PhoneNumber = new JTextField();
        
        JLabel lblHIPAA2Name = new JLabel("HIPAA #2 Name *");
        lblHIPAA2Name.setFont(new java.awt.Font("Arial", 0, 20));  
        lblHIPAA2Name.setForeground(new java.awt.Color(123, 130, 145));
        
        txtHIPAA2Name = new JTextField();
        
        JLabel lblHIPAA2Relation = new JLabel("Relationship to Patient *");
        lblHIPAA2Relation.setFont(new java.awt.Font("Arial", 0, 20));  
        lblHIPAA2Relation.setForeground(new java.awt.Color(123, 130, 145));
        
        txtHIPAA2Relation = new JTextField();
        
        JLabel lblHIPAA2PhoneNumber = new JLabel("HIPAA Phone Number *");
        lblHIPAA2PhoneNumber.setFont(new java.awt.Font("Arial", 0, 20));  
        lblHIPAA2PhoneNumber.setForeground(new java.awt.Color(123, 130, 145));
        
        txtHIPAA2PhoneNumber = new JTextField();

        javax.swing.GroupLayout pnlHIPAALayout = new javax.swing.GroupLayout(pnlHIPAA);
        pnlHIPAA.setLayout(pnlHIPAALayout);
        pnlHIPAALayout.setHorizontalGroup(
            pnlHIPAALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHIPAALayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(pnlHIPAALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHIPAA2PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHIPAA2Relation)
                    .addComponent(lblInformation)
                    .addComponent(lblHIPAA, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHIPAA1Relation, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHIPAA1Relation)
                    .addGroup(pnlHIPAALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblHIPAA1Name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHIPAA1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHIPAA1PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHIPAA1PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHIPAA2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlHIPAALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtHIPAA2Relation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                        .addComponent(txtHIPAA2Name, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtHIPAA2PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        pnlHIPAALayout.setVerticalGroup(
            pnlHIPAALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHIPAALayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblHIPAA)
                .addGap(4, 4, 4)
                .addComponent(lblInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHIPAA1Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHIPAA1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHIPAA1Relation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHIPAA1Relation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHIPAA1PhoneNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHIPAA1PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHIPAA2Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHIPAA2Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHIPAA2Relation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHIPAA2Relation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHIPAA2PhoneNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHIPAA2PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(86, 86, 86))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        pnlContentUserPage1.add(pnlHIPAA, gridBagConstraints);
        
        JButton btnNext = new JButton();
        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/6_nextbutton.png"))); 
        btnNext.setContentAreaFilled(false);
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNext.setPreferredSize(new java.awt.Dimension(80, 47));
        
        btnNext.addActionListener(e -> {
            ToDatabase objPassedVal = new ToDatabase(UserPanel.this);	
            if (objPassedVal.processToDatabase1()) {  	
                cardLayout.show(pnlPageSwitch, "pnlUserPage2");
            } else {
                cardLayout.show(pnlPageSwitch, "pnlUserPage1");
            }
        });
        
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        pnlContentUserPage1.add(btnNext, gridBagConstraints);
        
        JButton btnUserPageHome = new JButton();
        btnUserPageHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/9_home.png")));  
        btnUserPageHome.setToolTipText("");
        btnUserPageHome.setContentAreaFilled(false);
        btnUserPageHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserPageHome.addActionListener(evt -> {
        	HelperMethods.clearTxtFields(this);
        	cardLayout.show(pnlPageSwitch, "pnlHome");
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        pnlContentUserPage1.add(btnUserPageHome, gridBagConstraints);

        pnlUserPage1.add(pnlContentUserPage1, java.awt.BorderLayout.CENTER);
  		
        // user page 2
        pnlUserPage2.setLayout(new java.awt.BorderLayout());
    	
    	UIHelperMethods.addHeader(pnlUserPage2, "Registration", 2);
    	
        JPanel pnlContentUserPage2 = new JPanel();
        pnlContentUserPage2.setPreferredSize(new java.awt.Dimension(1233, 200));
        pnlContentUserPage2.setLayout(new java.awt.GridBagLayout());
        
        JButton btnBack = new JButton();
        btnBack.setBackground(new java.awt.Color(98, 113, 204));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 24));  
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/7_backbutton.png")));  
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setPreferredSize(new java.awt.Dimension(80, 50));
        btnBack.addActionListener(evt -> cardLayout.show(pnlPageSwitch, "pnlUserPage1"));
        
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        pnlContentUserPage2.add(btnBack, gridBagConstraints);
        
        JPanel pnlInsuranceInformation = new JPanel();
        pnlInsuranceInformation.setBackground(new java.awt.Color(216, 220, 235));
        pnlInsuranceInformation.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 0, 0, 0, new java.awt.Color(104, 120, 208)));
        pnlInsuranceInformation.setForeground(new java.awt.Color(0, 0, 255));
        
        JLabel lblInsuranceInformation = new JLabel("INSURANCE INFORMATION");
        lblInsuranceInformation.setFont(new java.awt.Font("Arial", 1, 36));  

        JLabel lblPrimaryInsurance = new JLabel("Primary Insurance");
        lblPrimaryInsurance.setBackground(new java.awt.Color(243, 245, 249));
        lblPrimaryInsurance.setFont(new java.awt.Font("Arial", 2, 14));  
        lblPrimaryInsurance.setForeground(new java.awt.Color(123, 130, 145));
        lblPrimaryInsurance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrimaryInsurance.setOpaque(true);

        JLabel lblInsurance1Name = new JLabel("Insurance Name *");
        lblInsurance1Name.setFont(new java.awt.Font("Arial", 0, 20));  
        lblInsurance1Name.setForeground(new java.awt.Color(123, 130, 145));

        txtInsurance1Name = new JTextField();

        JLabel lblSubscriber1Name = new JLabel("Subscriber's Name *");
        lblSubscriber1Name.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber1Name.setForeground(new java.awt.Color(123, 130, 145));

        txtSubscriber1Name = new JTextField();

        JLabel lblSubscriber1SSN = new JLabel("Subscriber's SSN *");
        lblSubscriber1SSN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber1SSN.setForeground(new java.awt.Color(123, 130, 145));

        txtSubscriber1SSN = new JTextField();

        JLabel lblSubscriber1Birthdate = new JLabel("Subscriber's Birthdate *");
        lblSubscriber1Birthdate.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber1Birthdate.setForeground(new java.awt.Color(123, 130, 145));

        dcSubscriber1Birthdate = new com.toedter.calendar.JDateChooser();

        JLabel lblSubscriber1Gender = new JLabel("Gender *");
        lblSubscriber1Gender.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber1Gender.setForeground(new java.awt.Color(123, 130, 145));

        ButtonGroup rbtnSubscriber1Gender = new ButtonGroup();

        rbtnSubscriber1Male = new JRadioButton("Male");
        rbtnSubscriber1Male.setFont(new java.awt.Font("Arial", 1, 14));  
        rbtnSubscriber1Male.setForeground(new java.awt.Color(123, 130, 145));
        rbtnSubscriber1Gender.add(rbtnSubscriber1Male);

        rbtnSubscriber1Female = new JRadioButton("Female");
        rbtnSubscriber1Female.setFont(new java.awt.Font("Arial", 1, 14));  
        rbtnSubscriber1Female.setForeground(new java.awt.Color(123, 130, 145));
        rbtnSubscriber1Gender.add(rbtnSubscriber1Female);

        JLabel lblSubscriber1Relation = new JLabel("Relationship to Patient *");
        lblSubscriber1Relation.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber1Relation.setForeground(new java.awt.Color(123, 130, 145));

        txtSubscriber1Relation = new JTextField();

        JLabel lblSubscriber1Employer = new JLabel("Employer");
        lblSubscriber1Employer.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber1Employer.setForeground(new java.awt.Color(123, 130, 145));

        txtSubscriber1Employer = new JTextField();

        JLabel lblSecondaryInsurance = new JLabel("Secondary Insurance");
        lblSecondaryInsurance.setBackground(new java.awt.Color(243, 245, 249));
        lblSecondaryInsurance.setFont(new java.awt.Font("Arial", 2, 14));  
        lblSecondaryInsurance.setForeground(new java.awt.Color(123, 130, 145));
        lblSecondaryInsurance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecondaryInsurance.setOpaque(true);

        JLabel lblInsurance2Name = new JLabel("Insurance Name *");
        lblInsurance2Name.setFont(new java.awt.Font("Arial", 0, 20));  
        lblInsurance2Name.setForeground(new java.awt.Color(123, 130, 145));

        txtInsurance2Name = new JTextField();

        JLabel lblSubscriber2Name = new JLabel("Subscriber's Name *");
        lblSubscriber2Name.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber2Name.setForeground(new java.awt.Color(123, 130, 145));

        txtSubscriber2Name = new JTextField();

        JLabel lblSubscriber2SSN = new JLabel("Subscriber's SSN *");
        lblSubscriber2SSN.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber2SSN.setForeground(new java.awt.Color(123, 130, 145));
        
        txtSubscriber2SSN = new JTextField();
        
        JLabel lblSubscriber2Birthdate = new JLabel("Subscriber's Birthdate *");
        lblSubscriber2Birthdate.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber2Birthdate.setForeground(new java.awt.Color(123, 130, 145));

        dcSubscriber2Birthdate = new com.toedter.calendar.JDateChooser();

        JLabel lblSubscriber2Gender = new JLabel("Gender *");
        lblSubscriber2Gender.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber2Gender.setForeground(new java.awt.Color(123, 130, 145));

        ButtonGroup rbtnSubscriber2Gender = new javax.swing.ButtonGroup();

        rbtnSubscriber2Male = new JRadioButton("Male");
        rbtnSubscriber2Male.setFont(new java.awt.Font("Arial", 1, 14));  
        rbtnSubscriber2Male.setForeground(new java.awt.Color(123, 130, 145));
        rbtnSubscriber2Gender.add(rbtnSubscriber2Male);

        rbtnSubscriber2Female = new JRadioButton("Female");
        rbtnSubscriber2Female.setFont(new java.awt.Font("Arial", 1, 14));  
        rbtnSubscriber2Female.setForeground(new java.awt.Color(123, 130, 145));
        rbtnSubscriber2Gender.add(rbtnSubscriber2Female);

        JLabel lblSubscriber2Relation = new JLabel("Relationship to Patient *");
        lblSubscriber2Relation.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber2Relation.setForeground(new java.awt.Color(123, 130, 145));

        txtSubscriber2Relation = new JTextField();

        JLabel lblSubscriber2Employer = new JLabel("Employer");
        lblSubscriber2Employer.setFont(new java.awt.Font("Arial", 0, 20));  
        lblSubscriber2Employer.setForeground(new java.awt.Color(123, 130, 145));
        
        txtSubscriber2Employer = new JTextField();
        
        /** NOTE: The following layout code was auto-generated by NetBeans GUI Builder (drag-and-drop interface).
        	As a result, it may appear verbose or complex. Manual edits should be made with caution.
        	The use of drag-and-drop tools was consented by Prof. Alexis Libunao and Prof. Monina Barretto **/
        
        javax.swing.GroupLayout pnlInsuranceInformationLayout = new javax.swing.GroupLayout(pnlInsuranceInformation);
        pnlInsuranceInformation.setLayout(pnlInsuranceInformationLayout);
        pnlInsuranceInformationLayout.setHorizontalGroup(
            pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInsuranceInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                        .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblInsurance1Name)
                                .addComponent(lblSubscriber1Employer)
                                .addComponent(lblSubscriber1Relation)
                                .addComponent(lblSubscriber1Name)
                                .addComponent(lblSubscriber1SSN)
                                .addComponent(lblSubscriber1Birthdate)
                                .addComponent(lblSubscriber1Gender)
                                .addComponent(txtSubscriber1Relation)
                                .addComponent(txtSubscriber1SSN)
                                .addComponent(txtInsurance1Name)
                                .addComponent(txtSubscriber1Employer)
                                .addComponent(lblPrimaryInsurance, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(dcSubscriber1Birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                                .addComponent(rbtnSubscriber1Male, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(rbtnSubscriber1Female))
                            .addComponent(txtSubscriber1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcSubscriber2Birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblInsurance2Name)
                                    .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblSubscriber2Employer)
                                        .addComponent(lblSubscriber2Relation)
                                        .addComponent(lblSubscriber2Name)
                                        .addComponent(lblSubscriber2SSN)
                                        .addComponent(lblSubscriber2Birthdate)
                                        .addComponent(lblSubscriber2Gender)
                                        .addComponent(txtSubscriber2Relation)
                                        .addComponent(txtSubscriber2SSN)
                                        .addComponent(txtSubscriber2Name)
                                        .addComponent(txtInsurance2Name)
                                        .addComponent(txtSubscriber2Employer)
                                        .addComponent(lblSecondaryInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                                        .addComponent(rbtnSubscriber2Male, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(rbtnSubscriber2Female)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnlInsuranceInformationLayout.setVerticalGroup(
            pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInsuranceInformationLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblInsuranceInformation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                        .addComponent(lblPrimaryInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInsurance1Name)
                        .addGap(5, 5, 5)
                        .addComponent(txtInsurance1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubscriber1Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubscriber1Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubscriber1SSN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubscriber1SSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSubscriber2Birthdate)
                            .addComponent(lblSubscriber1Birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInsuranceInformationLayout.createSequentialGroup()
                        .addComponent(lblSecondaryInsurance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblInsurance2Name)
                        .addGap(5, 5, 5)
                        .addComponent(txtInsurance2Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubscriber2Name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubscriber2Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSubscriber2SSN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubscriber2SSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcSubscriber2Birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcSubscriber1Birthdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubscriber1Gender)
                    .addComponent(lblSubscriber2Gender))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnSubscriber1Male)
                    .addComponent(rbtnSubscriber1Female)
                    .addComponent(rbtnSubscriber2Male)
                    .addComponent(rbtnSubscriber2Female))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubscriber1Relation)
                    .addComponent(lblSubscriber2Relation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubscriber1Relation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubscriber2Relation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubscriber1Employer)
                    .addComponent(lblSubscriber2Employer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInsuranceInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSubscriber1Employer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubscriber2Employer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContentUserPage2.add(pnlInsuranceInformation, new java.awt.GridBagConstraints());
        
        JPanel pnlSpacerUserPage2 = new JPanel();
        pnlSpacerUserPage2.setMinimumSize(new java.awt.Dimension(30, 100));
        pnlSpacerUserPage2.setOpaque(false);
        pnlSpacerUserPage2.setPreferredSize(new java.awt.Dimension(50, 100));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlContentUserPage2.add(pnlSpacerUserPage2, gridBagConstraints);
        
        JPanel pnlResponsibleParty = new JPanel();
        pnlResponsibleParty.setBackground(new java.awt.Color(216, 220, 235));
        pnlResponsibleParty.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 0, 0, 0, new java.awt.Color(104, 120, 208)));
        
        JLabel lblResponsibleParty = new JLabel("RESPONSIBLE PARTY");
        lblResponsibleParty.setFont(new java.awt.Font("Arial", 1, 36));  
        
        JLabel lblResponsibleName = new JLabel("Person Responsible for Bill *");
        lblResponsibleName.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleName.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsibleName = new JTextField();
        
        JLabel lblResponsibleBirthdate = new JLabel("Birthdate *");
        lblResponsibleBirthdate.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleBirthdate.setForeground(new java.awt.Color(123, 130, 145));
        
        dcResponsibleBirthdate = new com.toedter.calendar.JDateChooser();
        
        JLabel lblResponsibleAddress = new JLabel("Address *");
        lblResponsibleAddress.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleAddress.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsibleAddress = new JTextField();
        
        JLabel lblResponsiblePhoneNumber = new JLabel("Phone Number *");
        lblResponsiblePhoneNumber.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsiblePhoneNumber.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsiblePhoneNumber = new JTextField();
        
        JLabel lblResponsibleOccupation = new JLabel("Occupation *");
        lblResponsibleOccupation.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleOccupation.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsibleOccupation = new JTextField();
        
        JLabel lblResponsibleEmployer = new JLabel("Employer");
        lblResponsibleEmployer.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleEmployer.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsibleEmployer = new JTextField();
        
        JLabel lblResponsibleEmployerAddress = new JLabel("Employer Address");
        lblResponsibleEmployerAddress.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleEmployerAddress.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsibleEmployerAddress = new JTextField();
        
        JLabel lblResponsibleEmployerPhoneNumber = new JLabel("Employer Phone Number:");
        lblResponsibleEmployerPhoneNumber.setFont(new java.awt.Font("Arial", 0, 20));  
        lblResponsibleEmployerPhoneNumber.setForeground(new java.awt.Color(123, 130, 145));
        
        txtResponsibleEmployerPhoneNumber = new JTextField();

        javax.swing.GroupLayout pnlResponsiblePartyLayout = new javax.swing.GroupLayout(pnlResponsibleParty);
        pnlResponsibleParty.setLayout(pnlResponsiblePartyLayout);
        pnlResponsiblePartyLayout.setHorizontalGroup(
            pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResponsiblePartyLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlResponsiblePartyLayout.createSequentialGroup()
                        .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResponsiblePartyLayout.createSequentialGroup()
                                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblResponsibleName)
                                    .addComponent(lblResponsibleBirthdate)
                                    .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(dcResponsibleBirthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtResponsibleName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResponsibleEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblResponsibleEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtResponsibleOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblResponsibleOccupation)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResponsiblePartyLayout.createSequentialGroup()
                                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblResponsibleAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtResponsibleAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResponsiblePartyLayout.createSequentialGroup()
                                        .addComponent(txtResponsibleEmployerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))
                                    .addComponent(lblResponsibleEmployerAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlResponsiblePartyLayout.createSequentialGroup()
                                .addComponent(lblResponsibleParty, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(pnlResponsiblePartyLayout.createSequentialGroup()
                        .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtResponsiblePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResponsiblePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResponsiblePartyLayout.createSequentialGroup()
                                .addComponent(txtResponsibleEmployerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlResponsiblePartyLayout.createSequentialGroup()
                                .addComponent(lblResponsibleEmployerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))))))
        );
    
        pnlResponsiblePartyLayout.setVerticalGroup(
            pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResponsiblePartyLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblResponsibleParty)
                .addGap(18, 18, 18)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponsibleName)
                    .addComponent(lblResponsibleOccupation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsibleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsibleOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponsibleBirthdate)
                    .addComponent(lblResponsibleEmployer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtResponsibleEmployer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcResponsibleBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponsibleAddress)
                    .addComponent(lblResponsibleEmployerAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsibleAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsibleEmployerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponsiblePhoneNumber)
                    .addComponent(lblResponsibleEmployerPhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResponsiblePartyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResponsiblePhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResponsibleEmployerPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
       
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        pnlContentUserPage2.add(pnlResponsibleParty, gridBagConstraints);
        
        JButton btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBackground(new java.awt.Color(98, 113, 204));
        btnSubmit.setFont(new java.awt.Font("Segoe UI", 1, 24));  
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmit.setPreferredSize(new java.awt.Dimension(80, 23));
        btnSubmit.addActionListener(e -> {    	
        	ToDatabase objPassedVal = new ToDatabase(UserPanel.this); 
	     		if (objPassedVal.processToDatabase2()) {
	    			cardLayout.show(pnlPageSwitch, "pnlHome"); 
	    			HelperMethods.clearTxtFields(this);
	     		} else {
	    			cardLayout.show(pnlPageSwitch, "pnlUserPage2");
	     		}	
     		});
        
        JPanel pnlButtonResizer = new JPanel();
        javax.swing.GroupLayout pnlButtonResizerLayout = new javax.swing.GroupLayout(pnlButtonResizer);
        pnlButtonResizer.setLayout(pnlButtonResizerLayout);
        pnlButtonResizerLayout.setHorizontalGroup(
            pnlButtonResizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonResizerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlButtonResizerLayout.setVerticalGroup(
            pnlButtonResizerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonResizerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        pnlContentUserPage2.add(pnlButtonResizer, gridBagConstraints);

        pnlUserPage2.add(pnlContentUserPage2, java.awt.BorderLayout.CENTER);
    }
	
	// user panel getters
	
	  public String getTxtPatientSSN() {
	    	return txtPatientSSN.getText().trim();
	    }
	    public String getTxtPreviousPhysician() {
	        return txtPreviousPhysician.getText().trim();
	    }

	    public String getTxtPatientLastName() {
	        return txtPatientLastName.getText().trim();
	    }

	    public String getTxtPatientFirstName() {
	        return txtPatientFirstName.getText().trim();
	    }

	    public String getTxtPatientMiddleName() {
	        return txtPatientMiddleName.getText().trim();
	    }

	    public String getTxtPatientBirthdate() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if (txtPatientBirthdate.getDate() != null) {
	    		return sdf.format(txtPatientBirthdate.getDate());
	    	} else {
	    		return null;
	    	}
	    }
	    
	    public String getTxtPatientAge() {
	        return txtPatientAge.getText().trim();
	    }

	    public String getTxtPatientGender() {
	        if (rbtnPatientMale.isSelected()) {
	            return "Male";
	        } else if (rbtnPatientFemale.isSelected()) {
	            return "Female";
	        }
	        return null;
	    }

	    public String getTxtPatientHonorifics() {
	        return txtPatientHonorifics.getText().trim();
	    }

	    public String getPatientMaritalStatus() {	
	        return (String) cmbPatientMaritalStatus.getSelectedItem();
	    }
	    
	    public String getTxtPatientRace() {
	        return txtPatientRace.getText().trim();
	    }
	    
	    public String getTxtPatientEthnicity() {
	        return txtEthnicity.getText().trim();
	    }

	    public String getTxtPatientCPN() {
	        return txtPatientCPN.getText().trim();
	    }

	    public String getTxtPatientHPN() {
	        return txtPatientHPN.getText().trim();
	    }

	    public String getTxtPatientWPN() {
	        return txtPatientWPN.getText().trim();
	    }

	    public String getTxtPatientPO() {
	        return txtPatientPO.getText().trim();
	    }

	    public String getTxtPatientZipCode() {
	        return txtPatientZipCode.getText().trim();
	    }

	    public String getTxtPatientStreet() {
	        return txtPatientStreet.getText().trim();
	    }

	    public String getTxtPatientCity() {
	        return txtPatientCity.getText().trim();
	    }

	    public String getTxtPatientRegion() {
	        return txtPatientRegion.getText().trim();
	    }

	    public String getTxtPatientProvince() {
	        return txtPatientProvince.getText().trim();
	    }

	    public String getTxtPatientOccupation() {
	        return txtPatientOccupation.getText().trim();
	    }

	    public String getTxtPatientEmployer() {
	        return txtPatientEmployer.getText().trim();
	    }

	    public String getTxtPatientEmployerPN() {
	        return txtPatientEmployerPN.getText().trim();
	    }

	    public String getTxtPatientECName() {
	        return txtPatientECName.getText().trim();
	    }

	    public String getTxtPatientToEC() {
	        return txtPatientToEC.getText().trim();
	    }

	    public String getTxtPatientECPhoneNumber() {
	        return txtPatientECPhoneNumber.getText().trim();
	    }

	    public String getTxtHIPAA1Name() {
	        return txtHIPAA1Name.getText().trim();
	    }

	    public String getTxtHIPAA1Relation() {
	        return txtHIPAA1Relation.getText().trim();
	    }

	    public String getTxtHIPAA1PhoneNumber() {
	        return txtHIPAA1PhoneNumber.getText().trim();
	    }

	    public String getTxtHIPAA2Name() {
	        return txtHIPAA2Name.getText().trim();
	    }

	    public String getTxtHIPAA2Relation() {
	        return txtHIPAA2Relation.getText().trim();
	    }

	    public String getTxtHIPAA2PhoneNumber() {
	        return txtHIPAA2PhoneNumber.getText().trim();
	    }
	    
	    // user panel setters
	    
	    public void setTxtPatientSSN(String strPatientSSN) {
	    	txtPatientSSN.setText(strPatientSSN);
	    }
	    
	    public void setTxtPreviousPhysician(String strPrevPhysician) {
	        txtPreviousPhysician.setText(strPrevPhysician);
	    }

	    public void setTxtPatientLastName(String strPatientLastName) {
	        txtPatientLastName.setText(strPatientLastName);
	    }

	    public void setTxtPatientFirstName(String strPatientFirstName) {
	        txtPatientFirstName.setText(strPatientFirstName);
	    }

	    public void setTxtPatientMiddleName(String strPatientMiddleName) {
	        txtPatientMiddleName.setText(strPatientMiddleName);
	    }

	    public void setDcPatientBirthdate(Date datePatientBirthdate) {
	        txtPatientBirthdate.setDate(datePatientBirthdate);
	    }

	    public void setTxtPatientAge(String strAge) {
	        txtPatientAge.setText(strAge);
	    }

	    public void setPatientGender(String strGender) {
	        if (!strGender.isEmpty()) {
	            if (strGender.equalsIgnoreCase("Male")) {
	                rbtnPatientMale.setSelected(true);
	            } else if (strGender.equalsIgnoreCase("Female")) {
	                rbtnPatientFemale.setSelected(true);
	            }
	        } else {
	        	rbtnPatientMale.setSelected(false);
	        	rbtnPatientFemale.setSelected(false);
	        }
	    }

	    public void setTxtPatientHonorifics(String strPatientHonorifics) {
	        txtPatientHonorifics.setText(strPatientHonorifics);
	    }

	    public void setCbMaritalStatus(String strMaritalStatus) {
	        cmbPatientMaritalStatus.setSelectedItem(strMaritalStatus);
	    }

	    public void setTxtPatientEthnicity(String strEthinicity) {
	        txtEthnicity.setText(strEthinicity);
	    }

	    public void setTxtPatientRace(String strRace) {
	        txtPatientRace.setText(strRace);
	    }

	    public void setTxtPatientCPN(String strCPN) {
	        txtPatientCPN.setText(strCPN);
	    }

	    public void setTxtPatientHPN(String strHPN) {
	        txtPatientHPN.setText(strHPN);
	    }

	    public void setTxtPatientWPN(String strWPN) {
	        txtPatientWPN.setText(strWPN);
	    }

	    public void setTxtPatientPO(String strPO) {
	        txtPatientPO.setText(strPO);
	    }

	    public void setTxtPatientZipCode(String strZip) {
	        txtPatientZipCode.setText(strZip);
	    }

	    public void setTxtPatientStreet(String strStreet) {
	        txtPatientStreet.setText(strStreet);
	    }

	    public void setTxtPatientCity(String strCity) {
	        txtPatientCity.setText(strCity);
	    }

	    public void setTxtPatientRegion(String strRegion) {
	        txtPatientRegion.setText(strRegion);
	    }

	    public void setTxtPatientProvince(String strProvince) {
	        txtPatientProvince.setText(strProvince);
	    }

	    public void setTxtPatientOccupation(String strOccupation) {
	        txtPatientOccupation.setText(strOccupation);
	    }

	    public void setTxtPatientEmployer(String strPatientEmployer) {
	        txtPatientEmployer.setText(strPatientEmployer);
	    }

	    public void setTxtPatientEmployerPN(String strEmployerPN) {
	        txtPatientEmployerPN.setText(strEmployerPN);
	    }

	    public void setTxtPatientECName(String strECName) {
	        txtPatientECName.setText(strECName);
	    }

	    public void setTxtPatientToEC(String strPatientToEC) {
	        txtPatientToEC.setText(strPatientToEC);
	    }

	    public void setTxtPatientECPhoneNumber(String strPatienToECPN) {
	        txtPatientECPhoneNumber.setText(strPatienToECPN);
	    }

	    public void setTxtHIPAA1Name(String strHIPAAName1) {
	        txtHIPAA1Name.setText(strHIPAAName1);
	    }

	    public void setTxtHIPAA1Relation(String strHIPAA1Rel) {
	        txtHIPAA1Relation.setText(strHIPAA1Rel);
	    }

	    public void setTxtHIPAA1PhoneNumber(String strHIPAA1PN) {
	        txtHIPAA1PhoneNumber.setText(strHIPAA1PN);
	    }

	    public void setTxtHIPAA2Name(String strHIPAAPN2) {
	        txtHIPAA2Name.setText(strHIPAAPN2);
	    }

	    public void setTxtHIPAA2Relation(String strHIPAA2Rel) {
	        txtHIPAA2Relation.setText(strHIPAA2Rel);
	    }

	    public void setTxtHIPAA2PhoneNumber(String strHIPAA2PN) {
	        txtHIPAA2PhoneNumber.setText(strHIPAA2PN);
	    }
	    
	    public String getTxtInsurance1Name() {
	        return txtInsurance1Name.getText().trim();
	    }
	    
	    public String getTxtSubscriber1Name() {
	        return txtSubscriber1Name.getText().trim();
	    }

	    public String getTxtSubscriber1SSN() {
	        return txtSubscriber1SSN.getText().trim();
	    }

	    public String getDcSubscriber1Birthdate() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if (dcSubscriber1Birthdate.getDate() != null) {
	    		return sdf.format(dcSubscriber1Birthdate.getDate());
	    	} else {
	    		return null;
	    	}
	    }

	    public String getSubscriber1Gender() {
	        if (rbtnSubscriber1Male.isSelected()) {
	            return "Male";
	        } else if (rbtnSubscriber1Female.isSelected()) {
	            return "Female";
	        }
	        return null; 
	    }

	    public String getTxtSubscriber1Relation() {
	        return txtSubscriber1Relation.getText().trim();
	    }

	    public String getTxtSubscriber1Employer() {
	        return txtSubscriber1Employer.getText().trim();
	    }

	    public String getTxtInsurance2Name() {
	        return txtInsurance2Name.getText().trim();
	    }

	    public String getTxtSubscriber2Name() {
	        return txtSubscriber2Name.getText().trim();
	    }

	    public String getTxtSubscriber2SSN() {
	        return txtSubscriber2SSN.getText().trim();
	    }

	    public String getDcSubscriber2Birthdate() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if (dcSubscriber2Birthdate.getDate() != null) {
	    		return sdf.format(dcSubscriber2Birthdate.getDate());
	    	} else {
	    		return null;
	    	}
	    }
	    
	    public String getSubscriber2Gender() {
	        if (rbtnSubscriber2Male.isSelected()) {
	            return "Male";
	        } else if (rbtnSubscriber2Female.isSelected()) {
	            return "Female";
	        }
	        return null; 
	    }
	    
	    public String getTxtSubscriber2Relation() {
	        return txtSubscriber2Relation.getText().trim();
	    }

	    public String getTxtSubscriber2Employer() {
	        return txtSubscriber2Employer.getText().trim();
	    }

	    public String getTxtResponsibleName() {
	        return txtResponsibleName.getText().trim();
	    }
	    
	    public String getDcResponsibleBirthdate() {
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if (dcResponsibleBirthdate.getDate() != null) {
	    		return sdf.format(dcResponsibleBirthdate.getDate());
	    	} else {
	    		return null;
	    	}
	    } 
	 
	    public String getTxtResponsibleAddress() {
	        return txtResponsibleAddress.getText().trim();
	    }

	    public String getTxtResponsiblePhoneNumber() {
	        return txtResponsiblePhoneNumber.getText().trim();
	    }

	    public String getTxtResponsibleOccupation() {
	        return txtResponsibleOccupation.getText().trim();
	    }

	    public String getTxtResponsibleEmployer() {
	        return txtResponsibleEmployer.getText().trim();
	    }

	    public String getTxtResponsibleEmployerAddress() {
	        return txtResponsibleEmployerAddress.getText().trim();
	    }

	    public String getTxtResponsibleEmployerPhoneNumber() {
	        return txtResponsibleEmployerPhoneNumber.getText().trim();
	    }
	    
	    public void setTxtInsurance1Name(String strIns1) {
	        txtInsurance1Name.setText(strIns1);
	    }
	    
	    public void setTxtSubscriber1Name(String strSubName1) {
	        txtSubscriber1Name.setText(strSubName1);
	    }

	    public void setTxtSubscriber1SSN(String strSub1SSN) {
	        txtSubscriber1SSN.setText(strSub1SSN);
	    }

	    public void setDcSubscriber1Birthdate(Date dateSub1Birthdate) {
	        dcSubscriber1Birthdate.setDate(dateSub1Birthdate);
	    }

	    public void setSubscriber1Gender(String strSub1Gender) {
	        if (strSub1Gender != null) {
	            if (strSub1Gender.equalsIgnoreCase("Male")) {
	                rbtnSubscriber1Male.setSelected(true);
	            } else if (strSub1Gender.equalsIgnoreCase("Female")) {
	                rbtnSubscriber1Female.setSelected(true);
	            } else {
	            	rbtnSubscriber1Male.setSelected(false);
	            	rbtnSubscriber2Female.setSelected(false);
	            }
	        }
	    }


	    public void setTxtSubscriber1Relation(String strSub1Rel) {
	        txtSubscriber1Relation.setText(strSub1Rel);
	    }

	    public void setTxtSubscriber1Employer(String strSub1Emp) {
	        txtSubscriber1Employer.setText(strSub1Emp);
	    }

	    public void setTxtInsurance2Name(String strIns2) {
	        txtInsurance2Name.setText(strIns2);
	    }

	    public void setTxtSubscriber2Name(String strSub2Name) {
	        txtSubscriber2Name.setText(strSub2Name);
	    }

	    public void setTxtSubscriber2SSN(String strSub2SSN) {
	        txtSubscriber2SSN.setText(strSub2SSN);
	    }

	    public void setDcSubscriber2Birthdate(Date dateSub2Birthdate) {
	        dcSubscriber2Birthdate.setDate(dateSub2Birthdate);
	    }

	    public void setSubscriber2Gender(String strSub2Gender) {
	        if (strSub2Gender != null) {
	            if (strSub2Gender.equalsIgnoreCase("Male")) {
	                rbtnSubscriber2Male.setSelected(true);
	            } else if (strSub2Gender.equalsIgnoreCase("Female")) {
	                rbtnSubscriber2Female.setSelected(true);
	            } else {
	            	rbtnSubscriber2Male.setSelected(false);
	            	rbtnSubscriber2Female.setSelected(false);
	            }
	        }
	    }

	    public void setTxtSubscriber2Relation(String strSub2Rel) {
	        txtSubscriber2Relation.setText(strSub2Rel);
	    }

	    public void setTxtSubscriber2Employer(String strSub2Emp) {
	        txtSubscriber2Employer.setText(strSub2Emp);
	    }

	    public void setTxtResponsibleName(String strResponsibleName) {
	        txtResponsibleName.setText(strResponsibleName);
	    }

	    public void setDcResponsibleBirthdate(Date dateResponsibleBirthdate) {
	        dcResponsibleBirthdate.setDate(dateResponsibleBirthdate);
	    }

	    public void setTxtResponsibleAddress(String strResponsibleAdd) {
	        txtResponsibleAddress.setText(strResponsibleAdd);
	    }

	    public void setTxtResponsiblePhoneNumber(String strResponsiblePN) {
	        txtResponsiblePhoneNumber.setText(strResponsiblePN);
	    }

	    public void setTxtResponsibleOccupation(String strReponsibleOccupation) {
	        txtResponsibleOccupation.setText(strReponsibleOccupation);
	    }

	    public void setTxtResponsibleEmployer(String strReponsibleEmp) {
	        txtResponsibleEmployer.setText(strReponsibleEmp);
	    }

	    public void setTxtResponsibleEmployerAddress(String strReponsibleAdd) {
	        txtResponsibleEmployerAddress.setText(strReponsibleAdd);
	    }

	    public void setTxtResponsibleEmployerPhoneNumber(String strReponsibleEmpPN) {
	        txtResponsibleEmployerPhoneNumber.setText(strReponsibleEmpPN);
	    }
	    
	    public void setHIPAAFieldsState(Boolean boolValue) {
    	
	    	txtHIPAA1Name.setEnabled(boolValue);
	    	txtHIPAA1Relation.setEnabled(boolValue);
	    	txtHIPAA1PhoneNumber.setEnabled(boolValue);
	    	txtHIPAA2Name.setEnabled(boolValue);
	    	txtHIPAA2Relation.setEnabled(boolValue);
	    	txtHIPAA2PhoneNumber.setEnabled(boolValue);
	    	txtPatientSSN.setEditable(boolValue);
	    }
}