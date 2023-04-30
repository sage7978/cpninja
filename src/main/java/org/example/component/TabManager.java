package org.example.component;

import org.example.entity.Problem;
import org.example.utils.MyCloseActionHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TabManager {
    private static JTabbedPane tabPane = null;

    public TabManager() {
        if(Objects.isNull(tabPane)) {
            tabPane = new JTabbedPane();
            addANewTab("New Tab");
        }
    }

    public static JTabbedPane getTabPane() {
        return tabPane;
    }

    public static void addANewTab(String title) {
        JPanel tabBody = new JPanel();
        tabPane.addTab(title, tabBody);
        int index = tabPane.indexOfTab(title);
        JPanel pnlTab = new JPanel(new GridBagLayout());
        pnlTab.setOpaque(false);
        JLabel lblTitle = new JLabel(title);
        JButton btnClose = new JButton("x");
        customizeTabCloseButton(btnClose);
//        btnClose.setOpaque(false);
////        btnClose.setBorderPainted(false);
//        btnClose.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
//        btnClose.setContentAreaFilled(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx=0;gbc.gridy=0;gbc.weightx=1;
        pnlTab.add(lblTitle, gbc);

        gbc.gridx++;gbc.weightx=0;
        pnlTab.add(btnClose, gbc);

        tabPane.setTabComponentAt(index, pnlTab);

        MyCloseActionHandler myCloseActionHandler = new MyCloseActionHandler(title, tabPane);
        btnClose.addActionListener(myCloseActionHandler);
    }

    private static void customizeTabCloseButton(JButton button){
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        button.setContentAreaFilled(false);
    }

    public static JPanel currentActiveTabPanel() {
        int selectedTabIndex = tabPane.getSelectedIndex();
        if(selectedTabIndex == -1) {
            System.out.println("No tab selected");

            int lastTabIndex = totalNumberOfTabs();
            selectedTabIndex = lastTabIndex;
        }
        return (JPanel) tabPane.getComponentAt(selectedTabIndex);
    }

    public static int totalNumberOfTabs() {
        return tabPane.getTabCount();
    }

    public static int currentActiveTab() {
        return tabPane.getSelectedIndex();
    }
}





