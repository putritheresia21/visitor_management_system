<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\NationalityType;

class NationalityTypeController extends Controller
{
    public function index()
    {
        $nationalityTypes = NationalityType::all();

        return response()->json([
            'success' => true,
            'data' => $nationalityTypes
        ], 200);
    }
}
