import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class IconsPanel extends JPanel implements ActionListener {

    static ArrayList<Emoji> emojis = new ArrayList<>();
    private ArrayList<JButton> emojiButtons = new ArrayList<>();
    EmojiTab emojiTab;
    IconsPanel() {
        this.setLayout(new GridLayout(0, 6));
        startThread(this);
    }

    private static void startThread(IconsPanel iconsPanel) {
        SwingWorker<String, Emoji> sw = new SwingWorker<>() {

            @Override
            protected String doInBackground() throws Exception {
                for (Emoji emoji : emojis) {
                    // publish(emoji);
                    JButton emojiBtn = new JButton();
                    emojiBtn.setFont(MyFonts.NotoEmojiFont);
                    emojiBtn.setText(emoji.emoji);
                    emojiBtn.setSize(new Dimension(100, 100));
                    emojiBtn.setFocusable(false);
                    emojiBtn.addActionListener(iconsPanel);
                    emojiBtn.setBackground(new Color(0xfeffa4));
                    iconsPanel.emojiButtons.add(emojiBtn);
                    iconsPanel.add(emojiBtn);
                }
                return "Complete";
            }
        };
        sw.execute();
    }
    public void setNewIcons() {
        this.removeAll();
        this.emojiButtons.clear();
        for (Emoji emoji : emojis) {
            // publish(emoji);
            JButton emojiBtn = new JButton();
            emojiBtn.setFont(MyFonts.NotoEmojiFont);
            emojiBtn.setText(emoji.emoji);
            emojiBtn.setSize(new Dimension(100, 100));
            emojiBtn.setFocusable(false);
            emojiBtn.setBackground(new Color(0xfeffa4));
            emojiBtn.addActionListener(this);
            this.emojiButtons.add(emojiBtn);
            this.add(emojiBtn);
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i< emojiButtons.size(); i++) {
            if(e.getSource() == emojiButtons.get(i))
            {
                try {
                    if (emojiTab!= null) emojiTab.dispose();
                    
                    emojiTab = new EmojiTab(emojis.get(i), this);
                } catch (FontFormatException | IOException erorr) {
                    System.out.println(erorr.getMessage());
                    erorr.printStackTrace();
                }
                // System.out.println(emojis.get(i).emoji == emojiButtons.get(i).getText());
                
            }
        }
    }
}