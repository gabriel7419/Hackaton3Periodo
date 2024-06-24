package org.example.dao;

import org.example.model.Historico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {
    private Connection connection;

    public HistoricoDAO(Connection connection) {
        this.connection = connection;
    }

    public Historico getById(int id) throws SQLException {
        String query = "SELECT * FROM historico_saude WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Historico(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getBoolean("febre"),
                            resultSet.getBoolean("dor_cabeca"),
                            resultSet.getBoolean("tosse"),
                            resultSet.getString("vacina"),
                            resultSet.getFloat("peso"),
                            resultSet.getFloat("altura"),
                            resultSet.getString("alergias"),
                            resultSet.getString("medico")
                    );
                }
            }
        }
        return null;
    }

    public List<Historico> getAll() throws SQLException {
        List<Historico> historicos = new ArrayList<>();
        String query = "SELECT * FROM historico_saude";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                historicos.add(new Historico(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getBoolean("febre"),
                        resultSet.getBoolean("dor_cabeca"),
                        resultSet.getBoolean("tosse"),
                        resultSet.getString("vacina"),
                        resultSet.getFloat("peso"),
                        resultSet.getFloat("altura"),
                        resultSet.getString("alergias"),
                        resultSet.getString("medico")
                ));
            }
        }
        return historicos;
    }

    public void insert(Historico historico) throws SQLException {
        String query = "INSERT INTO historico_saude (nome, febre, dor_cabeca, tosse, vacina, peso, altura, alergias, medico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, historico.getNome());
            stmt.setBoolean(2, historico.isFebre());
            stmt.setBoolean(3, historico.isDorCabeca());
            stmt.setBoolean(4, historico.isTosse());
            stmt.setString(5, historico.getVacina());
            stmt.setFloat(6, historico.getPeso());
            stmt.setFloat(7, historico.getAltura());
            stmt.setString(8, historico.getAlergias());
            stmt.setString(9, historico.getMedico());
            stmt.executeUpdate();
        }
    }

    public void update(Historico historico) throws SQLException {
        String query = "UPDATE historico_saude SET nome = ?, febre = ?, dor_cabeca = ?, tosse = ?, vacina = ?, peso = ?, altura = ?, alergias = ?, medico = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, historico.getNome());
            stmt.setBoolean(2, historico.isFebre());
            stmt.setBoolean(3, historico.isDorCabeca());
            stmt.setBoolean(4, historico.isTosse());
            stmt.setString(5, historico.getVacina());
            stmt.setFloat(6, historico.getPeso());
            stmt.setFloat(7, historico.getAltura());
            stmt.setString(8, historico.getAlergias());
            stmt.setString(9, historico.getMedico());
            stmt.setInt(10, historico.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM historico_saude WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
