const express = require('express')
const mongoose = require('mongoose')
const bodyParser = require('body-parser')

const AuthRoute = require('./routes/auth')

mongoose.connect('mongodb://localhost:27017/testdb')
const db = mongoose.connection
db.on('error',(err) =>{
    console.log(err)
})

db.once('open',() =>{
    console.log('Db connected')
})

const app = express()

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())

app.listen(3000, function () {
    console.log('Express app listening on port 3000');
  });

  app.use('/api',AuthRoute)