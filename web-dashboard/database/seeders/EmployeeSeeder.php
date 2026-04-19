<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Employee;

class EmployeeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Employee::create([
            'name' => 'Peter Parker',
            'number_employee' => 'EMP001',
            'phone' => '081234567890',
            'departement_id' => 1,
        ]);
        Employee::create([
            'name' => 'Steve Rogers',
            'number_employee' => 'EMP002',
            'phone' => '081234567891',
            'departement_id' => 2,
        ]);
        Employee::create([
            'name' => 'Tony Stark',
            'number_employee' => 'EMP003',
            'phone' => '081234567892',
            'departement_id' => 3,
        ]);

    }
}
