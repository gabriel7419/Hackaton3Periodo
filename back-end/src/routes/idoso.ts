import express, { Router, Request, Response } from 'express';
import knex from '../database/index' // Assumindo que você tem um módulo database configurado corretamente
import routes from '.';

const router = Router();

router.post("/", async (req: Request, res: Response) => {
  const { cartaosus, senha } = req.body;

  try {
    if (!cartaosus || !senha) {
      return res.status(400).json({ error: 'Email e senha são obrigatórios' });
    }

    const user = await knex('idoso').select("nome").where({ cartaosus }).first();

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

// routes.get('/',async (req: Request, res: Response) => {
//     try {
//         const { email } = req.body;

//         const [result] = await db.execute('SELECT * FROM idoso WHERE emailResponsavel = ?', [email]);
//         res.status(200).json(result);
//     } catch (error) {
//         console.error("Erro ao buscar agentes de saúde:", error);
//         res.status(500).json({ error: 'Ocorreu um erro ao buscar os dados' });
//     }
// });

export default router;
