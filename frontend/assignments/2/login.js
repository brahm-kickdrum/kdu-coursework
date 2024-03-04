const loginButton = document.querySelector(".login-button");

loginButton.addEventListener("click", loginUser);

async function loginUser() {
    const username = document.querySelector(".username").value;
    const password = document.querySelector(".password").value;

    userData = {
        user_name: username,
        password: password
    };

    try {
        const response = await fetch('http://localhost:3001/api/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(userData)
        });
        if (!response.ok) {
            throw new Error('Failed to login data');
        }
        else{
            sessionStorage.setItem('username', username);
            window.location.href = '/mainpage/index.html';
        }

        console.log('Data submitted successfully');
        document.querySelector(".username").value = "";
        document.querySelector(".password").value = "";
    } catch (error) {
        console.error('Error:', error);
    }
}