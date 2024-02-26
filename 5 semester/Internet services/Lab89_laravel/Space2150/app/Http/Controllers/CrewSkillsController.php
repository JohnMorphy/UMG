<?php

namespace App\Http\Controllers;
use App\Models\CrewSkills;
use Illuminate\Validation\Rule;

use Illuminate\Http\Request;

class CrewSkillsController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $myCrewSkills = CrewSkills::all();

        return view('crewSkills.list', ['crewSkills' => $myCrewSkills]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('crewSkills.add');
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        $validated = $request->validate([
            'module_crew_id' => [
                'required',
                'integer',
                'min:1',
                Rule::exists('module_crew', 'id'),
            ],
            'name' => 'required|min:3|max:15|unique:crew_skills',
        ]);

        if($validated)
        {
            $mod_crew = new CrewSkills();

            $mod_crew->module_crew_id = $request->module_crew_id;
            $mod_crew->name = $request->name;

            $mod_crew->save();
            return redirect('/crewSkills/list');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $myCrewSkill = CrewSkills::find($id);
        
        if ($myCrewSkill == null) 
        {
            $error_message = "Crew skill id=".$id." not found";
            return view("crewSkills.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myCrewSkill->count() > 0) {
            return view('crewSkills.show', ['crewSkills' => $myCrewSkill]);
        }
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $myCrewSkill = CrewSkills::find($id);

        if ($myCrewSkill == null) 
        {
            $error_message = "Crew skill id=".$id." not found";
            return view("crewSkills.message", ['message'=>$error_message,'type_of_message'=>'Error']);
        }

        if ($myCrewSkill->count() > 0) {
            return view('crewSkills.edit', ['crewSkills' => $myCrewSkill]);
        }
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        $validated = $request->validate([
            'module_crew_id' => [
                'required',
                'integer',
                'min:1',
                Rule::exists('module_crew', 'id'),
            ],
            'name' => [
                'required',
                'min:3',
                'max:15',
                Rule::unique('crew_skills')->ignore($id),
            ]
        ]);

        if($validated)
        {
            $mod_crew = CrewSkills::find($id);

            if($mod_crew != null) {
                $mod_crew->module_crew_id = $request->module_crew_id;
                $mod_crew->name = $request->name;
    
                $mod_crew->save();
                return redirect('/crewSkills/list');    
            }
            else {
                $error_message = "Crew skill id=".$id." not found";
                return view("crewSkills.message", ['message'=>$error_message,'type_of_message'=>'Error']);
            }
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $mod_crew = CrewSkills::find($id);
        if($mod_crew != null) {
            $mod_crew->delete();
            return redirect('/crewSkills/list');
        }
        else {
            $error_message = "Delete crew skill id=".$id." not found";
            return view('crewSkills.message', ['message'=>$error_message,'type_of_message'=>'Error']);
        }
    }
}
