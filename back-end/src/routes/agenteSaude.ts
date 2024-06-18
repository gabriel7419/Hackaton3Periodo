import Router, { Request, Response } from "express"
import db from '../database/db'

const routes = Router()

routes.get("/", (req,res) =>{
    const sql= 'SELECT * FROM agentesaude'
    db.connection.query()
})
