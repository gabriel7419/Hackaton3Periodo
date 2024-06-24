package org.example;

import org.example.dao.HistoricoDAO;
import org.example.model.Historico;
import org.example.util.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TelaHistoricoSaude extends JPanel {
    private JTextField nomeField;
    private JCheckBox febreCheckBox;
    private JCheckBox dorCabecaCheckBox;
    private JCheckBox tosseCheckBox;
    private JCheckBox vacinaCheckBox;
    private JComboBox<String> vacinaComboBox;
    private JTextField pesoField;
    private JTextField alturaField;
    private JTextArea alergiasArea;
    private JTextField medicoField;
    private JTable table;
    private DefaultTableModel tableModel;

    public TelaHistoricoSaude() {
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 240, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nomeLabel, gbc);

        nomeField = new JTextField(20);
        nomeField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nomeField, gbc);

        JLabel checkInLabel = new JLabel("Check-in de Saúde:");
        checkInLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(checkInLabel, gbc);

        febreCheckBox = new JCheckBox("Febre");
        febreCheckBox.setFont(fieldFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(febreCheckBox, gbc);

        dorCabecaCheckBox = new JCheckBox("Dor de Cabeça");
        dorCabecaCheckBox.setFont(fieldFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(dorCabecaCheckBox, gbc);

        tosseCheckBox = new JCheckBox("Tosse");
        tosseCheckBox.setFont(fieldFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(tosseCheckBox, gbc);

        vacinaCheckBox = new JCheckBox("Vacina");
        vacinaCheckBox.setFont(fieldFont);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(vacinaCheckBox, gbc);

        vacinaComboBox = new JComboBox<>(new String[]{"Pfizer", "Moderna", "AstraZeneca", "Johnson & Johnson", "Sinovac", "Outra"});
        vacinaComboBox.setFont(fieldFont);
        vacinaComboBox.setEnabled(false);
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(vacinaComboBox, gbc);

        vacinaCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vacinaComboBox.setEnabled(vacinaCheckBox.isSelected());
            }
        });

        JLabel pesoLabel = new JLabel("Peso:");
        pesoLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(pesoLabel, gbc);

        pesoField = new JTextField(10);
        pesoField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(pesoField, gbc);

        JLabel alturaLabel = new JLabel("Altura:");
        alturaLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(alturaLabel, gbc);

        alturaField = new JTextField(10);
        alturaField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(alturaField, gbc);

        JLabel alergiasLabel = new JLabel("Alergias:");
        alergiasLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(alergiasLabel, gbc);

        alergiasArea = new JTextArea(5, 20);
        alergiasArea.setFont(fieldFont);
        alergiasArea.setLineWrap(true);
        alergiasArea.setWrapStyleWord(true);
        JScrollPane scrollPaneAlergias = new JScrollPane(alergiasArea);
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPaneAlergias, gbc);

        JLabel medicoLabel = new JLabel("Médico:");
        medicoLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(medicoLabel, gbc);

        medicoField = new JTextField(20);
        medicoField.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.gridy = 9;
        add(medicoField, gbc);

        JButton salvarButton = new JButton("Salvar Check-in");
        salvarButton.setFont(labelFont);
        salvarButton.setBackground(new Color(100, 150, 250));
        salvarButton.setForeground(Color.WHITE);
        salvarButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        add(salvarButton, gbc);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Check-in de Saúde", "Peso", "Altura", "Alergias", "Médico"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPaneTable = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPaneTable, gbc);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                boolean febre = febreCheckBox.isSelected();
                boolean dorCabeca = dorCabecaCheckBox.isSelected();
                boolean tosse = tosseCheckBox.isSelected();
                String vacina = vacinaCheckBox.isSelected() ? (String) vacinaComboBox.getSelectedItem() : null;

                float peso = 0;
                float altura = 0;

                try {
                    peso = Float.parseFloat(pesoField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para o peso.");
                    return;
                }

                try {
                    altura = Float.parseFloat(alturaField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para a altura.");
                    return;
                }

                String alergias = alergiasArea.getText();
                String medico = medicoField.getText();

                Historico historico = new Historico(0, nome, febre, dorCabeca, tosse, vacina, peso, altura, alergias, medico);

                try (Connection connection = DBConnection.getConnection()) {
                    HistoricoDAO historicoDAO = new HistoricoDAO(connection);
                    historicoDAO.insert(historico);
                    JOptionPane.showMessageDialog(null, "Check-in de saúde salvo com sucesso!");

                    tableModel.addRow(new Object[]{nome, getCheckInSaude(febre, dorCabeca, tosse, vacina), peso, altura, alergias, medico});
                    tableModel.fireTableDataChanged();

                    limparCampos();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar no banco de dados: " + ex.getMessage());
                }
            }
        });

        carregarHistoricos();
    }

    private String getCheckInSaude(boolean febre, boolean dorCabeca, boolean tosse, String vacina) {
        StringBuilder checkInSaude = new StringBuilder();
        if (febre) checkInSaude.append("Febre, ");
        if (dorCabeca) checkInSaude.append("Dor de Cabeça, ");
        if (tosse) checkInSaude.append("Tosse, ");
        if (vacina != null) checkInSaude.append("Vacina ").append(vacina).append(", ");
        if (checkInSaude.length() > 0) checkInSaude.setLength(checkInSaude.length() - 2);
        return checkInSaude.toString();
    }

    private void limparCampos() {
        nomeField.setText("");
        febreCheckBox.setSelected(false);
        dorCabecaCheckBox.setSelected(false);
        tosseCheckBox.setSelected(false);
        vacinaCheckBox.setSelected(false);
        vacinaComboBox.setEnabled(false);
        vacinaComboBox.setSelectedIndex(0);
        pesoField.setText("");
        alturaField.setText("");
        alergiasArea.setText("");
        medicoField.setText("");
    }

    private void carregarHistoricos() {
        try (Connection connection = DBConnection.getConnection()) {
            HistoricoDAO historicoDAO = new HistoricoDAO(connection);
            List<Historico> historicos = historicoDAO.getAll();

            for (Historico historico : historicos) {
                tableModel.addRow(new Object[]{
                        historico.getNome(),
                        getCheckInSaude(historico.isFebre(), historico.isDorCabeca(), historico.isTosse(), historico.getVacina()),
                        historico.getPeso(),
                        historico.getAltura(),
                        historico.getAlergias(),
                        historico.getMedico()
                });
            }

            tableModel.fireTableDataChanged();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar históricos de saúde: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tela Histórico de Saúde");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.add(new TelaHistoricoSaude());
        frame.setVisible(true);
    }
}
