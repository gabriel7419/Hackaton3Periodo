import { Router } from "express"

import agenteSaude from './agenteSaude'
import idoso from "./idoso"
import vacina from "./vacinas"
import historico from "./historioco"
import agendar from "./agendar"

const routes = Router()

routes.use('/agenteSaude', agenteSaude)
routes.use('/idoso', idoso)
routes.use('/vacina', vacina)
routes.use('/historico', historico)
routes.use('/agendar', agendar)

export default routes
