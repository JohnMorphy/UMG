<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\User;

class UsersSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        User::create([
            'user_role_id' => 1,
            'name' => 'user',
            'email' => 'regularuser@example.com',
            'password' => bcrypt('password123'),
        ]);

        User::create([
            'user_role_id' => 2,
            'name' => 'admin',
            'email' => 'admin@example.com',
            'password' => bcrypt('password123'),
        ]);
    }
}
