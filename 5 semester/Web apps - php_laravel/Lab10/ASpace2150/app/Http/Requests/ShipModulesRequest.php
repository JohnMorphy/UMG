<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Contracts\Validation\Validator;
use Illuminate\Http\Exceptions\HttpResponseException;
use Illuminate\Validation\Rule;


class ShipModulesRequest extends FormRequest
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
            'module_name' => 'required|String|min:3|max:25|unique:ship_modules',
            'is_workable' => 'required|boolean',
        ];

        if($this->isMethod('PUT') || $this->isMethod('PATCH')) {
            $id = $this->route('id');

            $rules = [
                'module_name' => [
                    'required',
                    'min:3',
                    'max:25',
                    Rule::unique('ship_modules')->ignore($id),
                ],
                'is_workable' => 'required|boolean',
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
            'module_name.required' => 'Field module_name is required',
            'is_workable.required' => 'Field is_workable is required'
        ];
    }

}
