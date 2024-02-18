const { v4: uuidv4 } = require('uuid');

let posts = [
    {
      post_id: uuidv4(),
      user_name: 'brahm',
      post_content: 'This is the content of the 1 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: 'This is the content of the 2 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'brahm',
      post_content: 'This is the content of the 3 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: 'This is the content of the 4 post.'
    },
  
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: 'This is the content of the 5 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: 'This is the content of the 6 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: 'This is the content of the 7 post.'
    },
  {
    post_id: uuidv4(),
    user_name: 'armaan',
    post_content: 'This is the content of the 8 post.'
  },
  {
    post_id: uuidv4(),
    user_name: 'khushi',
    post_content: 'This is the content of the 9 post.'
  },
  {
    post_id: uuidv4(),
    user_name: 'baneet',
    post_content: 'This is the content of the 10 post.'
  },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: 'This is the content of the 11 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: 'This is the content of the 12 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: 'This is the content of the 13 post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: 'This is the content of the 14 post.'
    }
  ];

module.exports = posts;