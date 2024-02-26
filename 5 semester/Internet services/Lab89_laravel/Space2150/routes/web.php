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

// Ship modules

Route::get('/shipModules/list', [ShipModulesController::class,'index'])->name('shipModules.list');
Route::get('/shipModules/assignedCrew/{id}', [ShipModulesController::class,'assignedCrew'])->name('shipModules.assignedCrew');
Route::get('/shipModules/add', [ShipModulesController::class,'create'])->name('shipModules.add');
Route::post('/shipModules/save', [ShipModulesController::class,'store'])->name('shipModules.save');
Route::get('/shipModules/edit/{id}', [ShipModulesController::class,'edit'])->name('shipModules.edit');
Route::post('/shipModules/update/{id}', [ShipModulesController::class,'update'])->name('shipModules.update');
Route::get('/shipModules/show/{id}', [ShipModulesController::class,'show'])->name('shipModules.show');
Route::post('/shipModules/delete/{id}', [ShipModulesController::class,'destroy'])->name('shipModules.delete');

// Module crew

Route::get('/moduleCrew/list', [ModuleCrewController::class,'index'])->name('moduleCrew.list');
Route::get('/moduleCrew/add', [ModuleCrewController::class,'create'])->name('moduleCrew.add');
Route::post('/moduleCrew/save', [ModuleCrewController::class,'store'])->name('moduleCrew.save');
Route::get('/moduleCrew/edit/{id}', [ModuleCrewController::class,'edit'])->name('moduleCrew.edit');
Route::post('/moduleCrew/update/{id}', [ModuleCrewController::class,'update'])->name('moduleCrew.update');
Route::get('/moduleCrew/show/{id}', [ModuleCrewController::class,'show'])->name('moduleCrew.show');
Route::post('/moduleCrew/delete/{id}', [ModuleCrewController::class,'destroy'])->name('moduleCrew.delete');

// Crew skills

Route::get('/crewSkills/list', [CrewSkillsController::class,'index'])->name('crewSkills.list');
Route::get('/crewSkills/add', [CrewSkillsController::class,'create'])->name('crewSkills.add');
Route::post('/crewSkills/save', [CrewSkillsController::class,'store'])->name('crewSkills.save');
Route::get('/crewSkills/edit/{id}', [CrewSkillsController::class,'edit'])->name('crewSkills.edit');
Route::post('/crewSkills/update/{id}', [CrewSkillsController::class,'update'])->name('crewSkills.update');
Route::get('/crewSkills/show/{id}', [CrewSkillsController::class,'show'])->name('crewSkills.show');
Route::post('/crewSkills/delete/{id}', [CrewSkillsController::class,'destroy'])->name('crewSkills.delete');
