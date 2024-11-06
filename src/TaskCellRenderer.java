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
        nameLabel.setText(task.getName());
        nameLabel.setForeground(task.isCompleted() ? Color.GRAY : Color.BLACK);

        switch (task.getPriority()) {
            case HIGH -> iconLabel.setIcon(new ImageIcon("red.jpg"));
            case MEDIUM -> iconLabel.setIcon(new ImageIcon("yellow.jpg"));
            case LOW -> iconLabel.setIcon(new ImageIcon("green.jpg"));
        }

        setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
        return this;
    }
}

