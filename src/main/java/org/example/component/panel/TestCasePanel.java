package org.example.component.panel;

import org.example.component.ButtonActions;
import org.example.component.CaseComponent;
import org.example.constants.NinjaConstants;

import javax.swing.*;
import java.awt.*;

public class TestCasePanel extends JPanel {
    private CaseComponent           input;
    private CaseComponent           output;
    private CaseComponent           expected;
    private ButtonActions           btnActions;
    private Integer                 count;
    private JScrollPane             scrollPane;
    private Double                  width  = NinjaConstants.TestCase.PANEL_WIDTH;
    private Double                  height = NinjaConstants.TestCase.PANEL_HEIGHT;

    public TestCasePanel(Integer count, ButtonActions btnActions) {
        this.count = count;
        input = new CaseComponent(" Input #"+count, "Run", width/3, height, btnActions, true, CaseComponentEnums.INPUT);
//        input.setPreferredSize(new Dimension(300, 200));

        output = new CaseComponent(" Output #"+count, "**", width/3, height, btnActions, false, CaseComponentEnums.OUTPUT);
//        output.setPreferredSize(new Dimension(300, 200));

        expected = new CaseComponent(" Expected #"+count, "Del", width/3, height, btnActions, true, CaseComponentEnums.EXPECTED);
//        expected.setPreferredSize(new Dimension(300, 200));

        this.setLayout(new GridLayout(1, 3));

        this.add(input);
        this.add(output);
        this.add(expected);
        this.setPreferredSize(new Dimension((int)Math.floor(width), (int)Math.floor(height)));
//        scrollPane = new JScrollPane(this);
    }
}
