<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use App\Models\ModuleCrew;

class ModuleCrewSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('module_crew')->insert([
            ['ship_module_id'=>1, 'nick'=>'Timmy','gender'=>'M','age'=>32],
            ['ship_module_id'=>2, 'nick'=>'Anna','gender'=>'W','age'=>34],
            ['ship_module_id'=>3, 'nick'=>'Tompson','gender'=>'M','age'=>21],
            ]);
    }
}
