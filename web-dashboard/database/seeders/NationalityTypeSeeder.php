<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\NationalityType;

class NationalityTypeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        NationalityType::create([
            'name' => 'Indonesian',
        ]);
        NationalityType::create([
            'name' => 'American',
        ]);
        NationalityType::create([
            'name' => 'Chinese',
        ]);
        NationalityType::create([
            'name' => 'Japanese',
        ]);
        NationalityType::create([
            'name' => 'Other',
        ]);
    }
}
