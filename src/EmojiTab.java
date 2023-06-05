import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class EmojiTab extends JDialog {

    EmojiTab(Emoji emoji, IconsPanel iconsPanel) throws FontFormatException, IOException {
        this.setIconImage(ImageIO.read(new File("resources\\favicon.png")));
        // this.setAlwaysOnTop(true);
        this.setTitle(emoji.name);
        
        JPanel box = new JPanel();
        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        
        JTextPane emojiIcon = new JTextPane();
        JLabel emojiName = new JLabel(emoji.name.toUpperCase());
        JTextPane emojiCode = new JTextPane();

        emojiIcon.setFont(MyFonts.NotoFont(Font.BOLD, 100f));
        emojiIcon.setAlignmentX(CENTER_ALIGNMENT);
        emojiIcon.setAlignmentY(CENTER_ALIGNMENT);
        emojiIcon.setContentType("text/html");
        emojiIcon.setText("<html><center style=\"font-weight: bolder;font-size: 100px;font-family: 'Noto Emoji', sans-serif;\">" + emoji.emoji + "</center></html>");
        emojiIcon.setEditable(false);
        emojiIcon.setBackground(null);

        emojiName.setFont(MyFonts.RobotoFont(Font.BOLD, 20f));
        emojiName.setBorder(new EmptyBorder(20, 0, 20, 0));
        emojiName.setAlignmentX(CENTER_ALIGNMENT);
        emojiName.setAlignmentY(CENTER_ALIGNMENT);
        emojiName.setVerticalTextPosition(JLabel.CENTER);
        emojiName.setHorizontalTextPosition(JLabel.CENTER);

        emojiCode.setFont(MyFonts.RobotoFont(Font.BOLD, 40f));
        emojiCode.setBorder(new EmptyBorder(20, 0, 20, 0));
        emojiCode.setAlignmentX(CENTER_ALIGNMENT);
        emojiCode.setAlignmentY(CENTER_ALIGNMENT);
        emojiCode.setContentType("text/html");
        emojiCode.setText("<html><center style=\"font-size: 20px;font-family: Roboto, sans-serif;\">U+" + emoji.codepoints+"</center></html>");
        emojiCode.setEditable(false);
        emojiCode.setBackground(null);
        
        box.add(emojiIcon);
        box.add(emojiName);
        box.add(emojiCode);
        box.setBackground(new Color(0xfff999));
        
        this.setSize(370, 500);
        this.add(box);
        this.setLocationRelativeTo(iconsPanel);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}
