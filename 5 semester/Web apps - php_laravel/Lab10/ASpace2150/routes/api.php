<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\RestApiController;
use App\Http\Controllers\RestApiShipModulesController;
use App\Http\Controllers\RestApiCrewSkillsController;
use App\Http\Controllers\RestApiModuleCrewController;


/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "api" middleware group. Make something great!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

//testing api
Route::get('/welcome', [RestApiController::class,'showWelcome']);
Route::get('/full-name/first-name/{first_name}/last-name/{last_name}',
[RestApiController::class,'showFullNameFromPath']);
Route::get('/full-name',
[RestApiController::class,'showFullNameFromQueryParams']);
Route::post('/full-name',
[RestApiController::class,'showFullNameFromAttributesData']);

// shipModules
Route::get('/shipModules/list',
[RestApiShipModulesController::class,'ListShipModules']);
Route::get('/shipModules/find/{id}',
[RestApiShipModulesController::class,'FindShipModule']);

Route::post('/shipModules/new',
[RestApiShipModulesController::class,'NewShipModule']);
Route::delete('/shipModules/delete/{id}',
[RestApiShipModulesController::class,'DeleteShipModule']);
Route::put('/shipModules/update/{id}',
[RestApiShipModulesController::class,'UpdateShipModule']);
Route::patch('/shipModules/update/{id}',
[RestApiShipModulesController::class,'UpdateShipModule']);

// moduleCrew
Route::get('/moduleCrew/list',
[RestApiModuleCrewController::class,'ListModuleCrew']);
Route::get('/moduleCrew/find/{id}',
[RestApiModuleCrewController::class,'FindModuleCrew']);
// used by shipModulesController but gets record from moduleCrew table
Route::get('/moduleCrew/assignedCrew/{id}',
[RestApiModuleCrewController::class,'AssignedCrew']);

Route::post('/moduleCrew/new',
[RestApiModuleCrewController::class,'NewModuleCrew']);
Route::delete('/moduleCrew/delete/{id}',
[RestApiModuleCrewController::class,'DeleteModuleCrew']);
Route::put('/moduleCrew/update/{id}',
[RestApiModuleCrewController::class,'UpdateModuleCrew']);
Route::patch('/moduleCrew/update/{id}',
[RestApiModuleCrewController::class,'UpdateModuleCrew']);

// crew skills

Route::get('/crewSkills/list',
[RestApiCrewSkillsController::class,'ListCrewSkills']);
Route::get('/crewSkills/find/{id}',
[RestApiCrewSkillsController::class,'FindCrewSkills']);

Route::post('/crewSkills/new',
[RestApiCrewSkillsController::class,'NewCrewSkills']);
Route::delete('/crewSkills/delete/{id}',
[RestApiCrewSkillsController::class,'DeleteCrewSkills']);
Route::put('/crewSkills/update/{id}',
[RestApiCrewSkillsController::class,'UpdateCrewSkills']);
Route::patch('/crewSkills/update/{id}',
[RestApiCrewSkillsController::class,'UpdateCrewSkills']);


?>