package ui;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {
    private static final String BUTTON_HTML_TEMPLATE = "<html><div style=\"padding: 8px 15px; "
                                                       + "margin: 5px; border-radius: 10px; background-color: #%s; "
                                                       + "color: white; font-family: Inter;\">%s</div></html>";

    public CustomButton(String text, String backgroundColor) {
        super(String.format(BUTTON_HTML_TEMPLATE, backgroundColor, text));
        initializeButton();
    }

    public CustomButton(String text) {
        this(text, "007bff");
    }

    public void initializeButton() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }
}
