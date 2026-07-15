import { BrowserRouter, Routes, Route, useNavigate } from "react-router-dom"

import Login from './components/login';
import Dashboard from './components/dashboard'
import { useEffect } from "react";

function App() {
  const navigate = useNavigate();
  const token = localStorage.getItem('token');
  useEffect(() => {
    if (token == null) {
      navigate('/login')
    } else {
        const sendOptions = {
          method: "POST",
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({ 'token': token })
        }
        const url = 'http://localhost:8080/validator'
        try {
          const sendValidation = async () => {
            const returnApiValidation = await fetch(url, sendOptions)
            const data = await returnApiValidation.json()

            if (returnApiValidation.status == 200){
              navigate('/dashboard')
            } else {
              console.log("Token inválido")
              navigate('/login')
            }
          }

        } catch (error) {
          console.log("[Erro] Rede internet ou API não disponível", error)
        }
      }
  }, [])



  return (
    <div className="gap-10 w-screen h-screen bg-indigo-950 flex items-center justify-center flex-col">
      
      <Routes>
        <Route path='/login' element={<Login />}></Route>
        <Route path='/dashboard' element={<Dashboard />}></Route>
      </Routes>
    
    </div>
  )
}

export default App