package org.example.dao;

import org.example.model.AgenteSaude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenteSaudeDAO {
    private Connection connection;

    public AgenteSaudeDAO(Connection connection) {
        this.connection = connection;
    }

    public AgenteSaude getById(int id) throws SQLException {
        String query = "SELECT * FROM agentesaude WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new AgenteSaude(
                            rs.getInt("id"),
                            rs.getString("agente"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                }
            }
        }
        return null;
    }

    public List<AgenteSaude> getAll() throws SQLException {
        List<AgenteSaude> agentes = new ArrayList<>();
        String query = "SELECT * FROM agentesaude";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                agentes.add(new AgenteSaude(
                        rs.getInt("id"),
                        rs.getString("agente"),
                        rs.getString("email"),
                        rs.getString("senha")
                ));
            }
        }
        return agentes;
    }

    public void save(AgenteSaude agenteSaude) throws SQLException {
        String query = "INSERT INTO agentesaude (nome, email, senha) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, agenteSaude.getNome());
            stmt.setString(2, agenteSaude.getEmail());
            stmt.setString(3, agenteSaude.getSenha());
            stmt.executeUpdate();
        }
    }


    public void update(AgenteSaude agenteSaude) throws SQLException {
        String query = "UPDATE agentesaude SET agente = ?, email = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(2, agenteSaude.getEmail());
            stmt.setString(3, agenteSaude.getSenha());
            stmt.setInt(4, agenteSaude.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM agentesaude WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}