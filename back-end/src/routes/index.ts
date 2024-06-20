import { Router } from "express"

import agenteSaude from './agenteSaude'
import idoso from "./idoso"

const routes = Router()

routes.use('/agenteSaude', agenteSaude)
routes.use('/idoso', idoso)

export default routes
