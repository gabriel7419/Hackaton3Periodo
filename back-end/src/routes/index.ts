import { Router } from "express"

import agenteSaude from './agenteSaude'
import idoso from "./idoso"
import vacina from "./vacinas"
import historico from "./historico"
import agendar from "./agendamentos"

const routes = Router()

routes.use('/agenteSaude', agenteSaude)
routes.use('/idoso', idoso)
routes.use('/vacina', vacina)
routes.use('/historico', historico)
routes.use('/agendamentos', agendar)

export default routes
