const homeButton = document.querySelector("#home");

homeButton.addEventListener("click", () => {
    // Show tweet post
    tweetPost.style.display = "block";
    tweetPost.style.animation = "";

    // Hide message section
    messageSection.style.display = "none";
    messageSection.style.animation = "";
});
