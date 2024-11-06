import ui.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskManagerApp extends JFrame {
    private final DefaultListModel<Task> taskModel;
    private final JList<Task> taskList;
    private final JTextField taskNameField;
    private final JComboBox<Priority> priorityComboBox;

    public TaskManagerApp() {
        setTitle("ToDo List");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskList.setCellRenderer(new TaskCellRenderer());

        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(1, 3));
        taskNameField = new JTextField();
        taskNameField.setFont(new Font("Inter", Font.PLAIN, 12));
        priorityComboBox = new JComboBox<>(Priority.values());
        priorityComboBox.setFont(new Font("Inter", Font.BOLD, 12));
        CustomButton addButton = new CustomButton("Añadir tarea");

        inputPanel.add(taskNameField);
        inputPanel.add(priorityComboBox);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        CustomButton deleteButton = new CustomButton("Eliminar tarea", "f00");
        add(deleteButton, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String name = taskNameField.getText();
            Priority priority = (Priority) priorityComboBox.getSelectedItem();
            if (!name.isEmpty()) {
                taskModel.addElement(new Task(name, priority));
                taskNameField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre de tarea.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = taskList.locationToIndex(e.getPoint());
                if (index >= 0) {
                    Task task = taskModel.getElementAt(index);
                    task.toggleStatus();
                    taskList.repaint();
                }
            }
        });

        deleteButton.addActionListener(e -> {
            int selected = taskList.getSelectedIndex();
            if (selected != -1) {
                taskModel.remove(selected);
            }
        });
    }

    public static void main(String[] args) {
        TaskManagerApp app = new TaskManagerApp();
        app.setVisible(true);
    }
}

