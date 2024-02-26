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
        Schema::create('property_photos', function (Blueprint $table) {
            $table->id('id');
            $table->unsignedBigInteger('offer_id');
            $table->string('filepath', 255)->nullable(false);
            $table->timestamps();

            // Define foreign key constraint
            $table->foreign('offer_id')->references('id')->on('offer')->onDelete('restrict');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('property_photos');
    }
};
