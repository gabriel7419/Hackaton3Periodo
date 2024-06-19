import { Router } from "express"

import agenteSaude from './agenteSaude'

const routes = Router()

routes.use('/agenteSaude', agenteSaude)

export default routes
