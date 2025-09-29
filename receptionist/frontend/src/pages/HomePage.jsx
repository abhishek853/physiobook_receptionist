import { useState } from 'react'

const HomePage = () => {
    const [appointments, setAppointments] = useState([
        {
            time: '09:00 AM',
            patientName: 'John Doe',
            therapyName: 'Physical Therapy',
            status: 'Not Arrived',
        },
        {
            time: '10:00 AM',
            patientName: 'John Doe',
            therapyName: 'Speech Therapy',
            status: 'Not Arrived',
        },
        {
            time: '10:30 AM',
            patientName: 'Jane Smith',
            therapyName: 'Occupational Therapy',
            status: 'In Cabin',
        },
        {
            time: '12:00 PM',
            patientName: 'John Doe',
            therapyName: 'Hydro Therapy',
            status: 'In Cabin',
        },
        {
            time: '02:00 PM',
            patientName: 'John Doe',
            therapyName: 'Massage Therapy',
            status: 'Completed',
        },
        {
            time: '12:30 PM',
            patientName: 'John Doe',
            therapyName: 'Cognitive Therapy',
            status: 'Reschedule',
        },
    ]);

    const statusOptions = ['Not Arrived', 'In Cabin', 'Completed', 'Reschedule'];

    // ✅ Update status function
    const handleStatusChange = (index, newStatus) => {
        const updatedAppointments = [...appointments];
        updatedAppointments[index].status = newStatus;
        setAppointments(updatedAppointments);
    };

    return (
        <div className='bg-violet-200'>
            <main className="container mx-auto mt-4 md:mt-0 p-4 md:p-6 bg-violet-200 rounded-lg shadow-md">
                <h1 className="text-xl md:text-2xl font-bold mb-4 md:mb-6">Today's Appointments</h1>

                {/* Responsive Table Wrapper */}
                <div className="overflow-x-auto">
                    <table className="min-w-full divide-y divide-gray-200">
                        <thead className="bg-violet-500">
                            <tr>
                                <th className="px-4 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">
                                    Time
                                </th>
                                <th className="px-4 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">
                                    Patient Name
                                </th>
                                <th className="px-4 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">
                                    Therapy Name
                                </th>
                                <th className="px-4 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">
                                    Status
                                </th>
                                <th className="px-4 py-3 text-left text-xs font-medium text-white uppercase tracking-wider">
                                    Actions
                                </th>
                            </tr>
                        </thead>
                        <tbody className="bg-violet-300 divide-y divide-gray-200">
                            {appointments.map((appointment, index) => (
                                <tr key={index}>
                                    <td className="px-4 py-4 whitespace-nowrap text-xs md:text-sm font-medium text-black">
                                        {appointment.time}
                                    </td>
                                    <td className="px-4 py-4 whitespace-nowrap text-xs md:text-sm text-black">
                                        {appointment.patientName}
                                    </td>
                                    <td className="px-4 py-4 whitespace-nowrap text-xs md:text-sm text-black">
                                        {appointment.therapyName}
                                    </td>
                                    <td className="px-4 py-4 whitespace-nowrap text-xs md:text-sm">
                                        {/* ✅ Controlled Status Dropdown */}
                                        <select
                                            value={appointment.status}
                                            onChange={(e) => handleStatusChange(index, e.target.value)}
                                            className="mt-1 block w-full pl-2 pr-8 py-1 md:py-2 text-xs md:text-sm border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 rounded-md text-black"
                                        >
                                            {statusOptions.map((status, statusIndex) => (
                                                <option key={statusIndex} value={status}>
                                                    {status}
                                                </option>
                                            ))}
                                        </select>
                                    </td>
                                    <td className="px-4 py-4 whitespace-nowrap text-sm font-medium">
                                        {/* Action Buttons */}
                                        <div className="flex items-center space-x-1 md:space-x-2">
                                            <button className="bg-blue-500 hover:bg-blue-600 text-white py-1 px-2 md:px-3 rounded text-xs md:text-sm">
                                                Edit
                                            </button>
                                            <button className="bg-red-500 hover:bg-red-600 text-white py-1 px-2 md:px-3 rounded text-xs md:text-sm">
                                                Delete
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    )
}

export default HomePage
