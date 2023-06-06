import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.swing.*;

public class Aside extends JPanel implements ActionListener {

	static Set<String> groups;
    private JButton allButton;
    ArrayList<JButton> grpButtons = new ArrayList<>();
    IconsPanel iconsPanel;
    Aside(Set<String> Groups, IconsPanel iconsPanel) throws FontFormatException, IOException {
        groups = Groups;
        this.iconsPanel = iconsPanel;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Iterator<String> group = groups.iterator();

        allButton = new JButton();
        allButton.setText("<html><center style='padding: 3px 5px'>All</center></html>");
        allButton.setBackground(Color.LIGHT_GRAY);
        allButton.setFont(MyFonts.RobotoFont(14f));
        allButton.setFocusable(false);
        allButton.setLayout(new BorderLayout());
        allButton.addActionListener(this);
        this.add(allButton);

        while (group.hasNext()) {
            JButton grpButton = new JButton();
            grpButton.setText("<html><center style='padding: 3px 5px'>" + group.next() + "</center></html>");
            grpButton.setBackground(Color.WHITE);
            grpButton.setFont(MyFonts.RobotoFont(14f));
            grpButton.setFocusable(false);
            grpButton.setLayout(new BorderLayout());
            grpButton.addActionListener(this);
            grpButtons.add(grpButton);
            this.add(grpButton);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == allButton) {
            Data.setSelectedGroup("All");
            allButton.setBackground(Color.LIGHT_GRAY);
            iconsPanel.setNewIcons();
        }
        else 
            allButton.setBackground(Color.WHITE);
            
        for (JButton grpButton : grpButtons) {
        if (e.getSource() == grpButton) {
            // System.out.println(getPlainText(grpButton));
            grpButton.setBackground(Color.LIGHT_GRAY);
            Data.setSelectedGroup(getPlainText(grpButton));
            iconsPanel.setNewIcons();
        }
        else 
           grpButton.setBackground(Color.WHITE);
    }
    }

    private String getPlainText(JButton button) {
        return button.getText()
            .split("<html><center style='padding: 3px 5px'>")[1]
            .split("</center></html>")[0];
    }
}
