<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;


class ModuleCrew extends Model
{
    //use HasFactory;
    
    public $timestamps = false;
    protected $table = 'module_crew';
    protected $primaryKey = 'id';
    protected $fillable = ['ship_module_id','nick','gender','age'];

    public function findCrew($id) {
        return ModuleCrew::find($id);
    }

}
