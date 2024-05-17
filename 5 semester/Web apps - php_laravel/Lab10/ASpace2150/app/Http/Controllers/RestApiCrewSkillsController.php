<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\CrewSkills;
use App\Http\Requests\CrewSkillsRequest;

class RestApiCrewSkillsController extends Controller
{
    public function ListCrewSkills() {
        $myCrewSkills = CrewSkills::all();
        $data = ["data" => $myCrewSkills];

        return response()->json($data, 200);
    }

    public function FindCrewSkills($id) {
        $crew_skill = CrewSkills::find($id);

        if($crew_skill != null) {
            return response()->json(['data' => $crew_skill]);
        } else {
            return response()->json(['data' => []]);
        }
    }

    public function NewCrewSkills(CrewSkillsRequest $request) {

        $data = $request->validated();

        $crew_skill = new CrewSkills();

        $crew_skill->module_crew_id = $data['module_crew_id'];
        $crew_skill->name = $data['name'];
        
        $crew_skill -> save();
        return response()->json(['data' => $crew_skill]);

    }

    public function DeleteCrewSkills($id) {
        $crew_skill = CrewSkills::find($id);

        if($crew_skill != null) {
            $crew_skill->delete();
            return response()->json(['data' => $crew_skill]);
        }
        else {
            return response()->json(['data' => []]);
        }
    }

    public function UpdateCrewSkills($id, CrewSkillsRequest $request) {
        $data = $request->validated();
        $crew_skill = CrewSkills::find($id);

        if ($crew_skill != null) {
            $crew_skill->module_crew_id = $data['module_crew_id'];
            $crew_skill->name = $data['name'];
            
            $crew_skill -> save();
            return response()->json(['data' => $crew_skill]);
        }
        else {
            return response()->json(['data' => []]);    
        }

    }

}
