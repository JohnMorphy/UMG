<?php

use App\Http\Controllers\ProfileController;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\WebController;
use App\Http\Controllers\Auth\RegisteredUserController;

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

/* offers */ 
Route::get('/', [WebController::class,'offerList']);
Route::get('/offers', [WebController::class,'offerList'])->name('offers');

Route::get('/offer_getById/{id}', [WebController::class,'offer_getById'])->name('offer_getById');
Route::get('/show_create_offer', [WebController::class,'show_create_offer'])->name('show_create_offer')->middleware('auth');
Route::post('/store_offer', [WebController::class,'storeOffer'])->name('offer_store')->middleware('auth');
Route::get('/delete_offer/{id}', [WebController::class,'delete_offer'])->name('delete_offer')->middleware('auth');
Route::get('/show_edit_offer/{id}', [WebController::class,'show_edit_offer'])->name('show_edit_offer')->middleware('auth');
Route::patch('/update_offer/{id}', [WebController::class,'update_offer'])->name('update_offer')->middleware('auth');
Route::get('/delete_offerPhotos/{id}', [WebController::class,'delete_offerPhotos'])->name('delete_offerPhotos')->middleware('auth');
Route::get('/update_expirationDate/{id}', [WebController::class,'update_expirationDate'])->name('update_expirationDate')->middleware('auth');


Route::get('/view_personal', [WebController::class,'view_personal'])->name('view_personal')->middleware('auth');
Route::get('/edit_user_data', [WebController::class, 'editUserData'])->name('user_data_edit')->middleware('auth');
Route::patch('/update_user_data', [WebController::class, 'updateUserData'])->name('user_data_update')->middleware('auth');
Route::get('/admin_dashboard_users', [WebController::class,'admin_dashboard_users'])->name('admin_dashboard_users')->middleware('auth');
Route::get('/admin_delete_user/{id}', [WebController::class,'admin_delete_user'])->name('admin_delete_user')->middleware('auth');
Route::get('/admin_dashboard_offers', [WebController::class,'admin_dashboard_offers'])->name('admin_dashboard_offers')->middleware('auth');
Route::get('/admin_delete_offer/{id}', [WebController::class,'admin_delete_offer'])->name('admin_delete_offer')->middleware('auth');


/*
Route::get('/dashboard', function () {
    return view('dashboard');
})->middleware(['auth', 'verified'])->name('dashboard');
*/

Route::get('/login', [WebController::class,'changeAuthorizationStatus']);
Route::get('/logout',[WebController::class,'changeAuthorizationStatus']);


Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

require __DIR__.'/auth.php';


?>