<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use App\Models\Departement;
use App\Models\AreaVisit;

class Visit extends Model
{
    use HasFactory;

    protected $fillable = [
        'visitor_id',
        'purpose',
        'employee_id',
        'department_id',
        'area_visited_id',
        // 'employee_name',
        // 'employee_phone'
    ];

    public function visitor()
    {
        return $this->belongsTo(Visitor::class);
    }

    public function employee()
    {
        return $this->belongsTo(Employee::class);
    }

    public function departement()
    {
        return $this->belongsTo(Departement::class);
    }

    public function areaVisit()
    {
        return $this->belongsTo(AreaVisit::class);
    }

    
}
