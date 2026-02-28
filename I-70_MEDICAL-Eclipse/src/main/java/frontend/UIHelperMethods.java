package frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;

public class UIHelperMethods {
	public static void addHeader(JPanel pnlAddHere, String strngSubText, int intVariation) {
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
	
        JPanel pnlHeader = new JPanel(new GridBagLayout());
        pnlHeader.setOpaque(true);
        pnlHeader.setBackground(Color.decode("#727fd0"));
        
        JLabel lblLogoHome = new JLabel();
        lblLogoHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogoHome.setIcon(new javax.swing.ImageIcon(UIHelperMethods.class.getResource("/1_logo.png")));  
        lblLogoHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblLogoHome.setMinimumSize(new Dimension(140, 120));
        lblLogoHome.setPreferredSize(new Dimension(140, 120));
        gridBagConstraints.gridx = 0; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        pnlHeader.add(lblLogoHome, gridBagConstraints);
       
        JLabel lblMain = new JLabel("I-70 MEDICAL CLINIC");
        lblMain.setFont(new Font("Tahoma", Font.BOLD, 60));
        lblMain.setForeground(Color.WHITE);
        JLabel lblSub = new JLabel(strngSubText);
        lblSub.setFont(new Font("Arial", Font.PLAIN, 30));
        lblSub.setForeground(Color.WHITE);
        JPanel pnlText = new JPanel();
        pnlText.setLayout(new BoxLayout(pnlText, BoxLayout.Y_AXIS));
        pnlText.add(lblMain);
        pnlText.add(lblSub);
        pnlText.setOpaque(false); 
        pnlText.setMinimumSize(new Dimension(120, 120));
        gridBagConstraints.gridx = 1; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        pnlHeader.add(pnlText, gridBagConstraints);
        
        JLabel lblSpacer = new JLabel();
		lblSpacer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblSpacer.setMinimumSize(new Dimension(100, 95));
		lblSpacer.setPreferredSize(new Dimension(500, 95));
        gridBagConstraints.gridx = 2; gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = GridBagConstraints.LINE_START;
        if (intVariation == 0) {
        	// if no tab indicator is needed 
		}
        else if (intVariation == 1) { // header with tab 1
        	lblSpacer.setIcon(new javax.swing.ImageIcon(UIHelperMethods.class.getResource("/4_usertab.png")));  
		}
        else if (intVariation == 2) { // header with tab 2
        	lblSpacer.setIcon(new javax.swing.ImageIcon(UIHelperMethods.class.getResource("/5_usertab.png")));  
		}
        pnlHeader.add(lblSpacer, gridBagConstraints);
        
        JLabel lblCross = new JLabel();
        lblCross.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCross.setIcon(new javax.swing.ImageIcon(UIHelperMethods.class.getResource("/11_cross.png")));  
        lblCross.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblCross.setPreferredSize(new Dimension(220, 130));
        lblCross.setMinimumSize(new Dimension(100, 130));
        gridBagConstraints.gridx = 3; gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        pnlHeader.add(lblCross, gridBagConstraints);

        pnlAddHere.add(pnlHeader, BorderLayout.NORTH);
    }
	
	
	public static JScrollPane getQueryScrollPane(String sqlQuery) {
	    JTextArea queryTextArea = new JTextArea();
	    queryTextArea.setText(sqlQuery); 
	    queryTextArea.setEditable(false);
	    queryTextArea.setBackground(new Color(216, 220, 235));
	    queryTextArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
	    queryTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    JScrollPane scrollPane = new JScrollPane(queryTextArea);
	    scrollPane.setBorder(null); 

	    return scrollPane;
	}
	
	
	public static JScrollPane getQueryTableScrollable(DefaultTableModel model) {
	    @SuppressWarnings("serial")
		JTable patientTable = new JTable(model) {
	    	@Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };
	    
	    patientTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	    
	    for (int i = 0; i < patientTable.getColumnModel().getColumnCount(); i++) {
	        patientTable.getColumnModel().getColumn(i).setPreferredWidth(150); 
	    }
	    
	    patientTable.setFont(new Font("Lantinghei TC", Font.PLAIN, 14));
	    patientTable.setRowHeight(25);
	    patientTable.setShowGrid(true);
	    patientTable.setGridColor(new Color(200, 200, 200));
	    patientTable.setBackground(new Color(240, 240, 245));
	    
	    JTableHeader header = patientTable.getTableHeader();
	    header.setFont(new Font("Lantinghei TC", Font.BOLD, 16));
	    header.setBackground(new Color(169, 178, 227));
	    header.setForeground(Color.WHITE);

	    JScrollPane scrollPane = new JScrollPane(
	        patientTable,
	        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
	    );
	    scrollPane.setBorder(null);
	    
	    return scrollPane;
	}
	
	public static JScrollPane getQueryTableNonScrollable(DefaultTableModel model) {
	    @SuppressWarnings("serial")
		JTable patientTable = new JTable(model) {
	    	@Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };

	    patientTable.setFont(new Font("Lantinghei TC", Font.PLAIN, 14));
	    patientTable.setRowHeight(25);
	    patientTable.setShowGrid(true);
	    patientTable.setGridColor(new Color(200, 200, 200));
	    patientTable.setBackground(new Color(240, 240, 245));
	    
	    JTableHeader header = patientTable.getTableHeader();
	    header.setFont(new Font("Lantinghei TC", Font.BOLD, 16));
	    header.setBackground(new Color(169, 178, 227));
	    header.setForeground(Color.WHITE);
	    
	    JScrollPane scrollPane = new JScrollPane(patientTable);
	    scrollPane.setBorder(null);
	    
	    return scrollPane;
	}
	
	
	public static void resetPnlQuery(QueriesPanel controlQueries, JComboBox<String> cmbDifficulties) {
        controlQueries.getPnlPane1Queries().removeAll();
        controlQueries.getPnlPane1Queries().revalidate();
        controlQueries.getPnlPane1Queries().repaint();
        controlQueries.setPnlPane1Queries(cmbDifficulties);
        controlQueries.getPnlPane2Queries().removeAll();
        controlQueries.getPnlPane2Queries().revalidate();
        controlQueries.getPnlPane2Queries().repaint();
	}
	

	public static void resetPnlPreviewPaneAdmin(AdminPanel fetchTable) {
        fetchTable.getPnlPreviewPaneAdmin().removeAll();
        fetchTable.getPnlPreviewPaneAdmin().revalidate();
        fetchTable.getPnlPreviewPaneAdmin().repaint();
		
	}
}
