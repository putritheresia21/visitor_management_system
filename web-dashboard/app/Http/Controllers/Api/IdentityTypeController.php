<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\IdentityType;

class IdentityTypeController extends Controller
{
    public function index()
    {
        $identityTypes = IdentityType::all();

        return response()->json([
            'success' => true,
            'data' => $identityTypes
        ], 200);
    }
}
