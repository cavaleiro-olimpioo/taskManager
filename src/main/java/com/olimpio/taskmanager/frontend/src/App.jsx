import { BrowserRouter, Routes, Route } from "react-router-dom"
import Login from './components/login';
import Dashboard from './components/dashboard'

function App() {
  return (
    <div className="gap-10 w-screen h-screen bg-indigo-950 flex items-center justify-center flex-col">
      <BrowserRouter>
        <Routes>
          <Route path='/login' element={<Login />}></Route>
          <Route path='/dashboard' element={<Dashboard />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App