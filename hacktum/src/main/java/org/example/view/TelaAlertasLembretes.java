package org.example.view;

import org.example.util.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaAlertasLembretes extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public TelaAlertasLembretes() {
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 240, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);

        JLabel alertasLabel = new JLabel("Lista de Alertas e Lembretes");
        alertasLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(alertasLabel, gbc);

        tableModel = new DefaultTableModel(new Object[]{"Data", "Descrição"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPane, gbc);

        JButton adicionarButton = new JButton("Adicionar Alerta");
        adicionarButton.setFont(labelFont);
        adicionarButton.setBackground(new Color(100, 150, 250));
        adicionarButton.setForeground(Color.WHITE);
        adicionarButton.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(adicionarButton, gbc);

        JButton salvarButton = new JButton("Salvar Lista");
        salvarButton.setFont(labelFont);
        salvarButton.setBackground(new Color(100, 150, 250));
        salvarButton.setForeground(Color.WHITE);
        salvarButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(salvarButton, gbc);

        JButton limparButton = new JButton("Limpar Lista");
        limparButton.setFont(labelFont);
        limparButton.setBackground(new Color(250, 100, 100));
        limparButton.setForeground(Color.WHITE);
        limparButton.setFocusPainted(false);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(limparButton, gbc);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = JOptionPane.showInputDialog(null, "Digite a data do alerta:");
                String descricao = JOptionPane.showInputDialog(null, "Digite a descrição do alerta:");

                if (data != null && descricao != null) {
                    tableModel.addRow(new Object[]{data, descricao});
                }
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarLista();
                salvarNoBanco();
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja limpar a lista?", "Confirmar Limpeza", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    tableModel.setRowCount(0);
                }
            }
        });

        recuperarDoBanco();
    }

    private void salvarLista() {
        try {
            FileWriter writer = new FileWriter("alertas_lembretes.csv");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.append(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Lista salva com sucesso!");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar a lista.");
        }
    }

    private void salvarNoBanco() {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DBConnection.getConnection();

            String sql = "INSERT INTO horarios_disponiveis (data_hora, disponivel) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                statement.setString(1, tableModel.getValueAt(i, 0).toString());
                statement.setString(2, tableModel.getValueAt(i, 1).toString());
                statement.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso na tabela horarios_disponiveis.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados na tabela horarios_disponiveis.");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void recuperarDoBanco() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT data_hora, disponivel FROM horarios_disponiveis";
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String data = resultSet.getString("data_hora");
                String disponivel	 = resultSet.getString("disponivel");
                tableModel.addRow(new Object[]{data, disponivel	});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null
                    , "Erro ao recuperar dados do banco de dados.");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
