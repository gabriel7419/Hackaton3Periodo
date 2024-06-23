import { Router, Request, Response } from 'express';
import knex from '../database/index'
const router = Router();

router.get('/', async (req: Request, res: Response) => {
    const vacina = await knex('vacina').select('*');

    if (vacina.length > 0) {
        return res.status(200).json({ vacina });
    } else {
        return res.status(404).json({ message: "Nenhuma vacina encontrada" });
    }
});

export default router
