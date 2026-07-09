import { use, useRef } from "react"
import { useNavigate } from "react-router-dom"

function Login() {
    const nameRef = useRef(null)
    const passRef = useRef(null)
    const navigate = useNavigate()
    
    async function PostLogin(nameRef, passRef){
        
        console.log(nameRef.current.value, passRef.current.value)
        const requestOptions = {
            method: "POST",
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ 'name':  nameRef.current.value, 'password': passRef.current.value })
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
        <main className="w-5xl h-1/2 bg-indigo-800 rounded-xl flex flex-col justify-center items-center gap-5">
            <h1 className="text-zinc-50 font-bold text-2xl mb-5">Bem-vindo de volta!</h1>
            <input ref={nameRef} className="w-md h-15 bg-indigo-950 text-zinc-50 pl-5" type="text" name="name" id="iname" placeholder="Ex: Ronaldinho" />
            <input ref={passRef} className="w-md h-15 bg-indigo-950 text-zinc-50 pl-5" type="password" name="pass" id="ipass" placeholder="Ex: 1234" />
            <button onClick={() => PostLogin(nameRef, passRef)} className="w-md h-15 bg-indigo-900 cursor-pointer mt-6 text-zinc-50">Entrar</button>
            <a href="#">Não tenho uma conta</a>
        </main>
    )
}

export default Login