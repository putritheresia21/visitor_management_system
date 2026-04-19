<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('visits', function (Blueprint $table) {
            $table->id();
            $table->string('purpose');
            
            $table->foreignId('visitor_id')
                    ->constrained()
                    ->onDelete('cascade');
            $table->foreignId('employee_id')
                    ->constrained()
                    ->onDelete('restrict');
            $table->foreignId('departement_id')
                    ->constrained()
                    ->onDelete('restrict');
            $table->foreignId('area_visit_id')
                    ->constrained('areas_visits')
                    ->onDelete('restrict');
            
            $table->string('employee_name');
            $table->string('employee_phone');

            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('visits');
    }
};
