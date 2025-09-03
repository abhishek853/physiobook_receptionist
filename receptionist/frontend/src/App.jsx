import { Route, Routes } from 'react-router-dom'
import './App.css'
import CreatePatient from './components/CreatePatient'

function App() {

  return (
    <>
      <h1 className='bg-red-500'>Receptionalist</h1>
      <Routes>
        <Route path="/" element={<CreatePatient/>}></Route>
      </Routes>
    </>
  )
}

export default App
