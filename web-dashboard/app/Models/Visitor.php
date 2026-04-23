<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Visitor extends Model
{
    use HasFactory;
    
    protected $fillable = [
        'name',
        'identity_number',
        'identity_type_id',
        'phone',
        'email',
        'nationality_id',
        'company',
        'photo',
    ];

    public function visits()
    {
        return $this->hasMany(Visit::class);
    }

    public function identityType()
    {
        return $this->belongsTo(IdentityType::class);
    }

    public function nationality()
    {
        return $this->belongsTo(NationalityType::class);
    }
}
