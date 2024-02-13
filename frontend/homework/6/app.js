const express = require("express");
const path=require('path')
const app = express();

//Body parser Middleware
app.use(express.json())
app.use('/api/posts',require('./routes/api/posts'))
app.listen(5001,()=>{
    console.log(`Server started on 5001`);
})