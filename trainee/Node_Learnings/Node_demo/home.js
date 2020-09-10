const express = require('express');
const app=express();

app.get('/',function(req,res)
{
res.sendFile(home.html);
});

app.get('/data',function(req,res)
{
res.send('Data of stock');
});
app.post('/data',function(req,res)
{
res.send('Data of stock');
});
app.listen(8080,function(req,res){
console.log('App Started....');
});