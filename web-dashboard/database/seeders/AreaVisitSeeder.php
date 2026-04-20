<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\AreaVisit;

class AreaVisitSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        AreaVisit::create([
            'area_name' => 'Lobby',
        ]);
        AreaVisit::create([
            'area_name' => 'Meeting Room',
        ]);
        AreaVisit::create([
            'area_name' => 'Office',
        ]);
        AreaVisit::create([
            'area_name' => 'Cafeteria',
        ]);
         AreaVisit::create([
            'area_name' => 'Parking Lot',
        ]);
    }
}
