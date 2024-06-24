package org.example.view;

import org.example.util.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaAgendamentoVisitas extends JPanel {
    private JTextField dataField;
    private JTextField horaField;
    private JTextField localField;
    private JTextArea detalhesArea;
    private JTable table;
    private DefaultTableModel tableModel;

    public TelaAgendamentoVisitas() {
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 240, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        JLabel dataLabel = new JLabel("Data:");
        dataLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(dataLabel, gbc);

        dataField = new JTextField(20);
        dataField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(dataField, gbc);

        JLabel horaLabel = new JLabel("Hora:");
        horaLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(horaLabel, gbc);

        horaField = new JTextField(20);
        horaField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(horaField, gbc);

        JLabel localLabel = new JLabel("Local:");
        localLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(localLabel, gbc);

        localField = new JTextField(20);
        localField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(localField, gbc);

        JLabel detalhesLabel = new JLabel("Detalhes:");
        detalhesLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(detalhesLabel, gbc);

        detalhesArea = new JTextArea(10, 20);
        detalhesArea.setFont(fieldFont);
        detalhesArea.setLineWrap(true);
        detalhesArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(detalhesArea);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPane, gbc);

        JButton agendarButton = new JButton("Agendar");
        agendarButton.setFont(labelFont);
        agendarButton.setBackground(new Color(100, 150, 250));
        agendarButton.setForeground(Color.WHITE);
        agendarButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(agendarButton, gbc);

        tableModel = new DefaultTableModel(new Object[]{"Data", "Hora", "Local", "Detalhes"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPaneTable = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPaneTable, gbc);

        carregarDados();


        agendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = dataField.getText();
                String hora = horaField.getText();
                String local = localField.getText();
                String detalhes = detalhesArea.getText();

                try (Connection connection = DBConnection.getConnection()) {
                    String sql = "INSERT INTO visitas (data, hora, local, detalhes) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, data);
                        statement.setString(2, hora);
                        statement.setString(3, local);
                        statement.setString(4, detalhes);
                        statement.executeUpdate();
                    }

                    tableModel.addRow(new Object[]{data, hora, local, detalhes});
                    tableModel.fireTableDataChanged();

                    JOptionPane.showMessageDialog(null, "Visita agendada com sucesso!");
                    limparCampos();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao agendar visita.");
                }
            }
        });
    }

    private void carregarDados() {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "SELECT data, hora, local, detalhes FROM visitas";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String data = resultSet.getString("data");
                    String hora = resultSet.getString("hora");
                    String local = resultSet.getString("local");
                    String detalhes = resultSet.getString("detalhes");
                    tableModel.addRow(new Object[]{data, hora, local, detalhes});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar visitas agendadas.");
        }
    }

    public JTextField getDataField() {
        return dataField;
    }

    public JTextField getHoraField() {
        return horaField;
    }

    public JTextField getLocalField() {
        return localField;
    }

    public JTextArea getDetalhesArea() {
        return detalhesArea;
    }

    public JTable getTable() {
        return table;
    }

    public void limparCampos() {
        dataField.setText("");
        horaField.setText("");
        localField.setText("");
        detalhesArea.setText("");
    }

    public AbstractButton getAgendarButton() {
        return null;
    }
}