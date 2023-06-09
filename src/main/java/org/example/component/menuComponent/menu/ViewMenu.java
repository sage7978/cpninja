package org.example.component.menuComponent.menu;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import org.example.component.menuComponent.menuitem.NinjaMIv2;
import org.example.module.render.UIRender;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ViewMenu extends JMenu implements ActionListener {
    private JMenuItem appearanceItem;
    public ViewMenu() {
        super("View");
        appearanceItem = NinjaMIv2.createNinjaMIv2(IconFontSwing.buildIcon(FontAwesome.LEAF, 15),
                "Appearance",
                "ctrl+alt+A");
        appearanceItem.addActionListener(this);
        add(appearanceItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Objects.equals(e.getSource(), appearanceItem)) {
            UIRender.renderMessage("appearance btn clicked");
        }
    }
}
