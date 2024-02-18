const messagesButton = document.querySelector("#messages");
const messageSection = document.querySelector(".message-section");
const tweetPost = document.querySelector(".tweet-post");

messagesButton.addEventListener("click", () => {
    // Show message section
    messageSection.style.display = "block";
    messageSection.style.animation = "";

    // Hide tweet post
    tweetPost.style.display = "none";
    tweetPost.style.animation = "";
});
