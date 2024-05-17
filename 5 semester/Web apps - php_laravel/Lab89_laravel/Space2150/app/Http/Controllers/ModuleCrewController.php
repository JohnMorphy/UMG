<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\ModuleCrew;
use Illuminate\Validation\Rule;

class ModuleCrewController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $myModuleCrew = ModuleCrew::all();

        return view('moduleCrew.list', ['module_crew' => $myModuleCrew]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('moduleCrew.add');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validated = $request->validate([
            'ship_module_id' => [
                'required',
                'integer',
                'min:1',
                Rule::exists('ship_modules', 'id'),
            ],
            'nick' => 'required|string|min:3|max:10|unique:module_crew',
            'age' => 'required|integer|min:18|max:85',
            'gender' => 'required|string|size:1|in:F,M,N',
        ]);

        if($validated)
        {
            $mod_crew = new ModuleCrew();

            $mod_crew->ship_module_id = $request->ship_module_id;
            $mod_crew->nick = $request->nick;
            $mod_crew->gender = $request->gender;
            $mod_crew->age = $request->age;

            $mod_crew->save();
            return redirect('/moduleCrew/list');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $myModuleCrew = ModuleCrew::find($id);
        
        if ($myModuleCrew == null) 
        {
            $error_message = "Crew id=".$id." not found";
            return view("moduleCrew.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myModuleCrew->count() > 0) {
            return view('moduleCrew.show', ['moduleCrew' => $myModuleCrew]);
        }
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $myModuleCrew = ModuleCrew::find($id);

        if ($myModuleCrew == null) 
        {
            $error_message = "Crew id=".$id." not found";
            return view("moduleCrew.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myModuleCrew->count() > 0) {
            return view('moduleCrew.edit', ['moduleCrew' => $myModuleCrew]);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $validated = $request->validate([
            'ship_module_id' => [
                'required',
                'integer',
                'min:1',
                Rule::exists('ship_modules', 'id'),
            ],
            'nick' => [
                'required',
                'string',
                'min:3',
                'max:10',
                Rule::unique('module_crew')->ignore($id),
            ],
            'age' => 'required|integer|min:18|max:85',
            'gender' => 'required|string|size:1|in:F,M,N',
        ]);

        if($validated)
        {
            $mod_crew = ModuleCrew::find($id);

            if($mod_crew != null) {
                $mod_crew->ship_module_id = $request->ship_module_id;
                $mod_crew->nick = $request->nick;
                $mod_crew->gender = $request->gender;
                $mod_crew->age = $request->age;
                $mod_crew->save();
                return redirect('/moduleCrew/list');
            }
            else {
                $error_message = "Crew id=".$id." not found";
                return view('moduleCrew.message', ['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $mod_crew = ModuleCrew::find($id);
        if($mod_crew != null) {
            $mod_crew->delete();
            return redirect('/moduleCrew/list');
        }
        else {
            $error_message = "Crew with id=".$id." not found";
            return view('moduleCrew.message', ['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }
}
