<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Admin</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .card {
            background: white;
            border-radius: 12px;
            padding: 40px;
            width: 400px;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
        }
        .logo {
            text-align: center;
            margin-bottom: 32px;
        }
        .logo h1 {
            font-size: 24px;
            color: #6200EE;
            font-weight: bold;
        }
        .logo p {
            font-size: 14px;
            color: #666;
            margin-top: 4px;
        }
        .form-group {
            margin-bottom: 16px;
        }
        label {
            display: block;
            font-size: 13px;
            color: #444;
            margin-bottom: 6px;
            font-weight: 500;
        }
        input {
            width: 100%;
            padding: 10px 14px;
            border: 1px solid #ddd;
            border-radius: 8px;
            font-size: 14px;
            outline: none;
            transition: border 0.2s;
        }
        input:focus {
            border-color: #6200EE;
        }
        .error {
            color: red;
            font-size: 12px;
            margin-top: 4px;
        }
        button {
            width: 100%;
            padding: 12px;
            background: #6200EE;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 15px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 8px;
        }
        button:hover { background: #5000CA; }
    </style>
</head>
<body>
    <div class="card">
        <div class="logo">
            <h1>Admin</h1>
            <p>Visitor Management System</p>
        </div>

        <form method="POST" action="/login">
            @csrf

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" value="{{ old('email') }}" placeholder="admin@gmail.com">
                @error('email')
                    <div class="error">{{ $message }}</div>
                @enderror
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" name="password" placeholder="••••••••">
            </div>

            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>