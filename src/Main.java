import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {
    public static void main(String[] args) throws Exception {
        new MyFonts();
        new Data();

        Navbar navbar = new Navbar();
        IconsPanel iconsPanel = new IconsPanel();
        Aside aside = new Aside(Data.groups, iconsPanel);
        JScrollPane scrollableIconPanel = new JScrollPane(iconsPanel);
        JFrame mainWindowFrame = new JFrame();
        
        scrollableIconPanel.getVerticalScrollBar().setUnitIncrement(16);
        aside.setPreferredSize(new Dimension(200, 100));
 
        ImageIcon favIcon = new ImageIcon(Main.class.getClassLoader().getResource("favicon.png"));

        mainWindowFrame.setIconImage(favIcon.getImage());
        mainWindowFrame.add(navbar, BorderLayout.NORTH);
        mainWindowFrame.add(aside, BorderLayout.WEST);
        mainWindowFrame.add(scrollableIconPanel, BorderLayout.CENTER);
        
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setSize(800, 500);
        mainWindowFrame.setVisible(true);

    }
}
