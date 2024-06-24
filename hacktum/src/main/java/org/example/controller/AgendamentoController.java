package org.example.controller;

import org.example.dao.AgendamentoDAO;
import org.example.model.Agendamento;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AgendamentoController {
    private AgendamentoDAO agendamentoDAO;

    public AgendamentoController(Connection connection) {
        this.agendamentoDAO = new AgendamentoDAO(connection);
    }

    public void agendar(Agendamento agendamento) throws SQLException {
        agendamentoDAO.insert(agendamento);
    }

    public List<Agendamento> listarAgendamentos() throws SQLException {
        return agendamentoDAO.getAll();
    }
}
