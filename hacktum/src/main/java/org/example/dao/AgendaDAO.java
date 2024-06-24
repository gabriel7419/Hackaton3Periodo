package org.example.dao;

import org.example.model.Agenda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    private Connection connection;

    public AgendaDAO(Connection connection) {
        this.connection = connection;
    }

    public Agenda getById(int id) throws SQLException {
        String query = "SELECT * FROM agenda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Agenda(resultSet.getInt("id"), resultSet.getInt("agentesaude_id"));
                }
            }
        }
        return null;
    }

    public List<Agenda> getAll() throws SQLException {
        List<Agenda> agendas = new ArrayList<>();
        String query = "SELECT * FROM agenda";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                agendas.add(new Agenda(resultSet.getInt("id"), resultSet.getInt("agentesaude_id")));
            }
        }
        return agendas;
    }

    public void insert(Agenda agenda) throws SQLException {
        String query = "INSERT INTO agenda (agentesaude_id) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, agenda.getAgenteSaudeId());
            stmt.executeUpdate();
        }
    }

    public void update(Agenda agenda) throws SQLException {
        String query = "UPDATE agenda SET agentesaude_id = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, agenda.getAgenteSaudeId());
            stmt.setInt(2, agenda.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM agenda WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}