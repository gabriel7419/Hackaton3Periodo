import { Router, Request, Response } from 'express';
import connection from '../database';
import db from '../database';
const router = Router();

router.get("/", async (req: Request, res: Response) => {
    try {
        const [result] = await db.execute('SELECT * FROM agentesaude');
        res.status(200).json(result);
    } catch (error) {
        console.error("Erro ao buscar agentes de saúde:", error);
        res.status(500).json({ error: 'Ocorreu um erro ao buscar os dados' });
    }
});

router.post("/", async (req: Request, res: Response) => {
    try {
<<<<<<< HEAD
        const { nome } = req.body;

        if (!nome) {
            return res.status(400).json({ error: 'O campo "nome" é obrigatório' });
        }

        await connection.execute('INSERT INTO agentesaude (nome) VALUES (?)', [nome]);
=======
        const agente = req.body;

        if (!agente.nome) {
            return res.status(400).json({ error: 'O campo "nome" é obrigatório' });
        }

        await connection.execute('INSERT INTO agentesaude (nome) VALUES (?)', [agente.nome]);
>>>>>>> 2319c3b568c6423c1f18ecd9563f6aa3a6f0f719

        res.status(201).json({ message: "Usuário salvo"});
    } catch (error) {
        console.error("Erro ao salvar usuário:", error);
<<<<<<< HEAD
        res.status(500).json({ error: 'Ocorreu um erro ao salvar o usuário' }); // Respond with a 500 status and error message
=======
        res.status(500).json({ error: 'Ocorreu um erro ao salvar o usuário' });
>>>>>>> 2319c3b568c6423c1f18ecd9563f6aa3a6f0f719
    }
});


export default router;
