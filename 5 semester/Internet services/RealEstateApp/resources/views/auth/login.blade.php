<!DOCTYPE html>
<html>
@include('partials.head')
<body>
 @include('partials.navi')

<div id="content">
<div class="form-view">
 <h1>Login</h1>

    <!-- Session Status -->
    <x-auth-session-status class="mb-4" :status="session('status')" />

    <form method="POST" action="{{ route('login') }}" class="form">
        @csrf

        <!-- Email Address -->
        <div class = "login-row">
            <x-input-label for="email" :value="__('Email')" /> <br>
            <x-text-input id="email" class="input" type="email" name="email" :value="old('email')" required autofocus autocomplete="username" />
            <x-input-error :messages="$errors->get('email')" class="mt-2" />
        </div>

        <!-- Password -->
        <div class = "login-row">
            <x-input-label for="password" :value="__('Password')" />
            <br>

            <x-text-input id="password" class="input"
                            type="password"
                            name="password"
                            required autocomplete="current-password" />

            <x-input-error :messages="$errors->get('password')" class="mt-2" />
        </div>

        <!-- Remember Me -->
        <div class = "login-row">
            <label for="remember_me" class="inline-flex items-center">
                <input id="remember_me" type="checkbox" class="checkbox" name="remember">
                <span class="ms-2 text-sm text-gray-600 dark:text-gray-400">{{ __('Remember me') }}</span>
            </label>
        </div>

        <div class = "login-row">

            <x-primary-button class="ms-3">
                {{ __('Log in') }}
            </x-primary-button>

            <a class="form-link" href="{{ route('register') }}">
                Create new account
            </a>

        </div>
    </form>
</div>
</div>
</body>
</html>
