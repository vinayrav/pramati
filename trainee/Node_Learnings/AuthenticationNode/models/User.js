const mongoose = require('mongoose');
const Schema = mongoose.Schema;

userSchema = new Schema( {
	
	email: {
        type: String,
        required: true
	},
	username: {
        type: String,
        required: true
	},
	password: {
        type: String,
        required: true
    }
}),
User = mongoose.model('User', userSchema);

module.exports = User;