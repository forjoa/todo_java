import ui.CustomLabel;

import javax.swing.*;
import java.awt.*;

public class TaskCellRenderer extends JPanel implements ListCellRenderer<Task> {
    private final JLabel nameLabel;
    private final JLabel iconLabel;

    public TaskCellRenderer() {
        setLayout(new BorderLayout());
        nameLabel = new JLabel();
        iconLabel = new JLabel();
        add(iconLabel, BorderLayout.WEST);
        add(nameLabel, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Task> list, Task task, int index, boolean isSelected, boolean cellHasFocus) {
        nameLabel.setText(new CustomLabel(task.getName(), task.isCompleted()).getText());
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 12));

        switch (task.getPriority()) {
            case ALTA:
                iconLabel.setIcon(new ImageIcon((new ImageIcon("red.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
            case MEDIA:
                iconLabel.setIcon(new ImageIcon((new ImageIcon("yellow.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
            case BAJA:
                iconLabel.setIcon(new ImageIcon((new ImageIcon("green.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
                break;
        }

        setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
        return this;
    }
}

