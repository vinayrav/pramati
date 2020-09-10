const express = require('express')
const mongoose = require('mongoose')
const url = 'mongodb://localhost/myDB'

const app=express()

mongoose.connect(url, {useNewUrlParser:true})
const con = mongoose.connection

con.on('open', function() {
    console.log('connected...')
})

const router=require('./routes/store')
app.use('/store',router)

app.listen(8080,function(){
    console.log('derver up...')
})