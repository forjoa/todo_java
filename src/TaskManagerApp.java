import ui.CustomButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class TaskManagerApp extends JFrame {
    private final DefaultListModel<Task> taskModel;
    private final JList<Task> taskList;
    private final JTextField taskNameField;
    private final JComboBox<Priority> priorityComboBox;
    private final String[] lookAndFeels = {
            "Metal (Cross-Platform)",
            "Windows",
            "Windows Classic",
            "Nimbus",
            "CDE/Motif"
    };

    public TaskManagerApp() {
        setTitle("ToDo List");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        taskList.setCellRenderer(new TaskCellRenderer());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 5));
        panel.add(taskList);

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(1, 4));
        taskNameField = new JTextField();
        taskNameField.setToolTipText("Input para crear una nueva tarea.");
        taskNameField.setFont(new Font("Inter", Font.PLAIN, 12));
        priorityComboBox = new JComboBox<>(Priority.values());
        priorityComboBox.setToolTipText("Selección de prioridad.");
        priorityComboBox.setFont(new Font("Inter", Font.BOLD, 12));
        CustomButton addButton = new CustomButton("Añadir tarea");
        addButton.setToolTipText("Botón para añadir una nueva tarea.");
        addButton.setMnemonic(KeyEvent.VK_A);

        JComboBox<String> lafc = getStringJComboBox();

        inputPanel.add(taskNameField);
        inputPanel.add(priorityComboBox);
        inputPanel.add(addButton);
        inputPanel.add(lafc);
        add(inputPanel, BorderLayout.NORTH);

        CustomButton deleteButton = new CustomButton("Eliminar tarea", "f00");
        deleteButton.setToolTipText("Botón para borrar la tarea seleccionada.");
        deleteButton.setMnemonic(KeyEvent.VK_D);
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

    private JComboBox<String> getStringJComboBox() {
        JComboBox<String> lafc = new JComboBox<>(lookAndFeels);
        lafc.addActionListener(e -> {
            try {
                String slaf = (String) lafc.getSelectedItem();
                switch (Objects.requireNonNull(slaf)) {
                    case "Metal (Cross-Platform)":
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                        // JOptionPane.showConfirmDialog(null, slaf);
                        break;
                    case "Windows":
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                        // JOptionPane.showConfirmDialog(null, slaf);
                        break;
                    case "Windows Classic":
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                        // JOptionPane.showConfirmDialog(null, slaf);
                        break;
                    case "Nimbus":
                        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                        // JOptionPane.showConfirmDialog(null, slaf);
                        break;
                    case "CDE/Motif":
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                        // JOptionPane.showConfirmDialog(null, slaf);
                        break;
                    default:
                        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                        break;
                }
                SwingUtilities.updateComponentTreeUI(TaskManagerApp.this);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        return lafc;
    }

    public static void main(String[] args) {
        TaskManagerApp app = new TaskManagerApp();
        app.setVisible(true);
    }
}

