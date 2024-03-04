const { v4: uuidv4 } = require('uuid');

let users = [
    {
        id : uuidv4(),
        name: "brahm",
        user_name: "brahm",
        user_email_id: "brahm@example.com",
        password: "1234",
        profile_url: "https://example.com/brahm"
    },
    {
        id : uuidv4(),
        name: "armaan",
        user_name: "armaan",
        user_email_id: "armaan@example.com",
        password: "password2",
        profile_url: "https://example.com/armaan"
    },
    {
        id : uuidv4(),
        name: "khushi",
        user_name: "khushi",
        user_email_id: "khushi@example.com",
        password: "password3",
        profile_url: "https://example.com/khushi"
    },
    {
        id : uuidv4(),
        name: "baneet",
        user_name: "baneet",
        user_email_id: "baneet@example.com",
        password: "password4",
        profile_url: "https://example.com/baneet"
    }
];

module.exports = users;