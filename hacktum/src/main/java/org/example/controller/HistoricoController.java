package org.example.controller;

import org.example.model.Historico;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoricoController {

    public void adicionarHistorico(Historico historico) throws SQLException {
        String sql = "INSERT INTO historico_saude (nome, febre, dor_cabeca, tosse, vacina, peso, altura, alergias, medico) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

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
}
