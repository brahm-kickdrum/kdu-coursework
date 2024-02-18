const express = require('express');
const router = express.Router();

const login = require("../../data/login_data");

router.post('/user/login', (req,res) => {
    if(!req.body.user_name || !req.body.password){
        res.status(402).send("Incomplete info");
    }
    
    let validUser = login.some(users => users.user_name === req.body.user_name && users.password === req.body.password);

    if(validUser){
        res.status(201).json("Logging in");
    }
    else{
        res.status(401).json({ success: false, message: 'Invalid credentials' });
    }
});

module.exports = router;