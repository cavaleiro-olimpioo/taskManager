import { useNavigate } from "react-router-dom"
import { useState, useRef, useEffect } from "react"


import a1 from '../assets/SignAside/a1.jpg'
import a2 from '../assets/SignAside/a2.png'
import a3 from '../assets/SignAside/a3.png'

function Sign(){
    const navigate = useNavigate()
    const img1Aside = useRef(null)
    const img2Aside = useRef(null)
    const img3Aside = useRef(null)

    const firstNameRef = useRef(null)
    const lastNameRef = useRef(null)
    const usernameRef = useRef(null)
    const emailRef = useRef(null)
    const passwordRef = useRef(null)
    const AgreeTermsRef = useRef(null)

    const errorTermsRef = useRef(null)
    const errorUsernameRef = useRef(null)
    const errorEmailRef = useRef(null)
    const errorPasswordRef = useRef(null)

    const errorEmailRepeatRef = useRef(null)
    const errorUsernameRepeatRef = useRef(null)

    const [temp, setTemp] = useState(0)

    useEffect(() => {
        if (img1Aside.current && img2Aside.current && img3Aside.current) {

            const timeout = setTimeout(() => { setTemp(prev => prev + 1) }, 10000)
            if (temp === 0) {
                img1Aside.current.classList.remove("translate-x-full")
                img2Aside.current.classList.remove("translate-x-full")
                img3Aside.current.classList.remove("translate-x-full")
            } else if (temp === 1) {
                img3Aside.current.classList.add("translate-x-full")
            } else if (temp === 2) {
                img2Aside.current.classList.add("translate-x-full")
            } else {
                img1Aside.current.classList.add("translate-x-full")
                setTemp(0)
            }
            return () => clearTimeout(timeout);
        } else {
            return
        }
        

    }, [temp])

    async function submit(){
        if (!AgreeTermsRef.current.checked || usernameRef.current.value === "" || emailRef.current.value === "" || passwordRef.current.value === ""){
            if(!AgreeTermsRef.current.checked){
                errorTermsRef.current.classList.add("opacity-100")
                errorTermsRef.current.classList.remove("opacity-0")
            } else {
                errorTermsRef.current.classList.add("opacity-0")
                errorTermsRef.current.classList.remove("opacity-100")
            }
            if (usernameRef.current.value === ""){
                errorUsernameRef.current.classList.add("opacity-100")
                errorUsernameRef.current.classList.remove("opacity-0")
            } else {
                errorUsernameRef.current.classList.add("opacity-0")
                errorUsernameRef.current.classList.remove("opacity-100")
            }
            if (emailRef.current.value === ""){
                errorEmailRef.current.classList.add("opacity-100")
                errorEmailRef.current.classList.remove("opacity-0")
            } else {
                errorEmailRef.current.classList.add("opacity-0")
                errorEmailRef.current.classList.remove("opacity-100")
            }
            if (passwordRef.current.value === ""){
                errorPasswordRef.current.classList.add("opacity-100")
                errorPasswordRef.current.classList.remove("opacity-0")
            } else {
                errorPasswordRef.current.classList.add("opacity-0")
                errorPasswordRef.current.classList.remove("opacity-100")
            }
            
        } else {
            const requestOptions = {
                method: "POST",
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    "email": emailRef.current.value,
                    "username": usernameRef.current.value,
                    "firstName": firstNameRef.current.value,
                    "lastName": lastNameRef.current.value,
                    "password": passwordRef.current.value
                })
            }
            const url = 'http://localhost:8080/sign'
            try {
                const returnApiLogin = await fetch(url, requestOptions)
                const data = await returnApiLogin.json()

                if (data == 0){
                    navigate('/login')
                } else {
                    if (data == 1){
                        window.alert("[ERRO] Algo deu errado, tente novamente")
                    }
                    if (data == 2){
                        errorUsernameRepeatRef.current.classList.remove("hidden")
                        errorUsernameRepeatRef.current.classList.add("block")
                        errorUsernameRef.current.classList.add("hidden")
                    } else {
                        errorUsernameRepeatRef.current.classList.add("hidden")
                        errorUsernameRepeatRef.current.classList.remove("block")
                        errorUsernameRef.current.classList.remove("hidden")
                    }
                    if (data == 3){
                        errorEmailRepeatRef.current.classList.remove("hidden")
                        errorEmailRepeatRef.current.classList.add("block")
                        errorEmailRef.current.classList.add("hidden")
                    } else {
                        errorEmailRepeatRef.current.classList.add("hidden")
                        errorEmailRepeatRef.current.classList.remove("block")
                        errorEmailRef.current.classList.remove("hidden")
                    }
                }


                

            } catch (error) {
                console.log("[ERRO] Não foi possível se conectar com a API", error)
            }
            navigate('/login')
        }
    }

    return (
        <main className="flex flex-row gap-10 p-10 h-screen min-w-11/12 m-20 mr-10 ml-10 bg-gray-900 overflow-hidden rounded-xl max-w-2xl shadow-2xl">
            <article className="w-1/2 h-full rounded-xl overflow-hidden overflow-y-auto shadow-2xl">
                <div className="overflow-hidden w-full h-full relative">
                    <div ref={img1Aside} className="flex justify-center absolute inset-0 w-full h-full object-cover bg-cover bg-center transition-all duration-300" style={{backgroundImage: `url(${a1})`}}>
                        <span className="text-gray-200 font-bold text-2xl pt-10 shadow-2xl">Clareza nas tarefas. Liberdade para criar</span>
                    </div>
                    <div ref={img2Aside} className="absolute inset-0 w-full h-full object-cover bg-cover bg-center transition-all duration-300" style={{backgroundImage: `url(${a2})`}}>
                    </div>
                    <div ref={img3Aside} className="flex justify-between items-center p-10 flex-col absolute inset-0 w-full h-full object-cover bg-cover bg-center transition-all duration-300" style={{backgroundImage: `url(${a3})`}}>
                        <span className="text-gray-100 font-bold text-lg">Entre a ideia e a realização existe uma tarefa</span>
                        <span className="text-gray-100 font-bold text-lg">Toda conquista começa com uma única ação</span>
                    </div>
                </div>
            </article>
            <article className="w-1/2 h-full p-10">
                <aside className="mb-14">
                    <h1 className="text-5xl text-sky-500 text-shadow-lg mb-3">Criar uma conta</h1>
                    <p className="inline text-gray-200 ">Já tem uma conta?</p>
                    <a className="inline text-sky-500 ml-2 cursor-pointer" href="/login">Entrar</a>
                </aside>
                <aside className="flex flex-col h-full">
                    <div className="w-full flex gap-1 justify-between mb-5">
                        <span></span>
                        <input ref={firstNameRef} type="text" name="firstName" id="firstName" placeholder="Nome" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs border border-gray-800 focus:outline-none w-full shadow-lg" />
                        <input ref={lastNameRef} type="text" name="lastName" id="lastName" placeholder="Sobrenome" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs border border-gray-800 focus:outline-none w-full shadow-lg" />
                    </div>
                    <span ref={errorUsernameRef} className="text-red-500 text-sm font-bold opacity-0 cursor-default">* Preencha seu username para prosseguir</span>
                    <span ref={errorUsernameRepeatRef} className="text-red-500 text-sm font-bold hidden cursor-default">* Username já em uso</span>
                    <input ref={usernameRef} type="text" name="username" id="username" placeholder="Nome de usuário" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs mb-5 border border-gray-800 focus:outline-none shadow-lg" />
                    <span ref={errorEmailRef} className="text-red-500 text-sm font-bold opacity-0 cursor-default">* Insira seu email para prosseguir</span>
                    <span ref={errorEmailRepeatRef} className="text-red-500 text-sm font-bold hidden cursor-default">* Email já em uso</span>
                    <input ref={emailRef} type="email" name="email" id="email" placeholder="Email" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs mb-5 border border-gray-800 focus:outline-none shadow-lg" />
                    <span ref={errorPasswordRef} className="text-red-500 text-sm font-bold opacity-0 cursor-default">* Insira sua senha para prosseguir</span>
                    <input ref={passwordRef} type="password" name="password" id="password" placeholder="Senha" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs border border-gray-800 focus:outline-none shadow-lg" />
                    <button className="bg-sky-500 text-white py-2 px-4 rounded-md cursor-pointer hover:bg-sky-600 transition-all mt-10 shadow-lg" onClick={submit}>Criar conta</button>

                    <div className="mt-5">
                        <input ref={AgreeTermsRef} className="inline mr-3 accent-sky-500" type="checkbox" required name="AgreeTerms" id="AgreeTerms" />
                        <label className="inline text-gray-200" htmlFor="AgreeTerms">Concordo com os <a className="text-sky-500" href="#">termos e condições</a></label>
                        <span ref={errorTermsRef} className="text-red-500 text-sm mt-2 font-bold opacity-0 block cursor-default">* Você precisa aceitar os termos para prosseguir</span>
                    </div>
                </aside>
            </article>
        </main>
    )
}

export default Sign;