<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Departement;

class DepartemenController extends Controller
{
    public function index()
    {
        $departements = Departement::all();

        return response()->json([
            'success' => true,
            'data' => $departements
        ], 200);
    }
}
