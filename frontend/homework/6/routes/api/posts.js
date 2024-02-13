const express=require('express')
const uuid=require('uuid')
const posts=require('../../data/posts')
const router=express.Router()

// api to get all the posts
router.get('/',(req,res)=>{
    if(posts.length==0)
    {
        res.status(200).json({msg:"There are no posts"})
    }
    else{
        res.json(posts);
    }
})

//api to post a post
router.post("/post", (req,res)=>{
    const post = {
        id:uuid.v4(),
        name : req.body.name,
        post : req.body.post
    }

    posts.push(post);
    res.status(201).json({post})
});

// api to get post by id
router.get('/:id',(req,res)=>{
    const searchId = req.params.id;
    const found=posts.some(post=>post.id===searchId);
    if(found)
    {
        res.json(posts.filter(post=>post.id===req.params.id))
    }
    else 
    {
        res.status(404).json({
            "message":"user with id not found"
        })
    }
})


module.exports = router;