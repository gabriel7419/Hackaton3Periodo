package org.example;

import org.example.view.TelaAgendamentoVisitas;
import org.example.view.TelaAlertasLembretes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Saúde");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JTabbedPane tabbedPane = new JTabbedPane();

            tabbedPane.addTab("Cadastro de Usuários", new org.example.TelaCadastroUsuarios());
            tabbedPane.addTab("Histórico de Saúde", new org.example.TelaHistoricoSaude());
            tabbedPane.addTab("Agendamento de Visitas", new TelaAgendamentoVisitas());
            tabbedPane.addTab("Alertas e Lembretes", new TelaAlertasLembretes());

            frame.add(tabbedPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
