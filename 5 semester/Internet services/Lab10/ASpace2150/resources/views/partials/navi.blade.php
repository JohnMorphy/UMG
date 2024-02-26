<nav>
 <div>
     
 <a href="{{ route('home') }}">Home page</a>

 <a href="{{ route('shipModules.list') }}">List Modules</a>
 <a href="{{ route('shipModules.add') }}">Add Modules</a>

 <a href="{{ route('moduleCrew.list') }}">List Crew</a>
 <a href="{{ route('moduleCrew.add') }}">Add Crew</a>
 
 <a href="{{ route('crewSkills.list') }}">List Crew Skills</a>
 <a href="{{ route('crewSkills.add') }}">Add Crew Skills</a>
 
 <!--
 @if(Auth::check()) 
    <a href="./wyloguj">Wyloguj</a>
 @else
    <a href="./loguj">Zaloguj</a>
 @endif
    -->
</div>
</nav>
