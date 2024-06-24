package org.example.dao;

import org.example.model.Idoso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IdosoDAO {
    private Connection connection;

    public IdosoDAO(Connection connection) {
        this.connection = connection;
    }

    public Idoso getById(int id) throws SQLException {
        String query = "SELECT * FROM idoso WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    return new Idoso(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("cpf"),
                            resultSet.getString("cartaosus"),
                            resultSet.getString("cep"),
                            resultSet.getString("logradouro"),
                            resultSet.getString("dataNasci"),
                            resultSet.getString("nomeResponsavel"),
                            resultSet.getString("cpfResponsavel"),
                            resultSet.getString("emailResponsavel"),
                            resultSet.getString("celular1"),
                            resultSet.getString("celular2"),
                            resultSet.getString("celular3"),
                            resultSet.getString("senha")
                    );
                }
            }
        }
        return null;
    }

    public List<Idoso> getAll() throws SQLException {
        List<Idoso> idosos = new ArrayList<>();
        String query = "SELECT * FROM idoso";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {
            while (resultSet.next()) {
                idosos.add(new Idoso(
                        resultSet.getInt("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("cartaosus"),
                        resultSet.getString("cep"),
                        resultSet.getString("logradouro"),
                        resultSet.getString("dataNasci"),
                        resultSet.getString("nomeResponsavel"),
                        resultSet.getString("cpfResponsavel"),
                        resultSet.getString("emailResponsavel"),
                        resultSet.getString("celular1"),
                        resultSet.getString("celular2"),
                        resultSet.getString("celular3"),
                        resultSet.getString("senha")
                ));
            }
        }
        return idosos;
    }

    public void insert(Idoso idoso) throws SQLException {
        String query = "INSERT INTO idoso (nome, cpf, cartaosus, cep, logradouro, dataNasci, nomeResponsavel, cpfResponsavel, emailResponsavel, celular1, celular2, celular3, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idoso.getNome());
            stmt.setString(2, idoso.getCpf());
            stmt.setString(3, idoso.getCartaoSus());
            stmt.setString(4, idoso.getCep());
            stmt.setString(5, idoso.getLogradouro());
            stmt.setString(6, idoso.getDataNascimento());
            stmt.setString(7, idoso.getNomeResponsavel());
            stmt.setString(8, idoso.getCpfResponsavel());
            stmt.setString(9, idoso.getEmailResponsavel());
            stmt.setString(10, idoso.getCelular1());
            stmt.setString(11, idoso.getCelular2());
            stmt.setString(12, idoso.getCelular3());
            stmt.setString(13, idoso.getSenha());
            stmt.executeUpdate();
        }
    }

    public void update(Idoso idoso) throws SQLException {
        String query = "UPDATE idoso SET nome = ?, cpf = ?, cartaosus = ?, cep = ?, logradouro = ?, dataNasci = ?, nomeResponsavel = ?, cpfResponsavel = ?, emailResponsavel = ?, celular1 = ?, celular2 = ?, celular3 = ?, senha = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, idoso.getNome());
            stmt.setString(2, idoso.getCpf());
            stmt.setString(3, idoso.getCartaoSus());
            stmt.setString(4, idoso.getCep());
            stmt.setString(5, idoso.getLogradouro());
            stmt.setString(6, idoso.getDataNascimento());
            stmt.setString(7, idoso.getNomeResponsavel());
            stmt.setString(8, idoso.getCpfResponsavel());
            stmt.setString(9, idoso.getEmailResponsavel());
            stmt.setString(10, idoso.getCelular1());
            stmt.setString(11, idoso.getCelular2());
            stmt.setString(12, idoso.getCelular3());
            stmt.setString(13, idoso.getSenha());
            stmt.setInt(14, idoso.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM idoso WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}