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
        Schema::create('offer', function (Blueprint $table) {
            $table->id('id');
            $table->unsignedBigInteger('user_id');
            $table->string('description', 2000)->nullable(false);
            $table->string('title', 50)->nullable(false);
            $table->string('offer_postalcode', 50)->nullable(false);
            $table->integer('offer_price')->nullable(false);
            $table->integer('area_in_meters')->nullable(false);
            $table->date('expiration_date')->nullable(false);
            $table->string('street', 50)->nullable(false);
            $table->string('address', 50)->nullable(false);
            $table->string('city', 50)->nullable(false);
            $table->timestamps();

            // Define foreign key constraint
            $table->foreign('user_id')->references('id')->on('users')->onDelete('restrict');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('offer');
    }
};
