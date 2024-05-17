<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\ShipModulesController;
use App\Http\Controllers\ModuleCrewController;
use App\Http\Controllers\CrewSkillsController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider and all of them will
| be assigned to the "web" middleware group. Make something great!
|
*/

Route::get('/', [HomeController::class,'index'])->name('home');

// Ship modules - without api
/*
Route::get('/shipModules/list', [ShipModulesController::class,'index'])->name('shipModules.list');
Route::get('/shipModules/assignedCrew/{id}', [ShipModulesController::class,'assignedCrew'])->name('shipModules.assignedCrew');
Route::get('/shipModules/add', [ShipModulesController::class,'create'])->name('shipModules.add');
Route::post('/shipModules/save', [ShipModulesController::class,'store'])->name('shipModules.save');
Route::get('/shipModules/edit/{id}', [ShipModulesController::class,'edit'])->name('shipModules.edit');
Route::post('/shipModules/update/{id}', [ShipModulesController::class,'update'])->name('shipModules.update');
Route::get('/shipModules/show/{id}', [ShipModulesController::class,'show'])->name('shipModules.show');
Route::post('/shipModules/delete/{id}', [ShipModulesController::class,'destroy'])->name('shipModules.delete');
*/

// Module crew - without api
/*
Route::get('/moduleCrew/list', [ModuleCrewController::class,'index'])->name('moduleCrew.list');
Route::get('/moduleCrew/add', [ModuleCrewController::class,'create'])->name('moduleCrew.add');
Route::post('/moduleCrew/save', [ModuleCrewController::class,'store'])->name('moduleCrew.save');
Route::get('/moduleCrew/edit/{id}', [ModuleCrewController::class,'edit'])->name('moduleCrew.edit');
Route::post('/moduleCrew/update/{id}', [ModuleCrewController::class,'update'])->name('moduleCrew.update');
Route::get('/moduleCrew/show/{id}', [ModuleCrewController::class,'show'])->name('moduleCrew.show');
Route::post('/moduleCrew/delete/{id}', [ModuleCrewController::class,'destroy'])->name('moduleCrew.delete');
*/

// Crew skills - without api
/*
Route::get('/crewSkills/list', [CrewSkillsController::class,'index'])->name('crewSkills.list');
Route::get('/crewSkills/add', [CrewSkillsController::class,'create'])->name('crewSkills.add');
Route::post('/crewSkills/save', [CrewSkillsController::class,'store'])->name('crewSkills.save');
Route::get('/crewSkills/edit/{id}', [CrewSkillsController::class,'edit'])->name('crewSkills.edit');
Route::post('/crewSkills/update/{id}', [CrewSkillsController::class,'update'])->name('crewSkills.update');
Route::get('/crewSkills/show/{id}', [CrewSkillsController::class,'show'])->name('crewSkills.show');
Route::post('/crewSkills/delete/{id}', [CrewSkillsController::class,'destroy'])->name('crewSkills.delete');
*/

// Ship modules - using api
Route::get('/shipModules/list', [ShipModulesController::class,'index_api'])->name('shipModules.list');
Route::get('/shipModules/assignedCrew/{id}', [ShipModulesController::class,'assignedCrew_api'])->name('shipModules.assignedCrew');
Route::get('/shipModules/add', [ShipModulesController::class,'create'])->name('shipModules.add');
Route::post('/shipModules/save', [ShipModulesController::class,'store_api'])->name('shipModules.save');
Route::get('/shipModules/edit/{id}', [ShipModulesController::class,'edit_api'])->name('shipModules.edit');
Route::post('/shipModules/update/{id}', [ShipModulesController::class,'update_api'])->name('shipModules.update');
Route::get('/shipModules/show/{id}', [ShipModulesController::class,'show_api'])->name('shipModules.show');
Route::post('/shipModules/delete/{id}', [ShipModulesController::class,'destroy_api'])->name('shipModules.delete');


// Module crew - using api
Route::get('/moduleCrew/list', [ModuleCrewController::class,'index_api'])->name('moduleCrew.list');
Route::get('/moduleCrew/add', [ModuleCrewController::class,'create'])->name('moduleCrew.add');
Route::post('/moduleCrew/save', [ModuleCrewController::class,'store_api'])->name('moduleCrew.save');
Route::get('/moduleCrew/edit/{id}', [ModuleCrewController::class,'edit_api'])->name('moduleCrew.edit');
Route::post('/moduleCrew/update/{id}', [ModuleCrewController::class,'update_api'])->name('moduleCrew.update');
Route::get('/moduleCrew/show/{id}', [ModuleCrewController::class,'show_api'])->name('moduleCrew.show');
Route::post('/moduleCrew/delete/{id}', [ModuleCrewController::class,'destroy_api'])->name('moduleCrew.delete');


// Crew skills - using api
Route::get('/crewSkills/list', [CrewSkillsController::class,'index_api'])->name('crewSkills.list');
Route::get('/crewSkills/add', [CrewSkillsController::class,'create'])->name('crewSkills.add');
Route::post('/crewSkills/save', [CrewSkillsController::class,'store_api'])->name('crewSkills.save');
Route::get('/crewSkills/edit/{id}', [CrewSkillsController::class,'edit_api'])->name('crewSkills.edit');
Route::post('/crewSkills/update/{id}', [CrewSkillsController::class,'update_api'])->name('crewSkills.update');
Route::get('/crewSkills/show/{id}', [CrewSkillsController::class,'show_api'])->name('crewSkills.show');
Route::post('/crewSkills/delete/{id}', [CrewSkillsController::class,'destroy_api'])->name('crewSkills.delete');
