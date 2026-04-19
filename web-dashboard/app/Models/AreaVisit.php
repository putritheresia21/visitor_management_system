<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class AreaVisit extends Model
{
    protected $table = 'areas_visits';

    protected $fillable = [
        'area_name',
    ];
}
