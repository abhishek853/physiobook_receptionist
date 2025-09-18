import React from 'react'
import logo from "../assets/logo.png";
import { Link } from 'react-router-dom';
const Navbar = () => {
  return (
    <nav className="bg-violet-600 p-4 shadow-lg">
      <div className="w-full px-4 flex items-center justify-between">
        {/* Logo and App Name */}
        <Link to="/">
          <div className="flex items-center text-white text-base md:text-xl font-bold">
            <img
              src={logo}
              alt="Therapy Logo"
              className="h-6 w-6 md:h-8 md:w-8 mr-2"
            />
            TherapyForU
          </div>
        </Link>

        {/* Action Buttons */}
        <div className="flex items-center space-x-2 md:space-x-4">
          <Link to="/new">
            <button className="bg-green-500 hover:bg-green-600 text-white text-sm md:text-base font-semibold py-2 px-3 md:px-4 rounded-full transition-colors duration-200">
              Add Patient
            </button>
          </Link>
          <div className="bg-gray-200 w-8 h-8 md:w-10 md:h-10 rounded-full flex items-center justify-center">
            {/* User Profile Icon/Image */}
            <svg
              xmlns="http://www.w3.org/2000/svg"
              className="h-5 w-5 md:h-6 md:w-6 text-gray-700"
              fill="none"
              viewBox="0 0 24 24"
              stroke="currentColor"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"
              />
            </svg>
          </div>
        </div>
      </div>
    </nav>
  )
}

export default Navbar