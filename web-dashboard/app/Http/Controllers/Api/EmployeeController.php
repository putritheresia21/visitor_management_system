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
}
