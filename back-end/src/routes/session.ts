import Router from 'express'
import knex from '../database/knex'
import AppError from '../utils/AppError';
import { compare } from 'bcryptjs'
import authConfig from '../config/auth'
import { sign } from 'jsonwebtoken'

const router = Router();

router.post("/", async (req, res) => {
    const { email, senha } = req.body

    const user = await knex('usuarios').where({
        email
    }).first()

    if (!user) {
        throw new AppError('Email ou senha incorreta')
    }

    const senhaIsIgual = await compare(
        senha,
        user.senha
    )

    if (!senhaIsIgual) {
        throw new AppError('Email ou senha incorreta')
    }


    // JWT - Json Web Token
    const token = sign(
        { idUsuario: user.id },
        authConfig.jwt.secret,
        {
            expiresIn: authConfig.jwt.expiresIn
        }
    )

    res.json({ user, token })

})

export default router
