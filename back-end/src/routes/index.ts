import { Router } from "express"

<<<<<<< HEAD
// import categoria from './categoria'
// import usuario from './usuario'
import session from './session'
import autenticacao from '../middlewares/autenticacao'

const routes = Router()

routes.use('/session', session)
routes.use(autenticacao)
// routes.use('/categorias', autenticacao, categoria)
// routes.use('/usuarios', usuario)
=======
import agenteSaude from './agenteSaude'
import idoso from "./idoso"

const routes = Router()

routes.use('/agenteSaude', agenteSaude)
routes.use('/idoso', idoso)
>>>>>>> ba497e8bfe05bbb6d94afdc347533674b051f633

export default routes
