package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.example.dao.IdosoDAO;
import org.example.model.Idoso;
import org.example.util.DBConnection;

public class TelaCadastroUsuarios extends JPanel {
    private JTextField idField;
    private JTextField nomeField;
    private JTextField cpfField;
    private JTextField cartaoSusField;
    private JTextField cepField;
    private JTextField logradouroField;
    private JTextField dataNascField;
    private JTextField nomeRespField;
    private JTextField cpfRespField;
    private JTextField emailRespField;
    private JTextField celular1Field;
    private JTextField celular2Field;
    private JTextField celular3Field;
    private JPasswordField senhaField;
    private JTable table;
    private DefaultTableModel tableModel;

    private IdosoDAO idosoDAO;

    public TelaCadastroUsuarios() {
        setLayout(new GridBagLayout());
        setBackground(new Color(230, 240, 255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        int y = 0;

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(idLabel, gbc);

        idField = new JTextField(20);
        idField.setFont(fieldFont);
        gbc.gridx = 1;
        add(idField, gbc);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(nomeLabel, gbc);

        nomeField = new JTextField(20);
        nomeField.setFont(fieldFont);
        gbc.gridx = 1;
        add(nomeField, gbc);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(cpfLabel, gbc);

        cpfField = new JTextField(20);
        cpfField.setFont(fieldFont);
        gbc.gridx = 1;
        add(cpfField, gbc);

        JLabel cartaoSusLabel = new JLabel("Cartão SUS:");
        cartaoSusLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(cartaoSusLabel, gbc);

        cartaoSusField = new JTextField(20);
        cartaoSusField.setFont(fieldFont);
        gbc.gridx = 1;
        add(cartaoSusField, gbc);

        JLabel cepLabel = new JLabel("CEP:");
        cepLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(cepLabel, gbc);

        cepField = new JTextField(20);
        cepField.setFont(fieldFont);
        gbc.gridx = 1;
        add(cepField, gbc);

        JLabel logradouroLabel = new JLabel("Logradouro:");
        logradouroLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(logradouroLabel, gbc);

        logradouroField = new JTextField(20);
        logradouroField.setFont(fieldFont);
        gbc.gridx = 1;
        add(logradouroField, gbc);

        JLabel dataNascLabel = new JLabel("Data de Nascimento:");
        dataNascLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(dataNascLabel, gbc);

        dataNascField = new JTextField(20);
        dataNascField.setFont(fieldFont);
        gbc.gridx = 1;
        add(dataNascField, gbc);

        JLabel nomeRespLabel = new JLabel("Nome do Responsável:");
        nomeRespLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(nomeRespLabel, gbc);

        nomeRespField = new JTextField(20);
        nomeRespField.setFont(fieldFont);
        gbc.gridx = 1;
        add(nomeRespField, gbc);

        JLabel cpfRespLabel = new JLabel("CPF do Responsável:");
        cpfRespLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(cpfRespLabel, gbc);

        cpfRespField = new JTextField(20);
        cpfRespField.setFont(fieldFont);
        gbc.gridx = 1;
        add(cpfRespField, gbc);

        JLabel emailRespLabel = new JLabel("E-mail do Responsável:");
        emailRespLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(emailRespLabel, gbc);

        emailRespField = new JTextField(20);
        emailRespField.setFont(fieldFont);
        gbc.gridx = 1;
        add(emailRespField, gbc);

        JLabel celular1Label = new JLabel("Celular 1:");
        celular1Label.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(celular1Label, gbc);

        celular1Field = new JTextField(20);
        celular1Field.setFont(fieldFont);
        gbc.gridx = 1;
        add(celular1Field, gbc);

        JLabel celular2Label = new JLabel("Celular 2:");
        celular2Label.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(celular2Label, gbc);

        celular2Field = new JTextField(20);
        celular2Field.setFont(fieldFont);
        gbc.gridx = 1;
        add(celular2Field, gbc);

        JLabel celular3Label = new JLabel("Celular 3:");
        celular3Label.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(celular3Label, gbc);

        celular3Field = new JTextField(20);
        celular3Field.setFont(fieldFont);
        gbc.gridx = 1;
        add(celular3Field, gbc);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = y++;
        add(senhaLabel, gbc);

        senhaField = new JPasswordField(20);
        senhaField.setFont(fieldFont);
        gbc.gridx = 1;
        add(senhaField, gbc);

        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            idosoDAO = new IdosoDAO(connection);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.");
        }

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(labelFont);
        cadastrarButton.setBackground(new Color(100, 150, 250));
        cadastrarButton.setForeground(Color.WHITE);
        cadastrarButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = y++;
        add(cadastrarButton, gbc);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String cpf = cpfField.getText();
                String cartaoSus = cartaoSusField.getText();
                String cep = cepField.getText();
                String logradouro = logradouroField.getText();
                String dataNasc = dataNascField.getText();
                String nomeResp = nomeRespField.getText();
                String cpfResp = cpfRespField.getText();
                String emailResp = emailRespField.getText();
                String celular1 = celular1Field.getText();
                String celular2 = celular2Field.getText();
                String celular3 = celular3Field.getText();
                String senha = new String(senhaField.getPassword());

                Idoso novoIdoso = new Idoso(0, nome, cpf, cartaoSus, cep, logradouro, dataNasc, nomeResp, cpfResp, emailResp, celular1, celular2, celular3, senha);

                try {
                    idosoDAO.insert(novoIdoso);

                    atualizarTabela();

                    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                    limparCampos();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário.");
                }
            }
        });

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF", "Cartão SUS", "CEP", "Logradouro", "Data de Nascimento", "Nome do Responsável", "CPF do Responsável", "E-mail do Responsável", "Celular 1", "Celular 2", "Celular 3", "Senha"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = y++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(scrollPane, gbc);

        atualizarTabela();
    }

    public void atualizarTabela() {
        try {

            tableModel.setRowCount(0);

            List<Idoso> idosos = idosoDAO.getAll();

            for (Idoso idoso : idosos) {
                tableModel.addRow(new Object[]{idoso.getId(), idoso.getNome(), idoso.getCpf(), idoso.getCartaoSus(), idoso.getCep(), idoso.getLogradouro(), idoso.getDataNascimento(), idoso.getNomeResponsavel(), idoso.getCpfResponsavel(), idoso.getEmailResponsavel(), idoso.getCelular1(), idoso.getCelular2(), idoso.getCelular3(), idoso.getSenha()});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados.");
        }
    }

    public JTextField getIdField() {
        return idField;
    }

    public JTextField getNomeField() {
        return nomeField;
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public JTextField getCartaoSusField() {
        return cartaoSusField;
    }

    public JTextField getCepField() {
        return cepField;
    }

    public JTextField getLogradouroField() {
        return logradouroField;
    }

    public JTextField getDataNascField() {
        return dataNascField;
    }

    public JTextField getNomeRespField() {
        return nomeRespField;
    }

    public JTextField getCpfRespField() {
        return cpfRespField;
    }

    public JTextField getEmailRespField() {
        return emailRespField;
    }

    public JTextField getCelular1Field() {
        return celular1Field;
    }

    public JTextField getCelular2Field() {
        return celular2Field;
    }

    public JTextField getCelular3Field() {
        return celular3Field;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public JTable getTable() {
        return table;
    }

    public void limparCampos() {
        idField.setText("");
        nomeField.setText("");
        cpfField.setText("");
        cartaoSusField.setText("");
        cepField.setText("");
        logradouroField.setText("");
        dataNascField.setText("");
        nomeRespField.setText("");
        cpfRespField.setText("");
        emailRespField.setText("");
        celular1Field.setText("");
        celular2Field.setText("");
        celular3Field.setText("");
        senhaField.setText("");
    }

    public AbstractButton getCadastrarButton() {
        return null;
    }
}

