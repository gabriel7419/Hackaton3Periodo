package org.example.dao;

import org.example.model.HorarioDisponivel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorarioDisponivelDAO {
    private Connection connection;

    public HorarioDisponivelDAO(Connection connection) {
        this.connection = connection;
    }

    public HorarioDisponivel getById(int id) throws SQLException {
        String query = "SELECT * FROM horarios_disponiveis WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new HorarioDisponivel(
                            resultSet.getInt("id"),
                            resultSet.getString("data_hora"),
                            resultSet.getBoolean("disponivel")
                    );
                }
            }
        }
        return null;
    }

    public List<HorarioDisponivel> getAll() throws SQLException {
        List<HorarioDisponivel> horarios = new ArrayList<>();
        String query = "SELECT * FROM horarios_disponiveis";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                horarios.add(new HorarioDisponivel(
                        resultSet.getInt("id"),
                        resultSet.getString("data_hora"),
                        resultSet.getBoolean("disponivel")
                ));
            }
        }
        return horarios;
    }

    public void insert(HorarioDisponivel horario) throws SQLException {
        String query = "INSERT INTO horarios_disponiveis (data_hora, disponivel) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, horario.getDataHora());
            stmt.setBoolean(2, horario.isDisponivel());
            stmt.executeUpdate();
        }
    }

    public void update(HorarioDisponivel horario) throws SQLException {
        String query = "UPDATE horarios_disponiveis SET data_hora = ?, disponivel = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, horario.getDataHora());
            stmt.setBoolean(2, horario.isDisponivel());
            stmt.setInt(3, horario.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM horarios_disponiveis WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}