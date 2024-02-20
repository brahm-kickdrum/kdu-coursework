const { v4: uuidv4 } = require('uuid');

let posts = [
    {
      post_id: uuidv4(),
      user_name: 'brahm',
      post_content: `This is the content of the first post. It contains some thoughts and reflections about various aspects of life. Feel free to share your opinions and engage in discussions.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: `Here's the content of the second post. It delves into the intricacies of human emotions and explores the depths of the human psyche. Join me in this exploration.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'brahm',
      post_content: `Welcome to the third post! In this post, we'll journey through the realms of imagination and creativity. Let your mind wander and discover new horizons with me.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: `Dive into the fourth post with me. We'll embark on a voyage of discovery, uncovering hidden truths and unraveling mysteries. Together, we'll navigate through the depths of knowledge.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: `Join me in exploring the fifth post, where we'll contemplate the wonders of the universe and ponder the mysteries of existence. Let's embark on this cosmic journey together!`,
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: `Embrace the content of the sixth post as we delve into the beauty of nature and the serenity it brings. Let's take a moment to appreciate the wonders that surround us.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: `This is the content of the seventh post. In this post, we'll discuss the importance of perseverance and determination in achieving our goals. Let's strive for success together!`,
    },
    {
      post_id: uuidv4(),
      user_name: 'armaan',
      post_content: `Join me in the eighth post as we explore the realms of fantasy and adventure. Let your imagination soar as we embark on an epic quest filled with excitement and wonder!`,
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: `In the ninth post, we'll reflect on the power of kindness and compassion in making the world a better place. Let's spread love and positivity wherever we go.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: `Welcome to the tenth post! In this post, we'll delve into the complexities of human relationships and the bonds that unite us. Join me in exploring the dynamics of connection.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: `Join me in the eleventh post as we celebrate the joys of friendship and camaraderie. Let's cherish the memories we've made and look forward to creating more together!`,
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: `In the twelfth post, we'll discuss the importance of self-discovery and personal growth. Join me on this journey of introspection as we uncover our true potential.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'khushi',
      post_content: `This is the content of the thirteenth post. Let's take a moment to appreciate the simple pleasures of life and find joy in the little things.`,
    },
    {
      post_id: uuidv4(),
      user_name: 'baneet',
      post_content: `Join me in the fourteenth post as we explore the depths of human resilience and the ability to overcome adversity. Let's find strength in our challenges and emerge stronger than ever before.`,
    }
];

module.exports = posts;
