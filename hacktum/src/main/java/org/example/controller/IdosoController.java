package org.example.controller;

import org.example.dao.IdosoDAO;
import org.example.model.Idoso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IdosoController {
    private IdosoDAO idosoDAO;

    public IdosoController(Connection connection) {
        this.idosoDAO = new IdosoDAO(connection);
    }

    public void cadastrarIdoso(Idoso idoso) throws SQLException {
        idosoDAO.insert(idoso);
    }

    public List<Idoso> listarIdosos() throws SQLException {
        return idosoDAO.getAll();
    }
}
