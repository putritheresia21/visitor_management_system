<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Employee;

class EmployeeController extends Controller
{
    public function index()
    {
        $employees = Employee::with('departement')->get();

        return response()->json([
            'success' => true,
            'data' => $employees
        ], 200);
    }

    public function getByDepartement($id)
    {
        $employees = Employee::where('departement_id', $id)->get();
    
        return response()->json([
            'success' => true,
            'data' => $employees
        ], 200);
    }

    public function getByNumber($number)
    {
        $employee = Employee::where('number_employee', $number)->first();
    
        if (!$employee) {
            return response()->json([
                'success' => false,
                'message' => 'Employee not found'
            ], 404);
        }
    
        return response()->json([
            'success' => true,
            'data' => $employee
        ], 200);
    }
}
