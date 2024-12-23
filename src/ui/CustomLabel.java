package ui;

import javax.swing.*;

public class CustomLabel extends JLabel {
    public final static String PRE = "<html><p style=\"margin: 0px 10px;\">";
    public final static String POST = "</p></html>";

    public CustomLabel(String text) {
        super(PRE + text + POST);
    }

    public CustomLabel(String text, boolean isCompleted) {
        super(isCompleted ? PRE + "<strike>" + text + "</strike>" + POST : PRE + text + POST);
    }
}
