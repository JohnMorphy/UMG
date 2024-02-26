<nav>
    <div class="nav_div">

        <a class="nav_link" href="{{ route('offers') }}">
            <img class='icon' src="{{ URL::asset('images/favicon.ico') }}" alt="Logo" width="32" height="32">
            YourNewHome
        </a>

        <div class="nav-links">
            <a class="nav_link" href="{{ route('offers') }}">View offers</a>
            <a class="nav_link" href="{{ route('show_create_offer') }}">Add offer</a>
            
            @if(Auth::check()) 
                <a class="nav_link" href="{{ route('view_personal') }}">
                    <img class='icon' src="{{ URL::asset('images/userIcon.png') }}" alt="Logo" width="32" height="32">
                    My data
                </a>
                <a class="nav_link" href="{{ route('logout') }}">Logout</a>

                @if(Auth::user()->user_role_id == 2)
                    <a class="nav_link" href="{{ route('admin_dashboard_users') }}">
                        <img class='icon' src="{{ URL::asset('images/gearIcon.png') }}" alt="Logo" width="32" height="32">
                        Admin Dashboard
                    </a>
                @endif

            @else
                <a class="nav_link" href="{{ route('login') }}">Login</a>
            @endif

        </div>

        <div class="hamburger-menu" onclick="toggleMenu()">
            <div class="bar bar1"></div>
            <div class="bar bar2"></div>
            <div class="bar bar3"></div>
        </div>


    </div>
</nav>
