<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Departement;

class DepartemenSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Departement::create([
            'departement_name' => 'IT',
        ]);
        Departement::create([
            'departement_name' => 'HRD',
        ]);
        Departement::create([
            'departement_name' => 'Finance',
        ]);
        Departement::create([
            'departement_name' => 'Marketing',
        ]);
    }
}
