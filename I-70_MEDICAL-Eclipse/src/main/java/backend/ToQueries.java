package backend;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import frontend.QueriesPanel;
import frontend.UIHelperMethods;
import sqlcodes.*;

public class ToQueries {
	
	private QueriesPanel objControlQueries; 

	public ToQueries(QueriesPanel objControlQueries) {
		this.objControlQueries = objControlQueries;
	}
	
	private String strEasy1 = "SELECT\n   p_firstname, p_lastname, p_homePN, p_cellPN\nFROM\n   patient_info;";
	private String strEasy2 = "SELECT\n   *\nFROM\n   patient_info\nWHERE\n   p_lastname = ‘Reyes’;";
	private String strEasy3 = "SELECT\n"
								+ "   p.p_lastname,\n"
								+ "   p.p_firstname,\n"
								+ "   p.EC_name AS emergency_contact,\n"
								+ "   p.EC2P_relation AS relationship,\n"
								+ "FROM\n"
								+ "   patient_info p\n"
								+ "WHERE\n"
								+ "   p.EC2P_relation = 'Spouse';";
				
	private String strAverage1 = "SELECT\n"
								+ "   p_occupation,\n"
								+ "   COUNT(*) as count\n" 
					            + "FROM\n"
								+ "   patient_info\n" 
					            + "GROUP BY\n" 
								+ "   p_occupation\n" 
					            + "ORDER BY\n"
								+ "   count DESC";
	
	private String strAverage2 = "SELECT\n"
								+ "   i.insurance_name,\n"
								+ "   p.p_gender,\n"
								+ "   COUNT(*) AS patient_count\n" 
								+ "FROM\n" 
								+ "   patient_info p\n" 
								+ "JOIN\n" 
								+ "   patient_insurance pi ON p.patient_ssn = pi.patient_ssn\n" 
								+ "JOIN\n"
								+ "   insurance_name i ON pi.insurance_code = i.insurance_code\n" 
								+ "GROUP BY\n"
								+ "   i.insurance_name,\n"
								+ "   p.p_gender\n" 
								+ "ORDER BY\n" 
								+ "   i.insurance_name,\n"
								+ "   patient_count DESC";
	
	private String strAverage3 = "SELECT\n" 
								+ "   pi.p_firstname,\n"
								+ "   pi.p_lastname,\n" 
								+ "   pi.patient_ssn,\n" 
								+ "   si.subscriber_name,\n" 
								+ "   pi2s.S2P_relation AS relationship_to_subscriber\n" 
								+ "FROM\n"
								+ "   patient_info pi\n" 
								+ "JOIN\n" 
								+ "   patient_insurance AS pi2s ON pi.patient_ssn = pi2s.patient_ssn\n" 
								+ "JOIN\n" 
								+ "   subscriber_info AS si ON pi2s.subscriber_ssn = si.subscriber_ssn\n" 
								+ "WHERE\n"
								+ "   pi.patient_ssn <> pi2s.subscriber_ssn";
	
	private String strAverage4 = "SELECT\n"
								+ "   i.insurance_name,\n"
								+ "   AVG(p.p_age) AS avg_age\n" 
								+ "FROM\n" 
								+ "   insurance_name i\n" 
								+ "JOIN\n"
								+ "   patient_insurance pi ON i.insurance_code = pi.insurance_code\n" 
								+ "JOIN\n" 
								+ "   patient_info p ON pi.patient_ssn = p.patient_ssn\n" 
								+ "GROUP BY\n"
								+ "   i.insurance_name\n" 
								+ "ORDER BY\n"
								+ "   avg_age DESC";
	
	private String strHard1 = "SELECT \n" 
								+ "   INSURANCE_NAME.insurance_name,\n" 
								+ "   patient_info.p_region,\n" 
								+ "   COUNT(DISTINCT patient_info.patient_ssn) AS patient_count,\n" 
								+ "   COUNT(DISTINCT billhandler_info.Billhandler_id) AS billhandler_count\n" 
								+ "FROM\n"
								+ "   patient_insurance\n" 
								+ "JOIN\n"
								+ "   insurance_name ON patient_insurance.insurance_code = insurance_name.insurance_code\n" 
								+ "JOIN\n"
								+ "   patient_info ON patient_insurance.patient_ssn = patient_info.patient_ssn\n" 
								+ "JOIN\n"
								+ "   billhandler_info ON patient_info.patient_ssn = billhandler_info.patient_ssn\n" 
								+ "GROUP BY\n"
								+ "   insurance_name.insurance_name,\n"
								+ "   patient_info.p_region\n" 
								+ "ORDER BY\n"
								+ "   insurance_name,\n"
								+ "   patient_count DESC";
	
