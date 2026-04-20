<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Employee extends Model
{
    protected $table = 'employees';

    protected $fillable = [
        'name',
        'number_employee',
        'phone',
        'departement_id',
    ];

    public function departement()
    {
        return $this->belongsTo(Departement::class);
    }
}
