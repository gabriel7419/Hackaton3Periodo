package org.example.controller;


import org.example.dao.AgenteSaudeDAO;
import org.example.model.AgenteSaude;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AgenteSaudeController {
    private AgenteSaudeDAO agenteSaudeDAO;

    public AgenteSaudeController(Connection connection) {
        this.agenteSaudeDAO = new AgenteSaudeDAO(connection);
    }

}

