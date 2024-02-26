<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\UserData;

class UserDataSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        UserData::create([
            'user_id' => 1,
            'user_firstname' => 'John',
            'user_lastname' => 'Doe',
            'user_phonenumber' => '1234567890',
        ]);

        UserData::create([
            'user_id' => 2,
            'user_firstname' => 'Admin',
            'user_lastname' => 'User',
            'user_phonenumber' => '9876543210',
        ]);
    }
}
