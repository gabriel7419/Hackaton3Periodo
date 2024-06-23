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
import vacina from "./vacinas"
import historico from "./historioco"
import agendar from "./agendar"

const routes = Router()

routes.use('/agenteSaude', agenteSaude)
routes.use('/idoso', idoso)
<<<<<<< HEAD
>>>>>>> ba497e8bfe05bbb6d94afdc347533674b051f633
=======
routes.use('/vacina', vacina)
routes.use('/historico', historico)
routes.use('/agendar', agendar)
>>>>>>> 91b27d47fc27829d1d6f4adc74ca6752cc94c2a4

export default routes
