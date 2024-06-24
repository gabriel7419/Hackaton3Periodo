package org.example.model;

public class Agenda {
    private int id;
    private int agenteSaudeId;

    public Agenda(int id, int agenteSaudeId) {
        this.id = id;
        this.agenteSaudeId = agenteSaudeId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAgenteSaudeId() {
        return agenteSaudeId;
    }

    public void setAgenteSaudeId(int agenteSaudeId) {
        this.agenteSaudeId = agenteSaudeId;
    }
}