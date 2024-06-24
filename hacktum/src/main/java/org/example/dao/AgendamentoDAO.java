package org.example.dao;

import org.example.model.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {
    private Connection connection;

    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Agendamento> getAll() throws SQLException {
        List<Agendamento> agendamentos = new ArrayList<>();
        String query = "SELECT * FROM visitas";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                agendamentos.add(new Agendamento(
                        resultSet.getInt("id"),
                        resultSet.getString("data"),
                        resultSet.getString("hora"),
                        resultSet.getString("local"),
                        resultSet.getString("detalhes")
                ));
            }
        }
        return agendamentos;
    }

    public void insert(Agendamento agendamento) throws SQLException {
        String query = "INSERT INTO visitas (data, hora, local, detalhes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, agendamento.getData());
            stmt.setString(2, agendamento.getHora());
            stmt.setString(3, agendamento.getLocal());
            stmt.setString(4, agendamento.getDetalhes());
            stmt.executeUpdate();
        }
    }
}
