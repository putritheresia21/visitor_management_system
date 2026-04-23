<?php

namespace App\Http\Controllers;

use App\Models\Visit;
use App\Models\Visitor;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class DashboardController extends Controller
{
    public function index()
    {
        $totalVisitors = Visitor::count();
        $totalVisits = Visit::count();
        $totalCompanies = Visitor::distinct('company')->count('company');

        $topEmployees = Visit::select('employee_id', \DB::raw('count(*) as visits'))
            ->with('employee')
            ->groupBy('employee_id')
            ->orderByDesc('visits')
            ->limit(5)
            ->get();

        $topDepartements = Visit::select('departement_id', DB::raw('count(*) as visits'))
            ->with('departement')
            ->groupBy('departement_id')
            ->orderByDesc('visits')
            ->limit(5)
            ->get();

        $companies = Visitor::select('company', DB::raw('count(*) as total'))
            ->groupBy('company')
            ->orderByDesc('total')
            ->limit(10)
            ->get();

        return view('dashboard', compact(
            'totalVisitors', 
            'totalVisits', 
            'totalCompanies',
            'topEmployees',
            'topDepartements',
            'companies'
        ));
            
    }
}
