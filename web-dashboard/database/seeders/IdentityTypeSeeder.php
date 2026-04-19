<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use App\Models\IdentityType;

class IdentityTypeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {        
        IdentityType::create([
            'identity_type' => 'KTP',
        ]);
        IdentityType::create([
            'identity_type' => 'SIM',
        ]);
        IdentityType::create([
            'identity_type' => 'Passport',
        ]);
    }
}
