package frontend;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	@SuppressWarnings("unused")
	private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    private JPanel pnlPageSwitch;
    private CardLayout cardLayout;

    private HomePanel pnlHome;
    private UserPanel pnlUserPages;
    private AdminPanel pnlAdmin;
    private QueriesPanel pnlQueries;
    
    Image originalImage = new ImageIcon(getClass().getResource("/main_logo.png")).getImage();
    Image scaledImage = originalImage.getScaledInstance(64, 64, Image.SCALE_SMOOTH);

    public MainFrame() {
        setTitle("I-70 MEDICAL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1934, 981);
        setLocationRelativeTo(null);
        setIconImage(scaledImage); 

        pnlPageSwitch = new JPanel();
        cardLayout = new CardLayout();
        pnlPageSwitch.setLayout(cardLayout);
        getContentPane().add(pnlPageSwitch, BorderLayout.CENTER);
        
        pnlUserPages = new UserPanel(cardLayout, pnlPageSwitch);
        pnlAdmin = new AdminPanel(cardLayout, pnlPageSwitch);
        pnlHome = new HomePanel(cardLayout, pnlPageSwitch, pnlUserPages);
        pnlQueries = new QueriesPanel(cardLayout, pnlPageSwitch);
   
        pnlPageSwitch.add(pnlHome, "pnlHome");
        pnlPageSwitch.add(pnlUserPages.pnlUserPage1, "pnlUserPage1");
        pnlPageSwitch.add(pnlUserPages.pnlUserPage2, "pnlUserPage2");
        pnlPageSwitch.add(pnlAdmin, "pnlAdmin");
        pnlPageSwitch.add(pnlQueries, "pnlQueries");

        cardLayout.show(pnlPageSwitch, "pnlHome");
        
        add(pnlPageSwitch, BorderLayout.CENTER);
    }
}
