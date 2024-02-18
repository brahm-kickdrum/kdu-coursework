const { v4: uuidv4 } = require('uuid');

let posts = [
    {
      post_id: uuidv4(),
      user_name: 'brahm',
      post_content: 'This is the content of the first post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: 'This is the content of the second post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: 'This is the content of the third post.'
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: 'This is the content of the fourth post.'
    }
  ];

module.exports = posts;