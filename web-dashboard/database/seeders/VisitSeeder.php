<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use App\Models\Visitor;
use App\Models\Visit;
use App\Models\Employee;

class VisitSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        Visitor::factory(50)->create();
        Visit::factory(30)->create();
        Visit::factory(20)->lastWeek()->create();
        Visit::factory(10)->lastDays(3)->create();
        Visit::factory(5)->lastDays(1)->create();

        // $emp1 = Employee::where('number_employee', 'EMP001')->first();
        // $emp2 = Employee::where('number_employee', 'EMP002')->first();
        // $emp3 = Employee::where('number_employee', 'EMP003')->first();

        // $visits = [
        //     ['visitor_id' => 1, 'employee_id' => $emp1->id,  'departement_id' => $emp1->departement_id,  'area_visit_id' => 1, 'purpose' => 'Meeting'],
        //     ['visitor_id' => 2, 'employee_id' => $emp1->id,  'departement_id' => $emp1->departement_id,  'area_visit_id' => 1, 'purpose' => 'Discussion'],
        //     ['visitor_id' => 3, 'employee_id' => $emp1->id,  'departement_id' => $emp1->departement_id,  'area_visit_id' => 2, 'purpose' => 'Presentation'],
        //     ['visitor_id' => 4, 'employee_id' => $emp1->id,  'departement_id' => $emp1->departement_id,  'area_visit_id' => 1, 'purpose' => 'Meeting'],
        //     ['visitor_id' => 5, 'employee_id' => $emp1->id,  'departement_id' => $emp1->departement_id,  'area_visit_id' => 2, 'purpose' => 'Training'],
        //     ['visitor_id' => 1, 'employee_id' => $emp2->id, 'departement_id' => $emp2->departement_id, 'area_visit_id' => 1, 'purpose' => 'Meeting'],
        //     ['visitor_id' => 3, 'employee_id' => $emp2->id, 'departement_id' => $emp2->departement_id, 'area_visit_id' => 2, 'purpose' => 'Interview'],
        //     ['visitor_id' => 6, 'employee_id' => $emp2->id, 'departement_id' => $emp2->departement_id, 'area_visit_id' => 1, 'purpose' => 'Discussion'],
        //     ['visitor_id' => 7, 'employee_id' => $emp2->id, 'departement_id' => $emp2->departement_id, 'area_visit_id' => 2, 'purpose' => 'Meeting'],
        //     ['visitor_id' => 2, 'employee_id' => $emp3->id, 'departement_id' => $emp3->departement_id, 'area_visit_id' => 1, 'purpose' => 'Delivery'],
        //     ['visitor_id' => 4, 'employee_id' => $emp3->id, 'departement_id' => $emp3->departement_id, 'area_visit_id' => 2, 'purpose' => 'Meeting'],
        //     ['visitor_id' => 8, 'employee_id' => $emp3->id, 'departement_id' => $emp3->departement_id, 'area_visit_id' => 1, 'purpose' => 'Discussion'],
        // ];

        // foreach ($visits as $visit) {
        //     try {
        //         Visit::create($visit);
        //     } catch (\Exception $e) {
        //         echo "Error creating visit for visitor_id: {$visit['visitor_id']}, employee_id: {$visit['employee_id']}. Error: " . $e->getMessage() . "\n";
        //     }
        // }
    }
}
