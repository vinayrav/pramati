const express = require('express')
const router = express.Router()
const Item = require('../model/schema')

router.get('/',function(req,res){
    try {
        const items = Item.find()
           res.json(items)


        
    } catch (error) {
        res.send("w")
  
    }
})