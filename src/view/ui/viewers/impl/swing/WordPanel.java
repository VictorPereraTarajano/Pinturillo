package view.ui.viewers.impl.swing;


import view.ui.display.impl.swing.WordDisplay;

import javax.swing.*;
import java.awt.*;

public class WordPanel extends JPanel implements view.ui.viewers.interfaces.WordPanel {

    private WordDisplay wordDisplay;

    public WordPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Word Panel"));
        createWidgets();
    }

    private void createWidgets() {
        add(createWordDisplay());
    }

    private Component createWordDisplay() {
        wordDisplay = new WordDisplay();
        return wordDisplay;
    }

    @Override
    public void refresh() {

    }
}