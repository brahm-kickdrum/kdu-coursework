document.addEventListener("DOMContentLoaded", function() {
    
    
  
    const textArea = document.getElementById("text-area");
    const button = document.querySelector('#desktop-post-button');

    textArea.addEventListener("input", function() {
      if (textArea.value.trim() === "") {
        button.style.backgroundColor = ""; // Revert to default background color
        button.style.color = "";
      } else {
        button.style.backgroundColor = "#1D9BF0"; // Change background color to red
        button.style.color = " #E7E9EA";
      }
    });
  });