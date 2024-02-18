const express = require('express');
const router = express.Router();

const posts = require("../../data/post_data");
const {v4: uuidv4 } = require('uuid')

router.get('/posts/:pagenum/:size', (req, res) => {
    const pagenum = parseInt(req.params.pagenum);
    const size = parseInt(req.params.size);

    // Calculate start and end indices of posts
    const start = pagenum * size;
    const end = (pagenum + 1) * size;

    // Slice the posts array to only include posts for this page
    const postsForThisPage = posts.slice(start, end);

    res.json(postsForThisPage);
});

router.post('/posts', (req, res) => {
    console.log(req.body);
    // const {user_name, post_content } = req.body;
    let user_name = req.body.username;
    let post_content = req.body.postContent;

    if (!user_name || !post_content) {
        return res.status(400).json({ success: false, message: 'Incomplete information' });
    }

    const newPost = {
        post_id: uuidv4(),
        user_name: user_name,
        post_content: post_content
    };

    posts.push(newPost);

    res.status(201).json({ success: true, message: 'Post created successfully', post: newPost });
});

module.exports = router;