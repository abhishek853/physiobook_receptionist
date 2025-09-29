import { Route, Routes } from 'react-router-dom'
import './App.css'
import CreatePatient from './pages/CreatePatient'
import HomePage from './pages/HomePage'
import Navbar from './components/Navbar'
import PatientList from './pages/PatientsList'

function App() {

  return (
    <>
      <Routes>
        <Route path="/" element={<Navbar />}>
          {/* These pages will appear inside <Outlet /> */}
          <Route index element={<HomePage />} />       {/* Default page */}
          <Route path="/new" element={<CreatePatient />} />
          <Route path='/PatientsList' element={<PatientList />}></Route>
        </Route>
      </Routes>
    </>
  )
}

export default App
