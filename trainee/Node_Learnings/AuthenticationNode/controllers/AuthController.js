const User = require('../models/User')
const bcrypt = require('bcryptjs')

const register = (req,res,next)=>{
    bcrypt.hash(req.body.password,10,function(err,hashedPass){
        if(err){
            res.json({
                err
                
                
            })
        }

        let user = new User({
            email: req.body.email,
            username: req.body.username,
            password: hashedPass
        })
        user.save()
        .then(user =>{
            res.json({
                message: "successfull"
            })
        })
        .catch(error =>{
            res.json({
                message: err
            })
        }
        )
    })   

}

const login = (req,res,next) =>{
    var username = req.body.username
    var password = req.body.password

    User.findOne({$or :[{username : username},{email:username}]})
    .then(user =>{
        if(user){
            bcrypt.compare(password,user.password,function(err,result){
            if(err){
                res.json({
                    error: err
                })
            }
            
            if(result){
                res.json({
                    message: 'success'
                })
            }
            else{
                res.json({
                    message:'password wrong'
                })
            }
        })
        }else{
            res.json({
                message:'User not found'

            })
        }
        
    })
}
module.exports = {
    register,login
}