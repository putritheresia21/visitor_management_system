<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visitor Management System</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Segoe UI', sans-serif; display: flex; height: 100vh; background: #f0f2f5; }

        .sidebar {
            width: 240px;
            background: #1a1a2e;
            color: white;
            display: flex;
            flex-direction: column;
            position: fixed;
            height: 100vh;
            z-index: 100;
        }

        .sidebar-logo {
            padding: 24px 20px;
            font-size: 16px;
            font-weight: bold;
            border-bottom: 1px solid rgba(255,255,255,0.1);
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .sidebar-logo span {
            font-size: 24px;
        }

        .sidebar-menu {
            padding: 16px 0;
            flex: 1;
        }

        .menu-label {
            padding: 8px 20px;
            font-size: 11px;
            color: rgba(255,255,255,0.4);
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .menu-item {
            display: flex;
            align-items: center;
            gap: 12px;
            padding: 12px 20px;
            color: rgba(255,255,255,0.7);
            text-decoration: none;
            font-size: 14px;
            transition: all 0.2s;
            border-left: 3px solid transparent;
        }

        .menu-item:hover {
            background: rgba(255,255,255,0.08);
            color: white;
        }

        .menu-item.active {
            background: rgba(98, 0, 238, 0.3);
            color: white;
            border-left: 3px solid #6200EE;
        }

        .menu-item .icon {
            font-size: 18px;
            width: 20px;
            text-align: center;
        }

        .sidebar-footer {
            padding: 16px 20px;
            border-top: 1px solid rgba(255,255,255,0.1);
            font-size: 12px;
            color: rgba(255,255,255,0.4);
        }

        .main {
            margin-left: 240px;
            flex: 1;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        .navbar {
            background: white;
            padding: 16px 24px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-shadow: 0 2px 8px rgba(0,0,0,0.08);
            position: sticky;
            top: 0;
            z-index: 99;
        }

        .navbar-title {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }

        .navbar-right {
            display: flex;
            align-items: center;
            gap: 12px;
            font-size: 14px;
            color: #666;
        }

        /* .avatar {
            width: 36px;
            height: 36px;
            background: #6200EE;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-weight: bold;
            font-size: 14px;
        } */

        .content {
            padding: 24px;
            flex: 1;
        }
    </style>
    @stack('styles')
</head>
<body>

    <div class="sidebar">
        <div class="sidebar-logo">
            <div>
                <div>Admin</div>
                <div style="font-size:11px; color:rgba(255,255,255,0.5); font-weight:normal">Visitor Management</div>
            </div>
        </div>

        <div class="sidebar-menu">
            <div class="menu-label">Main Menu</div>

            <a href="{{ url('/') }}"
               class="menu-item {{ request()->is('/') ? 'active' : '' }}">
                Dashboard
            </a>

            <a href="{{ url('/visits') }}"
               class="menu-item {{ request()->is('visits*') ? 'active' : '' }}">
                History Kunjungan
            </a>
        </div>

        
    </div>

    <div class="main">

        <div class="navbar">
            <div class="navbar-title">@yield('title', 'Dashboard')</div>
            {{-- <div class="navbar-right">
                <span>Admin</span>
                <div class="avatar">A</div>
            </div> --}}
        </div>

        <div class="content">
            @yield('content')
        </div>

    </div>

    @stack('scripts')
</body>
</html>