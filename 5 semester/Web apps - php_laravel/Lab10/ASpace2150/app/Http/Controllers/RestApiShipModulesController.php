<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ShipModules;
use App\Http\Requests\ShipModulesRequest;

class RestApiShipModulesController extends Controller
{
    public function ListShipModules() {
        $myShipModules = ShipModules::all();
        $data = ["data" => $myShipModules];

        return response()->json($data, 200);
    }

    public function FindShipModule($id) {
        $mod_ship = ShipModules::find($id);

        if($mod_ship != null) {
            return response()->json(['data' => $mod_ship]);
        } else {
            return response()->json(['data' => []]);
        }

    }

    public function NewShipModule(ShipModulesRequest $request) {

        $data = $request->validated();

        $mod_ship = new ShipModules();

        $mod_ship->module_name = $data['module_name'];
        $mod_ship->is_workable = $data['is_workable'];
        
        $mod_ship -> save();
        return response()->json(['data' => $mod_ship]);

    }

    public function DeleteShipModule($id) {
        $mod_ship = ShipModules::find($id);

        if($mod_ship != null) {
            $mod_ship->delete();
            return response()->json(['data' => $mod_ship]);
        }
        else {
            return response()->json(['data' => []]);
        }
    }

    public function UpdateShipModule($id, ShipModulesRequest $request) {
        $data = $request->validated();
        $mod_ship = ShipModules::find($id);

        if ($mod_ship != null) {
            $mod_ship->module_name = $data['module_name'];
            $mod_ship->is_workable = $data['is_workable'];
    
            $mod_ship -> save();
            return response()->json(['data' => $mod_ship]);
        }
        else {
            return response()->json(['data' => []]);    
        }

    }
}
