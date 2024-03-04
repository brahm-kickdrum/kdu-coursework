document.addEventListener('DOMContentLoaded', function() {
    const username = sessionStorage.getItem('username');
    const names = document.querySelectorAll(".name");
    const usernames = document.querySelectorAll(".username");
    const iconElement = username[0].toUpperCase();
    const nav = document.querySelector('.nav-section-profile-mobile');
    
    nav.innerText= iconElement;

    names.forEach(function(nameElement) {
        nameElement.textContent = username; 
    });

    usernames.forEach(function(usernameElement) {
        usernameElement.textContent = '@' + username; 
    });

    var profileIcon = document.querySelectorAll(".profile-img");

    profileIcon.forEach(function(iconElement) {
        iconElement.textContent = username[0].toUpperCase(); 
    });
});
