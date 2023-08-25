document.addEventListener('DOMContentLoaded', function() {
    const registerBtn = document.getElementById('rbtn');
    const loginBtn = document.getElementById('lbtn');
    const userWelcome = document.getElementById('user_details');
    const userName = document.getElementById('user_name');
    const userEmail = document.getElementById('user_email');
    const apiUrl = 'http://localhost:8080/user';
    registerBtn.addEventListener('click', async function() {
        const name = document.getElementById('rname').value;
        const email = document.getElementById('remail').value;
        const password = document.getElementById('rpassword').value;

        const response = await fetch(`${apiUrl}/register`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name, email, password }),
        });

        alert(await response.text());
        document.getElementById('rname').value = '';
        document.getElementById('remail').value = '';
        document.getElementById('rpassword').value = '';
    });

    loginBtn.addEventListener('click', async function() {
        const email = document.getElementById('lemail').value;
        const password = document.getElementById('lpassword').value;

        const response = await fetch(`${apiUrl}/login`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        });

        const result = await response.text();
        if (response.ok) {
            const userDetailsResponse = await fetch(`${apiUrl}/users?email=${email}`);
            if (userDetailsResponse.ok) {
                const userDetails = await userDetailsResponse.json();
                displayUserDetails(userDetails);
            }
        } 
            alert(result);
            
        
    });

    function displayUserDetails(userDetails) {
        userWelcome.style.display = 'block';
        userName.textContent = `Name: ${userDetails.name}`;
        userEmail.textContent = `Email: ${userDetails.email}`;
    }
});
