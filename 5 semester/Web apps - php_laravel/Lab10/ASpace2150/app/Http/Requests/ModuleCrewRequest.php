<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Validation\Rule;

class ModuleCrewRequest extends FormRequest
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
        'ship_module_id' => [
            'required',
            'integer',
            'min:1',
            Rule::exists('ship_modules', 'id'),
        ],
        'nick' => 'required|string|min:3|max:10|unique:module_crew',
        'age' => 'required|integer|min:18|max:85',
        'gender' => 'required|string|size:1|in:F,M,N'
        ];

        if($this->isMethod('PUT') || $this->isMethod('PATCH')) {
            $id = $this->route('id');
            
            $rules = [
                'ship_module_id' => [
                    'required',
                    'integer',
                    'min:1',
                    Rule::exists('ship_modules', 'id'),
                ],
                'nick' => [
                    'required',
                    'string',
                    'min:3',
                    'max:10',
                    Rule::unique('module_crew')->ignore($id),
                ],
                'age' => 'required|integer|min:18|max:85',
                'gender' => 'required|string|size:1|in:F,M,N',
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
            'ship_module_id.required' => 'Field ship_module_id is required',
            'nick.required' => 'Field nick is required',
            'age.required' => 'Field age is required',
            'gender.required' => 'Field gender is required',
        ];
    }

}
