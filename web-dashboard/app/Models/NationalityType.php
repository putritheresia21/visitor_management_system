<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class NationalityType extends Model
{
    protected $table = 'nationalities';

    protected $fillable = [
        'name',
    ];
}
