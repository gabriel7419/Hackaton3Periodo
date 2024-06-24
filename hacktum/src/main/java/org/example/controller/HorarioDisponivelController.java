package org.example.controller;

import org.example.dao.HorarioDisponivelDAO;
import org.example.model.HorarioDisponivel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class HorarioDisponivelController {
    private HorarioDisponivelDAO horarioDisponivelDAO;

    public HorarioDisponivelController(Connection connection) {
        this.horarioDisponivelDAO = new HorarioDisponivelDAO(connection);
    }

    public List<HorarioDisponivel> listarHorariosDisponiveis() throws SQLException {
        return horarioDisponivelDAO.getAll();
    }

    public void marcarHorario(HorarioDisponivel horario) throws SQLException {
        horarioDisponivelDAO.insert(horario);
    }

    public void cancelarHorario(int id) throws SQLException {
        horarioDisponivelDAO.delete(id);
    }
}
