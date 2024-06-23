import { Router, Request, Response } from 'express';
import knex from '../database/index'
const router = Router();

router.get("/", async (req: Request, res: Response) => {
    try {
      const user = await knex('agentesaude').select("agente");
      res.status(200).json(user);
    } catch (error) {
      console.error("Erro ao buscar agentes de saúde:", error);
      res.status(500).json({ error: 'Ocorreu um erro ao buscar os dados' });
    }
  });

// router.post("/", async (req: Request, res: Response) => {
//     try {
//         const agente = req.body;

//         if (!agente.nome) {
//             return res.status(400).json({ error: 'O campo "nome" é obrigatório' });
//         }

//         await db.execute('INSERT INTO agentesaude (nome) VALUES (?)', [agente.nome]);
//         res.status(201).json({ message: "Usuário salvo"});
//     } catch (error) {
//         console.error("Erro ao salvar usuário:", error);
//         res.status(500).json({ error: 'Ocorreu um erro ao salvar o usuário' });
//     }

// });

router.post("/", async (req: Request, res: Response) => {
    const { agente, senha } = req.body;

    try {
      if (!agente || !senha) {
        return res.status(400).json({ error: 'Email e senha são obrigatórios' });
      }

      const user = await knex('agentesaude').select("agente",'senha').where({ agente }).first();

      if (user) {
        return res.status(200).json({user});
      } else {
        return res.status(404).json({ message: "Usuário não encontrado" });
      }

    } catch (error) {
      console.error("Erro ao buscar o usuário:", error);
      return res.status(500).json({ error: 'Ocorreu um erro ao buscar os dados' });
    }
  });


export default router;
