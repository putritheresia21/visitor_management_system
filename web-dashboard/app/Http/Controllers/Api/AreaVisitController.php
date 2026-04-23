<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\AreaVisit;

class AreaVisitController extends Controller
{
    
    public function index()
    {
        $areaVisits = AreaVisit::all();
        return response()->json([
            'success' => true,
            'data' => $areaVisits
        ], 200);
    }
}
