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

// app.listen(port, () => {
//     console.log('Server is running on port 3000');
// });

io.on("connection", (socket) => {
try
    {    console.log("A user connected");

    // Listen for a login event from the client
    socket.on("login", (username) => {
      console.log(username)
        // Broadcast the user's name to all connected clients
        io.emit("userLoggedIn", username);
    });

    // Handle disconnect event
    socket.on("disconnect", () => {
        console.log("A user disconnected");
    });}
    catch(error)
    
    {
        console.log(error);
    }
});



server.listen(3001, () => {
  console.log("Server started on 3001");
});