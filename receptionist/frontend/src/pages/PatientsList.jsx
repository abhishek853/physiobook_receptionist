import React, { useEffect, useState } from 'react'
import axios from 'axios';

const PatientsList = () => {
  
  const [patients, setPatients] = useState([]);

  useEffect( () => {
    const fetchPatients = async () => {
      try {
        const res = await axios.get("http://localhost:8082/api/allPatients");
        console.log(res.data);
        setPatients(res.data);        
      } catch (error) {
        console.error("Error fetching patients:", error);
      }
    };
    fetchPatients();
  },[]); 

  return (
    <div className="p-6 bg-violet-200 min-h-screen">
      <h1 className="text-2xl font-bold text-violet-900 mb-6">Patients List</h1>

      <div className="bg-white shadow rounded-xl overflow-hidden">
        <table className="w-full border-collapse">
          <thead className="bg-violet-300 text-violet-900">
            <tr>
              {/* <th className="p-3 text-left">ID</th> */}
              <th className="p-3 text-left">Name</th>
              <th className="p-3 text-left">Age</th>
              <th className="p-3 text-left">Weight</th>
              <th className="p-3 text-left">Gender</th>
              <th className="p-3 text-left">Contact</th>
              <th className="p-3 text-left">Actions</th>
            </tr>
          </thead>
          <tbody>
            {patients.map((patient, idx) => (
              <tr
                key={patient.id}
                className={`border-b hover:bg-violet-100 ${
                  idx % 2 === 0 ? "bg-violet-50" : "bg-white"
                }`}
              >
                {/* <td className="p-3">{patient.id}</td> */}
                <td className="p-3 font-medium text-violet-800">{patient.name}</td>
                <td className="p-3">{patient.age}</td>
                <td className="p-3">{patient.weight}</td>
                <td className="p-3">{patient.gender}</td>
                <td className="p-3">{patient.phone}</td>
                <td className="p-3 flex gap-2">
                  <button className="bg-blue-600 text-white px-3 py-1 rounded-lg hover:bg-blue-700">
                    View
                  </button>
                  <button className="bg-green-600 text-white px-3 py-1 rounded-lg hover:bg-green-700">
                    Edit
                  </button>
                  <button className="bg-red-600 text-white px-3 py-1 rounded-lg hover:bg-red-700">
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default PatientsList