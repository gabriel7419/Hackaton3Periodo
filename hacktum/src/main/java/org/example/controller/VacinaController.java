package org.example.controller;

import org.example.dao.VacinaDAO;
import org.example.model.Vacina;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class VacinaController {
    private VacinaDAO vacinaDAO;

    public VacinaController(Connection connection) {
        this.vacinaDAO = new VacinaDAO(connection);
    }

    public void cadastrarVacina(Vacina vacina) throws SQLException {
        vacinaDAO.insert(vacina);
    }

    public List<Vacina> listarVacinas() throws SQLException {
        return vacinaDAO.getAll();
    }
}