function verify() {
    var password = document.getElementById('password').value;
    var verifyPassword = document.getElementById('verifyPassword').value;
    var errorDiv = document.getElementById('error');

    // Clear previous errors
    errorDiv.innerHTML = '';
    errorDiv.style.display = 'none';

    if (password !== verifyPassword) {
        errorDiv.innerHTML = 'Passwords do not match!';
        errorDiv.style.display = 'block';
        return false;
    }
    
    if (password.length < 6) {
        errorDiv.innerHTML = 'Password must be at least 6 characters!';
        errorDiv.style.display = 'block';
        return false;
    }
    
    return true;
}