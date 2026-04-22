<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

use App\Http\Controllers\Api\IdentityTypeController;
use App\Http\Controllers\Api\NationalityTypeController;
use App\Http\Controllers\Api\DepartemenController;
use App\Http\Controllers\Api\EmployeeController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

//get identity types
Route::get('/identity-types', [IdentityTypeController::class, 'index']);

//get nationality types
Route::get('/nationality-types', [NationalityTypeController::class, 'index']);

//get departemen
Route::get('/departements', [App\Http\Controllers\Api\DepartemenController::class, 'index']);
Route::get('/departements/{id}/employees', [App\Http\Controllers\Api\EmployeeController::class, 'getByDepartement']);

//get employees
Route::get('/employees/search/{number}', [App\Http\Controllers\Api\EmployeeController::class, 'getByNumber']);
Route::get('/employees', [App\Http\Controllers\Api\EmployeeController::class, 'index']);
