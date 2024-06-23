import { Router, Request, Response } from 'express';
import knex from '../database/index'
const router = Router();

router.get("/", async (req: Request, res: Response) => {
    const dados = await knex('historico')
    .select('idoso.nome', 'vacinas.nome AS nome_vacina', 'vacinas.dataInicio', 'vacinas.dataTermino')
    .join('vacinas', 'idoso.id', 'vacinas.id_idoso');
})


export default router;
