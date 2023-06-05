import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Navbar extends JPanel {
    Navbar() throws FontFormatException, IOException {
        this.setBorder(new EmptyBorder(0, 5, 0, 0));
        ImageIcon navIcon = new ImageIcon("resources\\open-book-emoji-48.png");
        JLabel navHead = new JLabel(" Emojipedia");
        
        Image image = navIcon.getImage(); // transform it 
        Image resizedIcon = image.getScaledInstance(35, 35,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        navIcon = new ImageIcon(resizedIcon);  // 

        navHead.setIcon(navIcon);
        navHead.setVerticalAlignment(JLabel.CENTER);
        navHead.setForeground(Color.WHITE);
        navHead.setFont(MyFonts.RobotoFont(Font.BOLD,18f));
        
        this.setLayout(new BorderLayout());
        this.add(navHead, BorderLayout.WEST);
        this.setBackground(new Color(0x141433));
        this.setPreferredSize(new Dimension(50, 50));
    }
}
