import { Router, Request, Response } from 'express';
import db from '../database';
const router = Router();

router.post("/", async (req: Request, res: Response) => {
    const idoso = req.body;

    try {
        const [rows] = await db.execute('SELECT emailResponsavel, senha FROM idoso WHERE emailResponsavel = ? AND senha=?', [idoso.email, idoso.senha]);

        if (rows == null) {
            res.status(404).json({ message: "Não encontrado" });
        } else {
            res.status(200).json({ message: "existe" });
        }
        res.status(200).json({message: "existe"});
    } catch (error) {
        console.error("Erro ao buscar agentes de saúde:", error);
        res.status(500).json({ error: 'Ocorreu um erro ao buscar os dados' });
    }
});


export default router;
