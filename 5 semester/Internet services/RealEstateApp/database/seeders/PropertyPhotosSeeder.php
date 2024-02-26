<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\PropertyPhoto;

class PropertyPhotosSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        PropertyPhoto::create([
            'offer_id' => 1, 
            'filepath' => 'photos/photo' . $i . '.jpg',
        ]);
    }
}
