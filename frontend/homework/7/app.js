const express = require('express');
const http = require('http')
const cors = require('cors')
const socketIo = require('socket.io')


const app = express()

const server = http.createServer(app);
const io = new socketIo.Server(server, {
    cors: {
        origin: "http://127.0.0.1:5500"
    }
});   //it takes a server as parameter for configuration

app.use(cors());
app.use(express.json())


app.get("/", (req, res) => {
    res.json({
        msg: "hello world"
    })
});

// activated when an event named connection is triggered
io.on("connection", (socket) =>{
    console.log("connection created");


    socket.on("message", payload =>{
        //socket.emit("new-message", payload);
        
        console.log("Payload", payload);
        io.except(socket.id).emit("new-message", payload);
        //sending a msg back to UI or every UI that is connected to server
    });
    
})

server.listen(3000, ()=>{
    console.log("hello");
})