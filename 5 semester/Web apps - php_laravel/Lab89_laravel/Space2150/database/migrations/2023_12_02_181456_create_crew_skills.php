<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::create('crew_skills', function (Blueprint $table) {
            $table->increments('id');
            $table->unsignedInteger('module_crew_id');
            $table->foreign('module_crew_id')->references('id')->on('module_crew');
            $table->string('name', 15)->unique();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('crew_skills');
    }
};
