<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Validation\Rule;

class CrewSkillsRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    // public function authorize(): bool
    // {
    //     return false;
    // }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        $rules = [
            'module_crew_id' => [
                'required',
                'integer',
                'min:1',
                Rule::exists('module_crew', 'id'),
            ],
            'name' => 'required|min:3|max:15|unique:crew_skills',
        ];

        if($this->isMethod('PUT') || $this->isMethod('PATCH')) {
            $id = $this->route('id');

            $rules = [
                'module_crew_id' => [
                    'required',
                    'integer',
                    'min:1',
                    Rule::exists('module_crew', 'id'),
                ],
                'name' => [
                    'required',
                    'min:3',
                    'max:15',
                    Rule::unique('crew_skills')->ignore($id),
                ]
            ];
        }

        return $rules;
    }

    public function failedValidation(Validator $validator) {

        throw new HttpResponseException(response()->json([
            'success' => false,
            'message' => 'Validation errors',
            'data' => $validator->errors()
        ]));
    }

    // customizing messages
    public function messages() {
        return [
            'module_crew_id.required' => 'Field module_crew_id is required',
            'name.required' => 'Field name is required'
        ];
    }
}
