import { Router } from "express"

import agenteSaude from './agenteSaude'
import idoso from "./idoso"
import vacina from "./vacinas"

const routes = Router()

routes.use('/agenteSaude', agenteSaude)
routes.use('/idoso', idoso)
routes.use('/vacina', vacina)

export default routes
