<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class UserData extends Model
{
    protected $table = 'user_data';

    public $timestamps = false;

    protected $fillable = [
        'user_id',
        'user_firstname',
        'user_lastname',
        'user_phonenumber',
    ];

    public function user()
    {
        return $this->belongsTo(User::class, 'user_id');
    }
}
