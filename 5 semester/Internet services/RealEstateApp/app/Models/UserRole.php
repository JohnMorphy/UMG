<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class UserRole extends Model
{
    protected $table = 'user_role';

    public $timestamps = false;
    
    protected $primaryKey = 'user_role_id';

    protected $fillable = [
        'user_role_name',
    ];

    public function users()
    {
        return $this->hasMany(User::class, 'user_role_id');
    }
}
