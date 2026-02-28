package frontend;

import javax.swing.*;
import backend.ToFetch;
import java.awt.*;

@SuppressWarnings("serial")
public class AdminPanel extends JPanel {
	JPanel pnlPreviewPaneAdmin;
	
	public AdminPanel(CardLayout cardLayout, JPanel pnlPageSwitch) {
		setPreferredSize(new Dimension(1920, 1080));
        setLayout(new BorderLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        UIHelperMethods.addHeader(this, "Administrator", 0);
        
        JPanel pnlContentAdmin = new JPanel();
        pnlContentAdmin.setLayout(new BorderLayout());
        
        JTextField txtSearchBarAdmin = new JTextField("  Search categories...");
        txtSearchBarAdmin.setBackground(new Color(169, 178, 227));
        txtSearchBarAdmin.setFont(new Font("Lantinghei TC", 0, 18));  
        txtSearchBarAdmin.setForeground(new Color(255, 255, 255));
        txtSearchBarAdmin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtSearchBarAdmin.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        txtSearchBarAdmin.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        txtSearchBarAdmin.setPreferredSize(new Dimension(400, 50));
        
        JButton btnQueries = new JButton();
        btnQueries.setIcon(new javax.swing.ImageIcon(getClass().getResource("/8_sql.png")));  
        btnQueries.setContentAreaFilled(false);
        btnQueries.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnQueries.addActionListener(evt -> {
        	UIHelperMethods.resetPnlPreviewPaneAdmin(AdminPanel.this);
        	cardLayout.show(pnlPageSwitch, "pnlQueries");
        });
        
        JButton btnHomeAdmin = new JButton();
        btnHomeAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/9_home.png")));  
        btnHomeAdmin.setContentAreaFilled(false);
        btnHomeAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHomeAdmin.addActionListener(evt -> {
        	UIHelperMethods.resetPnlPreviewPaneAdmin(AdminPanel.this);
        	cardLayout.show(pnlPageSwitch, "pnlHome");
        });
        
        
        JPanel pnlUpperComponentsAdmin = new JPanel();
        pnlUpperComponentsAdmin.setLayout(new BoxLayout(pnlUpperComponentsAdmin, BoxLayout.X_AXIS));
        JPanel pnlAdminSpacer = new JPanel(); pnlAdminSpacer.setPreferredSize(new Dimension(700, 20)); pnlAdminSpacer.setMinimumSize(new Dimension(10, 20)); 
        JPanel pnlButtonsAdmin = new JPanel(new FlowLayout());
        pnlButtonsAdmin.add(btnQueries); 
        pnlButtonsAdmin.add(btnHomeAdmin);
        pnlButtonsAdmin.add(Box.createVerticalStrut(100));
        JPanel pnlSearchBarAdmin = new JPanel(new FlowLayout());
        pnlSearchBarAdmin.add(Box.createVerticalStrut(100)); 
        pnlSearchBarAdmin.add(txtSearchBarAdmin); 
        pnlUpperComponentsAdmin.add(pnlSearchBarAdmin);
        pnlUpperComponentsAdmin.add(pnlAdminSpacer);
        pnlUpperComponentsAdmin.add(pnlButtonsAdmin);
        
        pnlContentAdmin.add(pnlUpperComponentsAdmin, BorderLayout.NORTH);
        
        JPanel pnlMiddleComponentsAdmin = new JPanel();
        pnlMiddleComponentsAdmin.setLayout(new GridBagLayout());
        
        JLabel lblTables = new JLabel("TABLES");
        lblTables.setFont(new Font("Tahoma", 1, 24));  
        lblTables.setToolTipText("");

        JButton btnPatientInfo = new JButton("Patient Information");
        btnPatientInfo.setFont(new Font("Lantinghei TC", 0, 16));  
        btnPatientInfo.setPreferredSize(new Dimension(200, 40));
        btnPatientInfo.setForeground(new Color(123, 130, 145));
        btnPatientInfo.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnPatientInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPatientInfo.addActionListener(evt -> {
        	ToFetch objPassedVal = new ToFetch(AdminPanel.this);
        	objPassedVal.btnPatientInformation();
        });
        
        JButton btnHIPAA = new JButton("HIPAA Information");
        btnHIPAA.setFont(new Font("Lantinghei TC", 0, 16));  
        btnHIPAA.setPreferredSize(new Dimension(200, 40));
        btnHIPAA.setForeground(new Color(123, 130, 145));
        btnHIPAA.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnHIPAA.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHIPAA.addActionListener(evt -> {
        	ToFetch objPassedVal = new ToFetch(AdminPanel.this);
        	objPassedVal.btnHIPAAInformation();
        });

        JButton btnBillHandler = new JButton("Bill Handler Information");
        btnBillHandler.setFont(new Font("Lantinghei TC", 0, 16)); 
        btnBillHandler.setPreferredSize(new Dimension(200, 40));
        btnBillHandler.setForeground(new Color(123, 130, 145));
        btnBillHandler.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnBillHandler.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBillHandler.addActionListener(evt -> {
        	ToFetch objPassedVal = new ToFetch(AdminPanel.this);
        	objPassedVal.btnBillHandlerInformation();
        });

        JButton btnInsuranceInfo = new JButton("Insurance Information");
        btnInsuranceInfo.setFont(new Font("Lantinghei TC", 0, 16));
        btnInsuranceInfo.setPreferredSize(new Dimension(200, 40));
        btnInsuranceInfo.setPreferredSize(new Dimension(200, 40));
        btnInsuranceInfo.setForeground(new Color(123, 130, 145));
        btnInsuranceInfo.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnInsuranceInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInsuranceInfo.addActionListener(evt -> {
        	ToFetch objPassedVal = new ToFetch(AdminPanel.this);
        	objPassedVal.btnPatientInsuranceInformation();
        });


        JButton btnInsuranceName = new JButton("Insurance Name");
        btnInsuranceName.setFont(new Font("Lantinghei TC", 0, 16));
        btnInsuranceName.setPreferredSize(new Dimension(200, 40));
        btnInsuranceName.setForeground(new Color(123, 130, 145));
        btnInsuranceName.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnInsuranceName.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnInsuranceName.addActionListener(evt -> {
        	ToFetch objPassedVal = new ToFetch(AdminPanel.this);
        	objPassedVal.btnInsuranceInformation();
        });

        JButton btnSubscriberInfo = new JButton("Subscriber Information");
        btnSubscriberInfo.setFont(new Font("Lantinghei TC", 0, 16)); 
        btnSubscriberInfo.setPreferredSize(new Dimension(200, 40));
        btnSubscriberInfo.setForeground(new Color(123, 130, 145));
        btnSubscriberInfo.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnSubscriberInfo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSubscriberInfo.addActionListener(evt -> {
        	ToFetch objPassedVal = new ToFetch(AdminPanel.this);
        	objPassedVal.btnSubscriberInformation();
        });
        
        JPanel pnlTableSelect = new JPanel(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(10, 0, 10, 0);
        
        gridBagConstraints.gridx = 0; gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = 1; pnlTableSelect.add(lblTables, gridBagConstraints);
        gridBagConstraints.gridy = 2; pnlTableSelect.add(btnInsuranceInfo, gridBagConstraints);
        gridBagConstraints.gridy = 3; pnlTableSelect.add(btnInsuranceName, gridBagConstraints);
        gridBagConstraints.gridy = 4; pnlTableSelect.add(btnSubscriberInfo, gridBagConstraints);
        gridBagConstraints.gridy = 5; pnlTableSelect.add(btnPatientInfo, gridBagConstraints);
        gridBagConstraints.gridy = 6; pnlTableSelect.add(btnBillHandler, gridBagConstraints);
        gridBagConstraints.gridy = 7; pnlTableSelect.add(btnHIPAA, gridBagConstraints);
        
        gridBagConstraints.insets = new Insets(0, 0, 0, 40);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        pnlMiddleComponentsAdmin.add(pnlTableSelect, gridBagConstraints);
        
        pnlPreviewPaneAdmin = new JPanel();
        pnlPreviewPaneAdmin.setBackground(new Color(216, 220, 235));
        pnlPreviewPaneAdmin.setMinimumSize(new Dimension(500, 200));
        pnlPreviewPaneAdmin.setPreferredSize(new Dimension(850, 450));
        pnlPreviewPaneAdmin.setLayout(new BorderLayout());

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        pnlMiddleComponentsAdmin.add(pnlPreviewPaneAdmin, gridBagConstraints);

        pnlContentAdmin.add(pnlMiddleComponentsAdmin, BorderLayout.CENTER);

        this.add(pnlContentAdmin, BorderLayout.CENTER);
	}
	
	public void setPnlPreviewPaneAdmin(JScrollPane scrollPane) {
	    pnlPreviewPaneAdmin.removeAll(); 
	    pnlPreviewPaneAdmin.add(scrollPane, BorderLayout.CENTER);
	    pnlPreviewPaneAdmin.revalidate(); 
	    pnlPreviewPaneAdmin.repaint(); 
	}
	
	public JPanel getPnlPreviewPaneAdmin() {
		return pnlPreviewPaneAdmin;
	}
}
