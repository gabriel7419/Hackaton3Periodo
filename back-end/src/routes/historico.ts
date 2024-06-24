import { Router, Request, Response } from 'express';
import knex from '../database/index';
const router = Router();

router.get('/:id', async (req: Request, res: Response) => {
    const { id  } = req.params;
    try {
        const historico = await knex('agendamentos')
        .innerJoin('idoso', 'agendamentos.idoso_id', 'idoso.id')
        .innerJoin('vacina', 'agendamentos.vacina_id', 'vacina.id')
        .innerJoin('agentesaude', 'agendamentos.agentesaude_id', 'agentesaude.id')
        .where('agendamentos.idoso_id', id)
        .select(
            'agendamentos.dataVas as agendamento_data',
            'agentesaude.agente as agente_nome',
            'vacina.nome as vacina_nome'
        );


            if (historico.length === 0) {
                return res.status(404).json({ message: 'Nenhum histórico encontrado para o idoso com o ID fornecido' });
            }

        res.status(200).json(historico);
    } catch (error) {
        console.error("Erro ao buscar o histórico:", error);
        res.status(500).json({ error: 'Ocorreu um erro ao buscar o histórico' });
    }
});

export default router;
