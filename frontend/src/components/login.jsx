import { use, useRef } from "react"
import { useNavigate } from "react-router-dom"
import LoginImg from '../assets/LoginAside/LoginImg.png'


function Login() {
    const nameRef = useRef(null)
    const passRef = useRef(null)
    const navigate = useNavigate()
    
    async function PostLogin(nameRef, passRef){
        
        console.log(nameRef.current.value, passRef.current.value)
        const requestOptions = {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 'username':  nameRef.current.value, 'password': passRef.current.value })
        }
        const url = 'http://localhost:8080/login'
        try{
            
            const returnApiLogin = await fetch(url, requestOptions)
            const data = await returnApiLogin.json()
            
            console.log(data)

            if (data.token == null) {
                console.log("Token não encontrado")
            } else {
                localStorage.setItem('token', data.token)
                navigate('/dashboard')
            }

        }catch(error){
            console.log("[ERRO] Não foi possível se conectar com a API", error)
        }
     
    }
    
    return (
        <main className="w-screen h-screen flex flex-row justify-between items-center gap-5 ">
            <article className="w-1/2">
                <div className="h-full w-1/2 max-w-3xl flex justify-center absolute inset-0 object-cover bg-cover bg-center" style={{backgroundImage: `url(${LoginImg})`}}></div>
            </article>
            <article className="w-1/2 max-w-2xl mr-28">
                <h1 className="text-zinc-50 font-bold text-2xl mb-5">Bem-vindo de volta!</h1>
                <input ref={nameRef} className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs mb-5 border border-gray-800 focus:outline-none shadow-lg block w-full" type="text" name="username" id="iname" placeholder="Ex: Ronaldinho" />
                <input ref={passRef} className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs mb-5 border border-gray-800 focus:outline-none shadow-lg block w-full" type="password" name="password" id="ipass" placeholder="Ex: 1234" />
                <button onClick={() => PostLogin(nameRef, passRef)} className="bg-sky-500 text-white w-full h-14 rounded-md cursor-pointer hover:bg-sky-600 transition-all mt-10 shadow-lg">Entrar</button>
                <button onClick={() => {navigate('/Sign')}}>Não tenho uma conta</button>
            </article>
        </main>
    )
}

export default Login