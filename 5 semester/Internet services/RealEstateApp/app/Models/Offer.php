<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Offer extends Model
{
    protected $table = 'offer';

    public $timestamps = false;

    protected $fillable = [
        'user_id',
        'title',
        'description',
        'offer_postalcode',
        'offer_price',
        'area_in_meters',
        'expiration_date',
        'street',
        'address',
        'city',
    ];

    public function user()
    {
        return $this->belongsTo(User::class, 'user_id');
    }

    public function propertyPhotos()
    {
        return $this->hasMany(PropertyPhoto::class, 'offer_id');
    }
}
