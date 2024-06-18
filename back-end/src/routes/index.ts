import { Router } from "express"

import categoria from './categoria'
import usuario from './usuario'
import session from './session'
import autenticacao from '../middlewares/autenticacao'

const routes = Router()

routes.use('/session', session)
routes.use(autenticacao)
routes.use('/categorias', autenticacao, categoria)
routes.use('/usuarios', usuario)

export default routes
