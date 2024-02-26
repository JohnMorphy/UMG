<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class ShipModules extends Model
{
    //use HasFactory;

    public $timestamps = false;
    protected $table = 'ship_modules';
    protected $primaryKey = 'id';
    protected $fillable = ['module_name','is_workable'];

    // reading ModuleCrew for a module
    public function moduleCrew()
    {
        return $this->hasMany(ModuleCrew::class);
    }

    public function findModule($id) {
        return ShipModules::find($id);
    }

    public function workableModules() {
        return ShipModules::all()->where('is_workable', 1);
    }

}
