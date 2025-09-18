import { Route, Routes } from 'react-router-dom'
import './App.css'
import CreatePatient from './components/CreatePatient'
import HomePage from './components/HomePage'
import Navbar from './components/Navbar'

function App() {

  return (
    <>
            
        <Navbar />              

      <Routes>                
        <Route path="/new" element={<CreatePatient />}></Route>
        <Route path="/" element={<HomePage />}></Route>
      </Routes>
    </>
  )
}

export default App
