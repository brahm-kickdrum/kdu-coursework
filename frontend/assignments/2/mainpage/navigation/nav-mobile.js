const navSectionProfileMobile = document.querySelector(".nav-section-profile-mobile");
const navigationSection = document.querySelector(".navigation-section");

navSectionProfileMobile.addEventListener("click", () => {
    navigationSection.style.display = "block";
    navigationSection.style.animation = "fadeIn 0.5s";

    navSectionProfileMobile.style.display = "none";
    navSectionProfileMobile.style.animation = "fadeOut 0.5s";

    // Reset animation after completion
    setTimeout(() => {
        navSectionProfileMobile.style.animation = "";
    }, 500); // 0.5s
});

// Add event listener to hide navigation section when clicking outside of it
document.addEventListener("click", (event) => {
    const screenWidth = screen.width;

    if (screenWidth<=414 && !event.target.closest(".navigation-section") && !event.target.closest(".nav-section-profile-mobile")) {
        navigationSection.style.display = "none";
        navigationSection.style.animation = "";
        navSectionProfileMobile.style.display = "block";
        navSectionProfileMobile.style.animation = "";
    }
});
