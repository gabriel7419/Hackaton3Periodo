package org.example.dao;

import org.example.model.Vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VacinaDAO {
    private Connection connection;

    public VacinaDAO(Connection connection) {
        this.connection = connection;
    }

    public Vacina getById(int id) throws SQLException {
        String query = "SELECT * FROM vacina WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Vacina(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("dataInicio"),
                            resultSet.getString("dataTermino"),
                            resultSet.getString("publicoAlvo")
                    );
                }
            }
        }
        return null;
    }

    public List<Vacina> getAll() throws SQLException {
        List<Vacina> vacinas = new ArrayList<>();
        String query = "SELECT * FROM vacina";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                vacinas.add(new Vacina(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("dataInicio"),
                        resultSet.getString("dataTermino"),
                        resultSet.getString("publicoAlvo")
                ));
            }
        }
        return vacinas;
    }

    public void insert(Vacina vacina) throws SQLException {
        String query = "INSERT INTO vacina (nome, dataInicio, dataTermino, publicoAlvo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getDataInicio());
            stmt.setString(3, vacina.getDataTermino());
            stmt.setString(4, vacina.getPublicoAlvo());
            stmt.executeUpdate();
        }
    }

    public void update(Vacina vacina) throws SQLException {
        String query = "UPDATE vacina SET nome = ?, dataInicio = ?, dataTermino = ?, publicoAlvo = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vacina.getNome());
            stmt.setString(2, vacina.getDataInicio());
            stmt.setString(3, vacina.getDataTermino());
            stmt.setString(4, vacina.getPublicoAlvo());
            stmt.setInt(5, vacina.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM vacina WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}