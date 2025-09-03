import { useState } from "react";

export default function CreatePatient() {
  const [formData, setFormData] = useState({
    name: "",
    age: "",
    gender: "",
    phone: "",
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Patient Data:", formData);
    // Here you can call your API to save patient
  };

  return (
    <div className="min-h-screen bg-gray-50 flex items-center justify-center p-4 sm:p-6 lg:p-8">
      <div className="bg-gray-100 shadow-2xl rounded-3xl p-6 sm:p-8 w-full max-w-sm md:max-w-md lg:max-w-lg">
        <h2 className="text-3xl font-extrabold mb-8 text-center text-gray-800">
          Create New Patient 🩺
        </h2>

        <form onSubmit={handleSubmit} className="space-y-6">
          {/* Name */}
          <div>
            <label htmlFor="name" className="block text-sm font-medium text-gray-700">
              Name
            </label>
            <input
              type="text"
              name="name"
              id="name"
              placeholder="e.g., Jane Doe"
              value={formData.name}
              onChange={handleChange}
              className="mt-1 block w-full px-4 py-2 text-black bg-gray-50 border border-gray-300 rounded-xl shadow-sm focus:ring-purple-500 focus:border-purple-500 transition-all duration-200"
              required
            />
          </div>

          {/* Age */}
          <div>
            <label htmlFor="age" className="block text-sm font-medium text-gray-700">
              Age
            </label>
            <input
              type="number"
              name="age"
              id="age"
              placeholder="e.g., 35"
              value={formData.age}
              onChange={handleChange}
              className="mt-1 block w-full px-4 py-2 text-black bg-gray-50 border border-gray-300 rounded-xl shadow-sm focus:ring-purple-500 focus:border-purple-500 transition-all duration-200"
              required
            />
          </div>

          {/* Gender */}
          <div>
            <label htmlFor="gender" className="block text-sm font-medium text-gray-700">
              Gender
            </label>
            <select
              name="gender"
              id="gender"
              value={formData.gender}
              onChange={handleChange}
              className="mt-1 block w-full px-4 py-2 text-black bg-gray-50 border border-gray-300 rounded-xl shadow-sm focus:ring-purple-500 focus:border-purple-500 transition-all duration-200"
              required
            >
              <option value="">Select Gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </select>
          </div>

          {/* Phone */}
          <div>
            <label htmlFor="phone" className="block text-sm font-medium text-gray-700">
              Phone
            </label>
            <input
              type="tel"
              name="phone"
              id="phone"
              placeholder="e.g., 123-456-7890"
              value={formData.phone}
              onChange={handleChange}
              className="mt-1 block w-full px-4 py-2 text-black bg-gray-50 border border-gray-300 rounded-xl shadow-sm focus:ring-purple-500 focus:border-purple-500 transition-all duration-200"
            />
          </div>

          {/* Submit Button */}
          <button
            type="submit"
            className="w-full bg-purple-600 text-white font-semibold py-3 rounded-xl shadow-md hover:bg-purple-700 transition-all duration-300 transform hover:scale-105 focus:outline-none focus:ring-2 focus:ring-purple-500 focus:ring-offset-2"
          >
            Save Patient
          </button>
        </form>
      </div>
    </div>
  );
}