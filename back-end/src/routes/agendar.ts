import { Router, Request, Response } from 'express';
import knex from '../database/index'
const router = Router();

router.post('/', async (req, res) => {
    const { agentesaude_id, dataVas, vacina_id } = req.body;

    try {
      if (!agentesaude_id|| !dataVas || !vacina_id) {
        return res.status(400).json({ error: 'Todos os campos são obrigatórios' });
      }

      // Inserindo dados no banco de dados
      const novoAgendamento = await knex('agendamentos').insert({
        dataVas,
        agentesaude_id,
        vacina_id
      });

      res.status(201).json({ message: 'Agendamento criado com sucesso', id: novoAgendamento[0] });
    } catch (error) {
      console.error("Erro ao criar agendamento:", error);
      res.status(500).json({ error: 'Ocorreu um erro ao criar o agendamento' });
    }
  });

export default router;
