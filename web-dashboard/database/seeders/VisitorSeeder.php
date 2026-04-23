<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class VisitorSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $visitors = [
            [
                'name' => 'John Smith',
                'identity_type_id' => 1,
                'identity_number'  => '1234567890',
                'phone'            => '081234567890',
                'email'            => 'john@starkindustries.com',
                'nationality_id'   => 1,
                'company'          => 'Stark Industries',
                'photo'            => null
            ],
            [
                'name' => 'Jane Jansen',
                'identity_type_id' => 2,
                'identity_number'  => '0987654321',
                'phone'            => '081234567891',
                'email'            => 'jane@wayneindustries.com',
                'nationality_id'   => 1,
                'company'          => 'Wayne Industries',
                'photo'            => null
            ],
            [
                'name' => 'Bruce Wayne',
                'identity_type_id' => 2,
                'identity_number'  => '1122334455',
                'phone'            => '081234567892',
                'email'            => 'bruce@wayneindustries.com',
                'nationality_id'   => 2,
                'company'          => 'Wayne Industries',
                'photo'            => null
            ],
            [
                'name' => 'Charlie Brown',
                'identity_type_id' => 3,
                'identity_number'  => 'AB0987654321',
                'phone'            => '081234567891',
                'email'            => 'charlie@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Peanuts',
                'photo'            => null
            ],
            [
                'name' => 'Lucy van Pelt',
                'identity_type_id' => 3,
                'identity_number'  => 'AB1234567890',
                'phone'            => '081234567890',
                'email'            => 'lucy@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Peanuts',
                'photo'            => null
            ],
            [
                'name' => 'Fiona Blue',
                'identity_type_id' => 1,
                'identity_number'  => '098765432123',
                'phone'            => '081234567891',
                'email'            => 'fiona@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Cyburg',
                'photo'            => null  
            ],
            [   
                'name' => 'Gina Green',
                'identity_type_id' => 2,
                'identity_number'  => '1122334454235',
                'phone'            => '081234567892',
                'email'            => 'gina@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Cyburg',
                'photo'            => null
            ],
            [
                'name' => 'Harry Potter',
                'identity_type_id' => 3,
                'identity_number'  => '091234567890',
                'phone'            => '081234567890',
                'email'            => 'harry@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Hogwarts',
                'photo'            => null
            ],
            [
                'name' => 'Hermione Granger',
                'identity_type_id' => 3,
                'identity_number'  => '091234567891',
                'phone'            => '081234567891',
                'email'            => 'hermione@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Hogwarts',
                'photo'            => null
            ],
            [
                'name' => 'Ron Weasley',
                'identity_type_id' => 3,
                'identity_number'  => '091234567892',
                'phone'            => '081234567892',
                'email'            => 'ron@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Hogwarts',
                'photo'            => null
            ],
            [
                'name' => 'Albus Dumbledore',
                'identity_type_id' => 3,
                'identity_number'  => '091234567893',
                'phone'            => '081234567893',
                'email'            => 'dumbledore@gmail.com',
                'nationality_id'   => 1,
                'company'          => 'Hogwarts',
                'photo'            => null
            ]
        ];
        
        foreach ($visitors as $visitor) {
            \App\Models\Visitor::create($visitor);
        }
    }
}
