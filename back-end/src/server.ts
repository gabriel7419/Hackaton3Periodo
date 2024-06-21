import express, { Request, Response, NextFunction } from 'express'
import 'express-async-errors'
import cors from "cors"
import routes from './routes'

const app = express()

app.use(cors())//consumo de api habilitado para outras plataformas
app.use(express.json());
app.use(routes)


const PORT = 8000
app.listen(PORT, () => {
    console.log('Express Iniciado na porta:' + PORT)
})
