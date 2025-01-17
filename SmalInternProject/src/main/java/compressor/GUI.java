package compressor;

import controller.ExecutionController;
import objects.ExpressionEvaluationResult;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private JFrame frame;
    private JTextField fileNameField;
    private JTextField extensionField;
    private JTextArea resultArea;

    public void createAndShowGUI() {
        frame = new JFrame("Arithmetic Computator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileNameField = new JTextField(20);
        extensionField = new JTextField(10);
        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(20));

        panel.add(createCenteredPanel(new JLabel("Введите имя файла:")));
        panel.add(createCenteredPanel(fileNameField));
        panel.add(createCenteredPanel(new JLabel("Введите расширение файла:")));
        panel.add(createCenteredPanel(extensionField));

        JButton calculateButton = new JButton("Вычислить");
        panel.add(createCenteredPanel(calculateButton));

        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(createCenteredPanel(scrollPane));

        frame.add(panel);
        frame.pack();

        frame.setMinimumSize(new Dimension(400, 300));

        frame.setResizable(true);

        frame.setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = fileNameField.getText();
                String extension = extensionField.getText().toLowerCase();

                ArrayList<ExpressionEvaluationResult> answers = ExecutionController.executeEvaluation(extension, filePath);
                StringBuilder result = new StringBuilder();

                for (ExpressionEvaluationResult token : answers) {
                    result.append(token).append("\n");
                }

                resultArea.setText(result.toString());
            }
        });
    }

    private JPanel createCenteredPanel(JComponent component) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(component);
        return panel;
    }

}

