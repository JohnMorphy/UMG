<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Offer;

class OfferSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        Offer::create([
            'user_id' => 1, 
            'offer_postalcode' => '12345',
            'offer_price' => 1000000,
            'area_in_meters' => 90,
            'expiration_date' => now()->addDays(30), // expiration date: 30 days
            'address' => '123 Main St',
        ]);
    }
}
