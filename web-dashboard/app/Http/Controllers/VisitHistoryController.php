<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Visit;

class VisitHistoryController extends Controller
{
    public function index(Request $request)
    {
        $visits =  Visit::with(['visitor', 'employee', 'departement', 'areaVisit'])
            ->orderByDesc('created_at')
            ->paginate(10);

        return view('visits.index', compact('visits'));
    }
}