	private String strHard2 = "SELECT\n" 
								+ "   pi.p_gender,\n" 
								+ "   pi.p_region,\n" 
								+ "   COUNT(DISTINCT pi.patient_ssn) as patient_count,\n" 
								+ "   COUNT(DISTINCT pi2s.insurance_code) as insurance_count,\n" 
								+ "   CAST(COUNT(DISTINCT pi2s.insurance_code) AS FLOAT) / \n"
								+ "   COUNT(DISTINCT pi.patient_ssn) as avg_insurance_per_patient\n" 
								+ "FROM\n"
								+ "   patient_info pi\n" 
								+ "LEFT JOIN\n"
								+ "   patient_insurance pi2s ON pi.patient_ssn = pi2s.patient_ssn\n" 
								+ "GROUP BY\n"
								+ "   pi.p_gender,\n"
								+ "   pi.p_region\n" 
								+ "ORDER BY\n" 
								+ "   pi.p_region,\n" 
								+ "   pi.p_gender";
	
	private String strHard3 = "SELECT\n"
								+ "   p.p_lastname,\n" 
								+ "   p.p_firstname,\n"
								+ "   b.BH_name,\n"
								+ "   b.BH_employer\n" 
								+ "FROM\n"
								+ "   PATIENT_INFO p\n" 
								+ "JOIN\n"
								+ "   BILLHANDLER_INFO b ON p.patient_ssn = b.patient_ssn\n" 
								+ "WHERE\n" 
								+ "   b.BH_employer = 'St. Jude Hospital'";
						
	public void btnEasyChoices() {
	    String[] strOptions = {"Select an EASY query", "Easy | Query I", "Easy | Query II", "Easy | Query III"};
	    JComboBox<String> cmbEasy = new JComboBox<>(strOptions);
	    cmbEasy.setFont(new Font("Arial", Font.BOLD, 14));  
	    cmbEasy.setSelectedItem("Select an easy query");

	    objControlQueries.setPnlPane1Queries(cmbEasy);

	    cmbEasy.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String strSelected = (String) cmbEasy.getSelectedItem();

	            if (strSelected.equals(strOptions[1])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbEasy);
	                objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strEasy1));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(One.fetchPatientContactData()));
	            } 
	            else if (strSelected.equals(strOptions[2])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbEasy);
	                objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strEasy2));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableScrollable(Two.fetchPatientDemographics()));
	            } 
	            else if (strSelected.equals(strOptions[3])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbEasy);
	                objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strEasy3));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Three.fetchPatientsWithSpouseEC()));
	            } 
	            else if (strSelected.equals(strOptions[0])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbEasy);
	            }
	        }
	    });
	    UIHelperMethods.resetPnlQuery(objControlQueries, cmbEasy);
	}
	
	public void btnMediumChoices() {
		
	    String[] strOptions = {"Select a AVERAGE query", "Average | Query I", "Average | Query II", "Average | Query III", "Average | Query IV"};
	    JComboBox<String> cmbMedium = new JComboBox<>(strOptions);
	    cmbMedium.setFont(new Font("Arial", Font.BOLD, 14));  
	    cmbMedium.setSelectedItem("");

	    objControlQueries.setPnlPane1Queries(cmbMedium);

	    cmbMedium.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String strSelected = (String) cmbMedium.getSelectedItem();

	            if (strSelected.equals(strOptions[1])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbMedium);
	                objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strAverage1));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Four.fetchTopOccupations()));
	            } 
	            else if (strSelected.equals(strOptions[2])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbMedium);
	            	objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strAverage2));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Five.fetchInsuranceGenderStats()));	
	            } 
	            else if (strSelected.equals(strOptions[3])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbMedium);
	            	objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strAverage3));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Six.fetchPatientSubscriberRelations()));
	            } 
	            else if (strSelected.equals(strOptions[4])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbMedium);
	            	objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strAverage4));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Seven.fetchInsuranceAvgAge()));
	            } 
	            else if (strSelected.equals(strOptions[0])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbMedium);
	            }
	        }
	    });	
	    UIHelperMethods.resetPnlQuery(objControlQueries, cmbMedium);
	}
	
	public void btnHardChoices() {
	    String[] strOptions = {"Select a HARD query", "Hard | Query I", "Hard | Query II", "Hard | Query III"};
	    JComboBox<String> cmbHard = new JComboBox<>(strOptions);
	    cmbHard.setFont(new Font("Arial", Font.BOLD, 14));  
	    cmbHard.setSelectedItem("Select a hard query");

	    objControlQueries.setPnlPane1Queries(cmbHard);

	    cmbHard.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String strSelected = (String) cmbHard.getSelectedItem();

	            if (strSelected.equals(strOptions[1])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbHard);
	            	objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strHard1));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Eight.fetchInsuranceRegionStats()));
	            } 
	            else if (strSelected.equals(strOptions[2])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbHard);
	            	objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strHard2));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Nine.fetchPatientInsuranceStats()));   	
	            }
	            	
	            else if (strSelected.equals(strOptions[3])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbHard);
	            	objControlQueries.setPnlPane1Queries(UIHelperMethods.getQueryScrollPane(strHard3));
	                objControlQueries.setPnlPane2Queries(UIHelperMethods.getQueryTableNonScrollable(Ten.fetchAbcCorpPatients()));
	            } 
	            else if (strSelected.equals(strOptions[0])) {
	            	UIHelperMethods.resetPnlQuery(objControlQueries, cmbHard);
	            }
	        }
	    });
	    UIHelperMethods.resetPnlQuery(objControlQueries, cmbHard);  
	}
}

	    