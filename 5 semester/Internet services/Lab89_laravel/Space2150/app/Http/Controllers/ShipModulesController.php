<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ShipModules;
use App\Models\ModuleCrew;
use Illuminate\Validation\Rule;

class ShipModulesController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $myShipModules = ShipModules::all();

        return view('shipModules.list', ['ship_modules' => $myShipModules]);
    }

    public function assignedCrew(string $id) {
        $crew = ModuleCrew::all()->where('ship_module_id',$id);
        $module = ShipModules::find($id);
    
        if ($crew == null || $module == null) 
        {
            $error_message = "Crew for module=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }
        
        if ($crew->count() == 0) 
        {
            $error_message = "There is no crew for module ".$module->module_name;
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'No crew members']);
        }

        
        if ($crew->count() > 0) {
            return view('shipModules.assignedCrew', ['crew' => $crew, 'module' => $module]);
        }
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('shipModules.add');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validated = $request->validate([
            'module_name' => 'required|min:3|max:25|unique:ship_modules',
            'is_workable' => 'required',
        ]);

        if($validated)
        {
            $mod_ship = new ShipModules();

            $mod_ship->module_name = $request->module_name;
            $mod_ship->is_workable = $request->is_workable;

            $mod_ship->save();
            return redirect('/shipModules/list');
        }

    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $myShipModule = ShipModules::find($id);
        
        if ($myShipModule == null) 
        {
            $error_message = "Ship module id=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myShipModule->count() > 0) {
            return view('shipModules.show', ['shipModule' => $myShipModule]);
        }
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $myShipModule = ShipModules::find($id);

        if ($myShipModule == null) 
        {
            $error_message = "Ship module id=".$id." not found";
            return view("shipModules.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myShipModule->count() > 0) {
            return view('shipModules.edit', ['shipModule' => $myShipModule]);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $validated = $request->validate([
            'module_name' => [
                'required',
                'min:3',
                'max:25',
                Rule::unique('ship_modules')->ignore($id),
            ],
            'is_workable' => 'required',
        ]);

        if($validated) {
            $mod_ship = ShipModules::find($id);

            if($mod_ship != null) {
                $mod_ship->module_name = $request->module_name;
                $mod_ship->is_workable = $request->is_workable;
                $mod_ship->save();

                return redirect('/shipModules/list');
            }
            else
            {
                $error_message = "Ship module id=".$id." not found";
                return view('shipModules.message', ['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $mod_ship = ShipModules::find($id);
        if($mod_ship != null) {
            $mod_ship->delete();
            return redirect('/shipModules/list');
        }
        else {
            $error_message = "Delete ship module id=".$id." not found";
            return view('shipModules.message', ['message'=>$error_message,'type_of_message'=>'Error']);
        }

    }
}
