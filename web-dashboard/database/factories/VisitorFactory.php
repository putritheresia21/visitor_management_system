<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Visitor>
 */
class VisitorFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition()
    {
        $companies = ['PT. ABC', 'PT. XYZ', 'PT. DEF', 'PT. GHI'];
        return [
            'name' => $this->faker->name(),
            'identity_type_id' => $this->faker->randomElement([1, 2, 3]),
            'identity_number' => $this->faker->unique()->numerify('##########'),
            'phone' => '08' . $this->faker->phoneNumber(),
            'email' => $this->faker->unique()->safeEmail(),
            'nationality_id' => $this->faker->numberBetween(1, 3),
            'company' => $this->faker->randomElement($companies),
            'photo' => null
        ];
    }
}
