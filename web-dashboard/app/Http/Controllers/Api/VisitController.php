<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Visit;
use App\Models\Visitor;

class VisitController extends Controller
{
    public function addVisit(Request $request)
    {
        $photoPath = null;
        if ($request->hasFile('photo')) {
            $photoPath = $request->file('photo')->store('photos', 'public');
        }

        $visitor = Visitor::create([
            'name' => $request->name,
            'identity_type_id' => $request->identity_type_id,
            'identity_number' => $request->identity_number,
            'phone' => $request->phone,
            'email' => $request->email,
            'nationality_id' => $request->nationality_id,
            'company' => $request->company,
            'photo' => $photoPath,
        ]);

        $visit = Visit::create([
            'visitor_id' => $visitor->id,
            'purpose' => $request->purpose,
            'employee_id' => $request->employee_id,
            'departement_id' => $request->departement_id,
            'area_visit_id' => $request->area_visit_id,
            // 'employee_name' => $request->employee_name,
            // 'employee_phone' => $request->employee_phone
        ]);

        return response()->json([
            'success' => true,
            'message' => 'Visit added successfully',
            'data'    => [
                'visitor' => $visitor,
                'visit'   => $visit
            ]
        ], 201);
    }
}
