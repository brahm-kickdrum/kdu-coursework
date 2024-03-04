const express = require('express')
const cors = require('cors');
const http = require('http');
const path = require('path');
const socketIo = require("socket.io");

// const port = process.env.PORT || 3000;

const app = express();

const server = http.createServer(app);
const io = new socketIo.Server(server, {
    cors: {
        origin: "http://127.0.0.1:5502",
    },
});

app.use(cors());
app.use(express.json());
app.use(express.static("mainpage"));

app.use('/api', require('./routes/api/login-api.js'));
app.use('/api', require('./routes/api/post-api.js'));


io.on("connection", (socket) => {
    console.log("connection created");

    socket.on("message", payload => {
        console.log("Payload", payload);
        // Emitting the message along with the username to all clients except the sender
        socket.broadcast.emit("new-message", { username: payload.username, message: payload.message });
    });
});

server.listen(3001, () => {
  console.log("Server started on 3001");
});