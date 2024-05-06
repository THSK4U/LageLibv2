<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library Login Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .background img{
    transform: scaleX(-1);
    max-width: 687px;
    height: 100%;
    position: absolute;
    right: 0;
    opacity: 0.2;
    top:0;
    z-index:-1;
        }

        .login-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        .login-header {
            text-align: center;
            margin-bottom: 24px;
        }

        .login-header h2 {
            margin: 0;
            color: #333;
            font-size: 24px;
        }

        .login-form {
            display: flex;
            flex-direction: column;
        }

        .login-form input[type="text"],
        .login-form input[type="password"] {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .login-form button {
            padding: 15px;
            background-color: #0056b3;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        .login-form button:hover {
            background-color: #004494;
        }

        .login-form a {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #0056b3;
            text-decoration: none;
            font-size: 14px;
        }

        .login-form a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="background">
            <img src="https://mrkzgulfup.com/uploads/171466215535451.png" alt="booksback">
        </div>
        
<div class="login-container">
    <div class="login-header">
        <h2>Login to Library</h2>
    </div>
    <form action="Login" method="post" class="login-form">
        <input type="text" name="username" id="username" placeholder="Username" required>
        <input type="password" name="password" id="password" placeholder="Password" required>
        <button type="submit">Login</button>
        <a href="register">Create New Account</a>
    </form>
</div>

</body>
</html>