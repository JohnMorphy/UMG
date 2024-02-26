<!DOCTYPE html>
<html>
@include('partials.head')
<body>
 @include('partials.navi')
<div id="content">
<div class ="form-view">   
 <h1>Register</h1>
    <form method="POST" action="{{ route('register') }}" class="form">
        @csrf

        <!-- Name -->
        <div class = "login-row">
            <x-input-label for="name" :value="__('Name')" />
            <br>
            <x-text-input id="name" class="input" type="text" name="name" :value="old('name')" required autofocus autocomplete="name" />
            <x-input-error :messages="$errors->get('name')" class="mt-2" />
        </div>

        <!-- Email Address -->
        <div class = "login-row">
            <x-input-label for="email" :value="__('Email')" />
            <br>
            <x-text-input id="email" class="input" type="email" name="email" :value="old('email')" required autocomplete="username" />
            <x-input-error :messages="$errors->get('email')" class="mt-2" />
        </div>

        <!-- Password -->
        <div class = "login-row">
            <x-input-label for="password" :value="__('Password')" />
            <br>
            <x-text-input id="password" class="input"
                            type="password"
                            name="password"
                            required autocomplete="new-password" />

            <x-input-error :messages="$errors->get('password')" class="mt-2" />
        </div>

        <!-- Confirm Password -->
        <div class = "login-row">
            <x-input-label for="password_confirmation" :value="__('Confirm Password')" />
            <br>
            <x-text-input id="password_confirmation" class="input"
                            type="password"
                            name="password_confirmation" required autocomplete="new-password" />

            <x-input-error :messages="$errors->get('password_confirmation')" class="mt-2" />
        </div>

        <div class = "login-row">
            <x-primary-button class="ms-4">
                {{ __('Register') }}
            </x-primary-button>

            <a class="form-link" href="{{ route('login') }}">
                'Already registered?
            </a>

        </div>
    </form>
</div>
</div>
</body>
</html>
