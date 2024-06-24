package org.example.controller;

import org.example.dao.AgendaDAO;
import org.example.model.Agenda;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AgendaController {
    private AgendaDAO agendaDAO;

    public AgendaController(Connection connection) {
        this.agendaDAO = new AgendaDAO(connection);
    }

    public void criarAgenda(Agenda agenda) throws SQLException {
        agendaDAO.insert(agenda);
    }

    public List<Agenda> listarAgendas() throws SQLException {
        return agendaDAO.getAll();
    }
}
