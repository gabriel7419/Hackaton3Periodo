import config from './../../knex'

import knex from 'knex'

const conexao = knex(config.development)

export default conexao
