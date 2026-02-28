package frontend;

import javax.swing.*;
import java.awt.*;

import backend.ToQueries;

@SuppressWarnings("serial")
public class QueriesPanel extends JPanel {
	private JPanel pnlPane1Queries;
	private JPanel pnlPane2Queries;
	
	public QueriesPanel(CardLayout cardLayout, JPanel pnlPageSwitch) {
		setPreferredSize(new Dimension(1920, 1080));
        setLayout(new BorderLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        
        UIHelperMethods.addHeader(this, "SQL Queries", 0);
        
        JPanel pnlContentQueries = new JPanel();
        pnlContentQueries.setLayout(new BorderLayout());
        
        JTextField fieldSearchCategories3 = new JTextField("  Search categories...");
        fieldSearchCategories3.setBackground(new Color(169, 178, 227));
        fieldSearchCategories3.setFont(new Font("Lantinghei TC", 0, 18));  
        fieldSearchCategories3.setForeground(new Color(255, 255, 255));
        fieldSearchCategories3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fieldSearchCategories3.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        fieldSearchCategories3.setPreferredSize(new Dimension(400, 50));
        
        JButton btnAdminBack = new JButton();
        btnAdminBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/10_admin.png")));  
        btnAdminBack.setContentAreaFilled(false);
        btnAdminBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdminBack.addActionListener(ev -> {
        	UIHelperMethods.resetPnlQuery(QueriesPanel.this, new JComboBox<String>());
        	cardLayout.show(pnlPageSwitch, "pnlAdmin");
        });
        
        JButton btnHome4 = new JButton();
        btnHome4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/9_home.png")));  
        btnHome4.setContentAreaFilled(false);
        btnHome4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHome4.addActionListener(evt -> {
        	UIHelperMethods.resetPnlQuery(QueriesPanel.this, new JComboBox<String>());
        	cardLayout.show(pnlPageSwitch, "pnlHome");
        
        });
        
        JPanel pnlAboveComponentsQueries = new JPanel();
        pnlAboveComponentsQueries.setLayout(new BoxLayout(pnlAboveComponentsQueries, BoxLayout.X_AXIS));
        JPanel pnlSearchBarQueries = new JPanel(new FlowLayout());
        pnlSearchBarQueries.add(Box.createVerticalStrut(100)); 
        pnlSearchBarQueries.add(fieldSearchCategories3); 
        JPanel pnlButtonsQueries = new JPanel(new FlowLayout());
        pnlButtonsQueries.add(btnAdminBack); 
        pnlButtonsQueries.add(btnHome4);
        pnlButtonsQueries.add(Box.createVerticalStrut(100));
        JPanel pnlQueriesSpacer = new JPanel(); pnlQueriesSpacer.setPreferredSize(new Dimension(700, 20)); pnlQueriesSpacer.setMinimumSize(new Dimension(10, 20));
        pnlAboveComponentsQueries.add(pnlSearchBarQueries);
        pnlAboveComponentsQueries.add(pnlQueriesSpacer);
        pnlAboveComponentsQueries.add(pnlButtonsQueries);

        pnlContentQueries.add(pnlAboveComponentsQueries, BorderLayout.NORTH);
        
        JPanel pnlMiddleComponentsQueries = new JPanel();
        pnlMiddleComponentsQueries.setLayout(new GridBagLayout());
        
        JLabel lblLevels = new JLabel("LEVELS");
        lblLevels.setFont(new Font("Tahoma", 1, 24)); 
        lblLevels.setPreferredSize(new Dimension(100, 50));
        lblLevels.setMinimumSize(new Dimension(100, 50));
        
        JButton btnEasy = new JButton("Easy");
        btnEasy.setPreferredSize(new Dimension(100, 50));
        btnEasy.setMinimumSize(new Dimension(100, 50));
        btnEasy.setMaximumSize(new Dimension(100, 50));
        btnEasy.setFont(new Font("Lantinghei TC", 0, 18));  
        btnEasy.setForeground(new Color(123, 130, 145));
        btnEasy.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnEasy.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEasy.addActionListener(evt -> {
        	ToQueries objPassedVal = new ToQueries(QueriesPanel.this);
        	objPassedVal.btnEasyChoices();
        });
        
        JButton btnMedium = new JButton("Medium");
        btnMedium.setFont(new Font("Lantinghei TC", 0, 18));
        btnMedium.setPreferredSize(new Dimension(100, 50));
        btnMedium.setMinimumSize(new Dimension(100, 50));
        btnMedium.setMaximumSize(new Dimension(100, 50));
        btnMedium.setForeground(new Color(123, 130, 145));
        btnMedium.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnMedium.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMedium.addActionListener(evt -> {
        	ToQueries objPassedVal = new ToQueries(QueriesPanel.this);
        	objPassedVal.btnMediumChoices();
        });
        
        JButton btnHard = new JButton("Hard");
        btnHard.setFont(new Font("Lantinghei TC", 0, 18));
        btnHard.setMinimumSize(new Dimension(100, 50));
        btnHard.setMaximumSize(new Dimension(100, 50));
        btnHard.setPreferredSize(new Dimension(100, 50));
        btnHard.setForeground(new Color(123, 130, 145));
        btnHard.setBorder(new javax.swing.border.LineBorder(new Color(197, 199, 207), 3, true));
        btnHard.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnHard.addActionListener(evt -> {
        	ToQueries objPassedVal = new ToQueries(QueriesPanel.this);
        	objPassedVal.btnHardChoices();
        });
        
        JPanel pnlLevels = new JPanel(new GridBagLayout());
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        
        gridBagConstraints.gridx = 0; gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.gridy = 1; pnlLevels.add(lblLevels, gridBagConstraints);
        gridBagConstraints.gridy = 2; pnlLevels.add(btnEasy, gridBagConstraints);
        gridBagConstraints.gridy = 3; pnlLevels.add(btnMedium, gridBagConstraints);
        gridBagConstraints.gridy = 4; pnlLevels.add(btnHard, gridBagConstraints);
       
        gridBagConstraints.insets = new Insets(0, 0, 0, 40);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        pnlMiddleComponentsQueries.add(pnlLevels, gridBagConstraints);
        
        pnlPane1Queries = new JPanel();
        pnlPane1Queries.setBackground(new Color(216, 220, 235));
        pnlPane1Queries.setMinimumSize(new Dimension(400, 200));
        pnlPane1Queries.setPreferredSize(new Dimension(600, 400));
        pnlPane1Queries.setLayout(new BorderLayout());

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        pnlMiddleComponentsQueries.add(pnlPane1Queries, gridBagConstraints);
        
        pnlPane2Queries = new JPanel();
        pnlPane2Queries.setBackground(new Color(216, 220, 235));
        pnlPane2Queries.setMinimumSize(new Dimension(600, 400));
        pnlPane2Queries.setPreferredSize(new Dimension(800, 600));
        pnlPane2Queries.setLayout(new BorderLayout());

        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.NORTH;
        
        pnlMiddleComponentsQueries.add(pnlPane2Queries, gridBagConstraints);
        
        pnlContentQueries.add(pnlMiddleComponentsQueries, BorderLayout.CENTER);

        this.add(pnlContentQueries, BorderLayout.CENTER);
	}
	
	public void setPnlPane1Queries(JComboBox<String> comboBox) {
		pnlPane1Queries.add(comboBox, BorderLayout.NORTH);
	}
	
	public void setPnlPane1Queries(JScrollPane scrollPane) {
		pnlPane1Queries.add(scrollPane, BorderLayout.CENTER);
	}
	
	public void setPnlPane2Queries(JScrollPane scrollPane) {
		pnlPane2Queries.add(scrollPane, BorderLayout.CENTER);
	}
	
	public JPanel getPnlPane1Queries() {
		return pnlPane1Queries;
	}
	
	public JPanel getPnlPane2Queries() {
		return pnlPane2Queries;
	}
	
	
}
