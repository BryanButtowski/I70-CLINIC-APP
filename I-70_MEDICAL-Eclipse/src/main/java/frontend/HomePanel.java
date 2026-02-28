package frontend;
import javax.swing.*;
import backend.ToDatabase;
import java.awt.*;

@SuppressWarnings("serial")
public class HomePanel extends JPanel{
	public HomePanel(CardLayout cardLayout, JPanel pnlPageSwitch, UserPanel objUserInput) {
		setOpaque(false);
        setLayout(new BorderLayout());
        
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        UIHelperMethods.addHeader(this, "Patient Record Management System", 0);
        
        JPanel pnlContentHome = new JPanel();
        pnlContentHome.setOpaque(false);
        pnlContentHome.setLayout(new GridBagLayout());
        
        JLabel lblWelcome = new JLabel("WELCOME,");
        lblWelcome.setFont(new Font("Arial", 1, 92)); 
        lblWelcome.setForeground(new Color(98, 113, 204));
        lblWelcome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblWelcome.setAlignmentY(0.0F);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(0, 0, 50, 0);
        pnlContentHome.add(lblWelcome, gridBagConstraints);
        
        JButton btnUser = new JButton();
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2_user.png")));
        btnUser.setContentAreaFilled(false);
        btnUser.setBorderPainted(false);
        btnUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUser.addActionListener(evt -> {
        	ToDatabase objPassedVal = new ToDatabase(objUserInput);
        	if (objPassedVal.userProcessChoice()) {
				cardLayout.show(pnlPageSwitch, "pnlUserPage1");
			} else {
				cardLayout.show(pnlPageSwitch, "pnlHome");
			}
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        pnlContentHome.add(btnUser, gridBagConstraints);
        
        JButton btnAdmin = new JButton();
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/3_admin.png"))); 
        btnAdmin.setContentAreaFilled(false);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdmin.addActionListener(evt -> {
        	ToDatabase objPassedVal = new ToDatabase(objUserInput);
        	if (objPassedVal.adminProcessChoice()) {
        		cardLayout.show(pnlPageSwitch, "pnlAdmin");
        	} else {
        		cardLayout.show(pnlPageSwitch, "pnlHome");
        	}
        });

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        pnlContentHome.add(btnAdmin, gridBagConstraints);

        this.add(pnlContentHome, BorderLayout.CENTER);
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image bg = new ImageIcon(getClass().getResource("/I-70 MEDICAL.png")).getImage();
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }	
}