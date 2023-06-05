import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;

import javax.imageio.ImageIO;
// import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class App {
    public static void main(String[] args) throws Exception {
        new MyFonts();
        
        new Data();
        // ArrayList<Emoji> emojis = data.emojis;
       
        Navbar navbar = new Navbar();
        IconsPanel iconsPanel = new IconsPanel();
        Aside aside = new Aside(Data.groups, iconsPanel);
        JScrollPane scrollableIconPanel = new JScrollPane(iconsPanel);
        JFrame mainWindowFrame = new JFrame();
        
        scrollableIconPanel.getVerticalScrollBar().setUnitIncrement(16);
        aside.setPreferredSize(new Dimension(200, 100));

 
        mainWindowFrame.setIconImage(ImageIO.read(new File("resources\\favicon.png")));
        mainWindowFrame.add(navbar, BorderLayout.NORTH);
        mainWindowFrame.add(aside, BorderLayout.WEST);
        mainWindowFrame.add(scrollableIconPanel, BorderLayout.CENTER);
        
        mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindowFrame.setSize(800, 500);
        mainWindowFrame.setVisible(true);

    }
}
