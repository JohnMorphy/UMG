<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ModuleCrew;
use App\Http\Requests\ModuleCrewRequest;

class RestApiModuleCrewController extends Controller
{
    public function ListModuleCrew() {
        $myModuleCrew = ModuleCrew::all();
        $data = ["data" => $myModuleCrew];

        return response()->json($data, 200);
    }

    public function FindModuleCrew($id) {
        $myModuleCrew = ModuleCrew::find($id);

        if($myModuleCrew != null) {
            return response()->json(['data' => $myModuleCrew]);
        } else {
            return response()->json(['data' => []]);
        }
    }

    public function NewModuleCrew(ModuleCrewRequest $request) {

        $data = $request->validated();

        $mod_crew = new ModuleCrew();

        $mod_crew->ship_module_id = $data['ship_module_id'];
        $mod_crew->nick = $data['nick'];
        $mod_crew->age = $data['age'];
        $mod_crew->gender = $data['gender'];

        $mod_crew -> save();
        return response()->json(['data' => $mod_crew]);

    }

    public function DeleteModuleCrew($id) {
        $mod_crew = ModuleCrew::find($id);

        if($mod_crew != null) {
            $mod_crew->delete();
            return response()->json(['data' => $mod_crew]);
        }
        else {
            return response()->json(['data' => []]);
        }
    }

    public function UpdateModuleCrew($id, ModuleCrewRequest $request) {
        $data = $request->validated();
        $mod_crew = ModuleCrew::find($id);

        if ($mod_crew != null) {
            $mod_crew->ship_module_id = $data['ship_module_id'];
            $mod_crew->nick = $data['nick'];
            $mod_crew->age = $data['age'];
            $mod_crew->gender = $data['gender'];
    
            $mod_crew -> save();
            return response()->json(['data' => $mod_crew]);
        }
        else {
            return response()->json(['data' => []]);    
        }

    }

    public function AssignedCrew($id) {
        $crew = ModuleCrew::all()->where('ship_module_id',$id);
        
        $data = ["data" => $crew];

        return response()->json($data, 200);
    
    }



}
