document.addEventListener("DOMContentLoaded", function() {
    getUsername();
});

function getUsername() {
    fetch('/current-username')
    .then(response => response.text())
    .then(username => {
        document.getElementById('username').innerText = username;
    })
    .catch(error => console.error('Error:', error));
}