const mongoose = require('mongoose')


const storeSchema = new mongoose.Schema({

    name: {
        type: String,
        required: true
    },
    color: {
        type: String,
        required: true
    },
    avalability: {
        type: Boolean,
        required: true,
        default: false
    }

})

module.exports = mongoose.model('Item',storeSchema)