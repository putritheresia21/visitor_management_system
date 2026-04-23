<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Visit>
 */
class VisitFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition()
    {
        $purpose = ['Meeting', 'Presentation', 'Discussion', 'Conference', 'Interview'];

        $date = $this->faker->dateTimeBetween('-1 month', 'now');   

        return [
            'visitor_id' => $this->faker->numberBetween(1, 50),
            'employee_id' => $this->faker->numberBetween(1, 3),
            'departement_id' => $this->faker->numberBetween(1, 3),
            'area_visit_id' => $this->faker->numberBetween(1, 2),
            'purpose' => $this->faker->randomElement($purpose),
            'created_at' => $date,
            'updated_at' => $date
        ];
    }

    public function lastWeek()
    {
        return $this->state(function (){
            $purpose = ['Meeting', 'Presentation', 'Discussion', 'Conference', 'Interview'];
            $date = $this->faker->dateTimeBetween('-1 week', 'now');   

            return [
                // 'visitor_id' => $this->faker->numberBetween(1, 50),
                // 'employee_id' => $this->faker->numberBetween(1, 3),
                // 'department_id' => $this->faker->numberBetween(1, 3),
                // 'area_visited_id' => $this->faker->numberBetween(1, 2),
                // 'purpose' => $this->faker->randomElement($purpose),
                'created_at' => $date,
                'updated_at' => $date
            ];
        });
    }

    public function lastDays(int $days = 3)
    {
        return $this->state(function () use ($days) {
            $date = $this->faker->dateTimeBetween("-$days days", 'now');
            return [
                'created_at' => $date,
                'updated_at' => $date
            ];
        });
    }
}
