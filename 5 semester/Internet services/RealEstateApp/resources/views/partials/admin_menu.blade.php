<nav>
    <div class="nav_div">

        <a class="nav_link" href="{{ route('offers') }}">
            <img class='icon' src="{{ URL::asset('images/favicon.ico') }}" alt="Logo" width="32" height="32">
            Go to website
        </a>

        <div class="nav-links">
            @if(Auth::check()) 
                @if(Auth::user()->user_role_id == 2)
                    <a class="nav_link" href="{{ route('admin_dashboard_users') }}">
                        Moderate users
                    </a>

                    <a class="nav_link" href="{{ route('admin_dashboard_offers') }}">
                        Moderate offers
                    </a>
                @endif
            @endif

        </div>

        <div class="hamburger-menu" onclick="toggleMenu()">
            <div class="bar bar1"></div>
            <div class="bar bar2"></div>
            <div class="bar bar3"></div>
        </div>


    </div>
</nav>
